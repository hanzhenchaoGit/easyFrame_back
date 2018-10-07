package com.frank.boot.service.user.impl;

import com.frank.boot.domain.user.SysUserloginLog;
import com.frank.boot.dao.user.SysUserloginLogMapper;
import com.frank.boot.service.user.SysUserloginLogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
/**
 * <p>
 * 系统用户登录日志 服务实现类
 * </p>
 *
 * @author frank
 * @since 2018-08-03
 */
@Service
public class SysUserloginLogServiceImpl extends ServiceImpl<SysUserloginLogMapper, SysUserloginLog> implements SysUserloginLogService {
}

