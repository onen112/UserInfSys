package com.onen404.servlet;

import com.onen404.service.Imp.ServiceImp;
import com.onen404.service.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录验证servlet，用于判断用户输入的验证码，用户名或密码的正确与否，
 * 并提示响应的错误信息，或者跳转到登录成功的页面
 */

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取验证码的实际值
        HttpSession session = request.getSession();
        String checkCode = (String)session.getAttribute("checkCode");
        //获取用户输入的验证码的值
        String check = request.getParameter("vcode");
        //将验证码从session中删除，防止用户不更新
        session.removeAttribute("checkCode");
        if(check.equalsIgnoreCase(checkCode)){
            //验证码输入成功，检测用户名密码是否正确
            String user = request.getParameter("user");
            String psw = request.getParameter("password");
            Service se = new ServiceImp();
            if(se.login(user,psw)){
                //用户名和密码存在
                request.getRequestDispatcher(request.getContextPath() + "/selectByPageServlet").forward(request,response);
            }else{
                //用户名或密码错误
                request.setAttribute("inf","用户名或密码输入错误🙅");
                request.setAttribute("user",request.getParameter("user"));
            }
        }else{
            request.setAttribute("inf","验证码输入错误🙅");
            request.setAttribute("user",request.getParameter("user"));
            System.out.println(request.getContextPath());
        }
        request.getRequestDispatcher(request.getContextPath() + "/login.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
