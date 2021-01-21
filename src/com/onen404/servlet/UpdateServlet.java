package com.onen404.servlet;

import com.onen404.domain.User;
import com.onen404.service.Imp.ServiceImp;
import com.onen404.service.Service;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.springframework.beans.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 删除用户信息
 */
@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        User user = new User();
        Map<String, String[]> map = request.getParameterMap();
        BeanUtilsBean b = new BeanUtilsBean();
        try {
            b.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        Service s = new ServiceImp();
        s.update(user);
        request.getRequestDispatcher(request.getContextPath() + "/showPagesServlet" + "?index=" + request.getParameter("index")).forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
