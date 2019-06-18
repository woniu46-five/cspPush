package com.woniu.dorm.mapper;

import java.util.List;

import com.woniu.dorm.pojo.Clazz;
import com.woniu.dorm.pojo.Dorm;
import com.woniu.dorm.pojo.Student;
import com.woniu.dorm.utils.Page;

public interface StudentMapper {
	public List<Student> selectbycid(Clazz clazz);
	public List<Student> seletebydid(Dorm dorm);
	public List<Student> all(Page<Student> page);
	public int total();
	public void add(Student student);
	public void delete(Student student);
	public Student selectbysid(Student student);
	public Student show(Student student);
	public void change(Student student);
	public List<Student> select(Student student);
	public Student nightfallbystudent(Student student);
}
