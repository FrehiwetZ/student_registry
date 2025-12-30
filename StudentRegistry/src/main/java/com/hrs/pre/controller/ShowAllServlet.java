package com.hrs.pre.controller;

import com.hrs.pre.util.DBConnection;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/show_all") // Action: The Servlet connects to the database [cite: 5, 6]
public class ShowAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        List<Map<String, String>> students = new ArrayList<>();
        
        try (Connection conn = DBConnection.getConnection()) {
            // Action: Retrieves all student records [cite: 6]
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            while (rs.next()) {
                Map<String, String> student = new HashMap<>();
                student.put("name", rs.getString("name"));
                student.put("email", rs.getString("email"));
                student.put("year", rs.getString("year"));
                students.add(student);
            }
            
            // Passes them to the view [cite: 6]
            request.setAttribute("studentList", students);
            request.getRequestDispatcher("show_students.jsp").forward(request, response);
            
        } catch (Exception e) {
            response.getWriter().println("Error fetching data: " + e.getMessage());
        }
    }
}