package com.woniu.dorm.service;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.woniu.dorm.mapper.BreakdownMapper;
import com.woniu.dorm.mapper.DormMapper;
import com.woniu.dorm.mapper.DormtypeMapper;
import com.woniu.dorm.mapper.HouseownerMapper;
import com.woniu.dorm.mapper.StudentMapper;
import com.woniu.dorm.mapper.UnitMapper;
import com.woniu.dorm.pojo.Breakdown;
import com.woniu.dorm.pojo.Dorm;
import com.woniu.dorm.pojo.Dormtype;
import com.woniu.dorm.pojo.Houseowner;
import com.woniu.dorm.pojo.Student;
import com.woniu.dorm.pojo.Unit;
import com.woniu.dorm.utils.Page;

@Service
public class DormService implements DormMapper{
	@Resource
	private DormMapper dormDAO;
	@Resource
	private DormtypeMapper dormtypeService;
	@Resource 
	private UnitMapper unitService;
	@Resource
	private HouseownerMapper houseownerService;
	@Resource
	private StudentMapper studentService;
	@Resource
	private BreakdownMapper breakdownService;
	
	
	
	
	





	public StudentMapper getStudentService() {
		return studentService;
	}


	public void setStudentService(StudentMapper studentService) {
		this.studentService = studentService;
	}


	public HouseownerMapper getHouseownerService() {
		return houseownerService;
	}


	public void setHouseownerService(HouseownerMapper houseownerService) {
		this.houseownerService = houseownerService;
	}


	public DormtypeMapper getDormtypeService() {
		return dormtypeService;
	}


	public void setDormtypeService(DormtypeMapper dormtypeService) {
		this.dormtypeService = dormtypeService;
	}


	public UnitMapper getUnitService() {
		return unitService;
	}


	public void setUnitService(UnitMapper unitService) {
		this.unitService = unitService;
	}


	public DormMapper getDormDAO() {
		return dormDAO;
	}


	public void setDormDAO(DormMapper dormDAO) {
		this.dormDAO = dormDAO;
	}


	@Override
	public List<Dorm> all(Page<Dorm> page) {
		// TODO Auto-generated method stub
		return dormDAO.all(page);
	}


	@Override
	public int allpage() {
		// TODO Auto-generated method stub
		return dormDAO.allpage();
	}


	@Override
	public void insertdorm(Dorm dorm) {
		// TODO Auto-generated method stub

		Dormtype dormtype = dorm.getType();
		dormtype= dormtypeService.selectDormtype(dormtype);
		Unit unit = dorm.getUnit();
		unit = unitService.selectUnit(unit);
		Houseowner houseowner = dorm.getHouseowner();
		houseownerService.insert(houseowner);

		houseowner=houseownerService.selectHouseowner(houseowner);
	
		dorm.setType(dormtype);
		dorm.setUnit(unit);
		dorm.setHouseowner(houseowner);
		dormDAO.insertdorm(dorm);
		
	}


	@Override
	public boolean deletedorm(Dorm dorm) {
		// TODO Auto-generated method stub
	
		Breakdown breakdown = new Breakdown();
		breakdown.setDid(dorm.getDid());
		breakdownService.delete(breakdown);
		List<Student> students = studentService.seletebydid(dorm);
		if (students.size()>0) {
			return false;
		}
		dormDAO.deletedorm(dorm);
		return true;
	}


	@Override
	public Dorm show(Dorm dorm) {
		// TODO Auto-generated method stub
		return dormDAO.show(dorm);
	}


	@Override
	public List<Dorm> myselect(Dorm dorm) {
		// TODO Auto-generated method stub
		
		
		
		
		return dormDAO.myselect(dorm);
	}


	@Override
	public void breakdown(Dorm dorm) {
		// TODO Auto-generated method stub
		dormDAO.breakdown(dorm);
	}


	@Override
	public List<Dorm> total() {
		// TODO Auto-generated method stub
		return dormDAO.total();
	}


	@Override
	public Dorm selectDormbydaddress(Dorm dorm) {
		// TODO Auto-generated method stub
		return dormDAO.selectDormbydaddress(dorm);
	}


	@Override
	public void person(Dorm dorm) {
		// TODO Auto-generated method stub
		dormDAO.person(dorm);
	}



}
