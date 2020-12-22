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

public class ShowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product product = new Product();
        ProductDao productDao = new ProductDao();
        String id = request.getParameter("id");
        HttpSession session = request.getSession();
        //拿到数据库的数据
        product = productDao.queryProductById(Integer.parseInt(id));
        if (product!=null){
            session.setAttribute("data",product);
            response.sendRedirect(request.getContextPath()+"/html/BookInfo.html");
        }
        System.out.println(product);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
