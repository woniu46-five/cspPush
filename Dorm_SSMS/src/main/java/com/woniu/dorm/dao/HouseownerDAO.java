package com.woniu.dorm.dao;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.woniu.dorm.mapper.HouseownerMapper;
import com.woniu.dorm.pojo.Houseowner;

@Repository
public class HouseownerDAO implements HouseownerMapper{
	@Resource
	private HouseownerMapper houseownerMapper;

	public HouseownerMapper getHouseownerMapper() {
		return houseownerMapper;
	}

	public void setHouseownerMapper(HouseownerMapper houseownerMapper) {
		this.houseownerMapper = houseownerMapper;
	}

	@Override
	public void insert(Houseowner houseowner) {
		// TODO Auto-generated method stub
		houseownerMapper.insert(houseowner);
	}

	@Override
	public Houseowner selectHouseowner(Houseowner houseowner) {
		// TODO Auto-generated method stub
		return houseownerMapper.selectHouseowner(houseowner);
	}
	
}
