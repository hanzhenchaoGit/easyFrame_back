package com.frank.boot.service.system;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.frank.boot.domain.system.SysSqlConfig;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
import java.util.Map;

public interface SystemService extends IService<SysSqlConfig> {

    Page<SysSqlConfig> excuteSqlByPager(Page<SysSqlConfig> pager, String sql, String uuid);

    List excuteSql(String sql, String uuid);
}
