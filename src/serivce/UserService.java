package serivce;

import domain.PageBean;
import domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用户管理业务接口
 */
public interface UserService {
    /**
     * 查询所以用户信息，返回一个list集合
     * @return
     */

    List<User> findAll();
    boolean login(String user,String psw);
    void add(User user);
    void del(String id);
    User search(String id);
    void update(User user);
    void delAll(String[] uid);
    PageBean<User> findUserByPages(String currentPage, String rows, Map<String, String[]> condition);
}
