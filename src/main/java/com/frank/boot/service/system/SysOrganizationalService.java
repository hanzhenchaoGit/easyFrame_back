package com.frank.boot.service.system;

import com.frank.boot.domain.system.SysOrganizational;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * <p>
 * 系统组织架构 服务类
 * </p>
 *
 * @author frank
 * @since 2018-07-27
 */
public interface SysOrganizationalService extends IService<SysOrganizational> {
    List<SysOrganizational> getAllOrganizationalsByPid(int pid);
}
