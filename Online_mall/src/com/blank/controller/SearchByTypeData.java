package com.blank.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SearchByTypeData extends HttpServlet {
    protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String json = "{}";
        Object data = request.getSession().getAttribute("TypeData");
        if (data!=null){
            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(data);
        }
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().println(json);
        response.getWriter().flush();
        response.getWriter().close();
//        System.out.println(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
