
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

</body>
</html>
