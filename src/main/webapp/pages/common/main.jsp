<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Main page :)</title>
</head>
<body class="page">
    <a href="${pageContext.request.contextPath}/controller?command=developers_show&recordsPerPage=2&currentPage=1">developers</a>
    <br>
    <a href="${pageContext.request.contextPath}/controller?command=testers_show&recordsPerPage=2&currentPage=1">testers</a>
    <br>
    <a href="${pageContext.request.contextPath}/controller?command=business_analysts_show&recordsPerPage=2&currentPage=1">business analysts</a>
    <br>
    <a href="${pageContext.request.contextPath}/controller?command=tl_sp_show&recordsPerPage=2&currentPage=1">team lead and software product</a>
</body>
</html>
