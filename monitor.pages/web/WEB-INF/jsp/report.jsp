<%--
  Created by IntelliJ IDEA.
  User: Александр
  Date: 18.12.2019
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
  <head>
    <title>ATM Monitor Report</title>
  </head>
  <body style="background-color:#d6f0f0;">
  <body>

  <h3>ATM Monitor Report</h3>

  <form method="get" action="${pageContext.request.contextPath}/monitor">
    <input type="submit" value="<- back to monitor page"/>
  </form>

  <br>
  <div>
    <table border="list">
      <td align="center" bgcolor="#C0C0C0">id</td>
      <td align="center" bgcolor="#C0C0C0">location</td>
      <td align="center" bgcolor="#C0C0C0">description</td>
      <td align="center" bgcolor="#C0C0C0">date</td>
      <td align="center" bgcolor="#C0C0C0">sensor</td>
      <td align="center" bgcolor="#C0C0C0">value</td>

      <c:forEach items="${states}" var="state">
        <tr>
          <td align="center">${state.atmId}</td>
          <td align="center">${state.atmLocation}</td>
          <td align="center">${state.atmDescription}</td>
          <td align="center">${state.date}</td>
          <td align="center">${state.sensorName}</td>
          <td align="center">${state.sensorValue}</td>
        </tr>
      </c:forEach>
    </table>
  </div>
  </body>
  </body>
</html>
