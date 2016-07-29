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
				<table class="table table-hover" text-align="center">
					<thead>
					<tr>
						<th><input type="checkbox"/></th>
						<th>E-Mail</th>
						<th>이름</th>
						<th>생년월일</th>
						<th>성별</th>
						<th>가입신청일</th>
					</tr>
					</thead>
					<c:forEach items="${req}" var="dto">
						<tr>
							<td><input type="checkbox" name="no" id="checked_member" value="${dto.mem_no}"/></td>
							<td>${dto.mem_email}</td>
							<td>${dto.mem_name}</td>
							<td>${dto.mem_birth}</td>
							<td>${dto.mem_gender}</td>
							<td>${dto.club_mem_regdate}</td>
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
		if(type==1){
			var param = [];
			$('#checked_member:checked').each(function(i){ 
		        param.push($(this).val());
		        console.log(param);
			});
		    $.ajax({
		    url : '/myclubMgr/myclubMgrRegister',
		    type : 'post',
		    dataType : 'text',
		    data : {mem_no : param}
		    });
		}
		else{
	
		}
	}
	
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
</body>
</html>