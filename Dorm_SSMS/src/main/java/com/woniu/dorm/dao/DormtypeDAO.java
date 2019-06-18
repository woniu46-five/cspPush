package com.woniu.dorm.dao;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import com.woniu.dorm.mapper.DormtypeMapper;
import com.woniu.dorm.pojo.Dormtype;

@Repository
public class DormtypeDAO implements DormtypeMapper {
	@Resource
	private DormtypeMapper dormtypeMapper;

	public DormtypeMapper getDormtypeMapper() {
		return dormtypeMapper;
	}

	public void setDormtypeMapper(DormtypeMapper dormtypeMapper) {
		this.dormtypeMapper = dormtypeMapper;
	}

	@Override
	public Dormtype selectDormtype(Dormtype dormtype) {
		// TODO Auto-generated method stub
		return dormtypeMapper.selectDormtype(dormtype);
	}

	


	
}
