<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Form</title>
</head>
<body>
    <h1>${employee.id == null ? 'Add Employee' : 'Edit Employee'}</h1>
    <c:choose>
        <c:when test="${employee.id == null}">
            <form action="/employees/add" method="post">
        </c:when>
        <c:otherwise>
            <form action="/employees/edit/${employee.id}" method="post">
        </c:otherwise>
    </c:choose>
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${employee.name}" placeholder="enter name" />
        <c:if test="${not empty result.fieldError('name')}">
            <span class="error">${result.fieldError('name').defaultMessage}</span>
        </c:if>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="${employee.email}" placeholder="enter email" />
        <c:if test="${not empty result.fieldError('email')}">
            <span class="error">${result.fieldError('email').defaultMessage}</span>
        </c:if>

        <label for="department">Department:</label>
        <input type="text" id="department" name="department" value="${employee.department}" placeholder="enter department" />
		<br>
		<br>
        <div>
            <button type="submit">Submit</button>
            <button type="reset">Clear</button>
        </div>
    </form>
</body>
</html>
