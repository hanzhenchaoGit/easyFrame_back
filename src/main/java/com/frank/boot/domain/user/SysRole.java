package com.frank.boot.domain.user;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.frank.boot.domain.base.PageInfo;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author frank
 * @since 2018-06-19
 */
@Data
public class SysRole extends PageInfo<SysRole> implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String roleName;
    private String roleKey;
    private String roleNote;
    @TableField(strategy=FieldStrategy.IGNORED)
    private String permissions;
    private String menuids;
}
