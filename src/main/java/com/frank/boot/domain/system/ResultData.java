package com.frank.boot.domain.system;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.frank.boot.utils.SysContent;
import org.apache.commons.lang.StringUtils;
import java.util.HashMap;

/**
 * Controller层返回前端的封装对象
 **/
public class ResultData {
    private String msg;
    private Integer code=SysContent.SUCCESS_CODE;
    private Object data;
    private CommonPager pager;
    private Integer userCount;
    private boolean success = true;
    public ResultData(){

    }
    public ResultData(Integer code){
        this.code = code;
        setAutoMsg(code,"");

    }
    public ResultData(String msg,Integer code){
        this.code = code;
        setAutoMsg(code,msg);
    }
    public ResultData(Integer code,Object data ){
        setAutoMsg(code,"");
        this.code = code;
        setResDatBody(data);
    }
    public ResultData(Object resData){
        setResDatBody(resData);
    }
    public ResultData(String msg,Integer code,Object data ){
        setAutoMsg(code,msg);
        this.code = code;
        setResDatBody(data);
    }
    // 需要导出excel功能时必须要传入pager
    public ResultData(Object resData, CommonPager pager) {
        setResDatBody(resData);
        this.pager = pager;
    }

    private void setAutoMsg(Integer code,String msg){
        if(StringUtils.isEmpty(msg)){
            switch (code) {
                case SysContent.SUCCESS_CODE:
                    this.msg = SysContent.SUCCESS_MSG;
                    break;
                case SysContent.SESSION_TIMEOUT:
                    this.msg = SysContent.SESSION_MSG;
            }
        } else {
            this.msg = msg;
        }
    }
    private void setResDatBody(Object resData){
        if(resData instanceof Page){
            Page page = (Page)resData;
            data = new HashMap<String,Object>();
            ((HashMap) data).put("total",page.getTotal());
            ((HashMap) data).put("items",page.getRecords());
        }else{
            data = resData;
        }
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        setResDatBody(data);
    }

    public CommonPager getPager() {
        return pager;
    }

    public void setPager(CommonPager pager) {
        this.pager = pager;
    }

    public Integer getUserCount() {
        return userCount;
    }

    public void setUserCount(Integer userCount) {
        this.userCount = userCount;
    }
}
