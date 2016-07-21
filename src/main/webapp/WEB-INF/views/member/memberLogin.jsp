<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- 부트스트랩은 모바일 우선이라서 metatag에 두항목을 추가하는데 일단은 없어도 됨 -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="../resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="../resources/bootstrap/css/startbootstrap-simple-sidebar.css"
	rel="stylesheet">
</head>
<body bgcolor="#FAFAD2">
	<%@ include file="../include/header.jsp"%>

	<div class="container-fluid">
		<div class="row">
			<div id="wrapper">
				<div>
					<%@ include file="../include/clubsidebar.jsp"%>
				</div>
				<div id="page-content-wrapper">
					<div class="col-md-10">
						<table align="center" height="90">
							<tr>
								<td><h1>로그인페이지</h1></td>
							</tr>
						</table>
						<table align="center" height="40" width="430" border="0"
							style="border: solid 2px #87CEEEB; margin-top: 4%">

							<tr>
								<td><input type="text" name="id" value=""
									style="height: 40px; width: 430px;" placeholder="아이디 입력"></td>
							</tr>
						</table>

						<table align="center" height="40" width="430" border="0"
							style="border: solid 2px #87CEEEB; margin-top: 1%">

							<tr>
								<td><input type="password" name="pw" value=""
									style="height: 40px; width: 430px" placeholder="비밀번호 입력"></td>
							</tr>

						</table>
						<table align="center" height="40" style="margin-top: 1%">
							<tr>
								<td><input type="button" name="login" value="로그인"
									style="height: 50px; width: 430px; background-color: border: solid 2px #808080; margin-top: 4%; color: black; font-size: 16px; border: solid 1px #808080;"></td>
							</tr>

						</table>
						<table align="center" height="0" width="440" border="1"
							style="border: solid 1px #050099; margin-top: 2%">
						</table>

						<table align="center" height="50" style="margin-top: 1%"
							class="mo">
							<tr>
								<td><a style="text-decoration: none;"
									href="http://localhost:8080/app/member/signUp.jsp">회원가입 | </td>
								<td><a style="text-decoration: none;"
									href="http://localhost:8080/app/member/searchID.jsp">아이디 찾기 | </td>
								<td><a style="text-decoration: none;"
									href="http://localhost:8080/app/member/searchPsw.jsp">비밀번호 찾기</td>
							</tr>

						</table>
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