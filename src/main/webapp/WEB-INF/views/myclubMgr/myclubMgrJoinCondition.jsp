<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- 부트스트랩은 모바일 우선이라서 metatag에 두항목을 추가하는데 일단은 없어도 됨 -->
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../resources/bootstrap/css/startbootstrap-simple-sidebar.css" rel="stylesheet">
<link href="../resources/bootstrap/css/custom.css" rel="stylesheet">
<!-- JQUERY -->
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
</head>
<body>
<script>
$(function() {
	  $( "#datepicker0, #datepicker1, #datepicker2" ).datepicker({
	    dateFormat: 'yy-mm-dd'
	  });
	});
</script>
<%@ include file="../include/header.jsp" %>

<div class="container-fluid">
	<div class="row">
		<div id="wrapper">
			<div>
				<%@ include file="../include/myclubMgrSidebar.jsp" %>
			</div>
			<div id="page-content-wrapper">
				<div class="col-md-10">
					<!-- 메인폼  -->
					<div align="left">
						<!-- 팀 타이틀이 들어갈 장소 -->
						<h2>가입조건관리</h2>
					</div>
					<div class="myteamheader" align="right">
						<!-- 버튼두개짜리 헤더  -->
						<%@include file="../include/myclubHeader.jsp" %>
					</div>
				</div>
				<div class="col-md-10">
					<div style="margin-left: 10%;">
						<form action="" method="post">
							<table id="inputs" class="table table-hover">
								<tr>
									<td><span>성별조건</span></td>
									<td><input type="radio" name="gender" value="all" checked="checked"/>모두</td>
									<td><input type="radio" name="gender" value="male"/>남자</td>
									<td><input type="radio" name="gender" value="female"/>여자</td>
								</tr>
								<tr>
									<td><span>연령조건</span></td>
									<td><input type="radio" name="age" value="all" />모두</td>
									<td><input type="radio" name="age" value="select" ></td>
									<td><input type="text" id="datepicker0" name="date" placeholder="선택" /></td>
								</tr>
								<tr>
									<td><span>클럽지역</span></td>
									<td><input id="loc" type="text" name="club_loc" value="${CLUB_KEY.club_loc}"/><input id="addr" type="button" value="지역찾기"/></td>
								</tr>
								<tr>
									<td><span>클럽설명</span></td>
									<td><textarea id="content" name="club_content" cols="50" rows="5">${CLUB_KEY.club_content}</textarea></td>
								</tr>
								<tr>
									<td><span>클럽유형</span></td>
									<td><input id="r1" type="radio" name="club_type" value="1" checked="checked">공개&nbsp;&nbsp;<input id="r2" type="radio" name="club_type" value="0">비공개</td>
								</tr>
							</table>						
<!-- 						성별조건 : -->
<!-- 							<input type="radio" name="gender" value="gebderall" >&nbsp;&nbsp;모두&nbsp;&nbsp;&nbsp;&nbsp; -->
<!-- 							<input type="radio" name="gender" value="male" >&nbsp;&nbsp;남자&nbsp;&nbsp;&nbsp;&nbsp; -->
<!-- 							<input type="radio" name="gender" value="female" >&nbsp;&nbsp;여자&nbsp;&nbsp;&nbsp;&nbsp; -->
<!-- 							<br/><br/><br/> -->
						연령조건 : 	
							<input type="radio" name="age" id="ageall" >&nbsp;&nbsp;모두&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" name="age" id="allselect" >&nbsp;&nbsp;<input type="text" id="datepicker0" placeholder="선택"> 이후 출생자만 가입
							<br/><br/><br/>
							<table>
								<tr>
									<td rowspan="3" valign="top">가입신청여부 : </td>
									<td>
										<input type="radio" name="sign" id="true" >&nbsp;&nbsp;가입신청을 받습니다.<br/>
										<br/>
									</td>
								</tr>
								<tr>
									<td>
										<input type="radio" name="sign" id="false" >&nbsp;&nbsp;아래의 기간동안은 받지 않습니다.
										<br/><br/>
									</td>
								</tr>
								<tr>
									<td>
										조회기간 : <input type="text" id="datepicker1"> ~ <input type="text" id="datepicker2">
										<br/><br/>
									</td>
								</tr>
								<tr>
									<td colspan="2" align="right">
										<button class="btn btn-default" type="submit">등록</button>
									</td>
								</tr>
							</table>
						</form>
					</div>
					<div class="col-md-10">
					</div>
				</div>	
			</div>
		</div>
	</div>
</div>
<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<script src="../resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>