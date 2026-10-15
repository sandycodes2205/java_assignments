<%@ page import="java.sql.*" %>
<html>
<body>
<h2>Patient Record Management</h2>

<form method="post">
    Patient ID: <input type="number" name="id" required><br><br>
    Name: <input type="text" name="name"><br><br>
    Age: <input type="number" name="age"><br><br>
    Disease: <input type="text" name="disease"><br><br>
    Treatment Status: <input type="text" name="status"><br><br>

    <button name="action" value="add">Add</button>
    <button name="action" value="update">Update</button>
    <button name="action" value="delete">Delete</button>
</form>

<%
    String url = "jdbc:mysql://localhost:3306/hospital";
    String user = "root";
    String pass = "sit@123";

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, pass);

        String action = request.getParameter("action");

        if (action != null) {
            int id = Integer.parseInt(request.getParameter("id"));

            if (action.equals("add")) {
                PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO patient VALUES (?, ?, ?, ?, ?)");
                ps.setInt(1, id);
                ps.setString(2, request.getParameter("name"));
                ps.setInt(3, Integer.parseInt(request.getParameter("age")));
                ps.setString(4, request.getParameter("disease"));
                ps.setString(5, request.getParameter("status"));
                ps.executeUpdate();
                out.println("Patient added successfully.");
            }

            if (action.equals("update")) {
                PreparedStatement ps = con.prepareStatement(
                    "UPDATE patient SET name=?, age=?, disease=?, status=? WHERE id=?");
                ps.setString(1, request.getParameter("name"));
                ps.setInt(2, Integer.parseInt(request.getParameter("age")));
                ps.setString(3, request.getParameter("disease"));
                ps.setString(4, request.getParameter("status"));
                ps.setInt(5, id);
                ps.executeUpdate();
                out.println("Patient updated successfully.");
            }

            if (action.equals("delete")) {
                PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM patient WHERE id=?");
                ps.setInt(1, id);
                ps.executeUpdate();
                out.println("Patient deleted successfully.");
            }
        }

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM patient");
%>

<h3>Patient Records</h3>
<table border="1">
<tr><th>ID</th><th>Name</th><th>Age</th><th>Disease</th><th>Treatment Status</th></tr>
<%
        while (rs.next()) {
%>
<tr>
    <td><%= rs.getInt("id") %></td>
    <td><%= rs.getString("name") %></td>
    <td><%= rs.getInt("age") %></td>
    <td><%= rs.getString("disease") %></td>
    <td><%= rs.getString("status") %></td>
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