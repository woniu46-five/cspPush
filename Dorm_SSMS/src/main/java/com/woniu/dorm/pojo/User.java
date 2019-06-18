package com.woniu.dorm.pojo;

import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

public class User {
	private int lid;
	@NotBlank
	private String account;
	@NotBlank
	private String pwd;
	private List<Role> roles;
	
	
	
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "User [lid=" + lid + ", account=" + account + ", pwd=" + pwd + ", roles=" + roles + "]";
	}
	

}
