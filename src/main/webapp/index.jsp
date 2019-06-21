
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags" %>
<p:mainPages>
    <jsp:attribute name="sidebar">
        <%@include file="indexes/indexSideBar.jsp" %>
    </jsp:attribute>
    <jsp:attribute name="header">
      <%@include file="indexes/indexHeader.jsp"%>
    </jsp:attribute>
    <jsp:body>
    </jsp:body>
</p:mainPages>
<img width="90%" height="100%" src="${pageContext.request.contextPath}/images/fon3.jpg"/>
