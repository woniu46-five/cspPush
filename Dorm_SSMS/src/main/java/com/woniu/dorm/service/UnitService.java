package com.woniu.dorm.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.woniu.dorm.mapper.UnitMapper;
import com.woniu.dorm.pojo.Unit;
@Service
public class UnitService implements UnitMapper{
	@Resource
	private UnitMapper unitDAO;

	public UnitMapper getUnitDAO() {
		return unitDAO;
	}

	public void setUnitDAO(UnitMapper unitDAO) {
		this.unitDAO = unitDAO;
	}

	@Override
	public Unit selectUnit(Unit unit) {
		// TODO Auto-generated method stub
		return unitDAO.selectUnit(unit);
	}
	
}
