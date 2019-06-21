<%--
  Created by IntelliJ IDEA.
  User: Andre
  Date: 13.06.2019
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Admin</title>

</head>
<body>
<p:mainPages>
<jsp:attribute name="sidebar">
       <%@include file="../logging&registration/logout.jsp" %>
   </jsp:attribute>
    <jsp:attribute name="header">
       <%@include file="../admins/welcomeAdmin.jsp" %>
   </jsp:attribute>
</p:mainPages>
<%--Welcome Andrew
<form  method="get" action="/admin">
    <button type="submit">show orders</button>
</form>
<form method="post" action="/admin">
    <button type="submit">show clients</button>
</form>--%>
</body>
</html>
