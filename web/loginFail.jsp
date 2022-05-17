<%--
  Created by IntelliJ IDEA.
  User: yuling
  Date: 2022/05/17
  Time: 8:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인실패</title>
</head>
<body>
<div class="title">
    <p> 존재하지 아이디 혹은 비밀번호가 맞지 않습니다. </p>
</div>
<div class="loginForm">
    <form action="${pageContext.request.contextPath}/login">
        <input type="text" value="아이디" name="id"><br>
        <input type="text" value="비밀번호" name="pw"><br>
        <input type="submit" value="로그인">
    </form>
</div>
</body>
</html>
