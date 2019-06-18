package com.woniu.dorm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.woniu.dorm.pojo.Clazz;
import com.woniu.dorm.pojo.Teacher;
import com.woniu.dorm.utils.Page;

public interface ClazzMapper {
	
	@Select("select * from clazz limit #{index},#{count}")
	@Results({
		@Result(id = true,column = "cid", property = "cid" ),
		@Result(column = "cname",property = "cname"),
		@Result(column = "cdate",property = "cdate"),
		@Result(property = "teachers",column = "tid",one = @One(select = "selectTeacher" ))
		
	})
	public List<Clazz> all(Page<Clazz> page);
	@Select("select * from teacher where tid=#{tid}")
	public Teacher selectTeacher(int tid);
	@Select("select count(*) from clazz")
	public int allpage();
	@Insert("insert into clazz(cname,cdate,tid) values(#{cname},#{cdate},#{teachers.tid})")
	public void add(Clazz clazz);
	@Delete("delete from clazz where cid =#{cid}")
	public boolean delete(Clazz clazz);
	@Select("select * from clazz")
	public List<Clazz> total();
	@Select("select * from clazz where cname=#{cname}")
	public Clazz selectbycname(Clazz clazz);

}
