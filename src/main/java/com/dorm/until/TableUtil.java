package com.dorm.until;

import java.util.List;

public class TableUtil {
    private int total;
    private List<?> rows;

    public TableUtil() {
    }

    @Override
    public String toString() {
        return "EasyUiResultUtil{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }

    public TableUtil(int total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
