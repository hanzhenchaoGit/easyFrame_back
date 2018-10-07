package com.frank.boot.domain.system;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

public class SysRemoteserviceLog {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String target;

    private String success;

    private String msg;

    private Date datetime;

    private String pk;

    private String pkvalue;

    private String operate;

    private String resend;
    public Integer getId() {
        return id;
    }

    public SysRemoteserviceLog setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public SysRemoteserviceLog setName(String name) {
        this.name = name;
        return this;
    }

    public String getTarget() {
        return target;
    }

    public SysRemoteserviceLog setTarget(String target) {
        this.target = target;
        return this;
    }

    public String getSuccess() {
        return success;
    }

    public SysRemoteserviceLog setSuccess(String success) {
        this.success = success;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public SysRemoteserviceLog setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Date getDatetime() {
        return datetime;
    }

    public SysRemoteserviceLog setDatetime(Date datetime) {
        this.datetime = datetime;
        return this;
    }

    public String getPk() {
        return pk;
    }

    public SysRemoteserviceLog setPk(String pk) {
        this.pk = pk;
        return this;
    }

    public String getPkvalue() {
        return pkvalue;
    }

    public SysRemoteserviceLog setPkvalue(String pkvalue) {
        this.pkvalue = pkvalue;
        return this;
    }

    public String getOperate(){
        return operate;
    }
    public SysRemoteserviceLog setOperate(String operate) {
        this.operate=operate;
        return this;
    }

    public String getResend() {
        return resend;
    }

    public void setResend(String resend) {
        this.resend = resend;
    }
}
