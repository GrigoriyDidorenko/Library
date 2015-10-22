<%--
  Created by IntelliJ IDEA.
  User: Григорий
  Date: 19.10.2015
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>

<div class="letters">
  <jsp:useBean id="letterList" class="net.didorenko.beans.LetterList" scope="application"/>
  <%

    String searchLetter = null;


    if (request.getParameter("letter") != null) {
      searchLetter = request.getParameter("letter");
      session.setAttribute("letter", searchLetter);
    } else if (session.getAttribute("letter") != null) {
      searchLetter = session.getAttribute("letter").toString();
    }


    char[] letters = letterList.getRussianLetters();
    for (char letter : letters) {

      if (searchLetter != null && searchLetter.toString().toUpperCase().charAt(0) == letter) {

  %>

  <a style="color:red;" href="books.jsp?letter=<%=letter%>"><%=letter%></a>
  <%
  } else {
  %>
  <a  href="books.jsp?letter=<%=letter%>"><%=letter%></a>
  <%
      }
    }%>
</div>