<!DOCTYPE html>
<html>
<head>
    <title>Add Student</title>
</head>
<body>

    <h2>Add New Student</h2>

<form action="add" method="post">

        ID: 
        <input type="number" name="id" min="1" required>
        <br><br>

        Name: 
        <input type="text" name="name" minlength="2" maxlength="50" required>
        <br><br>

        Email: 
        <input type="email" name="email" required>
        <br><br>

        Age: 
        <input type="number" name="age" min="1" max="120" required>
        <br><br>

        Marks: 
        <input type="number" name="marks" min="0" max="100" required>
        <br><br>

        <input type="submit" value="Save">

    </form>

    <br>
    <a href="index.jsp">Back to Home</a>

</body>
</html>
