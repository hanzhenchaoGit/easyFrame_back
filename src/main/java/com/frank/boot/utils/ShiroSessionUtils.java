package com.frank.boot.utils;


import com.frank.boot.domain.user.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@Component
public class ShiroSessionUtils {
    @Autowired
    RedisSessionDAO redisSessionDAO;
    public void setSession(String key,Object value){
        getShiroSession().setAttribute(key,value);
    }
    public Session getShiroSession(){
        return SecurityUtils.getSubject().getSession();
    }
    public SysUser getCurrentUser(){
    	return (SysUser)SecurityUtils.getSubject().getPrincipal();
    }
    public Object getShiroSessionAttr(String key){
        return getShiroSession().getAttribute(key);
    }
    public Collection<Session> getActiveSessions(){
        return redisSessionDAO.getActiveSessions();
    }
    public Integer getOnLineUserCount(){
        return getActiveSessions().size();
    }
    public List<SysUser> getOnLineUsers(){
        Iterator<Session> iterator = getActiveSessions().iterator();
        List<SysUser> users = new ArrayList<>();
        if(iterator.hasNext()){
            Session session = iterator.next();
            users.add((SysUser) session.getAttribute("org.apache.shiro.subject.support.DefaultSubjectContext_PRINCIPALS_SESSION_KEY"));
        }
        return users;
    }
}
