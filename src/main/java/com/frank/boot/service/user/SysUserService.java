package com.frank.boot.service.user;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.frank.boot.domain.user.SysUser;
import com.frank.boot.domain.user.SysUserRole;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author frank
 * @since 2018-06-15
 */
public interface SysUserService extends IService<SysUser> {
    SysUser getUserByUsername(String userName);

    Page selectUserPage(Page pager,Map<String,String> params);

    void addUser(SysUser sysUser);
    
	void addUserRole(List<SysUserRole> userRoles);
	
	void disableUserStatus(String id);

	void updateUserInfo(String operate, String userids);

}
