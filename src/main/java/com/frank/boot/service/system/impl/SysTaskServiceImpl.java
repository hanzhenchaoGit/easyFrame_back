package com.frank.boot.service.system.impl;

import com.frank.boot.domain.system.SysTask;
import com.frank.boot.dao.system.SysTaskMapper;
import com.frank.boot.service.system.SysTaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
/**
 * <p>
 * 系统定时作业-quartz 服务实现类
 * </p>
 *
 * @author frank
 * @since 2018-06-20
 */
@Service
public class SysTaskServiceImpl extends ServiceImpl<SysTaskMapper, SysTask> implements SysTaskService {
}

