<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link href="../../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../../resources/bootstrap/css/startbootstrap-simple-sidebar.css" rel="stylesheet">
<style>
	.caption_title{
		font-size: 15pt;
	}
	
	.caption_user{
		font-size: 10pt;
	}
	
	.caption_info{
		font-size: 10pt;
	}
</style>
</head>
<body>

<%@ include file="../../include/header.jsp" %>


<div class="container-fluid">
	<div class="row">
		<div id="wrapper">
			<div>
				<%@ include file="../../include/communitysidebar.jsp" %>
			</div>
			<div class="col-md-10">
				<div id="page-content-wrapper">
					<div class="col-md-12">
						<h1>축구 갤러리</h1>
						
						<div class="container">
							<div class="row">
					<c:forEach begin="1" end="6" step="1">
								<div class="col-sm-6 col-md-4">
									<div class="thumbnail">
										<a href="#">
											<img src="../../resources/images/koala.jpg" alt="...">
										</a>
								    	<div class="caption" align="left">
								    		<span class="caption_title"><a href="#">Thumbnail Title Here</a></span><br/>
								    		<span class="caption_user"><a href="#">Username Here</a></span><br/>
								    		<span class="caption_info">조회수 cnt / 게시일 0000.0.0</span>
								 		</div>
								    </div>
								</div>
					</c:forEach>
							</div>
						</div>
						
						<!-- 글쓰기 -->
						<div align="right" style="float: right;">
							<button class="btn btn-default" ><span class="glyphicon glyphicon-pencil"></span>글쓰기</button>
						</div>
						
						<!-- 검색하는 부분 -->
						<div class="row">
							<div class="col-lg-4" >
								<div class="input-group" align="center">
									<div class="input-group-btn">
										<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
										제목+내용<span class="caret" ></span></button>
										<ul class="dropdown-menu" role="menu">
										 <li><a href="#">제목+내용</a></li>
								         <li><a href="#">제목</a></li>
								         <li><a href="#">작성자</a></li>
										</ul>
									</div>
									<input type="text" class="form-control" />
									<span class="input-group-btn">
										<button type="button" onclick="" class="btn btn-default">검색</button>
									</span>
								</div>
							</div>
						</div>
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