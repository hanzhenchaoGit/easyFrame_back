package com.frank.boot.dao.system;

import com.frank.boot.domain.system.SysOrganizational;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统组织架构 Mapper 接口
 * </p>
 *
 * @author frank
 * @since 2018-07-27
 */
public interface SysOrganizationalMapper extends BaseMapper<SysOrganizational> {
    Map<String,String> selectSybGroupIds(@Param("groupType") String groupType);
    Map<String,String> selectSybGroupIdsByUserKs(@Param("ks") String ks);
    Map<String,String> selectSyqByKs(@Param("ks") String ks);
    @Select("select id,pid,name as label from sys_organizational where pid =#{pid} ")
    List<Map<String,Object>> selectOrgByPid(@Param("pid") String pid);
    @Select("select distinct sys_user.user_name as  id,''as pid, sys_user.name as label,'Y' isxs " +
            "from sys_user_organizational join sys_user on sys_user.id = sys_user_organizational.userid where orgid = #{id}")
    List<Map<String,Object>> selectUserByOrgId(@Param("id") String id);
}
