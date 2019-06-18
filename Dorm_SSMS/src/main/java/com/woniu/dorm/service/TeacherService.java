package com.woniu.dorm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.woniu.dorm.mapper.TeacherMapper;
import com.woniu.dorm.pojo.Teacher;

@Service
public class TeacherService implements TeacherMapper {
	@Resource
	private TeacherMapper teacherDAO;

	public TeacherMapper getTeacherDAO() {
		return teacherDAO;
	}

	public void setTeacherDAO(TeacherMapper teacherDAO) {
		this.teacherDAO = teacherDAO;
	}

	@Override
	public List<Teacher> all() {
		// TODO Auto-generated method stub
		return teacherDAO.all();
	}

	@Override
	public Teacher selecTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		return teacherDAO.selecTeacher(teacher);
	}
	
}
