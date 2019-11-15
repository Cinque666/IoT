<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="header.jsp"/>

<div class="registration-picture">
<h1>Регистрация нового пользователя</h1>

<form action="${pageContext.request.contextPath}/register" method="POST">
    <div class="form-group">
        <label for="name">Имя</label>
        <input type="text" name="name" class="form-control" id="name" placeholder="Enter your name">
    </div>
    <div class="form-group">
        <label for="surname">Фамилия</label>
        <input type="text" name="surname" class="form-control" id="surname" placeholder="Enter your surname">
    </div>
    <div class="form-group">
        <label for="userName">Логин</label>
        <input type="text" name="userName" class="form-control" id="userName" placeholder="Enter login">
    </div>
    <div class="form-group">
        <label for="password">Пароль</label>
        <input type="password" name="password" class="form-control" id="password" placeholder="Password">
    </div>
    <div class="form-group">
        <select name="role" id="role" class="form-control">
            <c:forEach var="role" items="${roles}">
                <option>${role}</option>
            </c:forEach>
        </select>
    </div>

    <button type="submit" class="btn btn-primary reg-btn">Отправить</button>
</form>
</div>

<jsp:include page="footer.jsp"/>