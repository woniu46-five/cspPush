package com.woniu.dorm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.woniu.dorm.mapper.ClazzMapper;
import com.woniu.dorm.mapper.StudentMapper;
import com.woniu.dorm.mapper.TeacherMapper;
import com.woniu.dorm.pojo.Clazz;
import com.woniu.dorm.pojo.Student;
import com.woniu.dorm.pojo.Teacher;
import com.woniu.dorm.utils.Page;

@Service
public class ClazzService implements ClazzMapper {
	@Resource
	private ClazzMapper clazzDAO;
	@Resource
	private TeacherMapper teacherService;
	@Resource 
	private StudentMapper studentService;
	

	public StudentMapper getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentMapper studentService) {
		this.studentService = studentService;
	}

	public TeacherMapper getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherMapper teacherService) {
		this.teacherService = teacherService;
	}

	public ClazzMapper getClazzDAO() {
		return clazzDAO;
	}

	public void setClazzDAO(ClazzMapper clazzDAO) {
		this.clazzDAO = clazzDAO;
	}


	@Override
	public Teacher selectTeacher(int tid) {
		// TODO Auto-generated method stub
		return clazzDAO.selectTeacher(tid);
	}

	@Override
	public List<Clazz> all(Page<Clazz> page) {
		// TODO Auto-generated method stub
		return clazzDAO.all(page);
	}

	@Override
	public int allpage() {
		// TODO Auto-generated method stub
		return clazzDAO.allpage();
	}

	@Override
	public void add(Clazz clazz) {
		// TODO Auto-generated method stub
		Teacher teacher = new Teacher();
		teacher = clazz.getTeachers();
		teacher=teacherService.selecTeacher(teacher);
		clazz.setTeachers(teacher);
		clazzDAO.add(clazz);
	}


	@Override
	public boolean delete(Clazz clazz) {
		// TODO Auto-generated method stub
		
		List<Student> students = studentService.selectbycid(clazz);
	
		if (students.size()>0) {
			return false;
		}
	
		clazzDAO.delete(clazz);
	
		return true;
	}

	@Override
	public List<Clazz> total() {
		// TODO Auto-generated method stub
		return clazzDAO.total();
	}

	@Override
	public Clazz selectbycname(Clazz clazz) {
		// TODO Auto-generated method stub
		return clazzDAO.selectbycname(clazz);
	}
	
}
