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
					<%@ include file="../include/myclubMgrSidebar.jsp"%>
				</div>
				<div id="page-content-wrapper">
					<div class="col-md-9">
						<h3>클럽양도</h3>
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
			</div><!-- /.row -->
			<br/><br/>
			<div class="row">
				<form action="/myclubMgr/myclubMgrTransfer" method="post">
					<table class="table table-hover" text-align="center">
						<thead>
						<tr>
							<th><input id="checkAll" type="checkbox"/></th>
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
								<td><input type="checkbox" name="mem_no" id="checked_member_${dto.mem_no}" value="${dto.mem_no}"/></td>
								<td>${dto.mem_email}</td>
								<td>
									<!-- 1:마스터 / 2:매니저 / 3:스탭 / 4:일반 -->
									<c:if test="${dto.mem_grade==1}">마스터</c:if>
									<c:if test="${dto.mem_grade==2}">매니저</c:if>
									<c:if test="${dto.mem_grade==3}">스탭</c:if>
									<c:if test="${dto.mem_grade==4}">일반</c:if>
								</td>
								<td>${dto.mem_name}</td>
								<td>${dto.mem_birth}</td>
								<td>${dto.mem_gender}</td>
								<td>${dto.club_mem_regdate}</td>
							</tr>
						</c:forEach>
					</table>
					
					<div style="float:right">
						<button class="btn btn-primary" type="submit">클럽양도</button>
					</div>
				</form>
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
		// 전체선택에 체크한 경우 변환
		$("#checkAll").click(function(){
			var check = $(this).prop("checked");
			if(check){
				$("input:checkbox").each(function(i, e){
					$(e).prop("checked", true);
				})
			}
			else{
				$("input:checkbox").each(function(i, e){
					$(e).prop("checked", false);
				})
			}
		});
	});

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