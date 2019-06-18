package com.woniu.dorm.mapper;

import org.apache.ibatis.annotations.Select;

import com.woniu.dorm.pojo.Dormtype;

public interface DormtypeMapper {
	
	@Select("select * from dormtype where typename=#{typename}")
	public Dormtype selectDormtype(Dormtype dormtype);

}
