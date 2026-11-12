<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head><title>Update Employee</title></head>
<body>
    <div align="center">
        <h2>Update Employee</h2>
<form:form action="${pageContext.request.contextPath}/updateEmployee" modelAttribute="employee" method="POST">            <form:hidden path="id" />
            First Name: <form:input path="firstName" /><br><br>
            Last Name: <form:input path="lastName" /><br><br>
            Email: <form:input path="email" /><br><br>
            <button type="submit">Update Employee</button>
        </form:form>
        <br>
        <a href="/">Back to Home</a>
    </div>
</body>
</html>