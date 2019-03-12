package com.frank.boot.domain.system;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.frank.boot.domain.user.SysPermission;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 系统菜单
 * </p>
 *
 * @author frank
 * @since 2018-06-25
 */
@Data
public class SysMenus implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 菜单上级id
     */
    private Integer pid;
    /**
     * 菜单名
     */
    private String name;
    /**
     * 图标
     */
    @TableField(strategy= FieldStrategy.IGNORED)
    private String icon;
    /**
     * 可访问的角色
     */
    private String roles;
    /**
     * 标题
     */
    private String label;

    private String path;

    private String component;

    private String mtype;
    @TableField(exist = false)
    private Boolean checked=true;
    @TableField(exist = false)
    private List<SysMenus> children;
    @TableField(strategy = FieldStrategy.IGNORED)
    private String permissions;
    @TableField(exist = false)
    private List<SysPermission> permissionsArray;
    
}
