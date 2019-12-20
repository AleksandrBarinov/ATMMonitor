<%--
  Created by IntelliJ IDEA.
  User: Александр
  Date: 20.12.2019
  Time: 0:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>
    <br>
    <div>
        <table border="list">
            <td align="center" bgcolor="#C0C0C0">atm id</td>
            <td align="center" bgcolor="#C0C0C0">atm location</td>
            <td align="center" bgcolor="#C0C0C0">atm description</td>
            <td align="center" bgcolor="#C0C0C0">state id</td>
            <td align="center" bgcolor="#C0C0C0">state date</td>
            <td align="center" bgcolor="#C0C0C0">sensor</td>
            <td align="center" bgcolor="#C0C0C0">sensor1</td>
            <td align="center" bgcolor="#C0C0C0">sensor2</td>
            <td align="center" bgcolor="#C0C0C0">sensor3</td>
            <td align="center" bgcolor="#C0C0C0">sensor4</td>
            <c:forEach items="${states}" var="state">
                <tr>
                    <td align="center">${state.atm.id}</td>
                    <td align="center">${state.atm.location}</td>
                    <td align="center">${state.atm.description}</td>
                    <td align="center">${state.id}</td>
                    <td align="center">${state.date}</td>
                    <td align="center">${state.sensor}</td>
                    <td align="center">${state.sensor1}</td>
                    <td align="center">${state.sensor2}</td>
                    <td align="center">${state.sensor3}</td>
                    <td align="center">${state.sensor4}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
