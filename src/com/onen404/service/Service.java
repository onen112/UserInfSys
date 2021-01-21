package com.onen404.service;


import com.onen404.domain.Pages;
import com.onen404.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public interface Service {
    boolean login(String user,String psw);
    List<User> search();
    void deleteUser(String id);

    void update(User user);

    void addUser(User user);

    void delSelect(String[] uids);

    List<User> findUser(String name);

    Pages showByPages(String index,String countInPage);
}
