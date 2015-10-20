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
    char[] letters = letterList.getRussianLetters();
    for (char letter : letters ) {
  %>
  <a  href="books.jsp?letter=<%=letter%>"><%=letter%></a>
  <%
    }%>
</div>