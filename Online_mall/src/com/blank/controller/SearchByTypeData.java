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
        Object match = request.getSession().getAttribute("match");
        System.out.println(data);
        System.out.println(match);
        ObjectMapper om = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        if (data!=null){
                json = om.writeValueAsString(data);
                response.getWriter().println(json);
                request.getSession().removeAttribute("TypeData");
        }
        if (match!=null){
            json = om.writeValueAsString(match);
            response.getWriter().println(json);
            request.getSession().removeAttribute("match");
        }
        response.getWriter().flush();
        response.getWriter().close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
