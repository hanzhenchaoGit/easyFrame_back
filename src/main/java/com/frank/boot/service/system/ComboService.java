package com.frank.boot.service.system;

import java.util.List;
import java.util.Map;

public interface ComboService {
    List<Map<String,String>> getKsCombo(Map<String,String> params);
}
