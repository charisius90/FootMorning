<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link href="../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../resources/bootstrap/css/startbootstrap-simple-sidebar.css" rel="stylesheet">
<link href="../resources/bootstrap/css/custom.css" rel="stylesheet">
<script>
function popupLink(popHeight,popWidth){ 
	var winHeight = document.body.clientHeight;	// 현재창의 높이
	var winWidth = document.body.clientWidth;	// 현재창의 너비
	var winX = window.screenLeft;	// 현재창의 x좌표
	var winY = window.screenTop;	// 현재창의 y좌표

	var popX = winX + (winWidth - popWidth)/2;
	var popY = winY + (winHeight - popHeight)/2;
	window.open("adminCommunityQ&APopup.jsp","popup","width="+popWidth+"px,height="+popHeight+"px,top="+popY+",left="+popX);
}
</script>
</head>
<body>

<%@ include file="../include/adminheader.jsp" %>

<div class="container">
	<div class="row">
		<h3>Q&A 관리</h3>
		<div class="admin">
			<div>
				<table style="width: 100%">
					<tr>
						<td>질문 검색</td>
						<td>
						<select class="form-control">
							<option>항목</option>
							<option>제목</option>
							<option>처리여부</option>
						</select>
						<td>
						<td><input type="text" class="form-control" size="40" placeholder="항목/제목/처리여부" id=""></td>
						<td><button class="btn btn-default">검색</button></td>
						<td><button class="btn btn-default">상세검색<span class="caret"></span></button>
					</tr>
				</table>
			</div>
		</div>
			
			질의수 3명
			<table class="table table-bordered">
				<tr style="background-color:#dddddd;">
					<td><input type="checkbox" name="" value="" /> 질의번호</td>
					<td>항목</td>
					<td>등록일자</td>
					<td>제목</td>
					<td>처리여부</td>
				</tr>
				<tr>
					<td><input type="checkbox" name="" value="" /> 3</td>
					<td>회원</td>
					<td>2016.07.18</td>
					<td>광고</td>
					<td>미처리</td>
				</tr>
				<tr>
					<td><input type="checkbox" name="" value="" /> 2</td>
					<td>클럽</td>
					<td>2016.07.18</td>
					<td>욕설</td>
					<td>처리중</td>
				</tr>
				<tr>
					<td><input type="checkbox" name="" value="" /> 1</td>
					<td>기타</td>
					<td>2016.07.18</td>
					<td>기타</td>
					<td>처리완료</td>
				</tr>
			</table>
			
			<table style="float: left;">
				<tr>
					<td>선택한 신고</td>
					<td>
						<select class="form-control">
							<option>처리중</option>
							<option>처리완료</option>
							<option>미처리</option>
						</select>
					</td>
					<td>(으)로 <button class="btn btn-default" type="submit">변경</button> 
			</table>
			<div style="float: right;">
				피신고게시글 <button class="btn btn-default" onclick="popupLink(500, 600)">질의 보기</button>				
			</div>
						
	</div><!-- /.row -->
</div><!-- /.container -->

<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<script src="../resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>