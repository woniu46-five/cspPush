package com.woniu.dorm.pojo;

public class Perm {
	private int pid;
	private String pname;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	@Override
	public String toString() {
		return "Perm [pid=" + pid + ", pname=" + pname + "]";
	}
	

}
