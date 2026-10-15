<%@ page import="java.sql.*" %>
<html>
<body>
<h2>Employee Management</h2>

<form method="post">
    ID: <input type="number" name="id" required><br><br>
    Name: <input type="text" name="name"><br><br>
    Department: <input type="text" name="dept"><br><br>
    Salary: <input type="number" step="0.01" name="salary"><br><br>

    <button name="action" value="add">Add</button>
    <button name="action" value="update">Update</button>
    <button name="action" value="delete">Delete</button>
</form>

<%
    String url = "jdbc:mysql://localhost:3306/company";
    String user = "root";
    String pass = "your_password";

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, pass);

        String action = request.getParameter("action");

        if (action != null) {
            int id = Integer.parseInt(request.getParameter("id"));

            if (action.equals("add")) {
                PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO employee VALUES (?, ?, ?, ?)");
                ps.setInt(1, id);
                ps.setString(2, request.getParameter("name"));
                ps.setString(3, request.getParameter("dept"));
                ps.setDouble(4, Double.parseDouble(
                    request.getParameter("salary")));
                ps.executeUpdate();
                out.println("Employee added successfully.");
            }

            if (action.equals("update")) {
                PreparedStatement ps = con.prepareStatement(
                    "UPDATE employee SET name=?, department=?, salary=? WHERE id=?");
                ps.setString(1, request.getParameter("name"));
                ps.setString(2, request.getParameter("dept"));
                ps.setDouble(3, Double.parseDouble(
                    request.getParameter("salary")));
                ps.setInt(4, id);
                ps.executeUpdate();
                out.println("Employee updated successfully.");
            }

            if (action.equals("delete")) {
                PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM employee WHERE id=?");
                ps.setInt(1, id);
                ps.executeUpdate();
                out.println("Employee deleted successfully.");
            }
        }

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM employee");
%>

<h3>Employee Records</h3>
<table border="1">
<tr><th>ID</th><th>Name</th><th>Department</th><th>Salary</th></tr>
<%
        while (rs.next()) {
%>
<tr>
    <td><%= rs.getInt("id") %></td>
    <td><%= rs.getString("name") %></td>
    <td><%= rs.getString("department") %></td>
    <td><%= rs.getDouble("salary") %></td>
</tr>
<%
        }
        con.close();
    } catch (Exception e) {
        out.println(e.getMessage());
    }
%>
</table>
</body>
</html> 