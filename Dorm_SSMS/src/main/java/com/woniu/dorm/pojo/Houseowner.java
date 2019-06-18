package com.woniu.dorm.pojo;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

public class Houseowner {
	private int hid;
	@NotBlank(message = "房东名不能为空")
	private String hname;
	@NotBlank(message = "房东电话不能为空")
	private String htelphone;
	@NotBlank(message = "租房日期不能为空")
	private String hdate;
	@NotBlank(message = "支付方式不能为空")
	private String hmtype;
	@Pattern(regexp = "[0-9]{0,}",message = "房租必须为数字")
	private String hprice;
	public int getHid() {
		return hid;
	}
	public void setHid(int hid) {
		this.hid = hid;
	}
	public String getHname() {
		return hname;
	}
	public void setHname(String hname) {
		this.hname = hname;
	}
	public String getHtelphone() {
		return htelphone;
	}
	public void setHtelphone(String htelphone) {
		this.htelphone = htelphone;
	}
	public String getHdate() {
		return hdate;
	}
	public void setHdate(String hdate) {
		this.hdate = hdate;
	}
	public String getHmtype() {
		return hmtype;
	}
	public void setHmtype(String hmtype) {
		this.hmtype = hmtype;
	}
	public String getHprice() {
		return hprice;
	}
	public void setHprice(String hprice) {
		this.hprice = hprice;
	}
	@Override
	public String toString() {
		return "Houseowner [hid=" + hid + ", hname=" + hname + ", htelphone=" + htelphone + ", hdate=" + hdate
				+ ", hmtype=" + hmtype + ", hprice=" + hprice + "]";
	}
	

}
