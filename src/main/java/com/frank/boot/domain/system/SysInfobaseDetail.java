package com.frank.boot.domain.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.frank.boot.domain.base.PageInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.apache.zookeeper.data.Id;

/**
     * <p>
     *
     * </p>
     *
     * @author jobob
     * @since 2019-03-07
     */
    @Data
    @EqualsAndHashCode(callSuper = true)
    @Accessors(chain = true)
    public class SysInfobaseDetail extends PageInfo {

        private static final long serialVersionUID = 1L;
        @TableId(value = "id", type = IdType.AUTO)
        private Integer id;
        private Integer typeId;

        private String itemCode;

        private String itemName;

        private String attr1;

        private String attr2;

        private String attr3;

        private String attr4;


    }