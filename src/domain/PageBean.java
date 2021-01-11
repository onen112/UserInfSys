package domain;

import java.util.ArrayList;
import java.util.List;

public class PageBean<T> {
    private List<T> lists;//该页的内容
    private int totalPages;//总页码
    private int countPages;//总记录数
    private int currentPages;//当前页码
    private int rows;//每页的记录数

    @Override
    public String toString() {
        return "PageBean{" +
                "lists=" + lists +
                ", totalPages=" + totalPages +
                ", countPages=" + countPages +
                ", currentPages=" + currentPages +
                ", rows=" + rows +
                '}';
    }

    public List<T> getLists() {
        return lists;
    }

    public void setLists(List<T> users) {
        this.lists = users;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getCountPages() {
        return countPages;
    }

    public void setCountPages(int countPages) {
        this.countPages = countPages;
    }

    public int getCurrentPages() {
        return currentPages;
    }

    public void setCurrentPages(int currentPages) {
        this.currentPages = currentPages;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }


}
