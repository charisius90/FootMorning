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
		<span style="float: left;"><h4>게시판 선택&nbsp;</h4></span>
		<div class="dropdown" style="float: left;">
			<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">
				OO게시판 <span class="glyphicon glyphicon-triangle-bottom"></span></button>
				<ul class="dropdown-menu" role="menu">
					<li><a href="#">OO게시판&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
					<li><a href="#">XX게시판&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
					<li><a href="#">AA게시판&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
				</ul>
		</div>
	</div>

	<h3>전체 게시글 관리</h3>
	<div class="row">
		<div class="admin">
			<div>
				<table style="width: 100%">
					<tr>
						<td>게시글 검색</td>
						<td>
							<select class="form-control">
								<option>직무</option>
								<option>이름</option>
							</select>
						<td>
						<td><input type="text" class="form-control" size="40" placeholder="제목/내용/게시회원" id=""></td>
						<td><button class="btn btn-default">검색</button></td>
						<td><button class="btn btn-default">상세검색<span class="caret"></span></button>
					</tr>
				</table>
			</div>
		</div>
		<br/>
			
			게시글 3명
			<table class="table table-bordered">
				<tr style="background-color:#dddddd;">
					<td><input type="checkbox" name="" value="" /> 회원 (아이디)</td>
					<td>글번호</td>
					<td>등록일</td>
					<td>제목</td>
					<td>내용</td>
				</tr>
				<tr>
					<td><input type="checkbox" name="" value="" /> 박수항2(soo2)</td>
					<td>1232</td>
					<td>2016.07.18</td>
					<td>바다이야기</td>
					<td>www.777.com</td>
				</tr>
				<tr>
					<td><input type="checkbox" name="" value="" /> 박수항2(soo2)</td>
					<td>1231</td>
					<td>2016.07.18</td>
					<td>뿅뿅뿅</td>
					<td>www.777.com</td>
				</tr>
				<tr>
					<td><input type="checkbox" name="" value="" /> 박수항2(soo2)</td>
					<td>1230</td>
					<td>2016.07.18</td>
					<td>빠칭코</td>
					<td>www.777.com</td>
				</tr>
			</table>
			<hr/>
			
			<table>
				<tr>
					<td>선택한 게시글을</td>
					<td>
						<button class="btn btn-default" onclick="delete()">삭제</button>
					</td>
				</tr>
			</table>
	
	</div><!-- /.row -->
</div><!-- /.container -->

<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<script src="../resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>