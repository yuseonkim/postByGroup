<%--
  Created by IntelliJ IDEA.
  User: yuling
  Date: 2022/05/21
  Time: 6:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${member.name}님 이미 ${team.tname}에 가입신청을 하셨습니다. 수락할때까지 기다려주세요.
<a href="/main?mid=${param.mid}">홈화면으로</a>
</body>
</html>
