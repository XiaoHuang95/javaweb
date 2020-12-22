package com.blank.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author blank
 * @date 2020/10/12 22:09
 */
public class OneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();
        HttpSession session = request.getSession();
        try {
            String name = (String) session.getAttribute("userName");
            if(name == null ){
                pw.write("Î´µÇÂ¼");
            }else {
                pw.write(name);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        pw.flush();
        pw.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
