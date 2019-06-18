package com.woniu.dorm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.woniu.dorm.pojo.Teacher;

public interface TeacherMapper {
	@Select("select * from teacher")
	public List<Teacher> all();
	
	@Select("select * from teacher where tname=#{tname}")
	public Teacher selecTeacher(Teacher teacher);

}
