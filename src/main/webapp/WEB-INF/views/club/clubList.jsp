<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- 부트스트랩은 모바일 우선이라서 metatag에 두항목을 추가하는데 일단은 없어도 됨 -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../resources/bootstrap/css/startbootstrap-simple-sidebar.css" rel="stylesheet">
<style>
	.logo{
		width: 80px;
		height: 80px;
	}
</style>
</head>
<body>
<%@ include file="../include/header.jsp" %>

<div class="container-fluid">
	<div class="row">
		<div id="wrapper">
			<div>
				<%@ include file="../include/clubsidebar.jsp" %>
			</div>
			<div id="page-content-wrapper">
				<div class="col-md-9">
					<h3>클럽</h3>
					<div class="row">
						<div class="col-lg-3">
							<div class="input-group">
								<input type="text" class="form-control" placeholder="Search"/>
								<span class="input-group-btn">
			        				<button class="btn btn-default" type="button">검색</button>
			     				</span>
							</div><!-- /input-group -->
							
							<input type="radio" name="sort" value="name" checked="checked">&nbsp;&nbsp;클럽명으로 검색&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="sort" value="local">&nbsp;&nbsp;지역으로 검색&nbsp;&nbsp;&nbsp;&nbsp;
						</div><!-- /.col-lg-4 -->
						<br/><br/><br/><br/>
					</div><!-- /.row -->
				
					<div class="row">
						<div class="col-md-12">
							<table class="table table-hover" text-align="center">
								<thead>
								<tr>
									<th>NO</th><th>로고</th><th>클럽명</th><th>지역</th><th>클럽소개</th>
								</tr>
								</thead>
								<c:forEach items="${list}" var="club">
									<tr id="row_${club.club_no}">
										<td>${club.club_no}</td>
										<td>
											<a href="/myclub/myclubMain?no=${club.club_no}"><img class="logo" src="${club.club_image}" alt="logo위치"/></a>
										</td>
										<td>${club.club_name}</td>
										<td>${club.club_loc}</td>
										<td>${club.club_content}</td>
									</tr>
								</c:forEach>
							</table>
							
							<nav align="center">
								<ul class="pagination">
									<li><a href="#" aria-label="Previous">
										<span aria-hidden="true">&laquo;</span>
									</a></li>
									<li><a href="#">1</a></li>
									<li><a href="#">2</a></li>
									<li><a href="#">3</a></li>
									<li><a href="#">4</a></li>
									<li><a href="#">5</a></li>
									<li><a href="#" aria-label="Next">
										<span aria-hidden="true">&raquo;</span>
									</a></li>
								</ul>
							</nav>
						</div>
					</div><!-- /.row -->	
				</div><!-- /.col-md-9 -->
			</div><!-- page-content-wrapper -->
		</div>
	</div><!-- /.row -->
</div><!-- /.container -->
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="../resources/bootstrap/js/bootstrap.min.js"></script>
<script>
// 	$(function(){
// 		$("#datepicker").datepicker(
// 			{
// 				dateFormat: "yymmdd",
// 				changeMonth: true,
// 				changeYear: true,
// 				minDate: "0",
// 				maxDate: "+1y",
// 			}		
// 		);
// 	});
	
</script>
</body>
</html>