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
			<h3>클럽멤버관리</h3>
			<div class="myteamheader" align="right">
					<!-- 버튼두개짜리 헤더  -->
					<%@include file="../include/myclubHeader.jsp" %>
			</div>
			<br/><br/>
			<div class="row">
				<div style="float:left">
					<select name="searchSelectBox" style="height:30px">
						<option value='mem_name' selected>이름</option>
						<option value='mem_id'>아이디</option>
					</select>
				</div>
				<div class="col-lg-3">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="Search"/>
						<span class="input-group-btn">
	        				<button class="btn btn-default" type="button">검색</button>
	     				</span>
					</div><!-- /input-group -->
				</div><!-- /.col-lg-4 -->
				<div style="float:right">
					<input type="button" value="멤버등업처리"/>
				</div>
			</div><!-- /.row -->
			<br/><br/>
			<div class="row">
				<table class="table table-hover" text-align="center">
					<thead>
					<tr>
						<th><input type="checkbox"/></th><th>닉네임</th><th>등급</th><th>성별</th>
						<th>전화번호</th><th>주소</th><th>가입일</th>
					</tr>
					</thead>
					<tr>
						<td><input type="checkbox"/></th><th>ksy4035</td><td>클럽장</td><td>여자</td>
						<td>010-7799-7470</td><td>서울 노원구 중계동</td><td>2016-07-01</td>
					</tr>
					<tr>
						<td><input type="checkbox"/></th><th>비실이이</td><td>운영자</td><td>남자</td>
						<td>010-1234-5678</td><td>서울 광진구 자양동</td><td>2016-07-02</td>
					</tr>
					<tr>
						<td><input type="checkbox"/></th><th>손니에스타</td><td>운영자</td><td>남자</td>
						<td>010-1357-2468</td><td>서울 구로구 구로동</td><td>2016-07-03</td>
					</tr>
				</table>
				
				<div style="float:right">
					<button class="btn btn-primary">수정</button>
				</div>
				</div><!-- /.row -->	
				<div class="row">
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