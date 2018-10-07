package com.frank.boot.service.system.impl;

import com.frank.boot.dao.system.ComboDao;
import com.frank.boot.service.system.ComboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ComboServiceImpl implements ComboService {
    @Autowired
    ComboDao comboDao;
    @Override
    public List<Map<String, String>> getKsCombo(Map<String, String> params) {
        List<Map<String,String>> ksList = comboDao.selectUserCombo(params);
        return ksList;
    }
}
