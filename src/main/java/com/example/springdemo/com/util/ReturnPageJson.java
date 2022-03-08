package com.example.springdemo.com.util;

import com.example.springdemo.com.Page.BasePage;

public class ReturnPageJson extends BasePage {
    private  boolean success;
    private Object data;
    private Integer totalRows;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(Integer totalRows) {
        this.totalRows = totalRows;
    }
}
