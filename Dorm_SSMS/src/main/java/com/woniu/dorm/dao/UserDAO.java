package com.woniu.dorm.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.woniu.dorm.mapper.UserMapper;
import com.woniu.dorm.pojo.Perm;
import com.woniu.dorm.pojo.Role;
import com.woniu.dorm.pojo.User;

@Repository
public class UserDAO implements UserMapper {
	@Resource
	private UserMapper userMapper;
	
	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return userMapper.login(user);
	}

	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		userMapper.add(user);
		
	}

	@Override
	public User roles(User user) {
		// TODO Auto-generated method stub
		return userMapper.roles(user);
	}

	@Override
	public List<Role> getRole(int lid) {
		// TODO Auto-generated method stub
		return userMapper.getRole(lid);
	}

	@Override
	public Role perms(Role role) {
		// TODO Auto-generated method stub
		return userMapper.perms(role);
	}

	@Override
	public List<Perm> getPerm(int rid) {
		// TODO Auto-generated method stub
		return userMapper.getPerm(rid);
	}

}
