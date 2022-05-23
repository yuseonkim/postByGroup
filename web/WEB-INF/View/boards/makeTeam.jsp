
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
            alert("팀이름를 입력해주세여");
            joinForm.id.focus();
        } else {
            window.open("${contextPath}/board/tnameCheck?id=" + id, "", "width=500,height=300");

        }
    }

    function checkValue() {

        var joinForm = document.joinForm;

        var id = joinForm.id.value;



        if (id.length == 0 || id == "") {
            alert("팀이름을 입력해주세요. ");
            joinForm.id.focus();
            return false;
        } else if (joinForm.idDuplication.value != "idCheck") {
            alert("팀이름 중복체크를 해주세요. ");
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
<form method="post" action="/board/insertTeam?mid=${param.mid}" name="joinForm">
    <p>팀이름</p> : <input type="text" name="id" onkeydown="inputIdChk()">
    <input type="button" value="중복확인" name="dbCheckId" onclick="openCheckId()">
    <input type="hidden" name="idDuplication" value="idUncheck">

    <input type="submit" value="확인" onclick="return checkValue();">

</form>

</body>
</html>
