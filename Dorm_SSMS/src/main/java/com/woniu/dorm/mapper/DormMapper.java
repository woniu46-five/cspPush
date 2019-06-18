package com.woniu.dorm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.woniu.dorm.pojo.Dorm;
import com.woniu.dorm.utils.Page;

public interface DormMapper {
	
	public List<Dorm> all(Page<Dorm> page);
	public int allpage();
	public void insertdorm(Dorm dorm);
	public boolean deletedorm(Dorm dorm);
	public Dorm show(Dorm dorm);
	public List<Dorm> myselect(Dorm dorm);
	@Update("update dorm set breakdown=#{breakdown} where did=#{did}")
	public void breakdown(Dorm dorm);
	@Select("select * from dorm")
	public List<Dorm> total();
	@Select("select * from dorm where daddress=#{daddress}")
	public Dorm selectDormbydaddress(Dorm dorm);
	@Update("update dorm set person=#{person} where did=#{did}")
	public void person(Dorm dorm);
}
