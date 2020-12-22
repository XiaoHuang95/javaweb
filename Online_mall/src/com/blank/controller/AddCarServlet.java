package com.blank.controller;

import com.blank.dao.ProductDao;
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
        String id = request.getParameter("id");
        Product product = new Product();
        try {
            //1.调用dao的方法根据id查找数据
            product = productDao.queryProductById(Integer.parseInt(id));
            //创建或获得用户的session
            HttpSession session = request.getSession(false);
            Object username = session.getAttribute("userName");
            if (username != null) {
                List<Product> cart = (List<Product>) session.getAttribute("cart");
                if (cart == null) {
                    //首次购物创建购物车
                    cart = new ArrayList<Product>();
                    //将购物车放入到session对象中
                    session.setAttribute("cart", cart);
                }
                //将商品放入购物车
                cart.add(product);
                response.sendRedirect(request.getContextPath() + "/html/car.html");
            }else{
                response.sendRedirect(request.getContextPath()+"/html/warning.html");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
