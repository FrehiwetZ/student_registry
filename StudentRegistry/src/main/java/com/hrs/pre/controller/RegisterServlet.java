package com.hrs.pre.controller;

import com.hrs.pre.util.DBConnection;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Input: Student Name, Email, and Year [cite: 3]
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String yearParam = request.getParameter("year");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try (Connection conn = DBConnection.getConnection()) {
            // Action: Ensure the 'students' table exists with required constraints [cite: 8, 11]
            String createTable = "CREATE TABLE IF NOT EXISTS students (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(100) NOT NULL, " +
                "email VARCHAR(100) NOT NULL UNIQUE, " +
                "year INT NOT NULL)";
            conn.createStatement().execute(createTable);

            // Action: Insert new student record [cite: 4]
            String sql = "INSERT INTO students (name, email, year) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setInt(3, Integer.parseInt(yearParam));
            ps.executeUpdate();

            // Minimalist Success UI (No Icons)
            out.println("<html><head><style>" +
                "body { background: #f3f4f6; display: flex; align-items: center; justify-content: center; height: 100vh; font-family: sans-serif; margin: 0; }" +
                ".card { background: white; padding: 40px; border-radius: 12px; box-shadow: 0 4px 15px rgba(0,0,0,0.05); text-align: center; width: 350px; }" +
                "h1 { color: #111827; margin: 0 0 10px; font-size: 24px; }" +
                "p { color: #4b5563; margin-bottom: 30px; line-height: 1.5; }" +
                ".links a { color: #8a3ffc; text-decoration: none; font-weight: 600; margin: 0 10px; font-size: 14px; }" +
                ".links a:hover { text-decoration: underline; }" +
                "</style></head><body>" +
                "<div class='card'>" +
                "<h1>Registration Success</h1>" +
                "<p>Student <b>" + name + "</b> has been added to the database.</p>" +
                "<div class='links'>" +
                "<a href='index.jsp'>Register Another</a>" +
                "<a href='show_all'>View List</a>" +
                "</div></div></body></html>");

        } catch (Exception e) {
            out.println("<body style='font-family:sans-serif; padding:40px;'><h3>Error: " + e.getMessage() + "</h3></body>");
        }
    }
}