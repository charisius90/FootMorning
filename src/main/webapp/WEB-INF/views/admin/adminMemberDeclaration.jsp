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
	window.open("adminMemberDeclarationNewpage.jsp","popup","width="+popWidth+"px,height="+popHeight+"px,top="+popY+",left="+popX);
}
	
</script>
</head>
<body>

<%@ include file="../include/adminheader.jsp" %>

<div class="container">
	<div class="row">
		<h3>신고 접수 관리</h3>
			
			<div class="admin">
				<div>
					<table style="width: 100%">
						<tr>
							<td>직원검색</td>
							<td>
							<select class="form-control">
								<option>회원</option>
								<option>신고사유</option>
								<option>처리여부</option>
							</select>
							<td>
							<td><input type="text" class="form-control" size="40" placeholder="회원/신고사유/처리여부" id=""></td>
							<td><button class="btn btn-default">검색</button></td>
							<td><button class="btn btn-default">상세검색<span class="caret"></span></button>
						</tr>
					</table>
				</div>
			</div>
			<br/>
				
			신고수 3명
			<form method="post" action="">
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
				<hr/>
		
				<table style="float: left;">
					<tr>
						<td>선택한직원을</td>
						<td>
							<select class="form-control">
								<option>처리중</option>
								<option>처리완료</option>
								<option>미처리</option>
							</select>
						</td>
						<td>
							(으)로 <button class="btn btn-default" type="submit">변경</button>
						</td>
					</tr>
				</table>
			</form>
			<table style="float: right;">
				<tr>
					<td>피신고자 게시글</td>
					<td>
						<button class="btn btn-default"type="button" onclick="popupLink(300,600)">조회</button>
					</td>
			</table>
				
	</div><!-- /.row -->
</div><!-- /.container -->

<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<script src="../resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>