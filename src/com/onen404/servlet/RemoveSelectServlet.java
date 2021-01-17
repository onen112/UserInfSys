package com.onen404.servlet;

import com.onen404.service.Imp.ServiceImp;
import com.onen404.service.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 通过用户id删除用户信息
 */
@WebServlet("/removeSelectServlet")
public class RemoveSelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> map = request.getParameterMap();
        String[] uids = map.get("uid");
        Service s = new ServiceImp();
        s.delSelect(uids);
        request.getRequestDispatcher(request.getContextPath() + "/selectByPageServlet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
