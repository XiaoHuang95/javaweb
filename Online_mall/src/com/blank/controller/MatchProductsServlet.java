package com.blank.controller;

import com.blank.dao.ProductDao;
import com.blank.domain.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MatchProductsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str = request.getParameter("name");
        List<Product>productList = new ArrayList<>();
        ProductDao productDao = new ProductDao();
        productList = (List<Product>) productDao.matchProducts(str);
        HttpSession session = request.getSession();
        if (productList!=null){
            session.setAttribute("match",productList);
            response.sendRedirect(request.getContextPath()+"/html/ShowBooks.html");
        }
    }
}
