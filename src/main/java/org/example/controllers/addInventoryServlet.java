package org.example.controllers;

import org.example.dao.Brands;
import org.example.dao.DaoFactory;
import org.example.model.Brand;
import org.example.model.LiquorType;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddLiquor")
public class addInventoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/create.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Brand brand = new Brand(
                request.getParameter("liquorName"),
                Integer.parseInt(request.getParameter("qty")),
                request.getParameter("category")
        );

        DaoFactory.getBrandsDao().insert(brand);
        response.sendRedirect("/results");
    }
}
