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

      long selectedGenreId = 0;


      if (request.getParameter("genre_id") != null) {
        selectedGenreId = Long.valueOf(request.getParameter("genre_id"));

      } else if (session.getAttribute("genre_id") != null) {
        selectedGenreId = Long.valueOf(session.getAttribute("genreId").toString());
      }

      session.setAttribute("genreId", selectedGenreId);

    %>

    <li><a href="books.jsp?genre_id=0">Все книги</a></li>
    <%
      for (Genre genre : genreList.getGenresList()) {
        if (selectedGenreId != 0 && selectedGenreId == genre.getId()) {
    %>
    <li><a style="color:red;" href="books.jsp?genre_id=<%=genre.getId()%>"><%=genre.getName()%></a></li>
    <%        } else {

    %>
    <li><a href="books.jsp?genre_id=<%=genre.getId()%>"><%=genre.getName()%></a></li>
    <%                }
    }

    %>

  </ul>
</div>
