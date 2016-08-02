<%@ page contentType="text/html; charset=UTF-8" %>
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
			<h3>멤버탈퇴관리</h3>
			<div class="myteamheader" align="right">
					<!-- 버튼두개짜리 헤더  -->
					<%@include file="../include/myclubHeader.jsp" %>
			</div>
			<br/><br/>
			<div class="row">
				<div style="float:left">
					<form action="#">
						<div class="form-search" style="float: left;">
							<select style="width: 100px; height: 30px;" name="searchType" class="btn btn-default input-group-add" size="1">
								<option value="n" <c:out value="${clubcri.searchType == null?'selected':''}"/>>---</option>
								<option value="m" <c:out value="${clubcri.searchType eq 'm'?'selected':''}"/>>이름</option>
								<option value="i" <c:out value="${clubcri.searchType eq 'i'?'selected':''}"/>>아이디</option>
							</select>
							<input type="text" name="keyword" value='${pageMaker.clubcri.keyword}' style="height: 28px;">
							<button id="searchBtn" class="btn btn-default input-group-add" type="submit" style="heigt: 25px;padding-top: 4px;padding-bottom: 4px;">검색</button>
						</div>
					</form>
				</div>
			</div><!-- /.row -->
			<br/><br/>
			<div class="row">
				<form action="/myclubMgr/myclubMgrOutMember" method="post">
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
						<button class="btn btn-primary" type="submit">선택회원방출</button>
					</div>
				</form>
				</div><!-- /.row -->	
				<div class="row">
					<nav align="center">
					<ul id="pagingul" class="pagination">
													
							<c:if test="${pageMaker.prev}">
								<li><a 
									href="/myclubMgr/myclubMgrOutMember${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
							</c:if>
									
							<c:forEach begin="${pageMaker.startPage}" 
										end="${pageMaker.endPage}" var="idx">
								<li
									<c:out value="${pageMaker.clubcri.page == idx?'class =active':''}"/>>
									<a href="/myclubMgr/myclubMgrOutMember${pageMaker.makeSearch(idx)}">${idx}</a>
								</li>
							</c:forEach>
									
							<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
								<li><a 
									href="/myclubMgr/myclubMgrOutMember${pageMaker.makeSearch(pageMaker.endPage + 1) }">&raquo;</a></li>
							</c:if>
						</ul>
					</nav>
				</div>
			</div><!-- /.col-md-9 -->
		</div><!-- page-content-wrapper -->
		</div>
	</div><!-- /.row -->
</div><!-- /.container -->

<script>
	var data = "${data}";
	if(data != ""){
		alert(data + "명이 방출되었습니다.");
	}
	
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
	
	$('#searchBtn').on("click", function(event) {
		
		// 검색옵션 값 가져오기
		var searchType = $("select[name=searchType]").val();
		
		// 키워드 값 가져오기
		var keyword = $("input[name=keyword]").val();
		
		
		self.location = "/myclubMgr/myclubMgrOutMember${pageMaker.makeQuery(1)}&searchType="+$("select option:selected").val() + "&keyword=" + $('#keywordInput').val();
	});
</script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<script src="../resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>