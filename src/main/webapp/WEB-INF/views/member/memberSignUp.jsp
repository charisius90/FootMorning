<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" session="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<!-- 부트스트랩은 모바일 우선이라서 metatag에 두항목을 추가하는데 일단은 없어도 됨 -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>회원가입</title>
<link href="../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../resources/bootstrap/css/startbootstrap-simple-sidebar.css" rel="stylesheet">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.0/themes/smoothness/jquery-ui.css">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<style>
	tr,td {padding:15px;}
	table{border-spacing:10px;}
</style>
</head>
<body>
<%@ include file="../include/header.jsp" %>

<spring:hasBindErrors name="memberDTO" />
<form:errors name="memberDTO" />

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
									<td><form:errors path="memberDTO.mem_email" /></td>
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
									<td><form:errors path="memberDTO.mem_pw" /></td>
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
<script src="../resources/bootstrap/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
<script>
	//데이트피커 연결
	var birth = $("[name=mem_birth]").datepicker({
		dateFormat:"yy-mm-dd",
		changeMonth:true,
		changeYear:true,
		yearRange: "1930:2016"
	});
</script>
</body>
</html>