package com.woniu.dorm.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.woniu.dorm.mapper.DormMapper;
import com.woniu.dorm.pojo.Dorm;
import com.woniu.dorm.utils.Page;

@Repository
public class DormDAO implements DormMapper{
	@Resource
	private DormMapper dormMapper;
	
	
	public DormMapper getDormMapper() {
		return dormMapper;
	}


	public void setDormMapper(DormMapper dormMapper) {
		this.dormMapper = dormMapper;
	}


	@Override
	public List<Dorm> all(Page<Dorm> page) {
		// TODO Auto-generated method stub
		return dormMapper.all(page);
	}


	@Override
	public int allpage() {
		// TODO Auto-generated method stub
		return dormMapper.allpage();
	}


	@Override
	public void insertdorm(Dorm dorm) {
		// TODO Auto-generated method stub
		dormMapper.insertdorm(dorm);
	}


	@Override
	public boolean deletedorm(Dorm dorm) {
		// TODO Auto-generated method stub
		return dormMapper.deletedorm(dorm);
	}


	@Override
	public Dorm show(Dorm dorm) {
		// TODO Auto-generated method stub
		return dormMapper.show(dorm);
	}


	@Override
	public List<Dorm> myselect(Dorm dorm) {
		// TODO Auto-generated method stub
		return dormMapper.myselect(dorm);
	}


	@Override
	public void breakdown(Dorm dorm) {
		// TODO Auto-generated method stub
		dormMapper.breakdown(dorm);
	}


	@Override
	public List<Dorm> total() {
		// TODO Auto-generated method stub
		return dormMapper.total();
	}


	@Override
	public Dorm selectDormbydaddress(Dorm dorm) {
		// TODO Auto-generated method stub
		return dormMapper.selectDormbydaddress(dorm);
	}


	@Override
	public void person(Dorm dorm) {
		// TODO Auto-generated method stub
		dormMapper.person(dorm);
	}




}
