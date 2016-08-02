<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link href="../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../resources/bootstrap/css/startbootstrap-simple-sidebar.css" rel="stylesheet">
</head>
<body>
<div class="container">
	<div class="row">
		
		<div class="admin">
			<div>
				<table>
					<tr>
						<td>게시글 검색</td>
						<td>
							<select class="form-control">
								<option>게시글/댓글</option>
								<option>게시글</option>
								<option>댓글</option>
							</select>
						</td>
						<td>3개</td>
					</tr>
				</table>
			</div>
		</div>
		<br/>
		
		<table class="table table-bordered">
			<tr style="background-color:#dddddd;">
				<td><input type="checkbox" name="" value="" /> 신고번호</td>
				<td>피신고자(아이디)</td>
				<td>신고일</td>
				<td>신고사유</td>
				<td>처리여부</td>
			</tr>
			<tr>
				<td><input type="checkbox" name="" value="" /> 3</td>
				<td>박수항(soo2)</td>
				<td>2016.07.18</td>
				<td>광고</td>
				<td>미처리</td>
			</tr>
			<tr>
				<td><input type="checkbox" name="" value="" /> 2</td>
				<td>박수항(soo2)</td>
				<td>2016.07.18</td>
				<td>욕설</td>
				<td>처리중</td>
			</tr>
			<tr>
				<td><input type="checkbox" name="" value="" /> 1</td>
				<td>박수항(soo2)</td>
				<td>2016.07.18</td>
				<td>기타</td>
				<td>처리완료</td>
			</tr>
		</table>
		<div style="border: 1px solid #dddddd">
			<table>
				<tr>
					<td>선택한 게시글을 <button class="btn btn-default" type="button">삭제</button></td>
				</tr>
			</table>		
		</div>
	</div><!-- /.row -->
</div><!-- /.container -->

<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<script src="../resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>