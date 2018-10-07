package com.frank.boot.utils;

import com.frank.boot.controller.base.BaseController;
import org.springframework.cache.interceptor.KeyGenerator;
import java.lang.reflect.Method;
import java.util.Map;

public class CacheKeyGenerator extends BaseController implements KeyGenerator {
    @Override
    public Object generate(Object target, Method method, Object... params) {

        Map<String,String> reqParams = getRequestParamStrMap();
        System.out.println(reqParams.toString()+method.getName());
        return "123123";
    }
}
