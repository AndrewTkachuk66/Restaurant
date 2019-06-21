
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    REGISTRATION FORM
        <form method="post" action="/registration" >
            Name : <input type="text" name= "name"/>
            <br />
            Login : <input type="text" name="login"/>
            <br />
            Password : <input type="text" name="password"/>
            <br />
            Email : <input type="text" name="email"/>
            <br />
            <input type="submit" value="Submit" />
        </form>
</body>
</html>