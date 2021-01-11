package dao;

import domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用户操作dao
 */
public interface UserDao {
     List<User> findAll();
     boolean login(String user,String psw);
     void add(User user);
     void del(int id);
     User search(int id);
    void update(User user);

    int totalCount(Map<String, String[]> condition);

    List<User> findByPages(int start, int rows, Map<String, String[]> condition);
}
