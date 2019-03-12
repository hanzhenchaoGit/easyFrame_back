package com.frank.boot.domain.user;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.frank.boot.domain.base.PageInfo;
import com.frank.boot.domain.system.SysMenus;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author frank
 * @since 2018-05-25
 */
@Data
public class SysUser extends PageInfo<SysUser> implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String userName;
    private String passWord;
    private String relName;
    @TableField(exist = false)
    private String token;
    /**
     * 是否启用
     */
    private String userEnable;

    @TableField(exist = false)
    private List<SysRole> roles;

    @TableField(exist = false)
    private Integer[] roleIds;

    @TableField(exist = false)
    private List<SysMenus> menus;
    /**
     * 头像
     */
    private String headPortrait;
    @TableField(strategy=FieldStrategy.IGNORED)
    private String mobile;
    @TableField(strategy=FieldStrategy.IGNORED)
    private String phone;
    @TableField(strategy=FieldStrategy.IGNORED)
    private String fax;
    @TableField(strategy=FieldStrategy.IGNORED)
    private String email;
    @TableField(strategy=FieldStrategy.IGNORED)
    private String qq;
    @TableField(strategy=FieldStrategy.IGNORED)
    private String msn;
    @TableField(strategy=FieldStrategy.IGNORED)
    private Date birthdate;
    @TableField(strategy=FieldStrategy.IGNORED)
    private String duty;
    @TableField(exist=false)
    private String dutyName;
    private String note;
    @TableField(exist=false)
    private String organization;
    @TableField(exist=false)
    private String organizationNames;
}
