package com.woniu.dorm.pojo;



import org.hibernate.validator.constraints.NotBlank;



public class Clazz {
	private int cid;
	@NotBlank(message = "班级名称不能为空")
	private String cname;
	@NotBlank(message = "开班时间不能为空")
	
	private String cdate;
	private Teacher teachers;
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCdate() {
		return cdate;
	}
	public void setCdate(String cdate) {
		this.cdate = cdate;
	}

	public Teacher getTeachers() {
		return teachers;
	}
	public void setTeachers(Teacher teachers) {
		this.teachers = teachers;
	}
	@Override
	public String toString() {
		return "Clazz [cid=" + cid + ", cname=" + cname + ", cdate=" + cdate + ", teachers=" + teachers + "]";
	}
	

}
