<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: romaz
  Date: 12.11.2019
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="header.jsp"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="main-picture">
    <table class="table table-dark">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Датчик</th>
            <th scope="col">Сенсор</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="device" items="${devices}">
            <tr>
                <th scope="row">${device.id}</th>
                <td>${device.name}</td>
                <td>
                    <div style="display: flex; flex-direction: column">
                        <span>Row 1</span>
                        <span>Row 2</span>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<jsp:include page="footer.jsp"/>