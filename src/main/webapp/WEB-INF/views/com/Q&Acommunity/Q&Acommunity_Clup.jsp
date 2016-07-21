<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link href="../../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../../resources/bootstrap/css/startbootstrap-simple-sidebar.css" rel="stylesheet">
<style>
	#pagingul{
		margin-top: 0px;
		margin-bottom: 0px;
	}
</style>
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
					<h1>Q&A 게시판</h1>
					<table class="table table-boardead table-hover" style="text-align: center;">
						<tr>
							<td>클럽명</td>
							<td>제목</td>
							<td>작성일</td>
							<td>조회수</td>
						</tr>
						<!-- 게시글 내용이 들어가는 부분 -->
						<tr>
							<td>kh5조</td>
							<td><a href="#">자유로운 영혼</a></td>
							<td>2016-7-17</td>
							<td>99</td>
						</tr>
						<tr>
							<td>kh5조</td>
							<td><a href="#">여기는 바로!</a></td>
							<td>2016-7-17</td>
							<td>99</td>
						</tr>
						<tr>
							<td>kh5조</td>
							<td><a href="#">무엇이 문제일까요</a></td>
							<td>2016-7-17</td>
							<td>99</td>
						</tr>
						<tr>
							<td>kh5조</td>
							<td><a href="#">이번에 갔던 MT 사진입니다!</a></td>
							<td>2016-7-17</td>
							<td>99</td>
						</tr>
					</table>
					<br/>
					
					<div class="container-fluid">
						<div class="row">
							<form>
								<!-- 검색하는 부분 -->
								<div class="col-md-5 form-inline" style="float: left;">
									<select class="btn btn-default input-group-add">
										<option>제목, 내용</option>
										<option>제목</option>
										<option>작성자</option>
										</select>
									<input class="form-control" type="text" value="" name="" />
									<button class="btn btn-default input-group-add">검색</button>
								</div>
									
								<!-- 페이징-->
								<div class="col-md-4">
									<ul id="pagingul" class="pagination">
								    	<li><a href="#">&laquo;</a></li>
								    	<li><a href="#">1</a></li>
								    	<li><a href="#">2</a></li>
								    	<li><a href="#">3</a></li>
										<li><a href="#">4</a></li>
										<li><a href="#">5</a></li>
										<li><a href="#">&raquo;</a></li>
									</ul>
								</div>
									
								<!-- 글쓰기 -->
								<div style="float: right;">
									<button class="btn btn-default" ><span class="glyphicon glyphicon-pencil"></span>글쓰기</button>
								</div>
							
							</form>
						</div>
					</div> <!-- /container-fluid -->

				</div> <!-- /col-md-10 -->
			</div> <!-- /page-content-wrapper -->
		</div> 
	</div> <!-- /row -->
</div> <!-- /container-fluid -->
<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<script src="../../resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>