package com.blank.controller;

import com.blank.dao.CartDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String pnum = request.getParameter("pnum");
        CartDao cartDao = new CartDao();
        int rs = cartDao.updateCart(Integer.parseInt(id),Integer.parseInt(pnum));
        if (rs == 1){
            response.sendRedirect(request.getContextPath()+"/html/car.html");
        }
    }
}
