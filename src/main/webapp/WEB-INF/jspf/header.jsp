<%--
  Created by IntelliJ IDEA.
  User: Григорий
  Date: 16.10.2015
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Онлайн библиотека</title>
  <link href="../css/style_main.css" rel="stylesheet" type="text/css">
</head>
<body>
  <%

            request.setCharacterEncoding("UTF-8");


        %>

<div class="container">

  <div class="header">
    <div class="logo">
      <a href="main.jsp"><img src="../images/library.png" alt="Логотип" name="logo" /></a>

    </div>
    <div class="descr">
      <h3>Онлайн библиотека</h3>

    </div>
    <div class="welcome">
      <h5>Добро пожаловать, <%=request.getParameter("username") %> !</h5>
      <h6><a href="../index.jsp">Выход</a></h6>
    </div>
    <div class="search_form">
      <form name="search_form" method="GET" action="books.jsp">
        <input type="text" name="search_string" size="110"/>
        <input class="search_button" type="submit" value="Поиск"/>
        <select name="search_option">
          <option>Название</option>
          <option>Автор</option>
        </select>
      </form>
    </div>
  </div>