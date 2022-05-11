<html>
<head>
  <%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>로그인</title>
  <link href="./css/style.css" rel="stylesheet">
</head>
<body>


<section class="login">
  <nav class="banner">
    <a href="index.jsp">프로젝트이름</a>
  </nav>
  <div>
    <form action="${pageContext.request.contextPath}/main">
      <input type="text" value="아이디" name="id"><br>
      <input type="text" value="비밀번호" name="pw"><br>
      <input type="submit" value="로그인">
    </form>
      <a href="/register">회원가입</a>
  </div>
</section>
<nav>
  <a href="">회원가입</a>
</nav>
</body>
</html>
