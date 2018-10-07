package com.frank.boot.webservice.export;

import org.springframework.stereotype.Service;

import javax.jws.WebMethod;

@Service("testExp")
public class TestExportWebservice {
    @WebMethod
    public String printMsg(String msg){
        return "hello:"+msg;
    }
}
