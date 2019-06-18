package com.woniu.dorm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.woniu.dorm.mapper.NightfallMapper;
import com.woniu.dorm.mapper.StudentMapper;
import com.woniu.dorm.pojo.Nightfall;
import com.woniu.dorm.pojo.Student;
import com.woniu.dorm.utils.Page;

@Service
public class NightfallService implements NightfallMapper{
	@Resource
	private NightfallMapper nightfallDAO;
	@Resource
	private StudentMapper studentService;

	public NightfallMapper getNightfallDAO() {
		return nightfallDAO;
	}

	public void setNightfallDAO(NightfallMapper nightfallDAO) {
		this.nightfallDAO = nightfallDAO;
	}

	@Override
	public List<Nightfall> all(Page<Nightfall> page) {
		// TODO Auto-generated method stub
		return nightfallDAO.all(page);
	}

	@Override
	public Student selectStudent(int sid) {
		// TODO Auto-generated method stub
		return nightfallDAO.selectStudent(sid);
	}

	@Override
	public int total() {
		// TODO Auto-generated method stub
		return nightfallDAO.total();
	}

	@Override
	public void add(Nightfall nightfall) {
		// TODO Auto-generated method stub
		Student student = nightfall.getStudent();
		student = studentService.nightfallbystudent(student);
		if (student==null) {
			return;
		}
		
		nightfall.setSid(student.getSid());

		nightfallDAO.add(nightfall);
		
	}

	@Override
	public void delete(Nightfall nightfall) {
		// TODO Auto-generated method stub
		nightfallDAO.delete(nightfall);
	}

	@Override
	public List<Nightfall> select(Nightfall nightfall) {
		// TODO Auto-generated method stub
		
		
		
		return nightfallDAO.select(nightfall);
	}

	@Override
	public void deleteall(Nightfall nightfall) {
		// TODO Auto-generated method stub
		nightfallDAO.deleteall(nightfall);
	}
	
	
}
