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
<jsp:useBean id="now" class="java.util.Date" />
<fmt:formatDate value="${now}" pattern="yyyy-MM-dd" var="today" /> 
<script type="text/javascript">
	function cancleGame(game_no) {
		alert("함수");
		   var params={
				   "game_no":game_no
		   }
			$.ajax({
				   type : "POST",
				   url : "/myclub/myclubCancleGame",
				   cache : false,
				   data : params,
				   success : function (data) {
					   data = $.parseJSON(data);
					   alert(data);
					   if(data.result){
						   $("#schedule_"+game_no+"_1").text("");
						   $("#schedule_"+game_no+"_2").text("");
						   $("#schedule_"+game_no+"_3").text("");
						   $("#schedule_"+game_no+"_4").text("취소됨");
					   }
				   },
				   fail : function (e) {
					   alert('등록된 스케줄이 없습니다.');
				   }
				});
	}
	
	   function editGame(game_no) {
		      alert("editcalled...");
		         var params={
		               "game_no":game_no,
		               "game_date":("#game_date_"+game_no),
		               "game_time":("#game_time_"+game_no),
		               "game_addr":("#game_addr_"+game_no),
		               "club_ability":("#club_ability_"+game_no)
		               
		         }
		         $.ajax({
		               type : "POST",
		               url : "/myclub/myclubEditGame",
		               cache : false,
		               data : params,
		               success : function (data) {
		                  data = $.parseJSON(data);
		                  alert(data);
		                  if(data.result){
		                     alert(result);
//		                      $("#edit"+game_no+"_1").text("");
//		                      $("#edit_"+game_no+"_2").text("");
//		                      $("#edit_"+game_no+"_3").text("");
//		                      $("#edit_"+game_no+"_4").text("");
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
			<h3>경기 일정 및 결과</h3>
			<div class="myteamheader" align="right">
					<!-- 버튼두개짜리 헤더  -->
					<%@include file="../include/myclubHeader.jsp" %>
			</div>
			<br/><br/>
			
			<div class="row">
			<h5>경기준비가 가능한 일정</h5>
				<c:out value="today : ${today}"/>
				<table class="table table-hover" text-align="center">
					<thead style="background-color: #e6e6e6">
					<tr>
						<th>경기 번호</th><th>날짜</th><th>시간</th><th>장소</th>
						<th>HOME실력</th><th>HOME</th><th>vs</th><th>AWAY</th><th>AWAY실력</th>
						<th>관리</th><th>비고</th>
					</tr>
					</thead>
					<%int i = 0; %>
					<c:forEach items="${list}" var="matchDto" step="2">
						<tr>
							<fmt:formatDate value="${matchDto.game_date}" pattern="yyyy-MM-dd" var="gameday"/>
							<td>${matchDto.game_no}</td>
							<td>${gameday}</td>
							<td>${matchDto.game_time}</td>
							<td>${matchDto.game_addr}</td>
							<td id="schedule_${matchDto.game_no}_1"><c:forEach begin="1" end="${matchDto.club_ability}"><i class="glyphicon glyphicon-star"></i></c:forEach></td>
							<td>${matchDto.club_no}</td>
							<td>0:0</td>
							<%i++;%>
							<c:set var="index" value="<%=i%>"></c:set>
							<td>${list[index].club_no}</td>
							<td id="schedule_${matchDto.game_no}_2"><c:forEach begin="1" end="${list[index].club_ability}"><i class="glyphicon glyphicon-star"></i></c:forEach></td>
							<td id="schedule_${matchDto.game_no}_3">
								<c:if test="${matchDto.club_ability==0}"></c:if>
								<c:if test="${matchDto.club_ability!=0}">
									<c:if test="${today<=gameday}">
										<c:if test="${matchDto.club_no==USER_KEY.club_no}"><a class="btn btn-default" href="/myclub/myclubGamePrepare?game_no=${matchDto.game_no}&game_flag=HOME">경기준비</a></c:if>
										<c:if test="${list[index].club_no==USER_KEY.club_no}"><a class="btn btn-default" href="/myclub/myclubGamePrepare?game_no=${list[index].game_no}&game_flag=AWAY">경기준비</a></c:if>
									</c:if>
									<c:if test="${today>gameday}"><a class="btn btn-default" href="">경기결과</a></c:if>
								</c:if>
							<%i++;%>
							</td>
							<td id="schedule_${matchDto.game_no}_4">
								<c:if test="${matchDto.club_ability==0}"><font color="red">취소됨</font></c:if>
								<c:if test="${matchDto.club_ability!=0}"><button class="btn btn-default" type="button" onclick="cancleGame(${matchDto.game_no})">경기취소</button></c:if>
							</td>
						</tr>
					</c:forEach>
				</table>
				<h5>경기준비가 필요한 일정</h5>   
            <table class="table table-hover" text-align="center">
               <thead style="background-color: #e6e6e6">
               <tr>
                  <th>경기 번호</th><th>날짜</th><th>시간</th><th>장소</th>
                  <th>HOME실력</th><th>HOME</th><th>vs</th><th>AWAY</th><th>AWAY실력</th>
                  <th>관리</th><th>비고</th>
               </tr>
               </thead>
               <%int j = 0; %>
               <c:forEach items="${nullList}" var="matchDto" step="2">
                  <tr>
                     <fmt:formatDate value="${matchDto.game_date}" pattern="yyyy-MM-dd" var="gameday"/>
                     <td>${matchDto.game_no}</td>
                     <td><input id="game_date_${matchDto.game_no}" style="width:120px" class="form-control" type="text" name="game_date"/></td>
                     <td><input id="game_time_${matchDto.game_no}" style="width:80px" class="form-control" type="text" name="game_time"/></td>
                     <td><input id="game_addr_${matchDto.game_no}" style="width:80px" class="form-control" type="text" name="game_addr"/></td>
                     <td>
                        <select class="form-control" id="club_ability_${matchDto.game_no}" name="club_ability" style="width:120px">
                            <option value="1">★</option>
                            <option value="2">★★</option>
                            <option value="3">★★★</option>
                            <option value="4">★★★★</option>
                            <option value="5">★★★★★</option>
                              </select>
                           </td>
                     <td>${matchDto.club_no}</td>
                     <td>0:0</td>
                     <%j++;%>
                     <c:set var="index" value="<%=j%>"></c:set>
                     <td>${nullList[index].club_no}</td>
                     <td><c:forEach begin="1" end="${nullList[index].club_ability}"><i class="glyphicon glyphicon-star"></i></c:forEach></td>
                     <%j++;%>
                     <td>
                        <c:if test="${matchDto.club_ability==0}"><input type="button" value="수정" onclick="editGame(${matchDto.club_no})" /></c:if>
                     </td>
                     <td>
                        <c:if test="${matchDto.club_ability==0}"></c:if>
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