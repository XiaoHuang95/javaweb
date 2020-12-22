package com.blank.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowDataServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String json = "{}";
        request.setCharacterEncoding("utf-8");
        Object data = request.getSession().getAttribute("data");
        if (data !=null){
            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(data);
        }
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().println(json);
        System.out.println(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
