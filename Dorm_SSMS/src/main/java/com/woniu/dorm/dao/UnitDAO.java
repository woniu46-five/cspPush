package com.woniu.dorm.dao;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.woniu.dorm.mapper.UnitMapper;
import com.woniu.dorm.pojo.Unit;

@Repository
public class UnitDAO implements UnitMapper {
	@Resource
	private UnitMapper unitMapper;

	public UnitMapper getUnitMapper() {
		return unitMapper;
	}

	public void setUnitMapper(UnitMapper unitMapper) {
		this.unitMapper = unitMapper;
	}

	@Override
	public Unit selectUnit(Unit unit) {
		// TODO Auto-generated method stub
		return unitMapper.selectUnit(unit);
	}
	
}
