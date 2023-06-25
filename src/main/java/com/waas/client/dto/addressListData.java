package com.waas.client.dto;

import java.util.List;

public class addressListData {

    private int page;
    private int max_page;
    private int count;
    private List<addressListItem> list;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getMax_page() {
        return max_page;
    }

    public void setMax_page(int max_page) {
        this.max_page = max_page;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<addressListItem> getList() {
        return list;
    }

    public void setList(List<addressListItem> list) {
        this.list = list;
    }
}
