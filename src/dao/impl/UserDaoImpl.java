package dao.impl;

import dao.UserDao;
import domain.User;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utile.JDBCUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    

    @Override
    public List<User> findAll() {
        List<User> user = template.query("select * from user", new BeanPropertyRowMapper<User>(User.class));
        return user;
    }

    @Override
    public boolean login(String user, String psw) {
        if(template.queryForList("select * from user where name = ? and password = ?",user,psw).size() != 0){
            return true;
        }
        return false;
    }

    @Override
    public void add(User user) {
        template.update("insert into user  values (null,?,?,?,?,?,?,null,null)",user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmile());
    }

    @Override
    public void del(int id) {
        template.update("delete from user where id = ?",id);
    }

    @Override
    public User search(int id) {
        String sql = "select * from user where id = ?";
        User user = new User();
        List<Map<String, Object>> maps = template.queryForList(sql, id);
        Map<String, Object> map = maps.get(0);
        BeanUtilsBean beanUtilsBean = new BeanUtilsBean();
        try {
            beanUtilsBean.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void update(User user) {
        String sql = "update user set gender=?,age=?,address=?,qq=?,emile=? where id=?";
        template.update(sql,user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmile(),user.getId());
    }
    @Override
    public int totalCount(Map<String, String[]> condition) {
        String sql = "select count(*) from user where 1=1 ";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> strings = condition.keySet();
        List<String> ls = new ArrayList<>();
        for(String key : strings){
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            String value = condition.get(key)[0];
            if(value != null &&  value != ""){
                sb.append(" and " + key + " like ?");
                ls.add("%" + value + "%");
            }
        }
        System.out.println(sb.toString());
        System.out.println(ls);
        return template.queryForObject(sb.toString(),Integer.class,ls.toArray());
    }

    @Override
    public List<User> findByPages(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from user where 1=1 ";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> strings = condition.keySet();
        List<Object> ls = new ArrayList<>();
        for(String key : strings){
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            String value = condition.get(key)[0];
            if(value != null &&  value != ""){
                sb.append(" and " + key + " like ? ");
                ls.add("%" + value + "%");
            }
        }
        sb.append(" limit ?,?");
        ls.add(start);
        ls.add(rows);

         List<User> user = template.query(sb.toString(),new BeanPropertyRowMapper<User>(User.class),ls.toArray());
        return user;
    }

}
