package com.frank.boot.dao.system;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ComboDao extends BaseMapper {
    List<Map<String,String>> selectUserCombo(Map<String,String> params);
}
