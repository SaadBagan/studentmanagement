package com.stmngt.servlet;

import com.stmngt.db.DBConnection;
import com.stmngt.model.Student;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class ViewStudentServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException
	{
		List<Student> list=new ArrayList<Student>();
		
		try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM students ORDER BY id ASC";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                s.setAge(rs.getInt("age"));
                s.setMarks(rs.getInt("marks"));

                list.add(s);
            }

            req.setAttribute("studentList", list);
            req.getRequestDispatcher("view.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}

}
