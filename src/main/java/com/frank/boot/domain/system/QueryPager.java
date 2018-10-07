package com.frank.boot.domain.system;

public class QueryPager {
    private int currentPage;
    private int pageSize;
    // 是否需要count总数查询 默认开启
    private boolean count = true;
    private String orderBy;
    // true且pageSize=0时返回全部结果，false时分页,null时用默认配置
    // 主要使用场景是查询列表中需要导出全部数据时
    private boolean pageSizeZero;
    private boolean export = false;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean getCount() {
        return count;
    }

    public void setCount(boolean count) {
        this.count = count;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public boolean getPageSizeZero() {
        return pageSizeZero;
    }

    public void setPageSizeZero(boolean pageSizeZero) {
        this.pageSizeZero = pageSizeZero;
    }

    public boolean isCount() {
        return count;
    }

    public boolean isPageSizeZero() {
        return pageSizeZero;
    }

    public boolean isExport() {
        return export;
    }

    public void setExport(boolean export) {
        this.export = export;
    }
}
