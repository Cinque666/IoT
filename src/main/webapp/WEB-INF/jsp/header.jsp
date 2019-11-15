<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: romaz
  Date: 12.11.2019
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="eu">
<head>
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">
        // Load the Visualization API and the piechart package.
        google.load('visualization', '1.0', {
            'packages' : [ 'corechart' ]
        });
        // Set a callback to run when the Google Visualization API is loaded.
        google.setOnLoadCallback(drawChart);
        // Callback that creates and populates a data table,
        // instantiates the pie chart, passes in the data and
        // draws it.
        function drawChart() {
            // Create the data table.
            //var data = new google.visualization.DataTable();
            //data.addColumn('string', 'Topping');
            //data.addColumn('number', 'Slices');
            var data = google.visualization.arrayToDataTable([
                ['Info', 'Value'],
                <c:forEach items="${values}" var="value">
                [ '${value.id}', ${value.value} ],
                </c:forEach>
            ]);
            // Set chart options
            var options = {
                'Average temperature' : 'Area-wise Top Seven Countries in the World', //title which will be shown right above the Google Pie Chart
                is3D : true, //render Google Pie Chart as 3D
                pieSliceText: 'label', //on mouse hover show label or name of the Country
                tooltip :  {showColorCode: true}, // whether to display color code for a Country on mouse hover
                'width' : 900, //width of the Google Pie Chart
                'height' : 500 //height of the Google Pie Chart
            };
            // Instantiate and draw our chart, passing in some options.
            var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
            chart.draw(data, options);
        }
    </script>
    <style>
        <%@include file="/WEB-INF/css/information.css"%>
    </style>
    <style>
        <%@include file='/WEB-INF/css/home.css' %>
    </style>
    <style>
        <%@include file='/WEB-INF/css/deviceDetails.css' %>
    </style>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>IoT</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Умный дом</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/">Начальная <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/information">Информация</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Список устройств
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <c:forEach var="device" items="${devices}">
                        <a class="dropdown-item"
                           href="${pageContext.request.contextPath}/deviceDetails/device/${device.id}">
                                ${device.name}
                        </a>
                    </c:forEach>
                </div>
            </li>

            <sec:authorize access="hasRole('ADMIN')">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/register">Регистрация</a>
                </li>
            </sec:authorize>

            <sec:authorize access="!isAuthenticated()">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/login">Вход</a>
                </li>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/logout">Выйти</a>
                </li>
            </sec:authorize>
        </ul>

    </div>
    <sec:authorize access="hasAnyRole('ADMIN', 'ANALYST')">
        <form action="${pageContext.request.contextPath}/search" class="form-inline my-2 my-lg-0">
            <input name="searchDevice" class="form-control mr-sm-2" type="search" placeholder="Поиск" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Поиск</button>
        </form>
    </sec:authorize>

</nav>