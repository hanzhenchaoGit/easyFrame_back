package com.frank.boot.domain.system;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author frank
 * @since 2018-09-05
 */
public class UploadFileList implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String groupid;
    private String filesize;
    private String filename;
    private String fileurl;
    private String fileremark;
    private Date uploadtime;
    private String uploaduser;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public String getFilesize() {
        return filesize;
    }

    public void setFilesize(String filesize) {
        this.filesize = filesize;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFileurl() {
        return fileurl;
    }

    public void setFileurl(String fileurl) {
        this.fileurl = fileurl;
    }

    public String getFileremark() {
        return fileremark;
    }

    public void setFileremark(String fileremark) {
        this.fileremark = fileremark;
    }

    public Date getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
    }

    public String getUploaduser() {
        return uploaduser;
    }

    public void setUploaduser(String uploaduser) {
        this.uploaduser = uploaduser;
    }

    @Override
    public String toString() {
        return "UploadFileList{" +
        "id=" + id +
        ", groupid=" + groupid +
        ", filesize=" + filesize +
        ", filename=" + filename +
        ", fileurl=" + fileurl +
        ", fileremark=" + fileremark +
        ", uploadtime=" + uploadtime +
        ", uploaduser=" + uploaduser +
        "}";
    }
}
