package com.frank.boot.service.system.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.frank.boot.domain.system.SysOrganizational;
import com.frank.boot.dao.system.SysOrganizationalMapper;
import com.frank.boot.service.system.SysOrganizationalService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统组织架构 服务实现类
 * </p>
 *
 * @author frank
 * @since 2018-07-27
 */
@Service
public class SysOrganizationalServiceImpl extends ServiceImpl<SysOrganizationalMapper, SysOrganizational> implements SysOrganizationalService {
    @Override
    public List<SysOrganizational> getAllOrganizationalsByPid(int pid) {
        return getOrgByPid(pid);
    }
    private List<SysOrganizational> getOrgByPid(int pId) {
        EntityWrapper<SysOrganizational> query = new EntityWrapper<>();
        query.eq("pid", pId);
        List<SysOrganizational> orgs = this.selectList(query);
        if (orgs.size() > 0) {
            for (SysOrganizational menu : orgs) {
                menu.setChildren(this.getOrgByPid(menu.getId()));
            }
        }
        return orgs;
    }
}

