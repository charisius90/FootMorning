<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<!-- 부트스트랩은 모바일 우선이라서 metatag에 두항목을 추가하는데 일단은 없어도 됨 -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="../resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="../resources/bootstrap/css/startbootstrap-simple-sidebar.css"
	rel="stylesheet">
</head>
<body>
	<%@ include file="../include/header.jsp"%>

	<div class="container-fluid">
		<div class="row">
			<div id="wrapper">
				<div>
					<%@ include file="../include/myPagesidebar.jsp"%>
				</div>
				<div id="page-content-wrapper">
					<div class="col-md-12">
						<div class="row">
							<div align="right"></div>
							<table class="table table-hover" text-align="center">

								<thead>
									<tr>
										<td><strong>게시판</strong></td>
										<td><strong>제목</strong></td>
										<td><strong>작성날짜</strong></td>
									</tr>
								</thead>

								<tr>
									<td>글작성한 게시판</td>
									<td>작성한 글 제목</td>
									<td>글 작성한 날짜</td>
								</tr>
								<tr>
									<td>글작성한 게시판</td>
									<td>작성한 글 제목</td>
									<td>글 작성한 날짜</td>
								</tr>
								<tr>
									<td>글작성한 게시판</td>
									<td>작성한 글 제목</td>
									<td>글 작성한 날짜</td>
								</tr>
							</table>
							<nav align="center">
							</nav>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
		<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
		<script src="../resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>