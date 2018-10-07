package com.frank.boot.domain.report;

import java.math.BigDecimal;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author frank
 * @since 2018-09-10
 */
public class XsReportCurrentByks implements Serializable {

    private static final long serialVersionUID = 1L;

    private String datamonth;
    private String groupname;
    private Integer groupid;
    private String group;
    private Integer userid;
    private String username;
    private Long zxsl;
    private BigDecimal zxcdcount;
    private String zxcdlv;
    private BigDecimal newcusdk;
    private BigDecimal oldcusdk;
    private BigDecimal received;


    public String getDatamonth() {
        return datamonth;
    }

    public void setDatamonth(String datamonth) {
        this.datamonth = datamonth;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getZxsl() {
        return zxsl;
    }

    public void setZxsl(Long zxsl) {
        this.zxsl = zxsl;
    }

    public BigDecimal getZxcdcount() {
        return zxcdcount;
    }

    public void setZxcdcount(BigDecimal zxcdcount) {
        this.zxcdcount = zxcdcount;
    }

    public String getZxcdlv() {
        return zxcdlv;
    }

    public void setZxcdlv(String zxcdlv) {
        this.zxcdlv = zxcdlv;
    }

    public BigDecimal getNewcusdk() {
        return newcusdk;
    }

    public void setNewcusdk(BigDecimal newcusdk) {
        this.newcusdk = newcusdk;
    }

    public BigDecimal getOldcusdk() {
        return oldcusdk;
    }

    public void setOldcusdk(BigDecimal oldcusdk) {
        this.oldcusdk = oldcusdk;
    }

    public BigDecimal getReceived() {
        return received;
    }

    public void setReceived(BigDecimal received) {
        this.received = received;
    }

    @Override
    public String toString() {
        return "XsReportCurrentByks{" +
        "datamonth=" + datamonth +
        ", groupname=" + groupname +
        ", groupid=" + groupid +
        ", group=" + group +
        ", userid=" + userid +
        ", username=" + username +
        ", zxsl=" + zxsl +
        ", zxcdcount=" + zxcdcount +
        ", zxcdlv=" + zxcdlv +
        ", newcusdk=" + newcusdk +
        ", oldcusdk=" + oldcusdk +
        ", received=" + received +
        "}";
    }
}
