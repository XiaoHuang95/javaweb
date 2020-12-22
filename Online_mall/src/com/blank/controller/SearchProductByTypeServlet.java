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

public class SearchProductByTypeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = new ArrayList<>();
        String Typename = request.getParameter("Typename");
        ProductDao productDao = new ProductDao();
        productList = productDao.queryProductByType(Typename);
//        System.out.println(productList);
        HttpSession session = request.getSession();
        //将数据放入到session中
        if (productList !=null) {
            session.setAttribute("TypeData", productList);
            response.sendRedirect(request.getContextPath()+"/html/ShowBooks.html");
        }
    }
}
