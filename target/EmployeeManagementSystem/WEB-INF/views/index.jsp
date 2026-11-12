<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head><title>Employee Management System</title></head>
<body>
    <div align="center">
        <h2>Employee List</h2>
        <a href="showNewEmployeeForm">Add New Employee</a>
        <br><br>
        <table border="1" cellpadding="10">
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="emp" items="${listEmployees}">
                <tr>
                    <td>${emp.firstName}</td>
                    <td>${emp.lastName}</td>
                    <td>${emp.email}</td>
                    <td>
                        <a href="showFormForUpdate/${emp.id}">Update</a> |
                        <a href="deleteEmployee/${emp.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>