<%--
  Created by IntelliJ IDEA.
  User: Григорий
  Date: 17.10.2015
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@page import="net.didorenko.beans.Genre"%>
<%@ page pageEncoding="UTF-8" %>
<div class="sidebar1">
  <h4>Жанры:</h4>
  <ul class="nav">
    <jsp:useBean id="genreList" class="net.didorenko.beans.GenreList" scope="application"/>
    <%
      for (Genre genre : genreList.getGenresList()) {
    %>
    <li><a href="books.jsp?genre_id=<%=genre.getId()%>"><%=genre.getName()%></a></li>
    <%}%>
  </ul>
</div>
