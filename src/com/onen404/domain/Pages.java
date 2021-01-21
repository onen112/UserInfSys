package com.onen404.domain;

import java.util.ArrayList;
import java.util.List;

public class Pages {
    //查询结果
    private List<User> users;
    //总共多少页
    private int totalPages;
    //每页多少数据
    private int countInPages;
    //当前第几页
    private int indexOfPages;
    //总共多少条信息
    private int totalInf;

    public int getTotalInf() {
        return totalInf;
    }

    public void setTotalInf(int totalInf) {
        this.totalInf = totalInf;
    }

    public Pages(){
        this.users = new ArrayList<>();
    }
    public Pages(List<User> users, int totalPages, int countInPages, int indexOfPages) {
        this.users = users;
        this.totalPages = totalPages;
        this.countInPages = countInPages;
        this.indexOfPages = indexOfPages;
    }

    public int getIndexOfPages() {
        return indexOfPages;
    }

    public void setIndexOfPages(int indexOfPages) {
        this.indexOfPages = indexOfPages;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getCountInPages() {
        return countInPages;
    }
    public void setCountInPages(int countInPages) {
        this.countInPages = countInPages;
    }
    @Override
    public String toString() {
        return "Pages{" +
                "users=" + users +
                ", totalPages=" + totalPages +
                ", countInPages=" + countInPages +
                '}';
    }
}
