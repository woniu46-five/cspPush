package com.woniu.dorm.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.woniu.dorm.mapper.TeacherMapper;
import com.woniu.dorm.pojo.Teacher;

@Repository
public class TeacherDAO implements TeacherMapper {
	@Resource
	private TeacherMapper teacherMapper;
	

	public TeacherMapper getTeacherMapper() {
		return teacherMapper;
	}


	public void setTeacherMapper(TeacherMapper teacherMapper) {
		this.teacherMapper = teacherMapper;
	}


	@Override
	public List<Teacher> all() {
		// TODO Auto-generated method stub
		return teacherMapper.all();
	}


	@Override
	public Teacher selecTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		return teacherMapper.selecTeacher(teacher);
	}
	
}
