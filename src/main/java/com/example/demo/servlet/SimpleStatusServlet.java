package com.example.demo.servlet;

import jakarta.servlet.ServletException; // Added this import
import jakarta.servlet.annotation.WebServlet; // Added this to map the URL
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/simple-status") // This makes the servlet accessible at the URL
public class SimpleStatusServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.getWriter().write("OK");
    }
}