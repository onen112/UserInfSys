package com.onen404.servlet;

import com.onen404.service.Imp.ServiceImp;
import com.onen404.service.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteInfServlet")
public class DeleteInfServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Service se = new ServiceImp();
        se.deleteUser(request.getParameter("id"));
        request.getRequestDispatcher(request.getContextPath() + "/selectByPageServlet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
