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
    for (int i = 0; i < letters.length; i++) {
  %>
  <a  href="../../pages/books.jsp?letter=<%=letters[i]%>"><%=letters[i]%></a>
  <%
    }%>
</div>