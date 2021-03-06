<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<!-- 부트스트랩은 모바일 우선이라서 metatag에 두항목을 추가하는데 일단은 없어도 됨 -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>회원정보</title>
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

	<div class="container-fluid">
		<div class="row">
			<div id="wrapper">
				<div>
					<%@ include file="../include/myPagesidebar.jsp"%>
				</div>
				<div id="page-content-wrapper">
					<div class="col-md-10" align="center">
						<h1>회원정보</h1><br/>

						<form method="post" action="/mypage/myPageProfile">
							<input type="hidden" name="mem_no" value="${USER_KEY.mem_no}"/>
							<table>
								<tr>
									<td>E-Mail</td>
									<td><input type="text" name="mem_email"
										value="${USER_KEY.mem_email}" disabled="disabled"></td>
								</tr>
								<tr>
									<td>이름</td>
									<td><input type="text" name="mem_name"
										value="${USER_KEY.mem_name}"></td>
								</tr>
								<tr>
									<td>생년월일</td>
									<td><input type="text" name="mem_birth" value="${USER_KEY.mem_birth}"></td>
								</tr>
								<tr>
									<td>성별</td>
									<td>
											<input type="radio" name="mem_gender" value="male" id="male">&nbsp;남자&nbsp;&nbsp;&nbsp;&nbsp;
											<input type="radio" name="mem_gender" value="female" id="female">&nbsp;여자
									</td>
								</tr>
								<tr>
									<td>전화번호</td>
									<td><input type="text" name="mem_phone" value="${USER_KEY.mem_phone}"></td>
								</tr>
								<tr>
									<td>주소</td>
									<td><input type="text" name="mem_addr" value="${USER_KEY.mem_addr}" size="50"></td>
								</tr>
								<tr>
									<td>회원등급</td>
									<td><input type="text" name="mem_grade" value="${USER_KEY.mem_grade}" disabled="disabled"></td>
								</tr>
								<tr>
									<td>가입일</td>
									<td><input type="text" name="mem_regdate" value="${USER_KEY.mem_regdate}" disabled="disabled"></td>
								</tr>
								<tr>
									<td>접속종료일</td>
									<td><input type="text" name="mem_logdate" value="${USER_KEY.mem_logdate}" disabled="disabled"></td>
								</tr>
								<tr>
									<td>소속클럽</td>
									<td><input type="text" name="club_no" value="${USER_KEY.club_no}" disabled="disabled"></td>
								</tr>
								<tr>
									<td>등번호</td>
									<td><input type="text" name="mem_backno" value="${USER_KEY.mem_backno}" disabled="disabled"></td>
								</tr>
								<tr >
									<td colspan="2" align="center"><input class="btn btn-primary" type="submit" value="수정">&nbsp;&nbsp;
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

	// 현재 접속중인 회원의 등록되있는 성별값을 가져와서 라디오 버튼에 체크
	$(document).ready(
		function(){
			var gender = "${USER_KEY.mem_gender}"
			
			if(gender == "male"){
				$("#male").attr({checked:"checked"});
			}
			else{
				$("#female").attr({checked:"checked"});
			}
		});
</script>
</body>
</html>