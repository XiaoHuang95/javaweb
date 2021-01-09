package com.blank.controller;

import com.blank.dao.OrderDao;
import com.blank.domain.Order;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QueryOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object uid = request.getSession().getAttribute("userId");
        List<Order> orderList = new ArrayList<>();
        OrderDao orderDao = new OrderDao();
        orderList = orderDao.queryOrderById((Integer)uid);
        String json = "{}";
        if (orderList!=null){
            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(orderList);
        }
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().printf(json);
    }
}
