<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- 부트스트랩은 모바일 우선이라서 metatag에 두항목을 추가하는데 일단은 없어도 됨 -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../resources/bootstrap/css/startbootstrap-simple-sidebar.css" rel="stylesheet">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script>
// 	$(function(){
// 		$("#datepicker, #datepicker2").datepicker(
// 			{
// 				dateFormat: "yyyy/mm/dd",
// 				changeMonth: true,
// 				changeYear: true,
// 				minDate: "0",
// 				maxDate: "+1y",
// 			}		
// 		);
// 	});
	function fnModal(game_no ,game_date , game_time , game_addr , club_name, club_no){
		
// 		alert("date?"+game_date);
// 		alert("time?"+game_time);
// 		alert("addr?"+game_addr);
// 		alert("gameNo?"+club_name+","+game_no);
		
		//open modal
		$('#send_chellenge_modal').modal('show');
		
		$("#game_no").val(game_no);
		$("#challengeDate").text(game_date);
		$("#challengeTime").text(game_time);
		$("#challengeAddr").text(game_addr);
		//추후에 
		$("#receiver_club_name").val(club_name);
		$("#receiver_club_no").val(club_no);
		
		
	}
</script>
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
			<h3>매칭</h3>
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
					<button type="button" data-toggle="modal" data-target="#detail_search_modal">상세검색</button>
					<br/><br/><br/><br/>
			</div><!-- /.row -->
			<div class="row">
				<div align="right"><a class="btn btn-default" href="/matching/register" type="button">매칭등록</a></div>
				<table class="table table-hover" text-align="center">
					<thead>
						<tr>
							<th>NO</th><th>날짜</th><th>시간</th><th>지역</th>
							<th>클럽명</th><th>클럽장</th><th>실력</th><th>도전장</th>
							
						</tr>
					</thead>
					
					
					
					<c:forEach items="${list}" var="dto">
						<tr>
							<td>${dto.game_no}</td>
							<td><fmt:formatDate value="${dto.game_date}" pattern="yyyy-MM-dd"/></td>
							<td>${dto.game_time}</td>
							<td>${dto.game_addr}</td>
							<td>${dto.club_name}</td>
							<td>${dto.club_master_name}</td>
							<td><c:forEach begin="1" end="${dto.club_ability}"><i class="glyphicon glyphicon-star"></i></c:forEach></td>
							<td><input type="button" value="보내기" onclick="fnModal(${dto.game_no},'${dto.game_date}','${dto.game_time}','${dto.game_addr}','${dto.club_name}',${dto.club_no})"/></td>
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

	<!-- 상세검색 모달창 -->
	<div id="detail_search_modal" class="modal fade" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h3 id="myModalLabel">상세검색</h3>
				</div>
				<div class="modal-body" align="center">
					<div>
						날짜&nbsp;<input type="text" id="datepicker"/><br/><br/>
						시간&nbsp;<select name="time" style="width:170px">
							<option></option>
							<option></option>
						</select><br/><br/>
						지역&nbsp;<input type="text" /><br/><br/>
						실력&nbsp;<select name="time" style="width:170px">
							<option></option>
							<option></option>
						</select>
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn btn-primary">조회</button>
					<button class="btn" data-dismiss="modal" aria-hidden="true">취소</button>
				</div>
			</div>
		</div>
	</div>
	
	
	
	
	
	
	
	<!-- 도전장보내기 모달창 -->
	<div id="send_chellenge_modal" class="modal fade" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h3 id="myModalLabel">도전장 보내기</h3>
				</div>
				<form method="post" action="/challenge/register">
				
				
					<input type="hidden" name="game_no" id="game_no"/>
					<input type="hidden" name="receiver_club_no" id="receiver_club_no"/>
					<input type="hidden" name="sender_club_no" id="sender_club_no" value="${USER_KEY.club_no}"/>
					<input type="hidden" name="game_flag" id="game_flag" value="AWAY"/>
					
					
					<div class="modal-body" align="center">
						<div>
							날짜&nbsp;<div id="challengeDate"></div><br/><br/>
							시간&nbsp;<div id="challengeTime"></div><br/><br/>
							지역&nbsp;<div id="challengeAddr"></div><br/><br/>
							HOME팀&nbsp;<input type="text" id="receiver_club_name"/><br/><br/>
							AWAY팀&nbsp;<input type="text" id="sender_club_name" value="${USER_KEY.club_no}"/><br/><br/>
							실력&nbsp;<select name="club_ability" style="width:170px">
										<option value="1">★</option>
										<option value="2">★★</option>
										<option value="3">★★★</option>
										<option value="4">★★★★</option>
										<option value="5">★★★★★</option>
							</select><br/><br/>
							<textarea name="challenge_content" rows="10" cols="20" style="width: 170px" placeholder="한마디"></textarea>
						</div>
					</div>
					<div class="modal-footer">
						<button class="btn btn-primary" type="submit">보내기</button>
						<button class="btn" data-dismiss="modal" aria-hidden="true">취소</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<script>
    
    var result = '${msg}';
    
    if(result == 'SUCCESS'){
    	alert("처리가 완료되었습니다.");
    }
    
    </script>
	
	
<script src="../resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>