<%--
  Created by IntelliJ IDEA.
  User: Григорий
  Date: 17.10.2015
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@page import="net.didorenko.beans.Book" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="net.didorenko.enums.SearchType" %>

<%@include file="../WEB-INF/jspf/left_menu.jsp"%>


<jsp:useBean id="bookList" class="net.didorenko.beans.BookList" scope="page"/>

<%@include file="../WEB-INF/jspf/letters.jsp" %>

<div class="book_list">



  <%
    ArrayList<Book> list = new ArrayList<Book>();

    if (request.getParameter("genre_id") != null) {
      long genreId = Long.valueOf(request.getParameter("genre_id"));
      list = bookList.getBooksByGenre(genreId);
    } else if (request.getParameter("letter") != null) {
      String letter = request.getParameter("letter");
      list = bookList.getBooksByLetter(letter);
    } else if (request.getParameter("search_string") != null) {
      String searchStr = request.getParameter("search_string");
      SearchType type = SearchType.TITLE;
      if (request.getParameter("search_option").equals("Автор")) {
        type = SearchType.AUTHOR;
      }

      if (searchStr != null && !searchStr.trim().equals("")) {
        list = bookList.getBooksBySearch(searchStr, type);
      }
    }
  %>
  <h5 style="text-align: left; margin-top:20px;">Найдено книг: <%=list.size() %> </h5>
  <%
    session.setAttribute("currentBookList", list);
    for (Book book : list) {

  %>

  <div class="book_info">
    <div class="book_title">
      <p> <%=book.getName()%></p>
    </div>
    <div class="book_image">
      <a href="#"><img src="<%=request.getContextPath()%>/ShowImage?index=<%=list.indexOf(book)%>" height="250" width="190" alt="Обложка"/></a>
    </div>
    <div class="book_details">
      <br><strong>ISBN:</strong> <%=book.getIsbn()%>
      <br><strong>Издательство:</strong> <%=book.getPublisher()%>

      <br><strong>Количество страниц:</strong> <%=book.getPageCount()%>
      <br><strong>Год издания:</strong> <%=book.getPublishDate()%>
      <br><strong>Автор:</strong> <%=book.getAuthor()%>
      <p style="margin:10px;"> <a href="#">Читать</a></p>
    </div>
  </div>


  <%}%>



</div>
