package com.woniu.dorm.mapper;

import org.apache.ibatis.annotations.Select;

import com.woniu.dorm.pojo.Unit;

public interface UnitMapper {
	
	@Select("select * from unit where uname=#{uname}")
	public Unit selectUnit(Unit unit);
}
