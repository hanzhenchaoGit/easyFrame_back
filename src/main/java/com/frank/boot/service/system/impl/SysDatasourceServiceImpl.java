package com.frank.boot.service.system.impl;

import com.frank.boot.domain.system.SysDatasource;
import com.frank.boot.dao.system.SysDatasourceMapper;
import com.frank.boot.service.system.SysDatasourceService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
/**
 * <p>
 * 系统数据源	 服务实现类
 * </p>
 *
 * @author frank
 * @since 2018-06-14
 */
@Service
public class SysDatasourceServiceImpl extends ServiceImpl<SysDatasourceMapper, SysDatasource> implements SysDatasourceService {
}

