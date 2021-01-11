package web.servlet;

import domain.PageBean;
import domain.User;
import serivce.UserService;
import serivce.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findUserByPagesServlet")
public class FindUserByPagesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String rows = request.getParameter("rows");
        String currentPage = request.getParameter("currentPage");
        UserService us = new UserServiceImpl();

        Map<String, String[]> condition = request.getParameterMap();

        PageBean<User> userByPages = us.findUserByPages(currentPage, rows,condition);
            request.setAttribute("pb",userByPages);
            request.setAttribute("condition",condition);
            request.getRequestDispatcher("/list.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
