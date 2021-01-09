package com.blank.controller;

import com.blank.dao.CartDao;
import com.blank.domain.Cart;
import com.blank.domain.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = (Integer) request.getSession().getAttribute("userId");
        CartDao cartDao = new CartDao();
        List<Cart> carts = new ArrayList<>();
        carts = cartDao.queryCart(id);
        System.out.println(carts);
        String json = "{}";
        if (carts!=null){
            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(carts);
        }
        System.out.println(json);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().printf(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
