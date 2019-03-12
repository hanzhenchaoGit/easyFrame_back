package com.frank.boot.domain.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 系统组织架构
 * </p>
 *
 * @author frank
 * @since 2018-07-27
 */
@Data
public class SysOrganizational implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer pid;
    @TableField(value = "name")
    private String label;
    private String note;
    private Integer orderSort;
    private Date createtime;
    private Date updatetime;
    @TableField(exist = false)
    private List<SysOrganizational> children;

}
