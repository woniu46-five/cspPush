package com.woniu.dorm.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.woniu.dorm.mapper.BreakdownMapper;
import com.woniu.dorm.mapper.ClazzMapper;
import com.woniu.dorm.mapper.DormMapper;
import com.woniu.dorm.mapper.NightfallMapper;
import com.woniu.dorm.mapper.StudentMapper;
import com.woniu.dorm.mapper.TeacherMapper;
import com.woniu.dorm.mapper.UserMapper;
import com.woniu.dorm.pojo.Breakdown;
import com.woniu.dorm.pojo.Clazz;
import com.woniu.dorm.pojo.Dorm;
import com.woniu.dorm.pojo.Dormtype;
import com.woniu.dorm.pojo.Houseowner;
import com.woniu.dorm.pojo.Nightfall;
import com.woniu.dorm.pojo.Role;
import com.woniu.dorm.pojo.Student;
import com.woniu.dorm.pojo.Teacher;
import com.woniu.dorm.pojo.Unit;
import com.woniu.dorm.pojo.User;
import com.woniu.dorm.service.UserService;
import com.woniu.dorm.utils.Page;

public class Base {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
		String[] names = applicationContext.getBeanDefinitionNames();
		for (String string : names) {
			System.out.println(string);
		}
		
		String string = new SimpleHash("MD5", 123456, "zsl", 10).toString();
		System.out.println(string);
		
//		NightfallMapper nightfallMapper = (NightfallMapper) applicationContext.getBean("nightfallService");
//		Nightfall nightfall = new Nightfall();
//		nightfall.setSid(1);
//		nightfallMapper.deleteall(nightfall);
//		Page<Nightfall> page = new Page<Nightfall>();
//		page.setIndex(0);
//		page.setCount(2);
//		List<Nightfall> list = nightfallMapper.all(page);
//		System.out.println(list);
		
//		StudentMapper studentMapper =  (StudentMapper) applicationContext.getBean("studentMapper");
//		Student student = new Student();
//		student.setSname("张");
//		Clazz clazz = new Clazz();
//		clazz.setCname("java");
//		student.setClazz(clazz);
//		List<Student> list = studentMapper.select(student);
//		System.out.println(list);
		
		
//		Student student = new Student();
//		student.setSname("haha");
//		student.setSsex("男");
//		student.setDid(1);
//		student.setTelphone("18888888888");
//		student.setCid(4);
//		student.setSdate("1980-02-18");
//		student.setSimg("1.png");
//		studentMapper.add(student);
		
		
//		Page<Student> page = new Page<Student>();
//		page.setIndex(0);
//		page.setCount(2);
//		List<Student> all = studentMapper.all(page);
//		System.out.println(all);
		
		
		
//			DormMapper sMapper = (DormMapper) applicationContext.getBean("dormService");
//			Dorm dorm = new Dorm();
//			dorm.setDaddress("天");
//			Dormtype dormtype = new Dormtype();
//			dormtype.setTypeid(1);
//			dorm.setType(dormtype);
//			dorm.setPerson("可住房间");
//			System.out.println(dorm);
//			List<Dorm> list = sMapper.myselect(dorm);
//			System.out.println(list);
			
		
		
//			BreakdownMapper dormMapper =  (BreakdownMapper) applicationContext.getBean("breakdownMapper");
//			List<Breakdown> list = dormMapper.myselect();
//			System.out.println(list);
//			List<Breakdown> breakdowns = new ArrayList<Breakdown>();
//			System.out.println(breakdowns);
			
		
		
//		//测试登陆角色以及权限
//		UserMapper service = (UserMapper) applicationContext.getBean("userService");
//		User user = new User();
//		user.setAccount("zsl");
//		user = service.roles(user);
//		System.out.println(user);
//		for(Role role:user.getRoles()) {
//			Role perms = service.perms(role);
//			System.out.println(perms);
//		}
//		//测试加密
//		String pwd = "123456";
//		String newpwd = new SimpleHash("MD5", pwd,"zsl",10).toString();
//		System.out.println(newpwd);
		//测试班级信息
//		ClazzMapper clazzMapper = (ClazzMapper) applicationContext.getBean("clazzService");
//		Page<Clazz> page = new Page<Clazz>();
//		page.setIndex(1);
//		page.setCount(2);
//		List<Clazz> all = clazzMapper.all(page);
//		System.out.println(all);
		//测试分页
//		ClazzMapper clazzMapper = (ClazzMapper) applicationContext.getBean("clazzService");
//		int allpage = clazzMapper.allpage();
//		System.out.println(allpage);
		
		//测试老师
//		TeacherMapper teacherMapper = (TeacherMapper) applicationContext.getBean("teacherService");
//		List<Teacher> list = teacherMapper.all();
//		System.out.println(list);
		//测试添加班级信息
//		ClazzMapper clazzMapper = (ClazzMapper) applicationContext.getBean("clazzService");
//		Teacher teacher = new Teacher();
//		teacher.setTid(1);
//		teacher.setTname("李老师");
//		Clazz clazz = new Clazz();
//		clazz.setCname("测试二班");
//		clazz.setCdate("2017-08-13");
//		clazz.setTeachers(teacher);
//		clazzMapper.add(clazz);
		
		
	}

}

