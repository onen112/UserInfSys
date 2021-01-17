package com.onen404.service.Imp;

import com.onen404.dao.Imp.DaoImp;
import com.onen404.domain.User;
import com.onen404.service.Service;

import java.util.List;

public class ServiceImp implements Service {
    DaoImp dao = new DaoImp();
    @Override
    public boolean login(String user, String psw) {
        return dao.login(user,psw);
    }

    @Override
    public List<User> search() {
        return dao.search();
    }

    @Override
    public void deleteUser(String id) {
        dao.deleteUser(Integer.parseInt(id));
    }

    @Override
    public void update(User user) {
        dao.update(user);
    }

    @Override
    public void addUser(User user) {
        dao.add(user);
        
    }

    @Override
    public void delSelect(String[] uids) {
        for(String s : uids){
            dao.deleteUser(Integer.parseInt(s));
        }
    }

    @Override
    public List<User> findUser(String name) {

        return dao.findUser(name);
    }
}
