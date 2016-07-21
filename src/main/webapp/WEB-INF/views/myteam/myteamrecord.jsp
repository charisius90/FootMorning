<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- 부트스트랩은 모바일 우선이라서 metatag에 두항목을 추가하는데 일단은 없어도 됨 -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../resources/bootstrap/css/startbootstrap-simple-sidebar.css" rel="stylesheet">
<link href="../resources/bootstrap/css/custom.css" rel="stylesheet">
</head>
<body>
<%@ include file="../include/header.jsp" %>

<div class="container-fluid">
	<div class="row">
		<div id="wrapper">
			<div>
				<%@ include file="../include/myteamsidebar.jsp" %>
			</div>
			<div id="page-content-wrapper">
				<div class="col-md-10">
					<!-- 메인폼  -->
					<div align="left">
						<!-- 팀 타이틀이 들어갈 장소 -->
						<h2>기록실</h2>
					</div>
					<div class="myteamheader" align="right">
						<!-- 버튼두개짜리 헤더  -->
						<%@include file="../include/myteamheader.jsp" %>
					</div>
				</div>
				<div class="col-md-10">
					<table class="table table-bordered table-hover">
						<!-- 기록 list td형식 -->
						<tr>
							<td>번호</td>
							<td>이름</td>
							<td>경기수</td>
							<td>골</td>
							<td>어시스트</td>
							<td>경고</td>
							<td>퇴장</td>
						</tr>
						<tr>
							<td>1</td>
							<td>홍길동</td>
							<td>15</td>
							<td>3</td>
							<td>7</td>
							<td>6</td>
							<td>1</td>
						</tr>
						<tr>
							<td>1</td>
							<td>홍길동</td>
							<td>15</td>
							<td>3</td>
							<td>7</td>
							<td>6</td>
							<td>1</td>
						</tr>
						<tr>
							<td>1</td>
							<td>홍길동</td>
							<td>15</td>
							<td>3</td>
							<td>7</td>
							<td>6</td>
							<td>1</td>
						</tr>
						<tr>
							<td>1</td>
							<td>홍길동</td>
							<td>15</td>
							<td>3</td>
							<td>7</td>
							<td>6</td>
							<td>1</td>
						</tr>
						<tr>
							<td>1</td>
							<td>홍길동</td>
							<td>15</td>
							<td>3</td>
							<td>7</td>
							<td>6</td>
							<td>1</td>
						</tr>
						<tr>
							<td>1</td>
							<td>홍길동</td>
							<td>15</td>
							<td>3</td>
							<td>7</td>
							<td>6</td>
							<td>1</td>
						</tr>
					</table>
					<div align="right">
						<a class="btn btn-default" role="button" href="myteamrecordMgr.jsp">관리</a>
					</div>
				</div>
			</div>	
		</div>
	</div>
</div>
<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<script src="../resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>