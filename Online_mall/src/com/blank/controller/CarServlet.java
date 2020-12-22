package com.blank.controller;

import com.blank.domain.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String json = "";
        List<Product> cart =null;
        //获得用户的session
        HttpSession session = request.getSession(false);
        //获得用户购物车
        cart = (List<Product>) session.getAttribute("cart");
        if (cart != null) {
            //转换成json格式
            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(cart);
        }
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().printf(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
