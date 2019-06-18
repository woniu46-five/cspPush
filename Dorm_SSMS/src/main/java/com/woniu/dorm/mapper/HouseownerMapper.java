package com.woniu.dorm.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.woniu.dorm.pojo.Houseowner;

public interface HouseownerMapper {
	
	@Insert("insert into houseowner(hname,htelphone,hdate,hmtype,hprice) values(#{hname},#{htelphone},#{hdate},#{hmtype},#{hprice}) ")
	public void insert(Houseowner houseowner);
	@Select("select * from houseowner where hname=#{hname} ")
	public Houseowner selectHouseowner(Houseowner houseowner);

}
