<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page contentType="text/html;charset=UTF-8"  language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Welcome Andrew
    <table border=1>
        <thead>
        <tr>
            <th>Id</th>
            <th> UserId</th>
            <th>Email</th>
            <c:forEach items="${orderList}" var="order">
        <tr>
            <td>${order.id}</td>
            <td>${order.userID}</td>
            <td><form >
                <button type="submit">Confirm user order</button>
            </form></td>
        </tr>
        </c:forEach>
        <c:forEach items="${clientList}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.email}</td>
            </tr>
        </c:forEach>
        </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
</body>
</html>
