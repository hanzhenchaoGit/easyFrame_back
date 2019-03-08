package com.frank.boot.domain.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class SysOrganizational implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer pid;
    @TableField(value = "name")
    private String label;
    private String note;
    private Integer order;
    // 组织分组 主动:ZD 被动:BD 分公司事业:FG
    private String group;
    private String parentgroup;
    private Date createtime;
    private Date updatetime;
    @TableField(exist = false)
    private List<SysOrganizational> children;

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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public List<SysOrganizational> getChildren() {
        return children;
    }

    public void setChildren(List<SysOrganizational> children) {
        this.children = children;
    }

    
    public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

    public String getParentgroup() {
        return parentgroup;
    }

    public void setParentgroup(String parentgroup) {
        this.parentgroup = parentgroup;
    }

    @Override
    public String toString() {
        return "SysOrganizational{" +
        "id=" + id +
        ", pid=" + pid +
        ", label=" + label +
          ", group=" + group +
        ", note=" + note +
        ", order=" + order +
        ", createtime=" + createtime +
        ", updatetime=" + updatetime +
        "}";
    }
}
