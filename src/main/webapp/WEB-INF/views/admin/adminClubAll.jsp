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
	<h3>전체 클럽 관리</h3>
		
		<div class="admin">
			<div>
				<table style="width: 100%">
					<tr>
						<td>전체 검색</td>
						<td>
							<select class="form-control">
								<option>클럽명</option>
								<option>클럽장</option>
								<option>아이디</option>
							</select>
						<td>
						<td><input type="text" class="form-control" size="40" placeholder="클럽명/클럽장/아이디" id=""></td>
						<td><button class="btn btn-default">검색</button></td>
						<td><button class="btn btn-default">상세검색<span class="caret"></span></button>
					</tr>
				</table>
			</div>
		</div>
			
			클럽수 <span style="color:red">${fn:length(list)}</span>개
			<table class="table table-bordered">
				<tr style="background-color:#dddddd;">
					<td><input type="checkbox" name="" value="" />&nbsp;&nbsp;클럽명</td>
					<td>클럽장</td>
					<td>연고지</td>
					<td>개설일</td>
					<td>회원수</td>
					<td>총경기 수</td>
					<td>속성</td>
				</tr>
			<c:forEach items="${list}" var="dto">
				<tr>
					<td><input type="checkbox" name="" value="" />&nbsp;&nbsp;${dto.club_name}</td>
					<td>${dto.club_master_name}</td>
					<td>2016.07.18</td>
					<td>서울</td>
					<td>10</td>
					<td>10</td>
					<td>일반클럽</td>
				</tr>
			</c:forEach>
			</table>
			
			<table>
				<tr>
					<td>선택한 클럽을</td>
					<td>
						<select class="form-control">
							<option>추천클럽</option>
							<option>일반클럽</option>
							<option>특별클럽</option>
						</select>
					</td>
					<td>(으)로 <button class="btn btn-default" type="submit">등록</button> <button class="btn btn-default" onclick="">클럽해제</button></td></tr>				
			</table>
						
	</div><!-- /.row -->
</div><!-- /.container -->

<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<script src="../resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>