<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link href="../../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../../resources/bootstrap/css/startbootstrap-simple-sidebar.css" rel="stylesheet">
</head>
<body>

<%@ include file="../../include/headerRoot.jsp" %>

<div class="container-fluid">
	<div class="row">
		<div id="wrapper">
			<div>
				<%@ include file="../../include/communitysidebar.jsp" %>
			</div>
			<div class="col-md-10">
				<div id="page-content-wrapper">
				<h1>축구 갤러리</h1> 			
				<br/><br/>
				
				<!-- 게시글 읽는 부분 -->
				<div class="container">
					<div class="row">
						<table class="table">
							<tr>
								<td class="span1">제목 - 축구 갤러리</td>
								<td>저희 팀 사진입니다</td>
								<td class="span1">조회수</td>
								<td>99</td>
							</tr>
							<tr>
								<td>작성자</td>
								<td>박규채</td>
								<td>등록일</td>
								<td>2016-07-18</td>
							</tr>
							<tr>
								<td>내용</td>
								<td>이번에 놀러갔던 곳입니다.
								</td>
							</tr>
						</table>
					</div>
				</div>
				<hr/>
				
					<div align="right">
						<a href="#" class="btn btn-default"><span class="glyphicon glyphicon-align-justify"></span>목록</a>
						<a href="#" class="btn btn-default"><span class="glyphicon glyphicon-pencil"></span>등록</a>
						<a href="#" class="btn btn-default"><span class="glyphicon glyphicon-remove"></span>취소</a>
					</div>		
				</div>
			</div>
		</div>
	</div>
</div>

<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<script src="../../resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>