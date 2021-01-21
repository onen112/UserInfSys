package com.onen404.servlet;

import com.onen404.domain.Pages;
import com.onen404.service.Imp.ServiceImp;
import com.onen404.service.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/showPagesServlet")
public class ShowPagesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Service se = new ServiceImp();

        Pages pg = se.showByPages(request.getParameter("index"),"5");;

        request.setAttribute("pb",pg);
        request.getRequestDispatcher(request.getContextPath() + "/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
