<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<style>
.banner >a{font-size: 16px; font-weight:bold; color: white;}

.nav-main{
    background-color: #f2dede;
}
#nav-ul > li > a{
	height:50px;
	padding: 15px;
}
#nav-ul > li > a:hover{
    background-color:pink;
}
</style>
<body>
<nav class="navbar navbar-default navbar-static-top">
		<div style="background-image: url('../../resources/images/banner.jpg'); background-size: cover; height: 200px;">
		<div class="banner" align="right" style="height: 24px; padding-top: 10px">
			<c:if test="${USER_KEY!=null}">
				<a href="/member/memberLogout"><i class="glyphicon glyphicon-log-in"></i> 로그아웃</a>&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="/mypage/myPageProfile"><i class="glyphicon glyphicon-cog"></i> MYPAGE</a>&nbsp;&nbsp;&nbsp;&nbsp;
			</c:if>
			<c:if test="${USER_KEY==null}">
				<a href="/member/memberLogin"><i class="glyphicon glyphicon-log-in"></i> 로그인</a>&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="/member/memberSignUp"><i class="glyphicon glyphicon-user"></i> 회원가입</a>&nbsp;&nbsp;&nbsp;&nbsp;
			</c:if>
		</div>
	</div>
	<div class="container">
		<div class="navbar-header"><a class="navbar-brand" href="/">로고들어갈위치</a></div>
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav nav-justified">
				<li><a href="/matching/main">매칭</a></li>
				<li><a href="/club/clubList">클럽</a></li>
				<c:if test="${USER_KEY.club_no!=null}">
					<li><a href="/myclub/myclubMain?no=${USER_KEY.club_no}">MYCLUB</a></li>
				</c:if>
				<li><a href="/com/boast/main">커뮤니티</a></li>
				<%-- <c:if test="${ADMIN!=null}"> --%>
					<li><a href="/admin/adminMain">관리</a></li>
				<%-- </c:if> --%>
			</ul>
		</div>
	</div>
<!-- /#wrapper -->
</nav>
<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<script src="../resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
