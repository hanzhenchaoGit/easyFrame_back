package com.frank.boot.controller.base;

import com.frank.boot.dao.system.SysOrganizationalMapper;
import com.frank.boot.domain.system.CommonPager;
import com.frank.boot.domain.user.SysRole;
import com.frank.boot.domain.user.SysUser;
import com.frank.boot.exception.PagerException;
import com.frank.boot.service.user.SysUserService;
import com.frank.boot.utils.SysContent;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import static com.frank.boot.utils.SysContent.DATA_PER_ALL;
import static com.frank.boot.utils.SysContent.DATA_PER_KS;
import static com.frank.boot.utils.SysContent.DATA_PER_SYQ;

/**
 * Controller基类
 */
public class BaseController {
    @Autowired
    public HttpServletRequest request;
    @Autowired
    SysOrganizationalMapper sysOrganizationalMapper;
    @Autowired
    public HttpServletResponse response;

    @Autowired
    SysUserService sysUserService;

    public void setAttribute(String key,Object obj){
        request.setAttribute(key,obj);
    }

    public void setShiroSession(String key,Object value){
        getShiroSubject().getSession().setAttribute(key,value);
    }

    public Object getAttribute(String key){return getShiroSubject().getSession().getAttribute(key);}
    // 获取当前登录对象
    public Subject getShiroSubject(){
       return SecurityUtils.getSubject();
    }

    public String getString(String reqKey){
        return request.getParameter(reqKey);
    }

    public int getInt(String reqKey){
        return Integer.parseInt(request.getParameter(reqKey));
    }
    //获取分页信息
    public CommonPager getPager() throws PagerException {
        CommonPager page = new CommonPager();
           
        if(StringUtils.isEmpty(getString("currentPage"))){
            throw new PagerException(SysContent.PAGER_NO_CURRENTPAGE);
        } else if(StringUtils.isEmpty(getString("pageSize"))){
            throw new PagerException(SysContent.PAGER_NO_PAGESIZSE);
        }

        page.setCurrent(getInt("currentPage"));
        
        //查询所有数据
        String exportType = getString("exportType");
        if(!StringUtils.isEmpty(exportType)){
            page.setExport(true);
            if("exportAll".equals(exportType)){
                page.setSize(Integer.MAX_VALUE);
            }else{
                page.setSize(getInt("pageSize"));
            }
        }else{
        	page.setSize(getInt("pageSize"));
        }
        return page;
    }
  //获取分页信息
    public CommonPager getnoPagerExport() throws PagerException {
        CommonPager page = new CommonPager();
        //查询所有数据
        String exportType = getString("exportType");
        if(!StringUtils.isEmpty(exportType)){
        	page.setExport(true);
        }
        return page;
    }
    
    
    
    public SysUser getCurrentUser(){
        return (SysUser)getShiroSubject().getPrincipal();
    }

    // 获取用户的部门字符串
    public String getUserOrgs(){
        return getCurrentUser().getOrganization();
    }

    /**
     * 获取请求中的查询参数
     * @return
     */
    public Map<String,Object> getRequestParamMap(){
        Map<String,Object> params =  new HashMap<>();
        Enumeration em = request.getParameterNames();
        while (em.hasMoreElements()) {
            String name = (String) em.nextElement();
            String value = request.getParameter(name);
            params.put(name,value);
        }
        return params;
    }
    public Map<String,String> getRequestParamStrMap(){
        Map<String,String> params =  new HashMap<>();
        Enumeration em = request.getParameterNames();
        while (em.hasMoreElements()) {
            String name = (String) em.nextElement();
            String value = request.getParameter(name);
            params.put(name,value);
        }
        return params;
    }

    public String getDataOrgsLimt(){
        return getCurrentUser().getOrganization();
    }

    public String getDataLimt(){
        List<SysRole> roles = getCurrentUser().getRoles();

        String dataType = "";
        String roleId = "";
        boolean continue_ = true;
        for (int i = 0; i < roles.size() ; i++) {
            roleId = roles.get(i).getId().toString();
            if(continue_){
                // 销售总监/总经理查看所有
                if("11".equals(roleId)||"1".equals(roleId)||"2".equals(roleId)||"14".equals(roleId)||"37".equals(roleId)){
                    dataType = DATA_PER_ALL;
                    continue_ = false;
                    // 销售副总监查看所在科室 所在的事业部下的所有科室
                }else if("28".equals(roleId)){
                    dataType = DATA_PER_SYQ;
                    continue_ = false;
                    // 销售主管销售部长查看所在科室
                }else{
                    dataType = DATA_PER_KS;
                    continue_ = false;
                }
            }
        }
        return dataType;
    }

    public Map<String,String> getLimtMap(){
        Map<String,String> params = new HashMap<>();
        params.put("dataLimit",getDataLimt());
        params.put("orgs",getDataOrgsLimt());
        return params;
    }

    public boolean hasRole(String roleId){
        SysUser user = getCurrentUser();
        List<SysRole> roles = user.getRoles();
        boolean hasRole = false;
        for(SysRole role : roles ){
            if(role.getId().toString().equals(roleId)){
                hasRole = true;
            }
        }
        return hasRole;
    }
}
