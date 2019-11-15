<%--
  Created by IntelliJ IDEA.
  User: romaz
  Date: 14.11.2019
  Time: 23:27
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="header.jsp"/>

<div class="sensor-details">
<table class="table table-dark">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Датчик</th>
        <th scope="col">Сенсор</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="searchDevice" items="${searchDevices}">
    <tr>
        <th scope="row">${searchDevice.id}</th>
        <td>${searchDevice.name}</td>
        <td>
            <div class="span-table-cells">
                <c:forEach var="sensor" items="${sensors}">
                    <span>
                        <a href="${pageContext.request.contextPath}/sensorDetails/${sensor.name}/${sensor.id}">
                                ${sensor.name}
                        </a>
                    </span>
                </c:forEach>
            </div>
        </td>
    </tr>
    </c:forEach>
    </tbody>
</table>
</div>

<jsp:include page="footer.jsp"/>
