<%@ page import="com.stmngt.model.Student" %>

<%
    Student s = (Student) request.getAttribute("student");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Update Student</title>
</head>
<body>

    <h2>Edit Student Details</h2>

    <form action="update" method="post">

        <input type="hidden" name="id" value="<%= s.getId() %>">

        Name: <input type="text" name="name" value="<%= s.getName() %>" required><br><br>
        Email: <input type="email" name="email" value="<%= s.getEmail() %>" required><br><br>
        Age: <input type="number" name="age" value="<%= s.getAge() %>" required><br><br>
        Marks: <input type="number" name="marks" value="<%= s.getMarks() %>"><br><br>

        <input type="submit" value="Update">
    </form>

    <br>
    <a href="view">Back to List</a>

</body>
</html>
