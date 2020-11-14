package org.example.controllers;

import org.example.dao.DaoFactory;
import org.example.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "controllers.AddEmployeeServlet", urlPatterns = "/addEmployee")
public class AddEmployeeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/addEmployee.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");

        // validate input
        boolean inputHasErrors = username.isEmpty()
                || password.isEmpty()
                || (! password.equals(passwordConfirmation));

        if (inputHasErrors) {
            response.sendRedirect("/addEmployee");
            return;
        }

        // create and save a new user
        Employee employee = new Employee(username, password);
        DaoFactory.getEmployeesDao().insert(employee);
        response.sendRedirect("/login");
    }

}
