package com.onen404.servlet;

import com.onen404.domain.User;
import com.onen404.service.Imp.ServiceImp;
import com.onen404.service.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 查询数据库获取所有的用户信息，并添加到
 *   request中，然后重定向到list页面，并将用户信息携带到list中
 */
@WebServlet("/selectByPageServlet")
public class SelectByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Service s = new ServiceImp();
        List<User> user = s.search();
        request.setAttribute("user",user);
        request.getRequestDispatcher(request.getContextPath() + "/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
