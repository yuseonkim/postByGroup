<%--
  Created by IntelliJ IDEA.
  User: yuling
  Date: 2022/05/11
  Time: 6:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <titlle>회원가입</titlle>
</head>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
    function fn_joinMember() {
        var joinForm = document.joinForm;
        var name = joinForm.name.value;
        var grade = joinForm.grade.value;
        var deaprt = joinForm.depart.value;
        var id = joinForm.id.value;
        var rePwd = joinForm.rePwd.value;

        if (name.length == 0 || name == "") {
            alert("이름을 입력해주세요. ");
            joinForm.name.focus();
        } else if (grade.length == 0 || name == "") {
            alert("학년을 입력해주세요");
            joinForm.grade.focus();
        } else if (depart.lengh == 0 || deaprt == "") {
            alert("소속을 입력해주세요");
            joinForm.depart.focus();
        } else if (id.length == 0 || id == "") {
            alert("아이디를 입력해주세요. ");
            joinForm.id.focus();
        } else if (joinForm.idDuplication.value != "idCheck") {
            alert("아이디 중복체크를 해주세요. ");
        } else if (pwd.length == 0 || pwd == ""){
            alert("패스워드를 입력해주세요");
            joinForm.pwd.focus();
        } else if (rePwd.length == 0 || rePwd == "") {
            alert("패스워드를 다시 입력해주세요");
            joinForm.repwd.focus();
        } else if (rePwd != pwd) {
            alert("입력하신 비밀번호가 틀립니다");
            joinForm.rePwd.focus();
        } else {
            joinForm.method="post";
            joinForm.action="${contextPath}/member/joinMember.do";
        }

            }
</script>
<body>
<form action="./register.jsp">
    <p>이름</p> : <input type="text" name="name"><input type="button" onclick="fd">
    <p>학년</p> : <input type="text" name="grade"><br>
    <p>학과</p> : <input type="text" name="depart">
    <p>ID</p> : <input type="text" name="id" onkeydown="inputIdChck()">
    <button type="button" onclick="fn_dbCheckId()" name="dbCheckId" class="checkId">중복확인
    </button>
    <input type="hidden" name="idDuplication" value="idUncheck"/>
    <p>PW</p> : <input type="text" name="pwd"><br>
    <p>PW재입력</p> : <input type="text" name="rePwd"><br>

</form>

</body>
</html>
