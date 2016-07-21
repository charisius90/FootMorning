<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- 부트스트랩은 모바일 우선이라서 metatag에 두항목을 추가하는데 일단은 없어도 됨 -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../resources/bootstrap/css/startbootstrap-simple-sidebar.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">

<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
</head>
<body>
	<%@ include file="../include/header.jsp"%>

	<div class="container-fluid">
		<div class="row">
			<div id="wrapper">
				<div>
					<%@ include file="../include/myteammgrsidebar.jsp"%>
				</div>
				<div id="page-content-wrapper">
					<div class="col-md-9">
						<h3>클럽양도</h3>
						<div class="row">
							<div class="col-lg-3">
								<div class="input-group">
									<input type="text" class="form-control" placeholder="Search" />
									<span class="input-group-btn">
										<button class="btn btn-default" type="button">검색</button>
									</span>
								</div>
								<!-- /input-group -->
							</div>
							
						</div>
						<!-- /.row -->
						<br/>
						<div class="row">
							<table class="table table-hover" text-align="center">
								<tr>
									<th>닉네임</th>
									<th>등급</th>
									<th>성별</th>
									<th>전화번호</th>
									<th>주소</th>
									<th>가입일</th>
								</tr>
								<tr>
									<td>woovcheko</td>
									<td>클럽장</td>
									<td>남자</td>
									<td>010-7564-xxxx</td>
									<td>경기도 광명시</td>
									<td>2016-07-18</td>
								</tr>
								<tr>
									<td>netsong7</td>
									<td>회원</td>
									<td>남자</td>
									<td>010-xxxx-xxxx</td>
									<td>의정부</td>
									<td>2016-07-18</td>
								</tr>
								<tr>
									<td>맨유</td>
									<td>클럽장</td>
									<td>남자</td>
									<td>010-1234-xxxx</td>
									<td>영국 맨체스터</td>
									<td>2013-2-12</td>
								</tr>
								<tr>
									<td>첼시</td>
									<td>클럽장</td>
									<td>남자</td>
									<td>010-4321-0000</td>
									<td>영국 런던</td>
									<td>2015-03-12</td>
								</tr>

							</table>
							<nav align="center">
								<ul class="pagination">
									<li><a href="#" aria-label="Previous"> <span
											aria-hidden="true">&laquo;</span>
									</a></li>
									<li><a href="#">1</a></li>
									<li><a href="#">2</a></li>
									<li><a href="#">3</a></li>
									<li><a href="#">4</a></li>
									<li><a href="#">5</a></li>
									<li><a href="#" aria-label="Next"> <span
											aria-hidden="true">&raquo;</span>
									</a></li>
								</ul>
							</nav>
						</div>
						<!-- /.row -->
					</div>
					<!-- /.col-md-9 -->
				</div>
				<!-- page-content-wrapper -->
			</div>
		</div>
		<!-- /.row -->
	</div>
	<!-- /.container -->


	<script src="../resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>