package com.woniu.dorm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.woniu.dorm.pojo.Perm;
import com.woniu.dorm.pojo.Role;
import com.woniu.dorm.pojo.User;

public interface UserMapper {
	
	@Select("select * from login where account=#{account}")
	public User login(User user);
	@Insert("insert into login(account,pwd) value(#{account},#{pwd})")
	public void add(User user);
	
	@Select("select * from login where account=#{account}")
	@Results({
		@Result(id = true,column = "lid",property = "lid"),
		@Result(column = "account",property = "account"),
		@Result(column = "pwd",property = "pwd"),
		@Result(property = "roles",column = "lid",many = @Many(select = "getRole"))
		
	})
	public User  roles(User user);
	
	@Select("SELECT * FROM role,login_role WHERE lid=#{lid} AND role.rid=login_role.rid")
	public List<Role> getRole(int lid);
	
	@Select("select * from role where rid=#{rid}")
	@Results({
		@Result(id = true,column = "rid",property = "rid"),
		@Result(column = "rname",property = "rname"),
		@Result(property = "perms",column = "rid",many = @Many(select = "getPerm"))
		
	})
	public Role perms(Role role);
	
	
	@Select("SELECT * FROM perm,role_perm WHERE rid =#{rid} AND perm.pid = role_perm.pid")
	public List<Perm> getPerm(int rid); 

	

	
	
}
