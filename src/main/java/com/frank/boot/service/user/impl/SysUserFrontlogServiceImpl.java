package com.frank.boot.service.user.impl;

import com.frank.boot.domain.user.SysUserFrontlog;
import com.frank.boot.dao.user.SysUserFrontlogMapper;
import com.frank.boot.service.user.SysUserFrontlogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
/**
 * <p>
 * 用户前端页面操作日志  两种类型  路由切换 按钮点击 服务实现类
 * </p>
 *
 * @author frank
 * @since 2018-08-02
 */
@Service
public class SysUserFrontlogServiceImpl extends ServiceImpl<SysUserFrontlogMapper, SysUserFrontlog> implements SysUserFrontlogService {
}

