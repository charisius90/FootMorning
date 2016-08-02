<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link href="../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../resources/bootstrap/css/startbootstrap-simple-sidebar.css" rel="stylesheet">
<link href="../resources/bootstrap/css/custom.css" rel="stylesheet">
</head>
<body>

<%@ include file="../include/adminheader.jsp" %>

<div class="container">
	<div class="row">
		<h3>전체 회원 관리</h3>
		
		<div class="admin">
			<div>
				<table style="width: 100%">
					<tr>
						<td>회원검색</td>
						<td>
						<select class="form-control">
							<option>E-Mail</option>
							<option>이름</option>
							<option>차단여부</option>
						</select>
						<td>
						<td><input type="text" class="form-control" size="40" placeholder="E-Mail/이름으로 검색가능" id=""></td>
						<td><button class="btn btn-default">검색</button></td>
						<td><button class="btn btn-default">상세검색<span class="caret"></span></button>
					</tr>
				</table>
			</div>
		</div>
			
		회원수 6명
		<form method="post" action="">
			<table class="table table-bordered">
				<tr style="background-color:#dddddd;">
					<td><input type="checkbox" name="" value="" /> E-Mail</td>
					<td>소속 클럽</td>
					<td>가입일</td>
					<td>최종방문일</td>
					<td>게시글 수</td>
					<td>댓글 수</td>
					<td>성별</td>
					<td>차단여부</td>
				</tr>
			<c:forEach items="${list}" var="dto">
				<tr>
					<td><input type="checkbox" name="" value="" />${dto.mem_email}</td>
					<td>${dto.mem_club_no}</td>
					<td>${dto.mem_regdate}</td>
					<td>${dto.mem_logdate}</td>
					<td>${}</td>
					<td>${}</td>
					<td>${dto.mem_gender}</td>
					<td>${}</td>
				</tr>
			</c:forEach>
			</table>
			<hr/>
			<table>
				<tr>
					<td>선택한 회원을&nbsp;</td>
					<td><input type="button" name="" value="차단" />&nbsp;&nbsp;</td>
					<td><input type="button" name="" value="해제" />&nbsp;&nbsp;</td>
					<td><input type="button" name="" value="삭제" />&nbsp;&nbsp;</td>
				</tr>
			</table>	
		</form>
	</div><!-- /.row -->
</div><!-- /.container -->

<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<script src="../resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>