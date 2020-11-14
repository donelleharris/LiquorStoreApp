package org.example.controllers;

import org.example.dao.DaoFactory;
import org.example.model.Employee;
import org.example.util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/employee");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Employee dbEmployee = DaoFactory.getEmployeesDao().findByUsername(username);

        if (dbEmployee == null) {
            response.sendRedirect("/login");
            return;
        }

        boolean validAttempt = Password.check(password, dbEmployee.getPassword());

        if (validAttempt) {
            request.getSession().setAttribute("user", dbEmployee);
            response.sendRedirect("/employee");
        } else {
            response.sendRedirect("/login");
        }
    }
}
