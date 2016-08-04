<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../resources/bootstrap/css/startbootstrap-simple-sidebar.css" rel="stylesheet">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/formation.css">
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
			${GAME_KEY.game_flag}&nbsp;&nbsp;&nbsp;&nbsp;${GAME_KEY.game_no}
				<h3>경기 준비</h3>
				<div id="formation">
					<div id="ground" class="ground"></div>
					<form id="request" method="POST" action="/myclub/myclubGamePrepareRegister">
						<input type="hidden" id="club_no" value="${USER_KEY.club_no}"/>
						<div id="list">
							<table>
								<tr>
									<th><label for="#participate">라인업</label><br /></th>
									<th></th>
									<th><label for="#member">선수</label><br/></th>
								</tr>
								<tr>
									<td>
										<select id="firstLineUp" onclick="fnFirstLineUpSelect()" size="15"></select>
										<hr width="100%" /> 
										<select id="subLineUp" onclick="fnSubLineUpSelect()" size="8"></select>
									</td>
									<td><div id="">
											<input type="button" value="추가" onclick="fnLineUpRegister()" /> 
											<br/>
											<input type="button" value="제외" onclick="fnLineUpRemove()" />
										</div></td>
									<td><select id="member" size="25"></select><br /></td>
								</tr>
								<tr>
									<td colspan="3">
										<input type="radio" name="lineUpType" value="first" checked="checked">선발 
										<input type="radio" name="lineUpType" value="sub">후보</td>
								</tr>
							</table>
						</div><br/>&nbsp;&nbsp;&nbsp;&nbsp;
						<input class="btn btn-default" onclick="registerMatch()" type="button" value="등록하기"/>
						<a class="btn btn-default" href="/myclub/myclubGameSchedule?club_no=${USER_KEY.club_no}">취소</a>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
var msg = "${msg}";
if(msg == "SUCCESS"){
	alert("등록 되었습니다");
}else if(msg == "EXIST"){
	alert("이미 있음");
}
</script>
	<!--Import jQuery before formation.js-->
	<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
	<script type="text/javascript" src="/resources/js/formation.js"></script>
	<script src="../resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>