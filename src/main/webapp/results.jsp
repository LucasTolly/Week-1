<%@include file="head.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    th, td {
        width: 150px;
    }
</style>
<html>
<body>

<%--TODO Pretty up the results!--%>
<div class="container-fluid">
    <h2>Search Results: </h2>

    <table>
        <tr>
            <th>Id</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Date of Birth</th>
            <th>Age</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.userid}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.dateOfBirth}</td>
                <td>${user.calculateUserAge()}</td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
