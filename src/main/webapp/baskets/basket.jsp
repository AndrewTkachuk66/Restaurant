
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags" %>
<title>Basket</title>
<table border=1>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
    </tr>
    </thead>
    <tbody>
    <tbody>

${user.name} your basket:
    <c:forEach items="${list}" var="dish">
        <tr>
            <td>${dish.id}</td>
            <td>${dish.name}</td>
            <td>${dish.price}</td>
            <td><form method="post" action="${
            pageContext.request.contextPath}/basket?action=delete&id=<c:out value="${dish.id}"/>">
                <button type="submit" value="delete"/>delete</form></td>

        </tr>
        <tr> <form method="get" action="${
            pageContext.request.contextPath}/order">
            </form></tr>
    </c:forEach>

   <td><form action="/order">
       <button type="submit">Pay</button>
       <td>Price of order: ${price}</td>
   </form></td>
    </tbody>
    <p:mainPages>
     <jsp:attribute name="menu">
      <%@include file="../indexes/indexMenu.jsp" %>
    </jsp:attribute>
        <jsp:attribute name="sidebar">
       <%@include file="../logging&registration/logout.jsp" %>
   </jsp:attribute>
    </p:mainPages>
</table>
