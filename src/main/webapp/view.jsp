<%@ page import="java.util.*, com.stmngt.model.Student" %>

<!DOCTYPE html>
<html>
<head>
    <title>Student List</title>
</head>
<body>

    <h2>All Students</h2>

    <table border="1" cellpadding="8">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Age</th>
            <th>Marks</th>
            <th>Actions</th>
        </tr>

        <%
            List<Student> students = (List<Student>) request.getAttribute("studentList");
            if (students != null) {
                for (Student s : students) {
        %>

        <tr>
            <td><%= s.getId() %></td>
            <td><%= s.getName() %></td>
            <td><%= s.getEmail() %></td>
            <td><%= s.getAge() %></td>
            <td><%= s.getMarks() %></td>

            <td>
                <a href="update?id=<%= s.getId() %>">Edit</a> |
                <a href="delete?id=<%= s.getId() %>">Delete</a>
            </td>
        </tr>

        <%
                }
            }
        %>

    </table>

    <br>
    <a href="add.jsp">Add New Student</a><br><br>
    <a href="index.jsp">Back to Home</a>

</body>
</html>
