package com.frank.boot.dao.task;

import java.util.List;
import java.util.Map;

public interface ComplexReportDao {
    /**
     * 获取行地域表基础表 用于校验是否需要生成基础数据
     * @param month
     * @return
     */
    public List<Map<String,String>> getAreaBaseMonthTable(String month);

    /**
     * 地域基础表插入上月数据
     * @param month
     */
    public void addLastMonthAreaBaseTable(String month);
}
