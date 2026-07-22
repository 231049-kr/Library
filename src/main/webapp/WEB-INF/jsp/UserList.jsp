<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>利用者管理</title>
    <style>
        body { font-family: sans-serif; margin: 20px; }
        table { border-collapse: collapse; width: 100%; margin-top: 15px; }
        th, td { border: 1px solid #ccc; padding: 8px; text-align: left; }
        th { background-color: #f4f4f4; }
        .form-box { background: #f9f9f9; padding: 15px; border: 1px solid #ddd; margin-bottom: 20px; }
        .status-stop { color: red; font-weight: bold; }
    </style>
</head>
<body>

    <h2>利用者管理</h2>

    <!-- 登録・更新フォーム -->
    <div class="form-box">
        <h3>利用者の登録・更新</h3>
        <form action="UserServlet" method="post">
            <input type="hidden" name="action" value="save">
            利用者ID: <input type="text" name="userId" required>
            氏名: <input type="text" name="name" required>
            Email: <input type="email" name="email" required>
            <button type="submit">保存</button>
        </form>
    </div>

    <!-- 一覧・参照・利用停止切り替え -->
    <h3>利用者一覧</h3>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>氏名</th>
                <th>メールアドレス</th>
                <th>ステータス</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<User> users = (List<User>) request.getAttribute("users");
                if (users != null && !users.isEmpty()) {
                    for (User u : users) {
                        boolean isStopped = "停止".equals(u.getStatus());
            %>
                <tr>
                    <td><%= u.getUserId() %></td>
                    <td><%= u.getName() %></td>
                    <td><%= u.getEmail() %></td>
                    <td>
                        <% if (isStopped) { %>
                            <span class="status-stop">停止</span>
                        <% } else { %>
                            有効
                        <% } %>
                    </td>
                    <td>
                        <form action="" method="post" style="display:inline;">
                            <input type="hidden" name="action" value="toggleStatus">
                            <input type="hidden" name="userId" value="<%= u.getUserId() %>">
                            <input type="hidden" name="currentStatus" value="<%= u.getStatus() %>">
                            <button type="submit">
                                <%= "有効".equals(u.getStatus()) ? "利用停止にする" : "停止解除" %>
                            </button>
                        </form>
                    </td>
                </tr>
            <%
                    }
                } else {
            %>
                <tr>
                    <td colspan="5">該当する利用者が見つかりませんでした。</td>
                </tr>
            <%
                }
            %>
        </tbody>
    </table>

</body>
</html>