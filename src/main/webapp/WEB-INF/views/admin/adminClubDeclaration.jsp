<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link href="../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../resources/bootstrap/css/startbootstrap-simple-sidebar.css" rel="stylesheet">
<link href="../resources/bootstrap/css/custom.css" rel="stylesheet">
<script>
function popupLink(){ 
	window.open("adminClubDeclarationPopup.jsp","popup");
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
						<td>신고 검색</td>
						<td>
							<select class="form-control">
								<option>클럽</option>
								<option>신고사유</option>
								<option>처리여부</option>
							</select>
						</td>
							<td><input type="text" class="form-control" size="40" placeholder="아이디/이름/직무로 검색가능" id=""></td>
							<td><button class="btn btn-default">검색</button></td>
						</tr>
					</table>
				</div>
			</div>

			
			신고수 3명
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
				</tr>
			</table>
			<div align="right" style="float: right;">
				피신고클럽 <button class="btn btn-default" onclick="popupLink()">페이지 보기</button>
			</div>
						
	</div><!-- /.row -->
</div><!-- /.container -->

<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<script src="../resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>