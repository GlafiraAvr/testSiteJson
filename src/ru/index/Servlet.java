package ru.index;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Glafira on 09.10.2015.
 */
public class Servlet extends HttpServlet {
   ArrayList<String> list = new ArrayList<String>();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        list.add(request.getParameter("value"));
        request.setAttribute("list",list);
        request.getRequestDispatcher("index.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Русский текст");
        request.setAttribute("Attribute","Русский текст");
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
