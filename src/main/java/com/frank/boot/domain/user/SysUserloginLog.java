package com.frank.boot.domain.user;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * <p>
 * 系统用户登录日志
 * </p>
 *
 * @author frank
 * @since 2018-08-03
 */
public class SysUserloginLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String sessionId;
    private String userid;
    private String username;
    private Timestamp  logindate;
    private Timestamp  logoutdate;
    private String loginip;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getLogindate() {
        return logindate;
    }

    public void setLogindate(Timestamp logindate) {
        this.logindate = logindate;
    }

    public Date getLogoutdate() {
        return logoutdate;
    }

    public void setLogoutdate(Timestamp logoutdate) {
        this.logoutdate = logoutdate;
    }

    public String getLoginip() {
        return loginip;
    }

    public void setLoginip(String loginip) {
        this.loginip = loginip;
    }

    @Override
    public String toString() {
        return "SysUserloginLog{" +
        "id=" + id +
        ", userid=" + userid +
        ", username=" + username +
        ", logindate=" + logindate +
        ", logoutdate=" + logoutdate +
        ", loginip=" + loginip +
        "}";
    }
}
