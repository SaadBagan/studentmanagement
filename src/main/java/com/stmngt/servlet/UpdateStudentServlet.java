package com.stmngt.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stmngt.db.DBConnection;
import com.stmngt.model.Student;

public class UpdateStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(req.getParameter("id"));
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM students WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                s.setAge(rs.getInt("age"));
                s.setMarks(rs.getInt("marks"));

                req.setAttribute("student", s);
                req.getRequestDispatcher("update.jsp").forward(req, resp);
            } else {
                resp.getWriter().println("Student not found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().println("Exception: " + e.getMessage());
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            int age = Integer.parseInt(req.getParameter("age"));
            int marks = Integer.parseInt(req.getParameter("marks"));

            Connection con = DBConnection.getConnection();

            String sql = "UPDATE students SET name=?, email=?, age=?, marks=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setInt(3, age);
            ps.setInt(4, marks);
            ps.setInt(5, id);

            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("Updated student with ID: " + id);
                resp.sendRedirect("view");
            } else {
                System.out.println("No student found with ID: " + id);
                resp.getWriter().println("Update failed!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().println("Exception: " + e.getMessage());
        }
    }
}
