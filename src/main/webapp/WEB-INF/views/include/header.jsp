<%@ page contentType="text/html; charset=UTF-8"%>
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
<nav class="nav-main navbar">
		<div style="background-image: url('../resources/images/banner.jpg'); background-size: cover; height: 200px;">
		<div class="banner" align="right" style="height: 24px; padding-top: 10px">
			<a href="/member/memberLogin"><i class="glyphicon glyphicon-log-in"></i> 로그인</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="/member/memberSignUp"><i class="glyphicon glyphicon-user"></i> 회원가입</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="/mypage/myPageProfile"><i class="glyphicon glyphicon-cog"></i> MYPAGE</a>&nbsp;&nbsp;&nbsp;&nbsp;
		</div>
	</div>
	<div class="container">
		<div class="navbar-header"><a class="navbar-brand" href="#">로고들어갈위치</a></div>
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav nav-justified" id="nav-ul">
				<li><a href="../matching/matchingPage.jsp">매칭</a></li>
				<li><a href="../club/clubPage.jsp">클럽</a></li>
				<li><a href="../myteam/myteam.jsp">MYTEAM</a></li>
				<li><a href="#">커뮤니티</a></li>
			</ul>
		</div>
	</div>
<!-- /#wrapper -->
</nav>
</body>
</html>
