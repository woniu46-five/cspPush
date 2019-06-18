package com.woniu.dorm.utils;

public class DormDes {
	private String address;
	private String breakdowns;
	private String personal;
	private String dormtype;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBreakdowns() {
		return breakdowns;
	}
	public void setBreakdowns(String breakdowns) {
		this.breakdowns = breakdowns;
	}
	public String getPersonal() {
		return personal;
	}
	public void setPersonal(String personal) {
		this.personal = personal;
	}
	public String getDormtype() {
		return dormtype;
	}
	public void setDormtype(String dormtype) {
		this.dormtype = dormtype;
	}
	@Override
	public String toString() {
		return "DormDes [address=" + address + ", breakdowns=" + breakdowns + ", personal=" + personal + ", dormtype="
				+ dormtype + "]";
	}
	
	
}
