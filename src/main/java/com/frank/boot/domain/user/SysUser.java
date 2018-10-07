package com.frank.boot.domain.user;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.FieldStrategy;
import com.baomidou.mybatisplus.enums.IdType;
import com.frank.boot.domain.system.SysMenus;
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
public class SysUser implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String userName;
    private String passWord;
    private String name;
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
    private String group;
    private String duty;
    @TableField(exist=false)
    private String dutyName;
    private String note;
    @TableField(exist=false)
    private String organization;
    @TableField(exist=false)
    private String organizationNames;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserEnable() {
        return userEnable;
    }

    public void setUserEnable(String userEnable) {
        this.userEnable = userEnable;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getMsn() {
        return msn;
    }

    public void setMsn(String msn) {
        this.msn = msn;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }
    
    public String getOrganizationNames() {
		return organizationNames;
	}

	public void setOrganizationNames(String organizationNames) {
		this.organizationNames = organizationNames;
	}

	public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    public Integer[] getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(Integer[] roleIds) {
        this.roleIds = roleIds;
    }

    public List<SysMenus> getMenus() {
        return menus;
    }

    public void setMenus(List<SysMenus> menus) {
        this.menus = menus;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getDutyName() {
		return dutyName;
	}

	public void setDutyName(String dutyName) {
		this.dutyName = dutyName;
	}

	public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", userName=" + userName +
                ", passWord=" + passWord +
                ", name=" + name +
                ", userEnable=" + userEnable +
                ", headPortrait=" + headPortrait +
                ", mobile=" + mobile +
                ", phone=" + phone +
                ", fax=" + fax +
                ", email=" + email +
                ", qq=" + qq +
                ", msn=" + msn +
                ", birthdate=" + birthdate +
                ", note=" + note +
                "}";
    }
}
