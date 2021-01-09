package com.blank.controller;

import com.blank.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class updateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String opwd = request.getParameter("opwd");
        String npwd = request.getParameter("npwd");
        UserDao userDao = new UserDao();
        int res =  userDao.alterPassword(userName,npwd,opwd);
        if (res !=0){
            response.sendRedirect(request.getContextPath()+"/html/login.html");
        }else {
            response.sendRedirect(request.getContextPath()+"/html/erro.html");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
