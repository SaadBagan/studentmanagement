package com.stmngt.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stmngt.db.DBConnection;

public class AddStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {

            String idStr = req.getParameter("id");
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String ageStr = req.getParameter("age");
            String marksStr = req.getParameter("marks");

            if (idStr == null || name == null || email == null || ageStr == null || marksStr == null ||
                idStr.isEmpty() || name.isEmpty() || email.isEmpty() || ageStr.isEmpty() || marksStr.isEmpty()) {

                resp.getWriter().println("All fields are required!");
                return;
            }

            int id = Integer.parseInt(idStr);
            int age = Integer.parseInt(ageStr);
            int marks = Integer.parseInt(marksStr);

            if (id <= 0) {
                resp.getWriter().println("Invalid ID!");
                return;
            }

            if (name.length() < 2 || name.length() > 50) {
                resp.getWriter().println("Name must be 2–50 characters!");
                return;
            }

            if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                resp.getWriter().println("Invalid email format!");
                return;
            }

            if (age < 1 || age > 120) {
                resp.getWriter().println("Invalid age!");
                return;
            }

            if (marks < 0 || marks > 100) {
                resp.getWriter().println("Marks should be between 0–100!");
                return;
            }

            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO students (id, name, email, age, marks) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, email);
            ps.setInt(4, age);
            ps.setInt(5, marks);

            int result = ps.executeUpdate();

            if (result > 0) {
                resp.sendRedirect("view");
            } else {
                resp.getWriter().println("Error while adding student!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().println("Exception: " + e.getMessage());
        }
    }
}
