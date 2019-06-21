
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true" %>
<%@attribute name="sidebar" fragment="true" %>
<%@attribute name="menu" fragment="true" %>
<%@attribute name="main" fragment="true" %>

<html>
<head>
    <style>
        #header{/*
            */background-color: aliceblue;
            width:100%;
            height:100px;
            text-align: center;

        }
        #sidebar{
            float:left;
            width:10%;
            background-color: red;
        }
          #main{
              background: url("/images/fon3.jpg");
          }

        #menu{
            float: right;
            width: 10%;
            background-color: darkorange;
        }
    </style>
    <title>Main Page</title>
</head>
<body>
<div id="header">
    <jsp:invoke fragment="header"/>

</div>
<div id="sidebar">
    <jsp:invoke fragment="sidebar"/>

</div>
<div id="main">
    <jsp:invoke fragment="main"/>
</div>
<div id="menu">
    <jsp:invoke fragment="menu"/>
</div>
</body>
</html>