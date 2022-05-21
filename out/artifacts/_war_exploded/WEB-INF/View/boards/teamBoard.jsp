<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yuling
  Date: 2022/05/19
  Time: 10:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<section id="list">
<table class="table">
  <thread>
    <tr>
      <th>번호</th>
      <th>방이름</th>
    </tr>
  </thread>
  <tbody>
  <c:forEach var="n" items="${team}" varStatus="st">
    <tr>
      <td>${n.tid}</td>
      <td><a href="">${n.tname}</a></td>
    </tr>

  </c:forEach>
  </tbody>
</table>
</section>
</body>
</html>
