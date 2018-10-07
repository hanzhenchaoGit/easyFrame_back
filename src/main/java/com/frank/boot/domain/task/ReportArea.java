package com.frank.boot.domain.task;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author frank
 * @since 2018-09-29
 */
public class ReportArea implements Serializable {

    private static final long serialVersionUID = 1L;

    private String state;
    private String city;
    private String datamonth;
    private Long sequence;
    private String reportField;


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDatamonth() {
        return datamonth;
    }

    public void setDatamonth(String datamonth) {
        this.datamonth = datamonth;
    }

    public Long getSequence() {
        return sequence;
    }

    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }

    public String getReportField() {
        return reportField;
    }

    public void setReportField(String reportField) {
        this.reportField = reportField;
    }

    @Override
    public String toString() {
        return "ReportArea{" +
        "state=" + state +
        ", city=" + city +
        ", datamonth=" + datamonth +
        ", sequence=" + sequence +
        ", reportField=" + reportField +
        "}";
    }
}
