package com.frank.boot.domain.task;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * <p>
 * 定时作业监控日志	
 * </p>
 *
 * @author frank
 * @since 2018-09-11
 */
public class QuartzLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String jgroup;
    private String jkey;
    private String jclass;
    /**
     * 执行开始时间
     */
    private Date jstarttime;
    /**
     * 执行结束时间
     */
    private Date jendtime;
    private Long jruntime;
    private String issuccess;
    private String jparams;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJgroup() {
        return jgroup;
    }

    public void setJgroup(String jgroup) {
        this.jgroup = jgroup;
    }

    public String getJkey() {
        return jkey;
    }

    public void setJkey(String jkey) {
        this.jkey = jkey;
    }

    public String getJclass() {
        return jclass;
    }

    public void setJclass(String jclass) {
        this.jclass = jclass;
    }

    public Date getJstarttime() {
        return jstarttime;
    }

    public void setJstarttime(Date jstarttime) {
        this.jstarttime = jstarttime;
    }

    public Date getJendtime() {
        return jendtime;
    }

    public void setJendtime(Date jendtime) {
        this.jendtime = jendtime;
    }

    public String getIssuccess() {
        return issuccess;
    }

    public void setIssuccess(String issuccess) {
        this.issuccess = issuccess;
    }

    public String getJparams() {
        return jparams;
    }

    public void setJparams(String jparams) {
        this.jparams = jparams;
    }

    public Long getJruntime() {
        return jruntime;
    }

    public void setJruntime(Long jruntime) {
        this.jruntime = jruntime;
    }

    @Override
    public String toString() {
        return "QuartzLog{" +
        "id=" + id +
        ", jgroup=" + jgroup +
        ", jkey=" + jkey +
        ", jclass=" + jclass +
        ", jstarttime=" + jstarttime +
        ", jendtime=" + jendtime +
        ", issuccess=" + issuccess +
        ", jparams=" + jparams +
        "}";
    }
}
