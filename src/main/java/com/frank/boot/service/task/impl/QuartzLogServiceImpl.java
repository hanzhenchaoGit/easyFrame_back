package com.frank.boot.service.task.impl;

import com.frank.boot.domain.task.QuartzLog;
import com.frank.boot.dao.task.QuartzLogMapper;
import com.frank.boot.service.task.QuartzLogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
/**
 * <p>
 * 定时作业监控日志	 服务实现类
 * </p>
 *
 * @author frank
 * @since 2018-09-11
 */
@Service
public class QuartzLogServiceImpl extends ServiceImpl<QuartzLogMapper, QuartzLog> implements QuartzLogService {
}

