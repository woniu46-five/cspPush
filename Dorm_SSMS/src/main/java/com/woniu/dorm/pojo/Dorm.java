package com.woniu.dorm.pojo;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;


public class Dorm {
	
	private int did;
	@NotBlank(message = "房间地址不能为空")
	private String daddress;
	private Dormtype type;
	private Unit unit;
	
	private int dcount;
	private int typeid;
	private String person;
	private String breakdown;
	@Valid
	private Houseowner houseowner;
	private List<Breakdown> breakdowns;
	private List<Student> students;
	
	
	
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public String getBreakdown() {
		return breakdown;
	}
	public void setBreakdown(String breakdown) {
		this.breakdown = breakdown;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDaddress() {
		return daddress;
	}
	public void setDaddress(String daddress) {
		this.daddress = daddress;
	}
	public Dormtype getType() {
		return type;
	}
	public void setType(Dormtype type) {
		this.type = type;
	}
	public Unit getUnit() {
		return unit;
	}
	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	
	

	public int getDcount() {
		return dcount;
	}
	public void setDcount(int dcount) {
		this.dcount = dcount;
	}
	public Houseowner getHouseowner() {
		return houseowner;
	}
	public void setHouseowner(Houseowner houseowner) {
		this.houseowner = houseowner;
	}
	public List<Breakdown> getBreakdowns() {
		return breakdowns;
	}
	public void setBreakdowns(List<Breakdown> breakdowns) {
		this.breakdowns = breakdowns;
	}
	@Override
	public String toString() {
		return "Dorm [did=" + did + ", daddress=" + daddress + ", type=" + type + ", unit=" + unit + ", dcount="
				+ dcount + ", person=" + person + ", breakdown=" + breakdown + ", houseowner=" + houseowner
				+ ", breakdowns=" + breakdowns + ", students=" + students + "]";
	}

	
	
}
