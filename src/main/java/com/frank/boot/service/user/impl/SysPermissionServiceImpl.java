package com.frank.boot.service.user.impl;

import com.frank.boot.domain.user.SysPermission;
import com.frank.boot.dao.user.SysPermissionMapper;
import com.frank.boot.service.user.SysPermissionService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author frank
 * @since 2018-07-31
 */
@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements SysPermissionService {
}

