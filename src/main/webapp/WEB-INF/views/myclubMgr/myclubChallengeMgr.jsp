<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<!-- 부트스트랩은 모바일 우선이라서 metatag에 두항목을 추가하는데 일단은 없어도 됨 -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../resources/bootstrap/css/startbootstrap-simple-sidebar.css" rel="stylesheet">

<script type="text/javascript">
	function yesChallenge(challenge_no, game_no, game_date, game_time, game_addr, club_ability, sender_club_no) {
		alert("함수");
		   var params={
				   "challenge_no":challenge_no,
				   "game_no":game_no, 
				   "game_date":game_date, 
				   "game_time":game_time, 
				   "game_addr":game_addr, 
				   "club_ability":club_ability,
				   "club_no":sender_club_no
		   }
			$.ajax({
				   type : "POST",
				   url : "/myclubMgr/yesChallenge",
				   cache : false,
				   data : params,
				   success : function (data) {
					   data = $.parseJSON(data);
					   alert(data);
					   if(data.result){
						   $("#challenge_flag_"+challenge_no).text("수락됨");
					   }
				   },
				   fail : function (e) {
					   alert('등록된 스케줄이 없습니다.');
				   }
				});
	}
	
	function noChallenge(challenge_no) {
		   var params={
				   "challenge_no":challenge_no,
		   }
			$.ajax({
				   type : "POST",
				   url : "/myclubMgr/noChallenge",
				   cache : false,
				   data : params,
				   success : function (data) {
					   data = $.parseJSON(data);
					   alert(data);
					   if(data.result){
						   $("#challenge_flag_"+challenge_no).text("거절됨");
					   }
				   },
				   fail : function (e) {
					   alert('등록된 스케줄이 없습니다.');
				   }
				});
	}
</script>

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
			<h3>도전장 관리</h3>
			<div class="myteamheader" align="right">
					<!-- 버튼두개짜리 헤더  -->
					<%@include file="../include/myclubHeader.jsp" %>
			</div>
			<br/><br/>
			
			<div class="row">
				<h3>보낸 도전장</h3>
				<table class="table table-hover" text-align="center">
					<thead>
					<tr>
						<th>경기 번호</th><th>날짜</th><th>시간</th>
						<th>장소</th><th>클럽명</th><th>실력</th><th>Y/N</th>
					</tr>
					</thead>
					<c:forEach items="${sendList}" var="sdto">
						<tr>
							<td>${sdto.game_no}</td>
							<td><fmt:formatDate value="${sdto.game_date}" pattern="yyyy-MM-dd"/></td>
							<td>${sdto.game_time}</td>
							<td>${sdto.game_addr}</td>
							<td>${sdto.sender_club_no}</td>
							<td><c:forEach begin="1" end="${sdto.club_ability}"><i class="glyphicon glyphicon-star"></i></c:forEach></td>
							<td id="challenge_flag_${sdto.challenge_no}">
							<c:if test="${sdto.challenge_flag == null}">요청중</c:if>
							<c:if test="${sdto.challenge_flag == 'YES'}">수락됨</c:if>
							<c:if test="${sdto.challenge_flag == 'NO'}">거절됨</c:if>
							<c:if test="${sdto.challenge_flag == 'CANCLE'}">취소됨</c:if>
							</td>
						</tr>
					</c:forEach>
				</table><br/><hr/><br/>
				
				<h3>받은 도전장</h3>
				<table class="table table-hover" text-align="center">
					<thead>
					<tr>
						<th>경기 번호</th><th>날짜</th><th>시간</th>
						<th>장소</th><th>클럽명</th><th>실력</th><th>Y/N</th>
					</tr>
					</thead>
					<c:forEach items="${reciveList}" var="rdto">
						<tr>
							<td>${rdto.game_no}</td>
							<td><fmt:formatDate value="${rdto.game_date}" pattern="yyyy-MM-dd"/></td>
							<td>${rdto.game_time}</td>
							<td>${rdto.game_addr}</td>
							<td>${rdto.sender_club_no}</td>
							<td><c:forEach begin="1" end="${rdto.club_ability}"><i class="glyphicon glyphicon-star"></i></c:forEach></td>
							<td id="challenge_flag_${rdto.challenge_no}">
							<c:if test="${rdto.challenge_flag == null}">
<%-- 								<input type="button" id="yesB_${rdto.challenge_no}" onclick="yesChallenge(${rdto.challenge_no})" value="수락"/> --%>
								<input type="button" id="yesB_${rdto.challenge_no}" onclick="yesChallenge(${rdto.challenge_no}, ${rdto.game_no}, '<fmt:formatDate value="${rdto.game_date}" pattern="yyyy-MM-dd"/>', '${rdto.game_time}', '${rdto.game_addr}', ${rdto.club_ability}, ${rdto.sender_club_no})" value="수락"/>
								<input type="button" id="noB_${rdto.challenge_no}" onclick="noChallenge(${rdto.challenge_no})" value="거절"/>
							</c:if>
							<c:if test="${rdto.challenge_flag == 'YES'}">수락됨</c:if>
							<c:if test="${rdto.challenge_flag == 'NO'}">거절됨</c:if>
							<c:if test="${rdto.challenge_flag == 'CANCLE'}">취소됨</c:if>
							</td>
						</tr>
					</c:forEach>
				</table>
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