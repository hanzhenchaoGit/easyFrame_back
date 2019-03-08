package com.frank.boot.domain.task;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;

public class ReportHy {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String hy;
    private String subhy;
    private String datamonth;
    private String reportType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHy() {
        return hy;
    }

    public void setHy(String hy) {
        this.hy = hy;
    }

    public String getSubhy() {
        return subhy;
    }

    public void setSubhy(String subhy) {
        this.subhy = subhy;
    }

    public String getDatamonth() {
        return datamonth;
    }

    public void setDatamonth(String datamonth) {
        this.datamonth = datamonth;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }
}
