<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: romaz
  Date: 12.11.2019
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="header.jsp"/>

<div class="device-details-picture">

<table class="table table-dark">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Датчик</th>
        <th scope="col">Сенсор</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <th scope="row">${device.id}</th>
        <td>${device.name}</td>
        <td>
            <div class="span-table-cells">
                <c:forEach var="sensor" items="${sensors}">
                    <span>
                        <a href="${pageContext.request.contextPath}/sensorDetails/${sensor.name}/${sensor.id}/1">
                                ${sensor.name}
                        </a>
                    </span>
                </c:forEach>
            </div>
        </td>
    </tr>
    </tbody>
</table>

</div>

<jsp:include page="footer.jsp"/>