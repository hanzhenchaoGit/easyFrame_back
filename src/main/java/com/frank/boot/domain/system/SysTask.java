package com.frank.boot.domain.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.frank.boot.domain.base.PageInfo;

import java.io.Serializable;

/**
 * <p>
 * 系统定时作业-quartz
 * </p>
 *
 * @author frank
 * @since 2018-06-20
 */
public class SysTask extends PageInfo<SysTask> implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 作业名称 同时作为jobkey
     */
    private String name;
    /**
     * 作业分组
     */
    private String group;
    /**
     * 作业说明
     */
    private String description;
    /**
     * corn触发表达式
     */
    private String corn;
    /**
     * 作业类
     */
    private String jobClass;
    @TableField(exist = false)
    private String state;
    private Date createtime;
    private String createuserid;
    private String updatetime;
    private String updateuserid;
    /**
     * 是否可用
     */
    private String enabled;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCorn() {
        return corn;
    }

    public void setCorn(String corn) {
        this.corn = corn;
    }

    public String getJobClass() {
        return jobClass;
    }

    public void setJobClass(String jobClass) {
        this.jobClass = jobClass;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCreateuserid() {
        return createuserid;
    }

    public void setCreateuserid(String createuserid) {
        this.createuserid = createuserid;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getUpdateuserid() {
        return updateuserid;
    }

    public void setUpdateuserid(String updateuserid) {
        this.updateuserid = updateuserid;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "SysTask{" +
        "id=" + id +
        ", name=" + name +
        ", group=" + group +
        ", description=" + description +
        ", corn=" + corn +
        ", jobClass=" + jobClass +
        ", createtime=" + createtime +
        ", createuserid=" + createuserid +
        ", updatetime=" + updatetime +
        ", updateuserid=" + updateuserid +
        ", enabled=" + enabled +
        "}";
    }
}
