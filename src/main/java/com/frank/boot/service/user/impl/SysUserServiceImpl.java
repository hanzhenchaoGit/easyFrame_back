package com.frank.boot.service.user.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.frank.boot.dao.user.SysUserRoleMapper;
import com.frank.boot.domain.user.SysUser;
import com.frank.boot.domain.user.SysUserOrganizational;
import com.frank.boot.dao.user.SysUserMapper;
import com.frank.boot.dao.user.SysUserOrganizationalMapper;
import com.frank.boot.domain.user.SysUserRole;
import com.frank.boot.service.user.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author frank
 * @since 2018-06-15
 */
@Service("userService")
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    @Autowired
    SysUserMapper sysUserMapper;
    @Autowired
    SysUserRoleMapper sysUserRoleMapper;
    @Autowired 
    SysUserOrganizationalMapper sysUserOrganizationalMapper;
    @Override
    public SysUser getUserByUsername(String userName) {
        return sysUserMapper.selectUserInfoByUserId(userName);
    }

    @Override
    public Page selectUserPage(Page pager, Map<String,String> params) {
        pager.setRecords(sysUserMapper.selectUserInfoByPager(pager,params));
        return pager;
    }

    @Override
    public void addUser(SysUser sysUser) {
        this.saveOrUpdate(sysUser);
        System.out.println("USERID= " + sysUser.getId());
        String [] orgIds = sysUser.getOrganization().split(",");
        sysUserOrganizationalMapper.delete(new QueryWrapper<SysUserOrganizational>().eq("userid", sysUser.getId()));
        for (String orgId : orgIds) {
        	SysUserOrganizational userOrg = new SysUserOrganizational();
        	userOrg.setOrgid(orgId);
        	userOrg.setUserid(sysUser.getId());
        	sysUserOrganizationalMapper.insert(userOrg);
		}
    }

	@Override
	public void addUserRole(List<SysUserRole> userRoles) {
		sysUserRoleMapper.delete(new QueryWrapper<SysUserRole>().eq("user_id", userRoles.get(0).getUserId()));
		userRoles.forEach(u->{
			sysUserRoleMapper.insert(u);
		});
	}

	@Override
	public void disableUserStatus(String ids) {
//		SysUser user = new SysUser();
//		user.setUserEnable(2);
//		Arrays.asList(ids.split(",")).stream().forEach(x -> 
//		sysUserMapper.update(user, new QueryWrapper<SysUser>().eq("id", x)));
	}

	@Override
	public void updateUserInfo(String operate, String userids) {
		List<String> userIds = Arrays.asList(userids.split(","));
		switch(operate){
			case "disable":{
				userIds.stream().forEach(x -> {
					sysUserMapper.disableUser(x);
				});
				break;
			}
			case "resetpwd":{
				userIds.stream().forEach(x -> {
					sysUserMapper.resetUserPassword(x);
				});
				break;
			}
		}
	}
}

