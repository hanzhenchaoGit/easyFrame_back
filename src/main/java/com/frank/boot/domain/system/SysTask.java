package com.frank.boot.domain.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.frank.boot.domain.base.PageInfo;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 系统定时作业-quartz
 * </p>
 *
 * @author frank
 * @since 2018-06-20
 */
@Data
public class SysTask extends PageInfo<SysTask> implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 作业名称 同时作为jobkey
     */
    private String taskName;
    /**
     * 作业分组
     */
    private String taskGroup;
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

}
