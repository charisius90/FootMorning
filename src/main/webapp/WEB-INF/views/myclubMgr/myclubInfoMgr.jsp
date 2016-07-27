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
			<div class="col-md-9" style="margin:30px">
				<div><h3>기본정보관리</h3></div>
				<div class="myteamheader" align="right">
					<!-- 버튼두개짜리 헤더  -->
					<%@include file="../include/myclubHeader.jsp" %>
				</div>
				<div>
					<div style="float:left">로 고&nbsp;&nbsp;</div>
					<a href="#">
					<div style="border:gray 1px solid; background-color:white; width:168px;
					 height:168px; padding:2px; overflow:hidden; cursor:pointer; cursor:hand;">
					</div>
					</a><br/>
					클 럽 명&nbsp;&nbsp;<input type="text" />&nbsp;&nbsp;<input type="button" value="중복확인"/><br/><br/>
					클럽주소&nbsp;&nbsp;<input type="text" style="width:500px"/><br/><br/>
					클럽지역&nbsp;&nbsp;<input type="text" />&nbsp;&nbsp;<input type="button" value="지역찾기"/><br/><br/>
					클럽설명&nbsp;&nbsp;<textarea cols="100" rows="5"></textarea><br/><br/>
					클럽유형&nbsp;&nbsp;<input type="radio">공개&nbsp;&nbsp;<input type="radio">비공개
				</div><br/><br/>
				<div align="center">
					<button class="btn btn-primary">수정</button>&nbsp;&nbsp;&nbsp;
					<button class="btn btn-default">취소</button>
				</div>
			</div>
		</div>
	</div>
	</div>
	</div>
</body>
</html>