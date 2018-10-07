package com.frank.boot.domain.user;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * <p>
 * 系统用户操作数据库记录表
 * </p>
 *
 * @author frank
 * @since 2018-08-02
 */
public class SysGlobalsqllog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String userid;
    private String username;
    private String mapperid;
    private String sql;
    private String params;
    private String operate;
    private Long excutetime;
    private Integer resultcount;
    private Date datatime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMapperid() {
        return mapperid;
    }

    public void setMapperid(String mapperid) {
        this.mapperid = mapperid;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    public Long getExcutetime() {
        return excutetime;
    }

    public void setExcutetime(Long excutetime) {
        this.excutetime = excutetime;
    }

    public Integer getResultcount() {
        return resultcount;
    }

    public void setResultcount(Integer resultcount) {
        this.resultcount = resultcount;
    }

    public Date getDatatime() {
        return datatime;
    }

    public void setDatatime(Date datatime) {
        this.datatime = datatime;
    }

    @Override
    public String toString() {
        return "SysGlobalsqllog{" +
        "id=" + id +
        ", userid=" + userid +
        ", username=" + username +
        ", mapperid=" + mapperid +
        ", sql=" + sql +
        ", params=" + params +
        ", operate=" + operate +
        ", excutetime=" + excutetime +
        ", resultcount=" + resultcount +
        ", datatime=" + datatime +
        "}";
    }
}
