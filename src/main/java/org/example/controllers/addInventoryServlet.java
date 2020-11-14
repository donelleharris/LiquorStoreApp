package org.example.controllers;

import org.example.dao.Brands;
import org.example.dao.DaoFactory;
import org.example.model.Brand;
import org.example.model.LiquorType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.AddInventoryServlet", urlPatterns = "/AddInventory")
public class AddInventoryServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/addInventory/create.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {


        Brand brand = new Brand(
                request.getParameter("liquorName"),
                Integer.parseInt(request.getParameter("quantity")),
                request.getParameter("category") //needs to pull value of chosen option from "liquorType" in create.jsp
        );

        DaoFactory.getBrandsDao().insert(brand);
        response.sendRedirect("/results");
    }
}
