package com.blank.controller;

import com.blank.dao.OrderDao;
import org.omg.CORBA.ORB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class paymentOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String state = "ÒÑÖ§¸¶";
        OrderDao orderDao = new OrderDao();
        int res = orderDao.paymentOrderById(Integer.parseInt(id),state);
        if (res!=0){
            response.sendRedirect(request.getContextPath()+"/html/order.html");
        }
    }
}
