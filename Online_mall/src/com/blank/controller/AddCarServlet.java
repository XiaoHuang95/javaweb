package com.blank.controller;

import com.blank.dao.CartDao;
import com.blank.dao.ProductDao;
import com.blank.domain.Cart;
import com.blank.domain.Product;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddCarServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDao productDao = new ProductDao();
        CartDao cartDao = new CartDao();
        Cart cart = new Cart();
        Integer rs = 0;
        Product product = new Product();
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        String id = request.getParameter("id");
        if (userId == null){
            response.sendRedirect(request.getContextPath()+"/html/warning.html");
        }
        try {
            //1.调用dao的方法根据id查找数据
            product = productDao.queryProductById(Integer.parseInt(id));
            int flag = cartDao.queryProduct(product.getId());
            if (flag ==0){
                rs = cartDao.InsertCart(userId, product, 1);
            }else if (flag==1){
                rs = cartDao.updateCart(product.getId());
            }
            if (rs != null) {
                response.setContentType("html/text;charset=utf-8");
                response.sendRedirect(request.getContextPath()+"/html/car.html");
            } else {
                response.sendRedirect(request.getContextPath()+"/html/warning.html");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
