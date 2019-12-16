<%--
  Created by IntelliJ IDEA.
  User: barboss
  Date: 12/16/19
  Time: 00:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>developers</title>
</head>
<body>
    <table>
        <c:forEach items="${developers}" var="developer">
            <tr>
                <td><c:out value="${developer.id}"/></td>
                <td> ${developer.name}</td>
                <td> ${developer.surname}</td>
                <td> ${developer.phoneNumber}</td>
                <td> ${developer.favoriteGame}</td>
            </tr>
        </c:forEach>
    </table>
    <nav>
        <ul>
            <c:if test="${currentPage != 1}">
                <li>
                    <%--<a href="developers?recordsPerPage=${recordsPerPage}&currentPage=${currentPage-1}">Previous</a>--%>
                    <a href="${pageContext.request.contextPath}/controller?command=developers_show&recordsPerPage=${recordsPerPage}&currentPage=${currentPage-1}">Previous</a>
                </li>
            </c:if>

            <c:forEach begin="1" end="${noOfPages}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <li><a>${i} <span>(current)</span></a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="${pageContext.request.contextPath}/controller?command=developers_show&recordsPerPage=${recordsPerPage}&currentPage=${i}">${i}</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>

            <c:if test="${currentPage lt noOfPages}">
                <li><a href="${pageContext.request.contextPath}/controller?command=developers_show&recordsPerPage=${recordsPerPage}&currentPage=${currentPage+1}">Next</a>
                </li>
            </c:if>
        </ul>
    </nav>
</body>
</html>
