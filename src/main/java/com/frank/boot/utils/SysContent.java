package com.frank.boot.utils;

/**
 * @Description 系统静态变量
 * @Author xq
 * @Date 2018 2018/5/8 15:15
 * @Param
 * @Version v1.0
 **/
public class SysContent {
    // 请求成功
    public static final int SUCCESS_CODE = 20000;
    // 请求成功msg
    public static final String SUCCESS_MSG = "成功";
    // 用户登陆失效（session超时）或未登陆状态码
    public static final int SESSION_TIMEOUT = 50004;
    // 请求成功msg
    public static final String SESSION_MSG = "用户未登陆或会话超时，请重新登陆！";

    public static final int ERROR_CODE = 50005;

    public static final String PAGER_NO_CURRENTPAGE = "未传入当前页码";

    public static final String PAGER_NO_PAGESIZSE = "未传入每页条数";

    public static final String EXPORT_SUCCESS = "导出成功";

    public static final String EXPORT_FAIL = "导出失败";

    public static final String DEL_SCCESS = "删除成功";

    //---------------------- quartz operate ---------------------
    public static final String QUARTZ_PAUSE="pause";
    public static final String QUARTZ_PAUSEALL="pauseAll";
    public static final String QUARTZ_RESUME="resume";
    public static final String QUARTZ_RESUMEALL="resumeAll";
    public static final String QUARTZ_ADD="add";
    public static final String QUARTZ_REMOVE="remove";


    //----------------------- 数据权限划分 -----------------------
    public static final String DATA_PER_ALL = "all";
    public static final String DATA_PER_SYQ = "syq";
    public static final String DATA_PER_KS = "ks";

    //----------------------- 咨询状态划分 -----------------------
    // 已分配 待确认
    // 与 sys_code 表 type='zxzy' 对应
    // 退回咨询
    public static final String ZX_BACK = "2";
    // 预咨询
    public static final String ZX_YZX = "3";
    // 重复咨询
    public static final String ZX_CFZX = "5";
    // 已分配,待认领
    public static final String ZX_YFPDQR = "7";
    // C组超时未认领
    public static final String ZX_CTIMEOUT = "8";
    // 已认领,未登记
    public static final String ZX_YRL = "9";

    // 咨询转移
    public static final String ZX_ZY = "-1";

    // 咨询补录完成
    public static final String ZX_BL = "100";

    //------------------------ 客户模块操作 ------------------------
    public static final String CUS_CONTANT_CONTDEL ="该联系人已添加跟进,无法删除！";
    // 公海
    public static final String CUS_CHANGE_STATE_GH = "0";
    // 非公海
    public static final String CUS_CHANGE_STATE_FGH = "1";

    //------------------------ 用户账号状态 ------------------------
    public static final String USER_DISABLED="0";
    public static final String USER_ENABLED="1";
}
