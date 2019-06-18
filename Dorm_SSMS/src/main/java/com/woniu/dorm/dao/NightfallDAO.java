package com.woniu.dorm.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.woniu.dorm.mapper.NightfallMapper;
import com.woniu.dorm.pojo.Nightfall;
import com.woniu.dorm.pojo.Student;
import com.woniu.dorm.utils.Page;
@Repository
public class NightfallDAO implements NightfallMapper {
	@Resource
	private NightfallMapper nightfallMapper;

	public NightfallMapper getNightfallMapper() {
		return nightfallMapper;
	}

	public void setNightfallMapper(NightfallMapper nightfallMapper) {
		this.nightfallMapper = nightfallMapper;
	}

	@Override
	public List<Nightfall> all(Page<Nightfall> page) {
		// TODO Auto-generated method stub
		return nightfallMapper.all(page);
	}

	@Override
	public Student selectStudent(int sid) {
		// TODO Auto-generated method stub
		return nightfallMapper.selectStudent(sid);
	}

	@Override
	public int total() {
		// TODO Auto-generated method stub
		return nightfallMapper.total();
	}

	@Override
	public void add(Nightfall nightfall) {
		// TODO Auto-generated method stub
		nightfallMapper.add(nightfall);
	}

	@Override
	public void delete(Nightfall nightfall) {
		// TODO Auto-generated method stub
		nightfallMapper.delete(nightfall);
	}

	@Override
	public List<Nightfall> select(Nightfall nightfall) {
		// TODO Auto-generated method stub
		return nightfallMapper.select(nightfall);
	}

	@Override
	public void deleteall(Nightfall nightfall) {
		// TODO Auto-generated method stub
		nightfallMapper.deleteall(nightfall);
	}
	
}
