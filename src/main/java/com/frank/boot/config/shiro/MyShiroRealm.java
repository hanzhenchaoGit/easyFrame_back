package com.frank.boot.config.shiro;

import com.frank.boot.domain.user.SysUser;
import com.frank.boot.service.user.SysRoleService;
import com.frank.boot.service.user.SysUserService;
import com.frank.boot.utils.ShiroSessionUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Iterator;

import static com.frank.boot.utils.SysContent.USER_DISABLED;

public class MyShiroRealm extends AuthorizingRealm {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);

    //如果项目中用到了事物，@Autowired注解会使事物失效，可以自己用get方法获取值
    @Autowired
    private SysRoleService roleService;
    @Autowired
    private SysUserService userService;
    @Autowired
    private ShiroSessionUtils shiroSessionUtils;

    /**
     * 认证信息.(身份验证) : Authentication 是用来验证用户身份
     *
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        logger.info("---------------- 执行 Shiro 凭证认证 ----------------------");
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        String username = token.getUsername();
        SysUser user = new SysUser();
        user.setUserName(username);
        // 从数据库获取对应用户名密码的用户
        user = userService.getUserByUsername(username);
        if (user != null) {
            // 用户为禁用状态
            if (USER_DISABLED.equals(user.getUserEnable())) {
                throw new DisabledAccountException();
            }
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                    user, //用户
                    user.getPassWord(), //密码
                    getName()  //realm name
            );
            String userName = (String)authcToken.getPrincipal();
            DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
            DefaultWebSessionManager sessionManager = (DefaultWebSessionManager)securityManager.getSessionManager();
            Collection<Session> sessions = sessionManager.getSessionDAO().getActiveSessions();//获取当前已登录的用户session列表
            Iterator<Session> iterator = sessions.iterator();
            while(iterator.hasNext()){
                Session session = iterator.next();
                SimplePrincipalCollection simplePrincipalCollection = (SimplePrincipalCollection)session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
                SysUser sessionUser = (SysUser)simplePrincipalCollection.getPrimaryPrincipal();
                if(userName.equals(sessionUser.getUserName())) {
                    sessionManager.getSessionDAO().delete(session);
                }
            }
            return authenticationInfo;
        }
        throw new UnknownAccountException();
    }

    /**
     * 授权 使用shiro标签或者使用shiro注解时才会触发 前后端分离的情况没有卵用
     */

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        logger.info("---------------- 执行 Shiro 权限获取 ---------------------");
//        Object principal = principals.getPrimaryPrincipal();
//        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//        if (principal instanceof SysUser) {
//            SysUser userLogin = (SysUser) principal;
//            Set<String> roles = roleService.findRoleNameByUserId(userLogin.getId());
//            authorizationInfo.addRoles(roles);
//
//            Set<String> permissions = userService.findPermissionsByUserId(userLogin.getId());
//            authorizationInfo.addStringPermissions(permissions);
//        }
//        logger.info("---- 获取到以下权限 ----");
//        logger.info(authorizationInfo.getStringPermissions().toString());
//        logger.info("---------------- Shiro 权限获取成功 ----------------------");
//        return authorizationInfo;
        return null;
    }
    public void clearCurrentUserOtherSession(){

    }

}