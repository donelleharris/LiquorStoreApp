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
import java.util.List;

@WebServlet("/AddLiquor")
public class CreateLiquorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/create.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Brands brandsDao = DaoFactory.getBrandsDao();

        String liquorCategory = request.getParameter("type");
        String liquorName = request.getParameter("liquorName");
        int quantity = Integer.parseInt(request.getParameter("qty"));

        Brand brand = new Brand(liquorName, quantity, liquorCategory);
        brandsDao.insert(brand);
        response.sendRedirect("/brands");
    }
}
