package com.woniu.dorm.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.woniu.dorm.mapper.StudentMapper;
import com.woniu.dorm.pojo.Clazz;
import com.woniu.dorm.pojo.Dorm;
import com.woniu.dorm.pojo.Student;
import com.woniu.dorm.utils.Page;

@Repository
public class StudentDAO implements StudentMapper {
	@Resource
	private StudentMapper studentMapper;

	public StudentMapper getStudentMapper() {
		return studentMapper;
	}

	public void setStudentMapper(StudentMapper studentMapper) {
		this.studentMapper = studentMapper;
	}

	@Override
	public List<Student> selectbycid(Clazz clazz) {
		// TODO Auto-generated method stub
		return studentMapper.selectbycid(clazz);
	}

	@Override
	public List<Student> seletebydid(Dorm dorm) {
		// TODO Auto-generated method stub
		return studentMapper.seletebydid(dorm);
	}

	@Override
	public List<Student> all(Page<Student> page) {
		// TODO Auto-generated method stub
		return studentMapper.all(page);
	}

	@Override
	public int total() {
		// TODO Auto-generated method stub
		return studentMapper.total();
	}

	@Override
	public void add(Student student) {
		// TODO Auto-generated method stub
		studentMapper.add(student);
	}

	@Override
	public void delete(Student student) {
		// TODO Auto-generated method stub
		studentMapper.delete(student);
	}

	@Override
	public Student selectbysid(Student student) {
		// TODO Auto-generated method stub
		return studentMapper.selectbysid(student);
	}

	@Override
	public Student show(Student student) {
		// TODO Auto-generated method stub
		return studentMapper.show(student);
	}

	@Override
	public void change(Student student) {
		// TODO Auto-generated method stub
		studentMapper.change(student);
	}

	@Override
	public List<Student> select(Student student) {
		// TODO Auto-generated method stub
		return studentMapper.select(student);
	}

	@Override
	public Student nightfallbystudent(Student student) {
		// TODO Auto-generated method stub
		return studentMapper.nightfallbystudent(student);
	}
	
}
