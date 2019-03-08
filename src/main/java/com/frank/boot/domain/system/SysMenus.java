package com.frank.boot.domain.system;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.frank.boot.domain.user.SysPermission;
import com.baomidou.mybatisplus.annotation.TableId;
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
    @TableField(exist = false)
    private Boolean checked=true;
    @TableField(exist = false)
    private List<SysMenus> children;
    @TableField(strategy = FieldStrategy.IGNORED)
    private String permissions;
    @TableField(exist = false)
    private List<SysPermission> permissionsArray;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<SysMenus> getChildren() {
        return children;
    }

    public void setChildren(List<SysMenus> children) {
        this.children = children;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	public List<SysPermission> getPermissionsArray() {
		return permissionsArray;
	}

	public void setPermissionsArray(List<SysPermission> permissionsArray) {
		this.permissionsArray = permissionsArray;
	}

	@Override
    public String toString() {
        return "SysMenus{" +
        "id=" + id +
        ", pid=" + pid +
        ", name=" + name +
        ", icon=" + icon +
        ", roles=" + roles +
        ", label=" + label +
        "}";
    }
    
}
