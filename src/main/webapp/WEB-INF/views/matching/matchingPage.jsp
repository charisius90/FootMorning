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
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script>
	$(function(){
		$("#datepicker, #datepicker2").datepicker(
			{
				dateFormat: "yyyy/mm/dd",
				changeMonth: true,
				changeYear: true,
				minDate: "0",
				maxDate: "+1y",
			}		
		);
	});
	
	function mach_regi(){
		location.href="matchingRegisterPage.jsp";
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
				<div align="right"><input type="button" value="매칭등록" onclick="mach_regi()"/></div>
				<table class="table table-hover" text-align="center">
					<thead>
					<tr>
						<th>NO</th><th>날짜</th><th>시간</th><th>지역</th>
						<th>장소</th><th>클럽명</th><th>실력</th><th>도전장</th>
						
					</tr>
					</thead>
					<tr>
						<td>1</td><td>7/14</td><td>12:00</td><td>서울</td>
						<td>경기장1</td><td>맨유</td><td>★★</td><td><input type="button" value="보내기" data-toggle="modal" data-target="#send_chellenge_modal"/></td>
					</tr>
					<tr>
						<td>2</td><td>7/14</td><td>13:00</td><td>부산</td>
						<td>경기장2</td><td>첼시</td><td>★★★★</td><td><input type="button" value="보내기" data-toggle="modal" data-target="#send_chellenge_modal"/></td>
					</tr>
					<tr>
						<td>3</td><td>7/15</td><td>15:00</td><td>광주</td>
						<td>미정</td><td>아스날</td><td>★</td><td><input type="button" value="보내기" data-toggle="modal" data-target="#send_chellenge_modal"/></td>
					</tr>
					<tr>
						<td>4</td><td>7/18</td><td>16:00</td><td>서울</td>
						<td>경기장3</td><td>리버풀</td><td>★★★</td><td><input type="button" value="보내기" data-toggle="modal" data-target="#send_chellenge_modal"/></td>
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
				<div class="modal-body" align="center">
					<div>
						날짜&nbsp;<input type="text" id="datepicker2"/><br/><br/>
						시간&nbsp;<select name="time" style="width:170px">
							<option></option>
							<option></option>
						</select><br/><br/>
						클럽명&nbsp;<input type="text" /><br/><br/>
						장소&nbsp;<input type="text" /><br/><br/>
						실력&nbsp;<select name="time" style="width:170px">
							<option></option>
							<option></option>
						</select>
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn btn-primary">보내기</button>
					<button class="btn" data-dismiss="modal" aria-hidden="true">취소</button>
				</div>
			</div>
		</div>
	</div>
<script src="../resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>