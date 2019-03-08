package com.frank.boot.dao.system;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface CommonDao {
	@Select("${sql}")
	List<Map<String, Object>> excuteQueryList(@Param("sql") String sql);

	@Select("${sql}")
	List<Map<String, Object>> excuteQueryByPager(Page<?> page, @Param("sql") String sql);
}
