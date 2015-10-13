<%@ page import="java.util.ArrayList" %>
<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
  какойто файл
  <p>Attribute
  <%=request.getAttribute("Attribute")%>
  </p>

  <table>
      <%  if (request.getAttribute("list")!=null){
          ArrayList<String> list = (ArrayList<String>) request.getAttribute("list");
      for (String name:list){%>
      <tr><td><%=name%></td></tr>
      <%}
          }%>
  </table>

  <form method="post" action="/Servlet">
      <input type="text" value="Name"  name="value"/>
      <input type="submit" value="Добавить"/>
  </form>
  </body>
</html>