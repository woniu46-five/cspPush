package com.woniu.dorm.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.woniu.dorm.mapper.ClazzMapper;
import com.woniu.dorm.pojo.Clazz;
import com.woniu.dorm.pojo.Teacher;
import com.woniu.dorm.utils.Page;

@Repository
public class ClazzDAO implements ClazzMapper{
	@Resource
	private ClazzMapper clazzMapper;
	
	
	public ClazzMapper getClazzMapper() {
		return clazzMapper;
	}

	public void setClazzMapper(ClazzMapper clazzMapper) {
		this.clazzMapper = clazzMapper;
	}



	@Override
	public Teacher selectTeacher(int tid) {
		// TODO Auto-generated method stub
		return clazzMapper.selectTeacher(tid);
	}

	@Override
	public List<Clazz> all(Page<Clazz> page) {
		// TODO Auto-generated method stub
		return clazzMapper.all(page);
	}

	@Override
	public int allpage() {
		// TODO Auto-generated method stub
		return clazzMapper.allpage();
	}

	@Override
	public void add(Clazz clazz) {
		// TODO Auto-generated method stub
	
		clazzMapper.add(clazz);
	}

	@Override
	public boolean delete(Clazz clazz) {
		// TODO Auto-generated method stub
		
		return clazzMapper.delete(clazz);
	}

	@Override
	public List<Clazz> total() {
		// TODO Auto-generated method stub
		return clazzMapper.total();
	}

	@Override
	public Clazz selectbycname(Clazz clazz) {
		// TODO Auto-generated method stub
		return clazzMapper.selectbycname(clazz);
	}

}
