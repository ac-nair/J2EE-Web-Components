<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.ltd.model.Task" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <title>Task List</title>
</head>
<body>
	<br>
    <b><p>To-Do List</p></b>
    <table border="1" style="border-collapse: collapse;">
        <tr>
            <th>ID</th>
            <th>Task Desc</th>
            <th>Task Status</th>
            <th>Action</th>
        </tr>
        <c:forEach var="task" items="${tasks}">
            <tr>
                <td>${task.id}</td>
                <td>${task.description}</td>
                <td>${task.status}</td>
                <td>
                    <a href="TaskController?action=delete&id=${task.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <a href="addTask.jsp">Add Task</a>
</body>
</html>
