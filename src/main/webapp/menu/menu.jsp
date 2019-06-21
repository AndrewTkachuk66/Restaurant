
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags" %>

<table border=1>
    <thead>
    <tr>
        MENU
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
        <th>buy</th>

    </tr>
    </thead>
    <body >
    <c:forEach items="${list}" var="dish">
        <tr >
            <td>${dish.id}</td>
            <td>${dish.name}</td>
            <td>${dish.price}</td>
            <td><form method="post" action="${
            pageContext.request.contextPath}/basket?action=insert&id=<c:out value="${dish.id}"/>">
                <input type="submit" value="Buy"/></form></td>
        </tr>
    </c:forEach>
<p:mainPages>
   <jsp:attribute name="sidebar">
       <%@include file="../logging&registration/logout.jsp" %>
       ${user.name}
   </jsp:attribute>
</p:mainPages>
    <%--<img  width="100%" height="100%" src="${pageContext.request.contextPath}/images/fon2.jpg"/>--%>
    </body>
</table>

