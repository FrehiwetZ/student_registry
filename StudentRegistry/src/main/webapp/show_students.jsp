<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Records</title>
    <style>
        body { background-color: #f9fafb; font-family: 'Segoe UI', sans-serif; padding: 50px; color: #1f2937; }
        .container { max-width: 850px; margin: auto; background: white; padding: 30px; border-radius: 12px; box-shadow: 0 2px 10px rgba(0,0,0,0.03); }
        h2 { margin-top: 0; color: #111827; border-bottom: 2px solid #f3f4f6; padding-bottom: 15px; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th { text-align: left; padding: 15px; background: #f8fafc; color: #64748b; font-size: 13px; text-transform: uppercase; border-bottom: 1px solid #e2e8f0; }
        td { padding: 15px; border-bottom: 1px solid #f1f5f9; font-size: 15px; }
        tr:hover { background-color: #fcfcfc; }
        .btn-nav { display: inline-block; margin-top: 25px; text-decoration: none; color: #8a3ffc; font-weight: 600; font-size: 14px; }
    </style>
</head>
<body>
    <div class="container">
        <h2>Registered Students List</h2>
        <table>
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Year</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    List<Map<String, String>> list = (List<Map<String, String>>) request.getAttribute("studentList");
                    if (list != null && !list.isEmpty()) {
                        for (Map<String, String> s : list) {
                %>
                <tr>
                    <td><%= s.get("name") %></td>
                    <td><%= s.get("email") %></td>
                    <td><%= s.get("year") %></td>
                </tr>
                <% 
                        }
                    } else {
                %>
                <tr><td colspan="3" style="text-align:center; padding:30px; color:#94a3b8;">No records found in the database.</td></tr>
                <% } %>
            </tbody>
        </table>
        <a href="index.jsp" class="btn-nav">Back to Registration</a>
    </div>
</body>
</html>