<%@ page language="java" %>
<html>
<body>
    <h2>Registration Details</h2>

    <%
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
    %>

    Name: <%= name %><br><br>
    Email: <%= email %><br><br>
    Phone Number: <%= phone %><br><br>

    <p>Registration successful!</p>
</body>
</html>