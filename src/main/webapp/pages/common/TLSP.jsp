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
    <title>TLSP</title>
</head>
<body>
    <table>
        <tr>
            <td> ${softwareProduct.title}</td>
            <td> ${softwareProduct.customer}</td>
        </tr>
    </table>
    <table>
        <tr>
            <td> ${teamLead.name}</td>
            <td> ${teamLead.surname}</td>
            <td> ${teamLead.phoneNumber}</td>
            <td> ${teamLead.favoriteGame}</td>
            <td> ${teamLead.motto}</td>
        </tr>
    </table>
</body>
</html>
