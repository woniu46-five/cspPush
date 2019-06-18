package com.woniu.dorm.handler;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woniu.dorm.mapper.UserMapper;
import com.woniu.dorm.pojo.User;

@Controller
@RequestMapping("/user")
public class UserHandler extends MyExceptionHandler {
	@Resource
	private UserMapper userService;
	
	
	public UserMapper getUserService() {
		return userService;
	}


	public void setUserService(UserMapper userService) {
		this.userService = userService;
	}

	@RequestMapping("/login")
	public String login(@Validated User user,Object remeberme,BindingResult result) throws Exception {
		
		if (result.hasErrors()) {
			return "/html/login.html";
		}
		
		
		Subject cuser = SecurityUtils.getSubject();
		
//		验证是否已经登陆过
		if (!cuser.isAuthenticated()) {
			// 创建token
		
			UsernamePasswordToken token = new UsernamePasswordToken(user.getAccount(), user.getPwd());
			if (remeberme!=null) {
				token.setRememberMe(true);
			}
			try {
				cuser.login(token);
			
				return "redirect:/html/clazz.jsp";
			} catch (UnknownAccountException e) {
				// TODO: handle exception
				
			} catch (IncorrectCredentialsException e) {
				// TODO: handle exception
				
			} catch (LockedAccountException e) {
				// TODO: handle exception
				
			}
		} else {
			
			return "/html/clazz.jsp";

		}

		
		return "/html/login.html";
	}
	
	@RequestMapping("/register")
	public String register(User user) throws Exception {
		user.setPwd(new SimpleHash("MD5", user.getPwd(), user.getAccount(), 10).toString());
	
		
		userService.add(user);
		
		return "/html/main.html";
	}
	
	
}
