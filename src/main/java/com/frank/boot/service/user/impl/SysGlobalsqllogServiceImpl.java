package com.frank.boot.service.user.impl;

import com.frank.boot.domain.user.SysGlobalsqllog;
import com.frank.boot.dao.user.SysGlobalsqllogMapper;
import com.frank.boot.service.user.SysGlobalsqllogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
/**
 * <p>
 * 系统用户操作数据库记录表 服务实现类
 * </p>
 *
 * @author frank
 * @since 2018-08-02
 */
@Service
public class SysGlobalsqllogServiceImpl extends ServiceImpl<SysGlobalsqllogMapper, SysGlobalsqllog> implements SysGlobalsqllogService {
}

