<jsp:include page="WEB-INF/jsp/header.jsp"/>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>

<%
    response.sendRedirect("http://localhost:8081/IoT_war/home");
%>

<div class="main-picture">
    <div class="about">
        Интеллектуальная система "Умный дом"<br>
        <button type="button" class="btn btn-dark">Подробнее</button>
    </div>
</div>

<jsp:include page="WEB-INF/jsp/footer.jsp"/>