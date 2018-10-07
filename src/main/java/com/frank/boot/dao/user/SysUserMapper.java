package com.frank.boot.dao.user;


import com.baomidou.mybatisplus.plugins.Page;
import com.frank.boot.domain.user.SysUser;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface SysUserMapper extends com.baomidou.mybatisplus.mapper.BaseMapper<SysUser> {
    public List<SysUser>  selectUserInfoByPager(Page<SysUser> pager,Map<String,String> params);

    SysUser selectUserInfoByUserId(String userName);
    @Update("update sys_user set user_enable='2' where id =#{id}")
    int disableUser(@Param(value="id") String id);
    @Update("update sys_user set pass_word='4280d89a5a03f812751f504cc10ee8a5' where id =#{id}")
    int resetUserPassword(@Param(value="id") String id);
}