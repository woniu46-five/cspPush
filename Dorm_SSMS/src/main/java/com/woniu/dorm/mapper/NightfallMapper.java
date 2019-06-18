package com.woniu.dorm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.woniu.dorm.pojo.Nightfall;
import com.woniu.dorm.pojo.Student;
import com.woniu.dorm.utils.Page;

public interface NightfallMapper {
	@Select("select * from nightfall limit #{index},#{count}")
		@Results({
			@Result(id = true,column = "nid",property = "nid"),
			@Result(column = "ndate",property = "ndate"),
			@Result(column = "ncouse",property = "ncouse"),
			@Result(property = "student",column = "sid",one = @One(select = "selectStudent"))
			
		})
	public List<Nightfall> all(Page<Nightfall> page);
	@Select("select * from student where sid =#{sid}")
	public Student selectStudent(int sid);
	
	@Select("select count(*) from nightfall ")
	public int total();
	@Insert("insert into nightfall(ncouse,ndate,sid) values(#{ncouse},#{ndate},#{sid})")
	public void add(Nightfall nightfall);
	@Delete("delete from nightfall where nid =#{nid}")
	public void delete(Nightfall nightfall);
	public List<Nightfall> select(Nightfall nightfall);
	@Delete("delete from nightfall where sid =#{sid}")
	public void deleteall(Nightfall nightfall);

}
