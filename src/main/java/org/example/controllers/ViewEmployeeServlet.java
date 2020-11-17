package org.example.controllers;

import org.example.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ViewEmployeeServlet", urlPatterns = "/employee")
public class ViewEmployeeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.setAttribute("brands", DaoFactory.getBrandsDao().all());
        request.getRequestDispatcher("/WEB-INF/employee.jsp").forward(request, response);
    }
}
