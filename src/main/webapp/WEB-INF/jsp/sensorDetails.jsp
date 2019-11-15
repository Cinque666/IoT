<%--
  Created by IntelliJ IDEA.
  User: romaz
  Date: 13.11.2019
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp"/>

<div class="sensor-details">
    <div class="sensor-name">${sensor}</div>
    <table class="table table-dark">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Дата</th>
            <th scope="col">Значение</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="sensorValue" items="${sensorValues}">
        <tr>
            <th scope="row">${sensorValue.id}</th>
            <td>${sensorValue.date}</td>
            <td>${sensorValue.value}</td>
        </tr>
        </c:forEach>
        </tbody>
    </table>

    <ul class="pagination pagination-sm">
        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/sensorDetails/${objSensor.name}/${objSensor.id}/1">1</a></li>
        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/sensorDetails/${objSensor.name}/${objSensor.id}/2">2</a></li>
        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/sensorDetails/${objSensor.name}/${objSensor.id}/3">3</a></li>
    </ul>

    <div style="width: 600px;">
        <div id="chart_div"></div>
    </div>
</div>

<jsp:include page="footer.jsp"/>