<%--
  Created by IntelliJ IDEA.
  User: Григорий
  Date: 20.10.2015
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<div class="pdfViewer">
  <applet code="EmbedPDF.class" archive="<%=getServletConfig().getServletContext().getContextPath()%>/jars/EmbedPDF.jar" width="850" height="900">

    <!-- Use the following parameters to configure Embed PDF: -->

    <!-- The URL of the PDF document that we want to show: -->
      <param name="pdf" value="<%= request.getContextPath()%>/PdfContent?index=<%=request.getParameter("index")%>&session_id=<%=request.getSession().getId()%>"/>

    <!-- Whether users may open the PDF document in a new window: -->
    <param name="enableOpenWindow" value="true"/>

    <!-- Whether the PDF is rendered with subpixel-antialiasing (may be slow and needs more memory) -->
    <param name="enableSubpixAA" value="true"/>

    <!-- Whether to display the "print" button. -->
    <param name="enablePrinting" value="true"/>


    <!-- The following parameters are recommended to improve usability and
         performance of the applet when run with Sun's Java Plugin: -->

    <!-- whether language-specific texts shall be looked up on the server. -->
    <param name="codebase_lookup" value="false"/>

    <!-- whether the code of the applet shall be shared with other applets. -->
    <param name="classloader_cache" value="false"/>

    <!-- Whether the server provides a highly compressed .pack.gz-version of the applet.
         The amount of memory that the applet may use (128m is 128 mega bytes).
    -->
    <param name="java_arguments" value="-Djnlp.packEnabled=true -Xmx128m"/>

      <param name="image" value="<%=getServletConfig().getServletContext().getContextPath()%>/images/splash.gif"/>

    <!-- the border of the splash screen. -->
    <param name="boxborder" value="false"/>

    <!-- whether the splash screen shall be centered. -->
    <param name="centerimage" value="true"/>

    <!-- If the browser does not supprt java, we just provide a link to the PDF-document. -->
    <a href="example.pdf">example.pdf</a>
  </applet>
</div>

</body>
</html>
