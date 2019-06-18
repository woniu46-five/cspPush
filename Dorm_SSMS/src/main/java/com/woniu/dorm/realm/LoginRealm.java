package com.woniu.dorm.realm;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Resource;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import com.woniu.dorm.mapper.UserMapper;
import com.woniu.dorm.pojo.Perm;
import com.woniu.dorm.pojo.Role;
import com.woniu.dorm.pojo.User;

public class LoginRealm extends AuthorizingRealm {
	@Resource
	private UserMapper userService;
	

public UserMapper getUserService() {
		return userService;
	}
	public void setUserService(UserMapper userService) {
		this.userService = userService;
	}
	//	授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		//获得账号
		String account=(String) principals.getPrimaryPrincipal();
		User user = new User();
		user.setAccount(account);
		user = userService.roles(user);
	
		Iterator<Role> iterator = user.getRoles().iterator();
		Set<String> roles = new HashSet<String>();
		Set<String> perms = new HashSet<String>();
		while (iterator.hasNext()) {
			Role role = (Role) iterator.next();
			roles.add(role.getRname());
			role=userService.perms(role);
			Iterator<Perm> piterator = role.getPerms().iterator();
			while (piterator.hasNext()) {
				Perm perm = (Perm) piterator.next();
				perms.add(perm.getPname());			
			}
		}
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
		info.setStringPermissions(perms);
		
		
		
		return info;
	}
//	登陆验证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		String account = (String) token.getPrincipal();
		User user = new User();
		user.setAccount(account);
		user = userService.login(user);
		if (user == null) {
			return null;
		}
		System.out.println(user);
		//返回从数据库获得的加盐的信息
		ByteSource byteSource = ByteSource.Util.bytes(account);
		AuthenticationInfo info = new SimpleAuthenticationInfo(user.getAccount(), user.getPwd(), byteSource,
				this.getName());

		return info;
	}

}
