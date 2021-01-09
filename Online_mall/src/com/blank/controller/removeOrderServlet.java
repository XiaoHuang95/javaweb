package com.blank.controller;

import com.blank.dao.OrderDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class removeOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        OrderDao orderDao = new OrderDao();
        int res = orderDao.deleteOrderById(Integer.parseInt(id));
        if (res !=0){
            response.sendRedirect(request.getContextPath()+"/html/order.html");
        }
    }
}
