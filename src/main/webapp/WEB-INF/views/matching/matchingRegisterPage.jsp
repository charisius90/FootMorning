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
		$("#datepicker").datepicker(
			{
				dateFormat: "yy/mm/dd",
				changeMonth: true,
				changeYear: true,
				minDate: "0",
				maxDate: "+1y",
			}		
		);
	});
	
</script>
<style>
	#register_table{height:200px;}
</style>
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
			<div class="col-md-9" align="center">
				<h3>매칭 등록하기</h3><br/>
				<div style="width:500px; border:1px solid gray; padding:30px; border-radius:10px" align="center">
					<table id="register_table">
						<tr>
							<td style="width:50px">날 짜</td><td><input type="text" id="datepicker"/></td>
						</tr>
						<tr>
							<td>시 간</td><td><input type="text" id="timepicker"/></td>
						</tr>
						<tr>
							<td>지 역</td><td><input type="text" />&nbsp;&nbsp;<input type="button" value="검색"></td>
						</tr>
						<tr>
							<td>장 소</td><td><input type="text" /></td>
						</tr>
						<tr>
							<td>실 력</td>
							<td><select name="time" style="width:170px">
								<option>★</option>
								<option>★★</option>
								<option>★★★</option>
								<option>★★★★</option>
								<option>★★★★★</option>
							</select></td>
						</tr>
					</table>
					<div style="margin-top:20px">
						<button class="btn btn-primary">등록</button>&nbsp;&nbsp;&nbsp;
						<button class="btn" data-dismiss="modal" aria-hidden="true">취소</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	</div>
<script src="../resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>