package com.woniu.dorm.handler;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniu.dorm.mapper.TeacherMapper;
import com.woniu.dorm.pojo.Teacher;

@Controller
@RequestMapping("/teacher")
public class TeacherHandler extends MyExceptionHandler {
	@Resource
	private TeacherMapper teacherService;

	public TeacherMapper getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherMapper teacherService) {
		this.teacherService = teacherService;
	}
	
	@RequestMapping("/all")
	@ResponseBody()
	public List<Teacher> all() throws Exception{
		List<Teacher> teachers = teacherService.all();
		return teachers;
	}
}
