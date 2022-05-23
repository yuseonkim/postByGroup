<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>

</head>
<body>
<header>
    <section>헤더</section>
    어서오세요 ${member.name}님!
</header>

<main id="main">
    <section h1="teamBoard">
        <a href="/board/team?mid=${member.mid}">가입중 팁목록</a>
    </section>
    <section h1="recuritingBoard">
        <a href="/board/recruiting?mid=${member.mid}">모집 중 팀 목록</a>
    </section>
    <section h1="OperatingBoard">
        <a href=""></a>
    </section>
    <section>
        <a href="/board/makeTeam?mid=${member.mid}">팀생성</a>
    </section>
</main>
<
</body>
</html>
