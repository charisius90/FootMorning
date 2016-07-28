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
				<%@ include file="../include/myclubMgrSidebar.jsp" %>
			</div>
		<div id="page-content-wrapper">
			<div class="col-md-9">
			<h3>가입신청관리</h3>
			<div class="myteamheader" align="right">
					<!-- 버튼두개짜리 헤더  -->
					<%@include file="../include/myclubHeader.jsp" %>
			</div>
			<br/><br/>
			<div class="row">
				<div style="float:right">
					<input type="button" value="가입신청승인"/>
					<input type="button" value="가입신청거절"/>	
				</div>
			</div><!-- /.row -->
			<br/><br/>
			<div class="row">
				<table class="table table-hover" text-align="center">
					<thead>
					<tr>
						<th><input type="checkbox"/></th><th>E-Mail</th><th>이름</th>
						<th>생년월일</th><th>가입신청일</th>
					</tr>
					</thead>
					<tr>
						<td><input type="checkbox"/></td><td>ksy4035@hanmail.net</td><td>김소영</td>
						<td>84/01/27</td><td>16/07/01</td>
					</tr>
					<tr>
						<td><input type="checkbox"/></td><td>abc@naver.com</td><td>박규채</td>
						<td>89/07/21</td><td>16/07/02</td>
					</tr>
					<tr>
						<td><input type="checkbox"/></td><td>acssh@naver.com</td><td>손승한</td>
						<td>89/07/21</td><td>16/07/03</td>
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