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
				<%@ include file="../include/myclubSidebar.jsp" %>
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
						<%@include file="../include/myclubHeader.jsp" %>
					</div>
				</div>
				<div class="col-md-10">
					<form action="" method="post">
						<table class="table table-bordered table-hover">
							<!-- 수정 list -->
							<tr style="text-align: center;font-weight:bold;">
								<td>번호</td>
								<td>이름</td>
								<td>경기수</td>
								<td>골</td>
								<td>어시스트</td>
								<td>경고</td>
								<td>퇴장</td>
							</tr>
							<tr style="text-algin:center">
								<td>1</td>
								<td>홍길동</td>
								<td><input type="text" class="form-control" size="2" id="usergoal" value="15"></td>
								<td><input type="text" class="form-control" size="2" id="userassist" value="3"></td>
								<td><input type="text" class="form-control" size="2" id="useryellowcard" value="7"></td>
								<td><input type="text" class="form-control" size="2" id="username" value="6"></td>
								<td><input type="text" class="form-control" size="2" id="userredcard" value="1"></td>
							</tr>
						</table>
						<div align="right">
							<button class="btn btn-default" type="submit">등록</button>
						</div>
					</form>
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