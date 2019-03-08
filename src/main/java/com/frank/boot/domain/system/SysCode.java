package com.frank.boot.domain.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author frank
 * @since 2018-09-15
 */
public class SysCode implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String codename;
    private String type;
    private String itemcode;
    private String itemname;
    private String para1;
    private String para2;
    private String para3;
    private Integer isnext;
    private String supercode;
    private Integer isedit;
    private String filed1;
    private String filed2;
    private String filed3;
    private String filed4;
    private String filed5;
    private String filed6;
    private String filed7;
    private String filed8;
    private String filed9;
    private String filed10;
    private String filed11;
    private String filed12;
    private String filed13;
    private String filed14;
    private String filed15;
    private String filed16;
    private String filed17;
    private String filed18;
    private String filed19;
    private String filed20;
    private String remark1;
    private String remark2;
    private String remark3;
    private String remark4;
    private String remark5;
    private String createtime;
    private String createuser;
    private String createdept;
    private String orgcode;
    private String updatetime;
    private String updateuser;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodename() {
        return codename;
    }

    public void setCodename(String codename) {
        this.codename = codename;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getPara1() {
        return para1;
    }

    public void setPara1(String para1) {
        this.para1 = para1;
    }

    public String getPara2() {
        return para2;
    }

    public void setPara2(String para2) {
        this.para2 = para2;
    }

    public String getPara3() {
        return para3;
    }

    public void setPara3(String para3) {
        this.para3 = para3;
    }

    public Integer getIsnext() {
        return isnext;
    }

    public void setIsnext(Integer isnext) {
        this.isnext = isnext;
    }

    public String getSupercode() {
        return supercode;
    }

    public void setSupercode(String supercode) {
        this.supercode = supercode;
    }

    public Integer getIsedit() {
        return isedit;
    }

    public void setIsedit(Integer isedit) {
        this.isedit = isedit;
    }

    public String getFiled1() {
        return filed1;
    }

    public void setFiled1(String filed1) {
        this.filed1 = filed1;
    }

    public String getFiled2() {
        return filed2;
    }

    public void setFiled2(String filed2) {
        this.filed2 = filed2;
    }

    public String getFiled3() {
        return filed3;
    }

    public void setFiled3(String filed3) {
        this.filed3 = filed3;
    }

    public String getFiled4() {
        return filed4;
    }

    public void setFiled4(String filed4) {
        this.filed4 = filed4;
    }

    public String getFiled5() {
        return filed5;
    }

    public void setFiled5(String filed5) {
        this.filed5 = filed5;
    }

    public String getFiled6() {
        return filed6;
    }

    public void setFiled6(String filed6) {
        this.filed6 = filed6;
    }

    public String getFiled7() {
        return filed7;
    }

    public void setFiled7(String filed7) {
        this.filed7 = filed7;
    }

    public String getFiled8() {
        return filed8;
    }

    public void setFiled8(String filed8) {
        this.filed8 = filed8;
    }

    public String getFiled9() {
        return filed9;
    }

    public void setFiled9(String filed9) {
        this.filed9 = filed9;
    }

    public String getFiled10() {
        return filed10;
    }

    public void setFiled10(String filed10) {
        this.filed10 = filed10;
    }

    public String getFiled11() {
        return filed11;
    }

    public void setFiled11(String filed11) {
        this.filed11 = filed11;
    }

    public String getFiled12() {
        return filed12;
    }

    public void setFiled12(String filed12) {
        this.filed12 = filed12;
    }

    public String getFiled13() {
        return filed13;
    }

    public void setFiled13(String filed13) {
        this.filed13 = filed13;
    }

    public String getFiled14() {
        return filed14;
    }

    public void setFiled14(String filed14) {
        this.filed14 = filed14;
    }

    public String getFiled15() {
        return filed15;
    }

    public void setFiled15(String filed15) {
        this.filed15 = filed15;
    }

    public String getFiled16() {
        return filed16;
    }

    public void setFiled16(String filed16) {
        this.filed16 = filed16;
    }

    public String getFiled17() {
        return filed17;
    }

    public void setFiled17(String filed17) {
        this.filed17 = filed17;
    }

    public String getFiled18() {
        return filed18;
    }

    public void setFiled18(String filed18) {
        this.filed18 = filed18;
    }

    public String getFiled19() {
        return filed19;
    }

    public void setFiled19(String filed19) {
        this.filed19 = filed19;
    }

    public String getFiled20() {
        return filed20;
    }

    public void setFiled20(String filed20) {
        this.filed20 = filed20;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3;
    }

    public String getRemark4() {
        return remark4;
    }

    public void setRemark4(String remark4) {
        this.remark4 = remark4;
    }

    public String getRemark5() {
        return remark5;
    }

    public void setRemark5(String remark5) {
        this.remark5 = remark5;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser;
    }

    public String getCreatedept() {
        return createdept;
    }

    public void setCreatedept(String createdept) {
        this.createdept = createdept;
    }

    public String getOrgcode() {
        return orgcode;
    }

    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getUpdateuser() {
        return updateuser;
    }

    public void setUpdateuser(String updateuser) {
        this.updateuser = updateuser;
    }

    @Override
    public String toString() {
        return "SysCode{" +
        "id=" + id +
        ", codename=" + codename +
        ", type=" + type +
        ", itemcode=" + itemcode +
        ", itemname=" + itemname +
        ", para1=" + para1 +
        ", para2=" + para2 +
        ", para3=" + para3 +
        ", isnext=" + isnext +
        ", supercode=" + supercode +
        ", isedit=" + isedit +
        ", filed1=" + filed1 +
        ", filed2=" + filed2 +
        ", filed3=" + filed3 +
        ", filed4=" + filed4 +
        ", filed5=" + filed5 +
        ", filed6=" + filed6 +
        ", filed7=" + filed7 +
        ", filed8=" + filed8 +
        ", filed9=" + filed9 +
        ", filed10=" + filed10 +
        ", filed11=" + filed11 +
        ", filed12=" + filed12 +
        ", filed13=" + filed13 +
        ", filed14=" + filed14 +
        ", filed15=" + filed15 +
        ", filed16=" + filed16 +
        ", filed17=" + filed17 +
        ", filed18=" + filed18 +
        ", filed19=" + filed19 +
        ", filed20=" + filed20 +
        ", remark1=" + remark1 +
        ", remark2=" + remark2 +
        ", remark3=" + remark3 +
        ", remark4=" + remark4 +
        ", remark5=" + remark5 +
        ", createtime=" + createtime +
        ", createuser=" + createuser +
        ", createdept=" + createdept +
        ", orgcode=" + orgcode +
        ", updatetime=" + updatetime +
        ", updateuser=" + updateuser +
        "}";
    }
}
