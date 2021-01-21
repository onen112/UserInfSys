package com.onen404.dao.Imp;

import com.onen404.domain.User;
import com.onen404.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
import java.util.Map;

public class DaoImp implements com.onen404.dao.Dao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 进行登录验证
     * @param user：用户名
     * @param psw：密码
     * @return
     */
    @Override
    public boolean login(String user, String psw) {
        String sql = "select * from admin where user = ? and psw = ?";
        List<Map<String, Object>> maps = template.queryForList(sql, user, psw);
        return maps.size() != 0;
    }
    /**
     * 查询所有用户信息
     * @return
     */
    @Override
    public List<User> search() {
        String sql = "select * from user";
        //将查询的结果封装为一个user类型的list
        List<User> user = template.query("select * from user", new BeanPropertyRowMapper<User>(User.class));
        return user;
    }
    /**
     *  通过id删除该用户的信息
     * @param id
     */
    @Override
    public void deleteUser(int id) {
        String sql = "delete from user where id = ?";
        template.update(sql,id);
    }
    @Override
    public void add(User user) {
        String sql = "insert into user set name=?,gender=?,age=?,address=?,qq=?,emile=?";
        template.update(sql,user.getName(),user.getGender(),Integer.parseInt(user.getAge()),user.getAddress(),user.getQq(),user.getEmile());
    }
    @Override
    public List<User> findUser(String name) {
        String sql = "select * from user where name like ?";

        List<User> user = template.query(sql,new BeanPropertyRowMapper<User>(User.class),"%" + name + "%");
        return user;
    }

    @Override
    public int totalInf() {

        String sql = "select * from user";

        return template.queryForList(sql).size();
    }

    @Override
    public List<User> searchByPage(int count, int page) {
        String sql = "select * from user limit ?,?";

        List<User> user = template.query(sql, new BeanPropertyRowMapper<User>(User.class), count * page, count);
        return user;
    }
    /**
     *
     * @param user
     */
    @Override
    public void update(User user) {
        String sql = "update user set name=?,age=?,gender=?,address=?,qq=?,emile=? where id=?";
        Integer
        template.update(sql,user.getName(),Integer.parseInt(user.getAge()),user.getGender(),user.getAddress(),user.getQq(),user.getEmile(),user.getId());
    }
}
