<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Add Task</title>
</head>
<body>
	<br>
    <b><p>Add New Task</p></b>
    <form action="TaskController" method="post">
        <label>Task Desc:</label>
        <input type="text" name="description" required />
        <br><br>
        <label>Task Status:</label>
        <select name="status">
        	<option value="Completed">Completed</option>
            <option value="Pending">Pending</option>
        </select>
        <br><br>
        <input type="submit" value="Add Task" />
        <input type="hidden" name="action" value="add" />
    </form>
    <br>
    <a href="TaskController?action=view">Task List</a>
</body>
</html>


