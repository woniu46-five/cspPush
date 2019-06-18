package com.woniu.dorm.pojo;

import org.hibernate.validator.constraints.NotBlank;

public class Breakdown {
	private int bid;
	private int did;
	@NotBlank(message = "损坏信息不能为空")
	private String bdescription;
	@NotBlank(message = "损坏时间不能为空")
	private String bdate;
	private int flag;
	
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBdescription() {
		return bdescription;
	}
	public void setBdescription(String bdescription) {
		this.bdescription = bdescription;
	}
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	@Override
	public String toString() {
		return "Breakdown [bid=" + bid + ", did=" + did + ", bdescription=" + bdescription + ", bdate=" + bdate
				+ ", flag=" + flag + "]";
	}

	
	

}
