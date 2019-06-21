<%--<%@ page import="models.User" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User page</title>
</head>
<body>
<p:mainPages>
<jsp:attribute name="menu">
      <%@include file="indexMenu.jsp" %>
    </jsp:attribute>
    <jsp:attribute name="sidebar">
       <%@include file="/logging&registration/logout.jsp" %>
   </jsp:attribute>
</p:mainPages>
${user.name} WELCOME. MAKE YOUR ORDER
<img width="90%" height="100%" src="${pageContext.request.contextPath}/images/fon2.jpg"/>
</body>
</html>
