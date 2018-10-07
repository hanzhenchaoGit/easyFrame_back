package com.frank.boot.service.system.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.frank.boot.service.system.SystemService;
import com.frank.boot.dao.system.CommonDao;
import com.frank.boot.dao.system.SysSqlConfigMapper;
import com.frank.boot.domain.system.SysSqlConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SystemServiceImpl extends ServiceImpl<SysSqlConfigMapper, SysSqlConfig> implements SystemService {
    @Autowired
    CommonDao commonDao;
    @Override
    public Page<SysSqlConfig> excuteSqlByPager(Page<SysSqlConfig> pager, String sql, String uuid) {
        pager.setSearchCount(true);
        List result = commonDao.excuteQueryByPager(pager,sql);
        return pager.setRecords(result);
    }

    @Override
    public List excuteSql(String sql, String uuid) {
        return commonDao.excuteQueryList(sql);
    }
}
