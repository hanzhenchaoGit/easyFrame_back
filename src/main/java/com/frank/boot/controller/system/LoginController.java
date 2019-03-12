package com.frank.boot.controller.system;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.frank.boot.controller.base.BaseController;
import com.frank.boot.exception.PagerException;
import com.frank.boot.domain.system.ResultData;
import com.frank.boot.domain.user.SysUser;
import com.frank.boot.domain.user.SysUserloginLog;
import com.frank.boot.service.user.SysUserService;
import com.frank.boot.service.user.SysUserloginLogService;
import com.frank.boot.utils.DateUtils;
import com.frank.boot.utils.NetUtils;
import com.frank.boot.utils.ShiroSessionUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

@RestController
@RequestMapping(value = "/auth")
public class LoginController extends BaseController {
    @Autowired
    SysUserService userService;
    @Autowired
    SysUserloginLogService logService;
    @Autowired
    ShiroSessionUtils sessionUtils;
    @PostMapping(value = "/login")
    public ResultData submitLogin(@RequestBody Map<String,String> params) {
        ResultData resultData = new ResultData();
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(params.get("username"), params.get("password"));
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
            // 执行到这里说明用户已登录成功
            SysUser user = (SysUser)SecurityUtils.getSubject().getPrincipal();
            user.setPassWord("");
            user.setToken(user.getUserName());
            writeLoginLog("login");
            resultData.setSuccess(true);
            resultData.setData(user);
            return resultData;
        } catch (DisabledAccountException e) {
            resultData.setMsg("账号为禁用状态");
            resultData.setSuccess(false);
            return resultData;
        } catch (IncorrectCredentialsException e) {
            resultData.setMsg("密码错误");
            resultData.setSuccess(false);
            return resultData;
        } catch (UnknownAccountException e) {
            resultData.setMsg("账号不存在");
            resultData.setSuccess(false);
            return resultData;
        }

    }

    @GetMapping("logout")
    public ResultData logout() throws PagerException {
    	writeLoginLog("logout_force");
        getShiroSubject().logout();
        return new ResultData();
    }


    private void writeLoginLog(String logtype){
    	SysUser userInfo = getCurrentUser();
		switch(logtype) {
			case "login":{
				SysUserloginLog log = new SysUserloginLog();
				log.setUserid(userInfo.getUserName());
				log.setUsername(userInfo.getRelName());
				log.setSessionId(sessionUtils.getShiroSession().getId().toString());
				log.setLoginip(NetUtils.getIpAddress(request));
				logService.save(log);
				break;
			}
			case "logout_force": {
//				logService.updateForSet("logoutdate='"+DateUtils.getCurrentDateTime()+"'",
//						new QueryWrapper<SysUserloginLog>().eq("session_id", sessionUtils.getShiroSession().getId().toString()));
				break;
			}
		}
	}
}