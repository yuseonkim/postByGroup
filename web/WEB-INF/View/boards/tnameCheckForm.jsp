
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contexPath" value="${pageContext.request.contextPath}"/>
<c:set var="id" value="${id}"/>

<html>
<head>
  <title>Title</title>
</head>
<script type="text/javascript">
  function sendCheckValue() {
    var openJoinfrm = opener.document.joinForm;
    if (document.checkIdForm.chResult.value=="N"){
      alert("다른 팀이름을 입력하시오");
      openJoinfrm.id.focus();

      window.close();
    }else{
      openJoinfrm.idDuplication.value ="idCheck";
      openJoinfrm.dbCheckId.disabled=true;
      openJoinfrm.dbCheckId.style.capacity=0.6;
      openJoinfrm.dbCheckId.style.cursor="default";
      window.close();
    }
  }
</script>
<body>
<form name="checkIdForm">
  <input type="text" name="id" value="${tname}" id="userId" disabled>
  <c:choose>
    <c:when test="${result == 1}">
      <p> 이미 사용중인 팀이름입니다 </p>
      <input type="hidden" name="chResult" value="N"/>
    </c:when>
    <c:when test="${result == 0}">
      <p> 사용가능한 팀이름입니다 </p>
      <input type="hidden" name="chResult" value="Y"/>
    </c:when>
    <c:when test="${result == -1}">
      <p>오류</p>
      <input type="hidden" name="chResult" value="N"/>
    </c:when>
  </c:choose>
  <input type="button" onclick="window.close()" value="취소"/><br>
  <input type="button" onclick="sendCheckValue()" value="사용하기"/><br>
</form>

</body>
</html>
