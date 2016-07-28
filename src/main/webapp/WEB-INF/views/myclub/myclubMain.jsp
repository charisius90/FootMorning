<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>
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
						<h2>${CLUB_KEY.club_name}</h2>
					</div>
					<div class="myteamheader" align="right">
						<!-- 버튼두개짜리 헤더  -->
						<%@include file="../include/myclubHeader.jsp" %>
					</div>
				</div>
				<div class="col-md-10" style="border:1px solid gray; padding:50px; border-radius:15px">
						<div class="col-md-6" id="clubMainImg" style="float:left">
							<img  src="../resources/images/real.jpg" width="100%" height="400px">
						</div>
						<div class="col-md-6">
							<table class="table">
							  <tr>
							  	<td><strong><span style="color:blue">${CLUB_KEY.club_name}</span>에 오신것을 환영합니다.</strong></td>
							  </tr>
							  <tr>
							  	<td align="right">회원수 <span style="color:red">${CLUB_KEY.club_mem_count}</span>&nbsp;&nbsp;|&nbsp;&nbsp;클럽개설일 <span style="color:red">${CLUB_KEY.club_regdate}</span></td>
							  </tr>
							  <tr>
							  	<td>
							  		<!-- 클럽소개 -->
							  		<strong>클럽소개</strong>
							  	</td>
							  </tr>
							  <tr>
							  <!-- img 들어갈곳 -->
							    <td style="vertical-align: text-top;">
							    <!-- text들어갈곳 -->
							   ${CLUB_KEY.club_content}
							    </td>
							  </tr>
							  <tr>
							  	<!-- 클럽장 텍스트 -->
							  	<td align="right"><strong>클럽장 : ${CLUB_KEY.club_master_name}</strong></td>
							  </tr>
							</table>
						</div>
				</div>
				<div class="col-md-10">
					<div class="col-md-6">
						<h4>공지사항</h4>
						<table class="table table-condensed" style="text-align: center">
							<tr>
								<td><b>번호</b></td>
								<td><b>제목</b></td>
								<td><b>작성자</b></td>
							</tr>
							<tr>
								<td>1</td>
								<td>방출자현황</td>
								<td>운영자</td>
							</tr>
							<tr>
								<td>2</td>
								<td>월말결산현황</td>
								<td>운영자</td>
							</tr>
						</table>
					</div>
					<div class="col-md-6" >
						<h4>일정</h4>
						<table class="table table-condensed" style="text-align: center" >
							<tr>
								<td><b>번호</b></td>
								<td><b>제목</b></td>
								<td><b>작성자</b></td>
							</tr>
							<tr>
								<td>1</td>
								<td>8월5일수강종료</td>
								<td>손승한</td>
							</tr>
							<tr>
								<td>2</td>
								<td>잠은 죽어서 자야지</td>
								<td>운영자</td>
							</tr>
						</table>
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
<script>
	var test = "${CLUB_KEY}";
	console.log(test);
</script>
</body>
</html>