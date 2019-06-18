package com.woniu.dorm.pojo;





import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

public class Student {
	private int sid;
	@NotBlank(message = "用户名不能为空")
	private String sname;
	
	@NotBlank(message = "性别不能为空")
	private String ssex;
	
	private int did;
	
	@NotBlank(message = "电话号码不能为空")
	private String telphone;
	
	private int cid;
	
	@NotBlank(message = "入住时间不能为空")
	private String sdate;
	
	private Clazz clazz;

	private Dorm dorm;
	
	private MultipartFile img;
	private String simg;
	
	
	public MultipartFile getImg() {
		return img;
	}
	public void setImg(MultipartFile img) {
		this.img = img;
	}

	public String getSimg() {
		return simg;
	}
	public void setSimg(String simg) {
		this.simg = simg;
	}
	public Dorm getDorm() {
		return dorm;
	}
	public void setDorm(Dorm dorm) {
		this.dorm = dorm;
	}
	public Clazz getClazz() {
		return clazz;
	}
	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSsex() {
		return ssex;
	}
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", ssex=" + ssex + ", did=" + did + ", telphone=" + telphone
				+ ", cid=" + cid + ", sdate=" + sdate + ", clazz=" + clazz + ", dorm=" + dorm + ", img=" + img
				+ ", simg=" + simg + "]";
	}



	
	

}
