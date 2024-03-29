package com.blank.controller;

import com.blank.dao.UserDao;
import com.blank.domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author blank
 * @date 2020/8/29 14:58
 */
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName,password;
        Integer result = 0;
        User user = new User();
        UserDao dao = new UserDao();
//        设置字符集
        request.setCharacterEncoding("utf-8");
//        获取浏览器提交的参数
        userName = request.getParameter("userName");
        password = request.getParameter("password");
        HttpSession session = request.getSession();
//       验证登录信息
        user = dao.login(userName,password);
//        登录信息输入正确
        if (user != null){
            //        将登录名放入session中
            System.out.println(user.getId());
            session.setAttribute("userId", user.getId());
            session.setAttribute("userName",userName);
            //重定向
            response.sendRedirect(request.getContextPath()+"/html/welcome.html");
        }else {
            response.sendRedirect(request.getContextPath()+"/html/login_error.html");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
