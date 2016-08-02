<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<style>
.banner >a{font-size: 16px; font-weight:bold; color: white;}
#main-navbar >li{font-size: 16px; font-weight:bold; color: gray;}
</style>
<body>
<nav class="navbar navbar-default navbar-static-top">
		<div style="background-image: url('../resources/images/banner.jpg'); background-size: cover; height: 200px;">
		<div class="banner" align="right" style="height: 24px; padding-top: 10px">
			<a href="/"><i class="glyphicon glyphicon-home"></i> 서비스홈</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="member/memberLogout"><i class="glyphicon glyphicon-log-out"></i> 로그아웃</a>&nbsp;&nbsp;&nbsp;&nbsp;
		</div>
	</div>
	<div class="container">
		<div class="navbar-header"><a class="navbar-brand" href="#">로고들어갈위치</a></div>
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav nav-justified" style="margin-top:10px" id="main-navbar">
				<li><a href="/admin/adminMain">관리 홈</a></li>
				
				<!-- 직원 메뉴 -->
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">직원</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="/admin/adminEmpAll">전체 직원 관리</a></li>
			            <li class="divider"></li>
						<li><a href="/admin/adminEmpAdd">직원 등록</a></li>
					</ul>
				</li>
				
				<!-- 회원 메뉴 -->
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">회원</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="/admin/adminMemberAll">전체 회원 관리</a></li>
			            <li class="divider"></li>
						<li><a href="/admin/adminMemberDeclaration">신고 접수 관리</a></li>
					</ul>
				</li>
				
				<!-- 클럽 메뉴 -->
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">클럽</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="/admin/adminClubAll">전체 클럽 관리</a></li>
			            <li class="divider"></li>
						<li><a href="/admin/adminClubDeclaration">신고 접수 관리</a></li>
					</ul>
				</li>
				
				<!-- 커뮤니티 메뉴 -->
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">커뮤니티</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="/admin/adminCommunityAll">전체 게시판 관리</a></li>
			            <li class="divider"></li>
						<li><a href="/admin/adminCommunityDeclaration">신고 접수 관리</a></li>
			            <li class="divider"></li>
						<li><a href="/admin/adminCommunityQnA">Q&A 관리</a></li>
					</ul>
				</li>
				
				<!-- 꾸미기 메뉴 -->
				<li class="dropdown">
				  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">꾸미기</a>
		          <ul class="dropdown-menu" role="menu">
		            <li><a href="/admin/adminAd">광고 관리</a></li>
		            <li class="divider"></li>
		            <li><a href="/admin/adminDesign">디자인 관리</a></li>
		          </ul>
        		</li>
      		</ul>
		</div>
	</div>
<!-- /#wrapper -->
</nav>

</body>
</html>
