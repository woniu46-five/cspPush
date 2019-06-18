package com.woniu.dorm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.woniu.dorm.mapper.UserMapper;
import com.woniu.dorm.pojo.Perm;
import com.woniu.dorm.pojo.Role;
import com.woniu.dorm.pojo.User;

@Service
public class UserService implements UserMapper{
	@Resource
	private UserMapper userDAO;
	

	public UserMapper getUserService() {
		return userDAO;
	}


	public void setUserService(UserMapper userService) {
		this.userDAO = userService;
	}


	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return userDAO.login(user);
	}


	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		userDAO.add(user);
		
	}


	@Override
	public User roles(User user) {
		// TODO Auto-generated method stub
		return userDAO.roles(user);
	}


	@Override
	public List<Role> getRole(int lid) {
		// TODO Auto-generated method stub
		return userDAO.getRole(lid);
	}


	@Override
	public Role perms(Role role) {
		// TODO Auto-generated method stub
		return userDAO.perms(role);
	}


	@Override
	public List<Perm> getPerm(int rid) {
		// TODO Auto-generated method stub
		return userDAO.getPerm(rid);
	}

}
