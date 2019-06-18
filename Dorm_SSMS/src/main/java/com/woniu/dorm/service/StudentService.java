package com.woniu.dorm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.woniu.dorm.mapper.ClazzMapper;
import com.woniu.dorm.mapper.DormMapper;
import com.woniu.dorm.mapper.NightfallMapper;
import com.woniu.dorm.mapper.StudentMapper;
import com.woniu.dorm.pojo.Clazz;
import com.woniu.dorm.pojo.Dorm;
import com.woniu.dorm.pojo.Nightfall;
import com.woniu.dorm.pojo.Student;
import com.woniu.dorm.utils.Page;

@Service
public class StudentService implements StudentMapper {
	@Resource
	private StudentMapper studentDAO;
	@Resource
	private ClazzMapper clazzService;
	@Resource
	private DormMapper dormService;
	@Resource 
	private NightfallMapper nightfallService;
	
	

	public NightfallMapper getNightfallService() {
		return nightfallService;
	}

	public void setNightfallService(NightfallMapper nightfallService) {
		this.nightfallService = nightfallService;
	}

	public ClazzMapper getClazzService() {
		return clazzService;
	}

	public void setClazzService(ClazzMapper clazzService) {
		this.clazzService = clazzService;
	}

	public DormMapper getDormService() {
		return dormService;
	}

	public void setDormService(DormMapper dormService) {
		this.dormService = dormService;
	}

	public StudentMapper getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentMapper studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Override
	public List<Student> selectbycid(Clazz clazz) {
		// TODO Auto-generated method stub
		return studentDAO.selectbycid(clazz);
	}

	@Override
	public List<Student> seletebydid(Dorm dorm) {
		// TODO Auto-generated method stub
		return studentDAO.seletebydid(dorm);
	}

	@Override
	public List<Student> all(Page<Student> page) {
		// TODO Auto-generated method stub
		return studentDAO.all(page);
	}

	@Override
	public int total() {
		// TODO Auto-generated method stub
		return studentDAO.total();
	}

	@Override
	public void add(Student student) {
		// TODO Auto-generated method stub
		System.out.println("ok3");
		Clazz clazz = student.getClazz();
		Dorm dorm = student.getDorm();
		clazz=clazzService.selectbycname(clazz);
		dorm=dormService.selectDormbydaddress(dorm);
		List<Student> list = studentDAO.seletebydid(dorm);
		
		if (list.size()>=dorm.getDcount()) {
			return ;
		}
		if (list.size()+1==dorm.getDcount()) {
			dorm.setPerson("房间已满");
			dormService.person(dorm);
		}
		
		student.setDid(dorm.getDid());
		student.setCid(clazz.getCid());
		System.out.println("ok2");
		studentDAO.add(student);
		System.out.println("ok1");
	}

	@Override
	public void delete(Student student) {
		// TODO Auto-generated method stub
		//删除学生之前设置房间的属性为可住房间。还有删除该学生的夜归记录
		student=studentDAO.selectbysid(student);
		System.out.println(student);
		Nightfall nightfall = new Nightfall();
		
		nightfall.setSid(student.getSid());
		nightfallService.deleteall(nightfall);
		System.out.println("ok");
		Dorm dorm =new Dorm();
		dorm.setDid(student.getDid());
		dorm.setPerson("可住房间");
		dormService.person(dorm);
		studentDAO.delete(student);
	}

	@Override
	public Student selectbysid(Student student) {
		// TODO Auto-generated method stub
		return studentDAO.selectbysid(student);
	}

	@Override
	public Student show(Student student) {
		// TODO Auto-generated method stub
		return studentDAO.show(student);
	}

	@Override
	public void change(Student student) {
		// TODO Auto-generated method stub

		//新房间设置dorm的属性
		Dorm olddorm = new Dorm();
		olddorm = student.getDorm();
		olddorm=dormService.selectDormbydaddress(olddorm);
	
		student.setDid(olddorm.getDid());
		List<Student> list = studentDAO.seletebydid(olddorm);
		
		if (list.size()>=olddorm.getDcount()) {
			return ;
		}
		if (list.size()+1==olddorm.getDcount()) {
			olddorm.setPerson("房间已满");
			dormService.person(olddorm);
		}
		//原来的房间设置drom的person属性
		Student nowstudent = new Student();
		nowstudent = studentDAO.selectbysid(student);
		Dorm nowdorm = new Dorm();
		nowdorm.setDid(nowstudent.getDid());
		nowdorm.setPerson("可住房间");
		dormService.person(nowdorm);
		
		studentDAO.change(student);
	}

	@Override
	public List<Student> select(Student student) {
		// TODO Auto-generated method stub
		return studentDAO.select(student);
	}

	@Override
	public Student nightfallbystudent(Student student) {
		// TODO Auto-generated method stub
		return studentDAO.nightfallbystudent(student);
	}
	
}
