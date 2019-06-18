package com.woniu.dorm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.woniu.dorm.mapper.BreakdownMapper;
import com.woniu.dorm.mapper.DormMapper;
import com.woniu.dorm.pojo.Breakdown;
import com.woniu.dorm.pojo.Dorm;
@Service
public class BreakdownService implements BreakdownMapper {
	@Resource
	private BreakdownMapper breakdownDAO;
	@Resource 
	private DormMapper dormService;
	


	public DormMapper getDormService() {
		return dormService;
	}


	public void setDormService(DormMapper dormService) {
		this.dormService = dormService;
	}


	public BreakdownMapper getBreakdownDAO() {
		return breakdownDAO;
	}


	public void setBreakdownDAO(BreakdownMapper breakdownDAO) {
		this.breakdownDAO = breakdownDAO;
	}


	@Override
	public void insertbreak(Breakdown breakdown) {
		// TODO Auto-generated method stub
		breakdown.setFlag(0);
		Dorm dorm = new Dorm();
		dorm.setDid(breakdown.getDid());
		dorm.setBreakdown("设施损坏");
		dormService.breakdown(dorm);
		breakdownDAO.insertbreak(breakdown);
	}


	@Override
	public void rbreak(Breakdown breakdown) {
		// TODO Auto-generated method stub
		
		breakdownDAO.rbreak(breakdown);
		breakdown=breakdownDAO.selectBreakdown(breakdown);
		List<Breakdown> list = breakdownDAO.selectList(breakdown);
		
		
		boolean exits=true;
		for (Breakdown breakdown2 : list) {
			if (breakdown2.getFlag()==0) {
				
				exits=false;
				break;
			}
		}
		if (exits) {
			
			Dorm dorm = new Dorm();
			dorm.setDid(breakdown.getDid());
			dorm.setBreakdown("正常");
			dormService.breakdown(dorm);
		}
		
	}


	@Override
	public List<Breakdown> myselect() {
		// TODO Auto-generated method stub
		return breakdownDAO.myselect();
	}


	@Override
	public List<Breakdown> selectList(Breakdown breakdown) {
		// TODO Auto-generated method stub
		return breakdownDAO.selectList(breakdown);
	}


	@Override
	public Breakdown selectBreakdown(Breakdown breakdown) {
		// TODO Auto-generated method stub
		return breakdownDAO.selectBreakdown(breakdown);
	}


	@Override
	public void delete(Breakdown breakdown) {
		// TODO Auto-generated method stub
		breakdownDAO.delete(breakdown);
	}
	
}
