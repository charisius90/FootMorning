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
					<input type="button" value="가입신청승인" onclick="fnProc(1)"/>
					<input type="button" value="가입신청거절" onclick="fnProc(0)"/>	
				</div>
			</div><!-- /.row -->
			<br/><br/>
			<div class="row">
				<form id="req_form" method="post">
					<table class="table table-hover" text-align="center">
						<thead>
						<tr>
							<th><input type="checkbox" id="checkAll"/></th>
							<th>E-Mail</th>
							<th>이름</th>
							<th>생년월일</th>
							<th>성별</th>
							<th>가입신청일</th>
						</tr>
						</thead>
						<c:forEach items="${req}" var="dto">
							<tr>
								<td><input type="checkbox" name="mem_no" id="checked_member" value="${dto.mem_no}"/></td>
								<td>${dto.mem_email}</td>
								<td>${dto.mem_name}</td>
								<td>${dto.mem_birth}</td>
								<td>${dto.mem_gender}</td>
								<td>${dto.club_mem_regdate}</td>
							</tr>
						</c:forEach>
					</table>
				</form>
					<nav align="center">
						<ul id="pagingul" class="pagination">
													
							<c:if test="${pageMaker.prev}">
								<li><a 
									href="/myclubMgr/myclubMgrRegister${pageMaker.makeQuery(pageMaker.startPage - 1) }">&laquo;</a></li>
							</c:if>
									
							<c:forEach begin="${pageMaker.startPage}" 
										end="${pageMaker.endPage}" var="idx">
								<li
									<c:out value="${pageMaker.clubcri.page == idx?'class =active':''}"/>>
									<a href="/myclubMgr/myclubMgrRegister${pageMaker.makeQuery(idx)}">${idx}</a>
								</li>
							</c:forEach>
									
							<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
								<li><a 
									href="/myclubMgr/myclubMgrRegister${pageMaker.makeQuery(pageMaker.endPage + 1) }">&raquo;</a></li>
							</c:if>
						</ul>
					</nav>
				</div><!-- /.row -->	
			</div><!-- /.col-md-9 -->
		</div><!-- page-content-wrapper -->
		</div>
	</div><!-- /.row -->
</div><!-- /.container -->

<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<script src="../resources/bootstrap/js/bootstrap.min.js"></script>
<script>
	function fnProc(type){
	    // jquery로 선택된 체크박스들의 mem_no를 모두 가져와 post방식으로 서버에 전송
	    var $form = $("#req_form");
	    if(type==1){
	       $form.attr("action", "/myclubMgr/myclubMgrRegister?type=approval");
	    }
	    else{
	       $form.attr("action", "/myclubMgr/myclubMgrRegister?type=deny");
	    }
	    $form.submit();
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
	});

</script>
</body>
</html>