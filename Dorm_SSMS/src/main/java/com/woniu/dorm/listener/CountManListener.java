package com.woniu.dorm.listener;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

public class CountManListener implements SessionListener {

	@Override
	public void onStart(Session session) {
		// TODO Auto-generated method stub
		System.out.println("session创建");
	}

	@Override
	public void onStop(Session session) {
		// TODO Auto-generated method stub
		System.out.println("session销毁");
	}

	@Override
	public void onExpiration(Session session) {
		// TODO Auto-generated method stub
		System.out.println("session过期");
	}

}
