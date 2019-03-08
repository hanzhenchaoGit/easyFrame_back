package com.frank.boot.dao.user;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.frank.boot.domain.user.SysRole;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysRoleMapper extends BaseMapper<SysRole> {
    @Select("select r.id,r.role_name as roleName,r.role_key as roleKey,r.role_note as roleNote " +
            "from sys_user_role ur join sys_role r on ur.user_id=r.id where ur.user_id= #{userid}")
    List<SysRole> selectUserRoleByUserId(String userName);
}