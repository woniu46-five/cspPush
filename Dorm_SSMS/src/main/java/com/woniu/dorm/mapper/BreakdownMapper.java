package com.woniu.dorm.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.woniu.dorm.pojo.Breakdown;

public interface BreakdownMapper {
	@Insert("insert into breakdown(did,bdescription,bdate,flag) values(#{did},#{bdescription},#{bdate},#{flag})")
	public void  insertbreak(Breakdown breakdown);
	@Update("UPDATE breakdown SET flag=1 WHERE bid=#{bid}")
	public void rbreak(Breakdown breakdown);
	@Select("select * from breakdown where flag = 0")
	public List<Breakdown> myselect();
	@Select("select * from breakdown where did =#{did}")
	public List<Breakdown> selectList(Breakdown breakdown);
	@Select("select * from breakdown where bid=#{bid}")
	public Breakdown selectBreakdown(Breakdown breakdown);
	@Delete("delete from breakdown where did=#{did}")
	public void delete(Breakdown breakdown);
}
