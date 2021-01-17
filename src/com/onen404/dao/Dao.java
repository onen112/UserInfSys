package com.onen404.dao;

import com.onen404.domain.User;

import java.util.List;

public interface Dao {
    boolean login(String user,String psw);
    List<User> search();
    void update(User user);
    void deleteUser(int id);
    void add(User user);
    List<User> findUser(String name);
}
