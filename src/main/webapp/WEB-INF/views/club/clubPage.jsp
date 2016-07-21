<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- 부트스트랩은 모바일 우선이라서 metatag에 두항목을 추가하는데 일단은 없어도 됨 -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../resources/bootstrap/css/startbootstrap-simple-sidebar.css" rel="stylesheet">

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
				</div><!-- /.col-lg-4 -->
					<input type="radio" name="teamName">&nbsp;&nbsp;클럽명으로 검색&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="teamLocal">&nbsp;&nbsp;지역으로 검색&nbsp;&nbsp;&nbsp;&nbsp;
					<br/><br/><br/><br/>
			</div><!-- /.row -->
			
			<div class="row">
				<table class="table table-hover" text-align="center">
					<thead>
					<tr>
						<th>NO</th><th>로고</th><th>클럽명</th><th>지역</th><th>클럽소개</th>
					</tr>
					</thead>
					<tr>
						<td>1</td><td>로고</td><td>맨유</td><td>서울</td><td>맨유가 오라면 와야지</td>
					</tr>
					<tr>
						<td>2</td><td>로고</td><td>첼시</td><td>부산</td><td>맨더빅아</td>
					</tr>
					<tr>
						<td>3</td><td>로고</td><td>아스날</td><td>광주</td><td>리빅아</td>
					</tr>
					<tr>
						<td>4</td><td>로고</td><td>리버풀</td><td>서울</td><td>4스날</td>
					</tr>
					
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
				</div><!-- /.row -->	
			</div><!-- /.col-md-9 -->
		</div><!-- page-content-wrapper -->
		</div>
	</div><!-- /.row -->
</div><!-- /.container -->

<script>
	$(function(){
		$("#datepicker").datepicker(
			{
				dateFormat: "yymmdd",
				changeMonth: true,
				changeYear: true,
				minDate: "0",
				maxDate: "+1y",
			}		
		);
	});

</script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<script src="../resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>