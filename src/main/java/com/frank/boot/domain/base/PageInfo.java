package com.frank.boot.domain.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

@Data
public class PageInfo<T> {
    @TableField(exist = false)
    @JSONField(serialize=false)
    private int pageSize;
    @TableField(exist = false)
    @JSONField(serialize=false)
    private int pageNumber;
    @JSONField(serialize=false)
    public Page<T> getPage() {
        Page<T> page = new Page<>();
        page.setCurrent(this.pageNumber);
        page.setSize(this.pageSize);
        return  page;
    }
}
