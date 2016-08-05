<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<!-- 부트스트랩은 모바일 우선이라서 metatag에 두항목을 추가하는데 일단은 없어도 됨 -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>로그인 페이지</title>
<link href="../resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="../resources/bootstrap/css/startbootstrap-simple-sidebar.css"
	rel="stylesheet">
</head>
<body bgcolor="#FAFAD2">
	<%@ include file="../include/header.jsp"%>
	
	<spring:hasBindErrors name="memberDTO" />
	<form:errors name="memberDTO" />

	<div class="container-fluid">
		<div class="row">
			<div id="wrapper">
				<div>
					<%@ include file="../include/clubsidebar.jsp"%>
				</div>
				<div id="page-content-wrapper">
					<div class="col-md-10">
						<div align="center"><h1>로그인 페이지</h1></div>
						<form action="/member/memberLoginProc2" method="post">
						<table align="center" height="40" width="430" border="0"
							style="border: solid 2px #87CEEEB; margin-top: 4%">

							<tr>
								<td><input type="text" name="mem_email"
									style="height: 40px; width: 430px; margin: 10px" placeholder="E-Mail 입력"></td>
							</tr>
							<tr>
								<td><form:errors path="memberDTO.mem_email"/></td>
							</tr>
							<tr>
								<td><input type="password" name="mem_pw"
									style="height: 40px; width: 430px; margin: 10px" placeholder="비밀번호 입력"></td>
							</tr>
							<tr>
								<td><form:errors path="memberDTO.mem_pw"/></td>
							</tr>
							<tr>
								<td><input type="submit" value="로그인"
									style="height: 40px; width: 430px; margin: 10px; font-size: 16px; border: solid 1px #808080;"></td>
							</tr>
							<tr align="center">
								<td><a style="text-decoration: none;"
									href="/member/memberSignUp">회원가입</a>&nbsp;|&nbsp;
								<a style="text-decoration: none;"
									href="/member/memberSearchPW">비밀번호 찾기</a></td>
							</tr>
							<tr>
								<td style="color: red;"><form:errors path="memberDTO"/></td>
							</tr>
						</table>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
	<script src="../resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>