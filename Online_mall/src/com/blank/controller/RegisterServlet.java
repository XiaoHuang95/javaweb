package com.blank.controller;

import com.blank.dao.UserDao;
import com.blank.domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author blank
 * @date 2020/9/21 22:48
 */
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName,password,email,gender,phoneNum;
        int result = 0;
        UserDao dao = new UserDao();
        userName = request.getParameter("userName");
        password = request.getParameter("password");
        email = request.getParameter("email");
        gender = request.getParameter("gender");
        phoneNum = request.getParameter("phoneNum");
        User users = new User(null,userName,password,gender,email,phoneNum);
        result = dao.register(users);
        //3.【调用响应对象】将【处理结果】以二进制形式写入到响应体
        response.setContentType("text/html;charset = utf-8");
        if (result == 1){
            response.sendRedirect(request.getContextPath()+"/html/register_success.html");
        }else {
            response.sendRedirect(request.getContextPath()+"/html/register_error.html");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
