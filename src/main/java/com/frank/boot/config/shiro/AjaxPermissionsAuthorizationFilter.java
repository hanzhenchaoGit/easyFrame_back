package com.frank.boot.config.shiro;

import com.alibaba.fastjson.JSONObject;
import com.frank.boot.domain.user.SysUser;
import com.frank.boot.utils.SysContent;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author: frank
 * @description: 对没有登录的请求进行拦截, 全部返回json信息. 覆盖掉shiro原本的跳转login.jsp的拦截方式
 * @date: 2018/06/01 10:11
 */
public class AjaxPermissionsAuthorizationFilter extends FormAuthenticationFilter {

    /**
     * 在访问过来的时候检测是否为OPTIONS请求，如果是就直接返回true
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        if (httpRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            setHeader(httpRequest,httpResponse);
            return true;
        }
        return super.preHandle(request,response);
    }
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        SysUser sysUser = (SysUser)SecurityUtils.getSubject().getPrincipal();
        JSONObject jsonObject = new JSONObject();
        if(sysUser==null){
            //System.out.println(sysUser.getUserName()+" 进入ajax filter");
            jsonObject.put("code",SysContent.SESSION_TIMEOUT);
            jsonObject.put("msg", SysContent.SESSION_MSG);

            PrintWriter out = null;
            HttpServletResponse res = (HttpServletResponse) response;
            try {
                res.setCharacterEncoding("UTF-8");
                res.setContentType("application/json");
                out = response.getWriter();
                out.print(jsonObject);
            } catch (Exception e) {
            } finally {
                if (null != out) {
                    out.flush();
                    out.close();
                }
            }
        }
        return false;
    }

    /**
     * 为response设置header，实现跨域
     */
    private void setHeader(HttpServletRequest request,HttpServletResponse response){
        //跨域的header设置
        response.setHeader("Access-control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Methods", request.getMethod());
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", request.getHeader("Access-Control-Request-Headers"));
        //防止乱码，适用于传输JSON数据
        response.setHeader("Content-Type","application/json;charset=UTF-8");
        response.setStatus(HttpStatus.OK.value());
    }

    @Bean
    public FilterRegistrationBean registration(AjaxPermissionsAuthorizationFilter filter) {
        FilterRegistrationBean registration = new FilterRegistrationBean(filter);
        registration.setEnabled(false);
        return registration;
    }
}