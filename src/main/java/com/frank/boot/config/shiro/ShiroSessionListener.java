package com.frank.boot.config.shiro;


import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListenerAdapter;
/**
 * session监控 记录用户日志
 * @author Administrator
 *
 */
public class ShiroSessionListener extends SessionListenerAdapter{
	
	@Override
	public void onExpiration(Session session) {
		super.onExpiration(session);
		System.out.println(session.getId()+" 登陆的--------------session id ---------");
	}
	@Override
	public void onStart(Session session) {
		super.onStart(session);
	}
	@Override
	public void onStop(Session session) {
		System.out.println(session.getId()+"登出的--------------session id ---------");
		super.onStop(session); 
		
	}   
	
	 
 
}
