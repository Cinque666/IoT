<%--
  Created by IntelliJ IDEA.
  User: romaz
  Date: 10.11.2019
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="header.jsp"/>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>

    <div class="main-picture">
        <div class="about">
            Интеллектуальная система "Умный дом"<br>
            <form action="${pageContext.request.contextPath}/information" method="get">
                <button type="submit" class="btn btn-dark">Подробнее</button>
            </form>
        </div>

        <div>
            ${password}
        </div>

    </div>

<jsp:include page="footer.jsp"/>

