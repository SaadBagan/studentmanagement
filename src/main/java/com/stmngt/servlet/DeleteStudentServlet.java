package com.stmngt.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stmngt.db.DBConnection;

public class DeleteStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(req.getParameter("id"));

            Connection con = DBConnection.getConnection();
            String sql = "DELETE FROM students WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            int result = ps.executeUpdate();
            if (result > 0) {
                System.out.println("Deleted student with ID: " + id);
            } else {
                System.out.println("No student found with ID: " + id);
            }
            resp.sendRedirect("view");

        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().println("Exception: " + e.getMessage());
        }
    }
}
