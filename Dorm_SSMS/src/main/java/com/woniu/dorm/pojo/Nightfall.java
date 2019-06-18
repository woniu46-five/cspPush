package com.woniu.dorm.pojo;

public class Nightfall {
	private int nid;
	private String ndate;
	private String ncouse;
	private int sid;
	private Student student;
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public String getNdate() {
		return ndate;
	}
	public void setNdate(String ndate) {
		this.ndate = ndate;
	}
	public String getNcouse() {
		return ncouse;
	}
	public void setNcouse(String ncouse) {
		this.ncouse = ncouse;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "nightfall [nid=" + nid + ", ndate=" + ndate + ", ncouse=" + ncouse + ", sid=" + sid + ", student="
				+ student + "]";
	}
	
	

}
