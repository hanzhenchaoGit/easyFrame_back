package com.frank.boot.dao.system;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

public interface ComboDao extends BaseMapper {
    List<Map<String,String>> selectUserCombo(Map<String,String> params);
}
