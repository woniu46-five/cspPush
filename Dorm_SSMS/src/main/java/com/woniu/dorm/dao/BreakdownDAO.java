package com.woniu.dorm.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.woniu.dorm.mapper.BreakdownMapper;
import com.woniu.dorm.pojo.Breakdown;
@Repository
public class BreakdownDAO implements BreakdownMapper{
	@Resource
	private BreakdownMapper breakdownMapper;

	public BreakdownMapper getBreakdownMapper() {
		return breakdownMapper;
	}

	public void setBreakdownMapper(BreakdownMapper breakdownMapper) {
		this.breakdownMapper = breakdownMapper;
	}

	@Override
	public void insertbreak(Breakdown breakdown) {
		// TODO Auto-generated method stub
		breakdownMapper.insertbreak(breakdown);
	}

	@Override
	public void rbreak(Breakdown breakdown) {
		// TODO Auto-generated method stub
		breakdownMapper.rbreak(breakdown);
	}

	@Override
	public List<Breakdown> myselect() {
		// TODO Auto-generated method stub
		return breakdownMapper.myselect();
	}

	@Override
	public List<Breakdown> selectList(Breakdown breakdown) {
		// TODO Auto-generated method stub
		return breakdownMapper.selectList(breakdown);
	}

	@Override
	public Breakdown selectBreakdown(Breakdown breakdown) {
		// TODO Auto-generated method stub
		return breakdownMapper.selectBreakdown(breakdown);
	}

	@Override
	public void delete(Breakdown breakdown) {
		// TODO Auto-generated method stub
		breakdownMapper.delete(breakdown);
	}
	
}
