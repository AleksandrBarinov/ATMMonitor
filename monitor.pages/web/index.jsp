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
    <title>ATM Monitor</title>
  </head>
  <body style="background-color:#d6f0f0;">

  <br>

  <h3>ATM Monitor</h3>

  <form method="post" action="${pageContext.request.contextPath}/generate">
    <input type="submit" value="Generate states"/>
  </form>
  <form method="get" action="${pageContext.request.contextPath}/monitor">
    <input type="submit" value="ATM states"/>
  </form>

  <form name="atmForm" action="${pageContext.request.contextPath}/report ">
      <div>
        ATM:
        <select name="atm">
            <option></option>
          <c:forEach items="${states}" var="state">
            <option>${state.atm.id}</option>
          </c:forEach>
        </select>
        sensor:
        <select name="sensor">
            <option value="0">sensor</option>
            <option value="1">sensor1</option>
            <option value="2">sensor2</option>
            <option value="3">sensor3</option>
            <option value="4">sensor4</option>
        </select>
      </div>
    <br>
      <div>
        <div>
          <label>
            <input type="date" name="dateFrom">
          </label>
          <label>
            <input type="time" name="timeFrom">
          </label>
          (from)
        </div>
        <div>
          <label>
            <input type="date" name="dateTo">
          </label>
          <label>
            <input type="time" name="timeTo">
          </label>
          (to)
        </div>
      </div>
      <br>
        <input type="submit" value="generate report"/>
  </form>

  <c:import url="WEB-INF/jsp/monitor.jsp"></c:import>

  </body>
</html>
