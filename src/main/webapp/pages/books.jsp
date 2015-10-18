<%--
  Created by IntelliJ IDEA.
  User: Григорий
  Date: 17.10.2015
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@page import="net.didorenko.beans.Book" %>
<%@ page import="java.util.ArrayList" %>

<%@include file="../WEB-INF/jspf/left_menu.jsp"%>

<% request.setCharacterEncoding("UTF-8");

  long genreId = 0;

  try{
    genreId = Long.valueOf(request.getParameter("genre_id"));
  } catch (Exception e){
    e.printStackTrace();
  }

  %>

<jsp:useBean id="bookList" class = "net.didorenko.beans.BookList" scope="page"/>

<div class="book_List">
  <h3>${param.name}</h3>

  <%
    ArrayList<Book> bookArrayList = bookList.getBooksById(genreId);
    session.setAttribute("currentBookList", bookArrayList);
    for(Book book : bookArrayList){
  %>

  <table cellpadding="30" style="font-size: 12px;">
    <tr>
      <td style="width:400px;height: 100px;">
        <p style="color:#378de5 ;font-weight: bold; font-size: 15px;"> <%=book.getName()%></p>
        <br><strong>ISBN:</strong> <%=book.getIsbn()%>
        <br><strong>Издательство:</strong> <%=book.getPublisher() %>

        <br><strong>Количество страниц:</strong> <%=book.getPageCount() %>
        <br><strong>Год издания:</strong> <%=book.getPublishDate() %>
        <br><strong>Автор:</strong> <%=book.getAuthor() %>
        <p style="margin:10px;"> <a href="#">Читать</a></p>
      </td>
      <td style="width:150px;height: 100px;">
        <img src="<%=request.getContextPath()%>/ShowImage?index=<%=bookArrayList.indexOf(book)%>" height="250" width="190" alt="Обложка">
      </td>
    </tr>
      <%}%>
</div>
