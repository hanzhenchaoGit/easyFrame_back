package com.frank.boot.domain.system;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import com.frank.boot.domain.base.PageInfo;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author frank
 * @since 2018-06-14
 */
public class SysCodegenConfig extends PageInfo<SysCodegenConfig> implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 数据源配置id

     */
    private Integer datasourceId;
    /**
     * 模块划分
     */
    private String module;
    private String tableName;
    /**
     * 作者
     */
    private String author;
    /**
     * 增、删、改、查、分页查询是否带参数
     */
    private String genType;
    /**
     * 单表查询参数
     */
    private String queryParams;
    /**
     * 代码输出目录
     */
    private String outpath;

    private Date createtime;

    private transient SysDatasource sysDatasource;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDatasourceId() {
        return datasourceId;
    }

    public void setDatasourceId(Integer datasourceId) {
        this.datasourceId = datasourceId;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenType() {
        return genType;
    }

    public void setGenType(String genType) {
        this.genType = genType;
    }

    public String getQueryParams() {
        return queryParams;
    }

    public void setQueryParams(String queryParams) {
        this.queryParams = queryParams;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public SysDatasource getSysDatasource() {
        return sysDatasource;
    }

    public void setSysDatasource(SysDatasource sysDatasource) {
        this.sysDatasource = sysDatasource;
    }

    public String getOutpath() {
        return outpath;
    }

    public void setOutpath(String outpath) {
        this.outpath = outpath;
    }

    @Override
    public String toString() {
        return "SysCodegenConfig{" +
        "id=" + id +
        ", datasourceId=" + datasourceId +
        ", module=" + module +
        ", tableName=" + tableName +
        ", author=" + author +
        ", genType=" + genType +
        ", queryParams=" + queryParams +
        ", createtime=" + createtime +
        "}";
    }
}
