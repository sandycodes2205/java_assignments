<%@ page language="java" %>
<html>
<body>
    <h2>Student Information</h2>

    <form method="post">
        Name: <input type="text" name="name" required><br><br>
        Roll Number: <input type="text" name="roll" required><br><br>
        Course: <input type="text" name="course" required><br><br>
        Age: <input type="number" name="age" required><br><br>

        <input type="submit" value="Submit">
    </form>

    <%
        String name = request.getParameter("name");
        String roll = request.getParameter("roll");
        String course = request.getParameter("course");
        String age = request.getParameter("age");

        if (name != null) {
    %>
        <h3>Student Details</h3>
        Name: <%= name %><br>
        Roll Number: <%= roll %><br>
        Course: <%= course %><br>
        Age: <%= age %><br>
    <%
        }
    %>
</body>
</html>