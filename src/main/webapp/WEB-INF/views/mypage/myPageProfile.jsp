<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- 부트스트랩은 모바일 우선이라서 metatag에 두항목을 추가하는데 일단은 없어도 됨 -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>아이디 찾기</title>
<link href="../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../resources/bootstrap/css/startbootstrap-simple-sidebar.css"
	rel="stylesheet">
<style type="text/css">
line{border-bottom:2px solid;black }


</style>
</head>
<body>
	<%@ include file="../include/header.jsp" %>

<div class="container-fluid">
	<div class="row">
		<div id="wrapper">
			<div>
				<%@ include file="../include/myPagesidebar.jsp" %>
			</div>
		<div id="page-content-wrapper">
				<div class="col-md-10">
				<h1 align="center">회원정보</h1>
				<table align="center"class="table table-bordered" style="border:1px solid gray;" >
				<tr>
					<td align="center" class="active">ID</td>
					<td>##아이디##</td>
				</tr>
			
				<tr>
					<td align="center" class="active">이름</td>
					<td>##이름##</td>
				</tr>
				
				<tr>
					<td align="center" class="active">닉네임</td>
					<td>##닉네임##</td>
				</tr>
				<tr>
					<td align="center" class="active">E-Mail</td>
					<td>##메일##</td>
				</tr>
				<tr>
					<td align="center" class="active">전화번호</td>
					<td>##전화번호##</td>
				</tr>
				</table><br/><br/>
				<div align="center">
				</div>
				</div>
			</div>	
		</div>
	</div>
</div>
<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<script src="../resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>