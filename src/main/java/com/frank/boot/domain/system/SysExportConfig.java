package com.frank.boot.domain.system;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 表格导出配置
 * </p>
 *
 * @author frank
 * @since 2018-06-20
 */
public class SysExportConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 导出唯一标识
1.普通请求为springmvc的请求加密MD5
如/system/test加密为MD5
2.代理配置的查询为proxy-uuid
     */
    private String uuid;
    /**
     * 请求url
     */
    private String urlPath;
    /**
     * 请求类型  
普通请求pt
代理请求pr

     */
    private String requestType;
    /**
     * 文件名称
     */
    private String sheetName;
    
    private String istem;
    
    private String template;
    
    private Integer startrow;
    
    /**
     * 返回数据的filed
     */
    @TableField(strategy= FieldStrategy.IGNORED)
    private String sqlField;
    /**
     * 导出的excel表头
     */
    @TableField(strategy=FieldStrategy.IGNORED)
    private String colNames;
    @TableField(exist = false)
    private List dataList;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public String getSqlField() {
        return sqlField;
    }

    public void setSqlField(String sqlField) {
        this.sqlField = sqlField;
    }

    public String getColNames() {
        return colNames;
    }

    public void setColNames(String colNames) {
        this.colNames = colNames;
    }

    public List getDataList() {
        return dataList;
    }

    public void setDataList(List dataList) {
        this.dataList = dataList;
    }

    public String getIstem() {
		return istem;
	}

	public void setIstem(String istem) {
		this.istem = istem;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public Integer getStartrow() {
		return startrow;
	}

	public void setStartrow(Integer startrow) {
		this.startrow = startrow;
	}

	@Override
    public String toString() {
        return "SysExportConfig{" +
        "id=" + id +
        ", uuid=" + uuid +
        ", urlPath=" + urlPath +
        ",istem="+istem+
        ",template="+template+
        ", requestType=" + requestType +
        ", sheetName=" + sheetName +
        ", sqlField=" + sqlField +
        ", colNames=" + colNames +
        "}";
    }
}
