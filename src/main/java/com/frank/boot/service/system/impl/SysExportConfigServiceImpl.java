package com.frank.boot.service.system.impl;

import com.frank.boot.domain.system.SysExportConfig;
import com.frank.boot.dao.system.SysExportConfigMapper;
import com.frank.boot.service.system.SysExportConfigService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
/**
 * <p>
 * 表格导出配置 服务实现类
 * </p>
 *
 * @author frank
 * @since 2018-06-19
 */
@Service("export")
public class SysExportConfigServiceImpl extends ServiceImpl<SysExportConfigMapper, SysExportConfig> implements SysExportConfigService {
}

