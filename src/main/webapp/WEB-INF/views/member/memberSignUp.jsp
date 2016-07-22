<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- 부트스트랩은 모바일 우선이라서 metatag에 두항목을 추가하는데 일단은 없어도 됨 -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>회원가입</title>
<link href="../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../resources/bootstrap/css/startbootstrap-simple-sidebar.css" rel="stylesheet">
<style>
	tr,td {padding:15px;}
	table{border-spacing:10px;}
</style>
</head>
<body>
<%@ include file="../include/header.jsp" %>

	<div class="container-fluid">
		<div class="row">
			<div id="wrapper">
				<div>
					<%@ include file="../include/clubsidebar.jsp"%>
				</div>
				<div id="page-content-wrapper">
					<div class="col-md-10" align="center">
						<h1>회원가입</h1><br/>

						<form method="post" action="/member/memberSignUp">
							<table>
								<tr>
									<td>E-Mail</td>
									<td><input type="text" name="mem_email"
										placeholder="E-Mail 입력" required></td>
								</tr>
								<tr>
									<td>이름</td>
									<td><input type="text" name="mem_name"
										placeholder="이름 입력" required></td>
								</tr>
								<tr>
									<td>비밀번호</td>
									<td><input type="password" name="mem_pw"
										placeholder="비밀번호 입력" required></td>
								</tr>
								<tr>
									<td>비밀번호 확인</td>
									<td><input type="password" name="mem_pw_check"
										placeholder="비밀번호 재입력" required></td>
								</tr>
								<tr>
									<td>생년월일</td>
									<td><input type="text" name="mem_birth" placeholder="생년월일 입력"
										required></td>
								</tr>
								<tr>
									<td>성별</td>
									<td><input type="radio" name="mem_gender" value="male">&nbsp;남자&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="radio" name="mem_gender" value="female">&nbsp;여자</td>
								</tr>
								<tr>
									<td>전화번호</td>
									<td><input type="text" name="mem_phone" placeholder="전화번호입력"
										required></td>
								</tr>
								<tr >
									<td colspan="2" align="center"><input class="btn btn-primary" type="submit" value="가입">&nbsp;&nbsp;
									<input class="btn btn-default" type="reset" value="취소"></td>
								</tr>
							</table>
						</form>
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