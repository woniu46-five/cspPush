package com.woniu.dorm.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.woniu.dorm.mapper.DormtypeMapper;
import com.woniu.dorm.pojo.Dormtype;

@Service
public class DormtypeService implements DormtypeMapper{
	@Resource
	private DormtypeMapper dormtypeDAO;



	public DormtypeMapper getDormtypeDAO() {
		return dormtypeDAO;
	}



	public void setDormtypeDAO(DormtypeMapper dormtypeDAO) {
		this.dormtypeDAO = dormtypeDAO;
	}



	@Override
	public Dormtype selectDormtype(Dormtype dormtype) {
		// TODO Auto-generated method stub
		return dormtypeDAO.selectDormtype(dormtype);
	}
	
}
