package com.woniu.dorm.pojo;

import java.util.List;

public class Role {
	private int rid;
	private String rname;
	private List<Perm> perms;
	
	
	
	public List<Perm> getPerms() {
		return perms;
	}
	public void setPerms(List<Perm> perms) {
		this.perms = perms;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	@Override
	public String toString() {
		return "Role [rid=" + rid + ", rname=" + rname + ", perms=" + perms + "]";
	}
	

}
