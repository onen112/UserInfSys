package serivce.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.PageBean;
import domain.User;
import serivce.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        //调用dao完成查询
        return dao.findAll();
    }

    @Override
    public boolean login(String user, String psw) {
        return dao.login(user,psw);
    }

    @Override
    public void add(User user) {
        dao.add(user);
    }

    @Override
    public void del(String id) {
        dao.del(Integer.parseInt(id));
    }

    @Override
    public User search(String id) {
       return dao.search(Integer.parseInt(id));
    }

    @Override
    public void update(User user) {
        dao.update(user);
    }

    @Override
    public void delAll(String[] uid) {
        for(String id : uid){
            dao.del(Integer.parseInt(id));
        }
    }

    @Override
    public PageBean<User> findUserByPages(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = _currentPage==null?1:Integer.parseInt(_currentPage);
        if(currentPage <= 0){
            currentPage = 1;
        }
        int rows = _rows==null?5:Integer.parseInt(_rows);
        PageBean<User> pb = new PageBean<>();
        int totalCount =  dao.totalCount(condition);
        int totalPages = totalCount%rows==0?totalCount/rows :(totalCount/rows+1);
        if(currentPage > totalPages){
            currentPage = totalPages;
        }
        pb.setTotalPages(totalPages);
        pb.setCountPages(totalCount);
        pb.setRows(rows);
        pb.setCurrentPages(currentPage);
        int start = (currentPage-1) * rows;
        List<User> us = dao.findByPages(start,rows,condition);
        pb.setLists(us);
        return pb;
    }



}
