package com.frank.boot.service.user.impl;

import com.frank.boot.domain.user.SysRole;
import com.frank.boot.dao.user.SysRoleMapper;
import com.frank.boot.service.user.SysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author frank
 * @since 2018-06-19
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
}

