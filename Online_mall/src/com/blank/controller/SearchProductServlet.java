package com.blank.controller;

import com.blank.dao.ProductDao;
import com.blank.domain.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String json = "{}";
        List <Product> productList = new ArrayList<>();
        ProductDao productDao = new ProductDao();
        //拿到数据库的数据
        productList = productDao.queryProduct();
        //将数据转换为json格式
        if (productList !=null){
            ObjectMapper om =new ObjectMapper();
            json = om.writeValueAsString(productList);
        }
        //输出数据
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().println(json);
        System.out.println(json);
        response.getWriter().flush();
        response.getWriter().close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
