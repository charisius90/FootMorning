<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- 부트스트랩은 모바일 우선이라서 metatag에 두항목을 추가하는데 일단은 없어도 됨 -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../resources/bootstrap/css/startbootstrap-simple-sidebar.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">

<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
</head>
<body>
	<%@ include file="../include/header.jsp"%>

	<div class="container-fluid">
		<div class="row">
			<div id="wrapper">
				<div>
					<%@ include file="../include/myteammgrsidebar.jsp"%>
				</div>
				<div id="page-content-wrapper">
					<div class="col-md-10">

						<br/><br/>
						<h1 align="center">클럽 폐쇄</h1>
						<br/><br/>
						<p align="center">
							<label>클럽명 : <input type="text" name="club"
								placeholder="클럽명 입력" required></label>
						</p>
						<p align="center">
							<label>관리자 아이디 : <input type="text" name="id"
								placeholder="아이디 입력" required></label>
						</p>
						<p align="center">
							<label>관리자 비밀번호 : <input type="password" name="pwdck"
								placeholder="비밀번호 재입력" required></label>
						</p>
						<br />
						<br />
						<div align="center">
							<button type="button" data-toggle="modal"
								data-target="#drop_club">폐쇄 신청</button>

						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 클럽폐쇄 모달창-->
	<div id="drop_club" class="modal fade" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<h3 id="myModalLabel">클럽 폐쇄</h3><br/><br/>
				정말로 클럽을 폐쇄하시겠습니까?<br/><br/>
				<div class="modal-footer">
					<button class="btn btn-primary">확인</button>
					<button class="btn" data-dismiss="modal" aria-hidden="true">취소</button>
				</div>
			</div>
		</div>
	</div>
	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
	<script src="../resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>