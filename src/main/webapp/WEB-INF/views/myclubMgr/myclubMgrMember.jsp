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
				<form method="post" action="/myclubMgr/myclubMgrMember">
					<table class="table table-hover" text-align="center">
						<thead>
						<tr>
							<th><input type="checkbox"/></th>
							<th>E-Mail</th>
							<th>회원등급</th>
							<th>이름</th>
							<th>생년월일</th>
							<th>성별</th>
							<th>클럽가입일</th>
						</tr>
						</thead>
						<c:forEach items="${list}" var="dto">
							<tr>
								<td><input type="checkbox" name="mem_no" id="checked_member" value="${dto.mem_no}"/></td>
								<td>${dto.mem_email}</td>
								<td>
									<select name="select_grade" style="height:30px">
										<option value='1'>마스터</option>
										<option value='2'>매니저</option>
										<option value='3'>스탭</option>
										<option value='4'>일반회원</option>
									</select>
								</td>
								<td>${dto.mem_name}</td>
								<td>${dto.mem_birth}</td>
								<td>${dto.mem_gender}</td>
								<td>${dto.club_mem_regdate}</td>
							</tr>
						</c:forEach>
					</table>
				</form>
				
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
	$(document).ready(
		function(){
			var grade = "${dto.mem_grade}";
			console.log(grade);
			$("#select_grade").val(grade).attr("selected", "selected");
		}
	);

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