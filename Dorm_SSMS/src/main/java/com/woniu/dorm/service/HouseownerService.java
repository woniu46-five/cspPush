package com.woniu.dorm.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.woniu.dorm.mapper.HouseownerMapper;
import com.woniu.dorm.pojo.Houseowner;

@Service
public class HouseownerService implements HouseownerMapper {
	@Resource
	private HouseownerMapper houseownerDAO;

	public HouseownerMapper getHouseownerDAO() {
		return houseownerDAO;
	}

	public void setHouseownerDAO(HouseownerMapper houseownerDAO) {
		this.houseownerDAO = houseownerDAO;
	}

	@Override
	public void insert(Houseowner houseowner) {
		// TODO Auto-generated method stub
		houseownerDAO.insert(houseowner);
	}

	@Override
	public Houseowner selectHouseowner(Houseowner houseowner) {
		// TODO Auto-generated method stub
		return houseownerDAO.selectHouseowner(houseowner);
	}
	
}
