package com.frank.boot.service.system;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.frank.boot.domain.system.CommonPager;
import com.frank.boot.domain.system.SysSqlConfig;

import java.util.List;
import java.util.Map;

public interface SystemService extends IService<SysSqlConfig> {

    Page<SysSqlConfig> excuteSqlByPager(Page<SysSqlConfig> pager, String sql, String uuid);

    List excuteSql(String sql, String uuid);
}
