package com.frank.boot.controller.user;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.frank.boot.annotation.Export;
import com.frank.boot.controller.base.BaseController;
import com.frank.boot.domain.system.SysMenus;
import com.frank.boot.domain.user.SysRole;
import com.frank.boot.exception.SystemException;
import com.frank.boot.service.system.SysMenusService;
import com.frank.boot.utils.ShiroSessionUtils;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.frank.boot.service.user.SysRoleService;
import com.frank.boot.service.user.SysUserService;
import com.frank.boot.domain.user.SysUser;
import com.frank.boot.domain.user.SysUserRole;
import org.apache.commons.lang.StringUtils;
import java.util.*;
import com.frank.boot.domain.system.ResultData;
import com.frank.boot.exception.PagerException;
/**
 * user Controller
 * @author frank
 * @since 2018-06-15
 */

@RestController
@RequestMapping("/user")
public class SysUserController extends BaseController{
    @Autowired
    SysUserService iSysUserService;
    @Autowired
    SysMenusService sysMenusService;
    @Autowired
    SysRoleService iSysRoleService;
    @Autowired
    ShiroSessionUtils sessionUtils;
    @Value("${system.password.hashIterations}")
    private int hashIterations;
    @PostMapping("/addSysUser")
    public ResultData add(@RequestBody SysUser iSysUser) {
        iSysUserService.addUser(iSysUser);
        return new ResultData();
    }
    
    @PostMapping("/addSysUserRoles")
    public ResultData addUserRole(@RequestBody List<SysUserRole> userRoles) {
        iSysUserService.addUserRole(userRoles);
        return new ResultData();
    }
    // 根据部门编码获取用户信息
    @Export("cee6873a-83ea-46ef-bf76-175eb323829a")
    @GetMapping("/getSysUserByOrgPager")
    public ResultData getSysUserListByPager() throws PagerException {
        Map<String,String> params = new HashMap<>();
        if(!StringUtils.isEmpty(getString("user_name"))){
            params.put("user_name",getString("user_name"));
        }
        if(!StringUtils.isEmpty(getString("user_enable"))){
            params.put("user_enable",getString("user_enable"));
        }
        params.put("organization", getString("organization"));
        return new ResultData(iSysUserService.selectUserPage(getPager(),params),getPager());
    }
    @GetMapping("/operate/{operate}")
    public ResultData del(@PathVariable(value="operate", required=false) String operate,
    		@RequestParam String userids) {
    	iSysUserService.updateUserInfo(operate,userids);
        return new ResultData();
    }
    @GetMapping("/info")
    public ResultData getUserInfo(@RequestParam String userName) {
        SysUser sysUser = iSysUserService.getUserByUsername(userName);
        List<SysRole> roles = sysUser.getRoles();
        String menuIds = "";
        for(SysRole role : roles){
            if(!StringUtils.isEmpty(role.getMenuids())){
                menuIds+= ","+role.getMenuids();
            }
        }
        if(!StringUtils.isEmpty(menuIds)){
            List<SysMenus> menus = sysMenusService.getMenusByFileter(0,menuIds);
            sysUser.setMenus(menus);
        }
        return new ResultData(sysUser);
    }
    @PostMapping("/modifyPassword")
    public ResultData modifyPassword(@RequestBody Map<String,String> userInfo) throws SystemException {
        String userName = userInfo.get("username");
        if(userName.equals(getCurrentUser().getUserName())){
            String password = userInfo.get("password");
            String hashAlgorithmName = "MD5";
            Object obj = new SimpleHash(hashAlgorithmName, password, "", hashIterations);
            iSysUserService.updateForSet("pass_word='"+obj.toString()+"'",new EntityWrapper<SysUser>().eq("user_name",userName));
        }else{
            throw new SystemException("修改密码失败，用户信息异常，登陆用户不一致！");
        }
        return new ResultData();
    }
}

