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
    <title>회원가입</title>
</head>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
    function openCheckId() {
        var joinForm = document.joinForm;
        var id = joinForm.id.value;
        if (id.length == 0 || id == "") {
            alert("아이디를 입력해주세여");
            joinForm.id.focus();
        } else {
            window.open("member/idCheck?id=" + id, "", "width=500,height=300");

        }
    }

    function checkValue() {

        var joinForm = document.joinForm;
        var name = joinForm.name.value;
        var grade = joinForm.grade.value;
        var depart = joinForm.depart.value;
        var id = joinForm.id.value;
        var rePwd = joinForm.rePwd.value;

        if (name.length == 0 || name == "") {
            alert("이름을 입력해주세요. ");
            joinForm.name.focus();
            return false;
        } else if (grade.length == 0 || name == "") {
            alert("학년을 입력해주세요");
            joinForm.grade.focus();
            return false;
        } else if (depart.lengh == 0 || depart == "") {
            alert("소속을 입력해주세요");
            joinForm.depart.focus();
            return false;
        } else if (id.length == 0 || id == "") {
            alert("아이디를 입력해주세요. ");
            joinForm.id.focus();
            return false;
        } else if (joinForm.idDuplication.value != "idCheck") {
            alert("아이디 중복체크를 해주세요. ");
            return false;
        } else if (pwd.length == 0 || pwd == "") {
            alert("패스워드를 입력해주세요");
            joinForm.pwd.focus();
            return false;
        } else if (rePwd.length == 0 || rePwd == "") {
            alert("패스워드를 다시 입력해주세요");
            joinForm.repwd.focus();
            return false;
        } else if (rePwd != pwd) {
            alert("입력하신 비밀번호가 틀립니다");
            joinForm.rePwd.focus()
            return false;
        } else {
            return true;
        }

    }

    function inputIdChk() {
        document.joinForm.idDuplication.value = "idUncheck";
    }

</script>
<body>
<form method="post" action="./register" name="joinForm">
    <p>이름</p> : <input type="text" name="name">
    <p>학년</p> :
    <label>
        <select name="grade">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
        </select>
    </label>
    <p>학과</p> :
    <input type="text" name="depart">
    <p>ID</p> : <input type="text" name="id" onkeydown="inputIdChk()">
    <input type="button" value="중복확인" onclick="openCheckId()">
    <input type="hidden" name="idDuplication" value="idUncheck">
    <p>PW</p> : <input type="text" name="pwd"><br>
    <p>PW재입력</p> : <input type="text" name="rePwd"><br>
    <input type="submit" value="확인" onclick="return checkValue();">

</form>

</body>
</html>
