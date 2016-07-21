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
							<option>아이디</option>
							<option>이름</option>
							<option>차단여부</option>
						</select>
						<td>
						<td><input type="text" class="form-control" size="40" placeholder="아이디/이름/직무로 검색가능" id=""></td>
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
					<td><input type="checkbox" name="" value="" /> 이름 (아이디)</td>
					<td>소속 클럽</td>
					<td>가입일</td>
					<td>최종방문일</td>
					<td>게시글 수</td>
					<td>댓글 수</td>
					<td>성별</td>
					<td>차단여부</td>
				</tr>
				<tr>
					<td><input type="checkbox" name="" value="" /> 박수항(soo1)</td>
					<td>맨유</td>
					<td>2016.07.18</td>
					<td>2016.07.18</td>
					<td>1</td>
					<td>1</td>
					<td>남</td>
					<td>차단</td>
				</tr>
				<tr>
					<td><input type="checkbox" name="" value="" /> 박수항(soo2)</td>
					<td>첼시</td>
					<td>2016.07.18</td>
					<td>2016.07.18</td>
					<td>1</td>
					<td>1</td>
					<td>남</td>
					<td>정상</td>
				</tr>
				<tr>
					<td><input type="checkbox" name="" value="" /> 박수항(soo3)</td>
					<td>아스날</td>
					<td>2016.07.18</td>
					<td>2016.07.18</td>
					<td>1</td>
					<td>1</td>
					<td>남</td>
					<td>정상</td>
				</tr>
				<tr>
					<td><input type="checkbox" name="" value="" /> 박수항(soo4)</td>
					<td>토트넘</td>
					<td>2016.07.18</td>
					<td>2016.07.18</td>
					<td>1</td>
					<td>1</td>
					<td>남</td>
					<td>정상</td>
				</tr>
				<tr>
					<td><input type="checkbox" name="" value="" /> 박수항(soo5)</td>
					<td>맨시티</td>
					<td>2016.07.18</td>
					<td>2016.07.18</td>
					<td>1</td>
					<td>1</td>
					<td>남</td>
					<td>정상</td>
				</tr>
				<tr>
					<td><input type="checkbox" name="" value="" /> 박수항(soo6)</td>
					<td>QPR</td>
					<td>2016.07.18</td>
					<td>2016.07.18</td>
					<td>1</td>
					<td>1</td>
					<td>남</td>
					<td>정상</td>
				</tr>
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