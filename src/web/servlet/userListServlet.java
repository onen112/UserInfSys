package web.servlet;

import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import serivce.UserService;
import serivce.impl.UserServiceImpl;
import utile.JDBCUtils;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;

@WebServlet("/userListServlet")
public class userListServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        UserService us = new UserServiceImpl();
        List<User> users = us.findAll();
        request.setAttribute("users",users);
        request.getRequestDispatcher(request.getContextPath() + "list.jsp").forward(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request,response);
    }
}
