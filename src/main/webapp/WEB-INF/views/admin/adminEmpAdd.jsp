<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<!-- 부트스트랩은 모바일 우선이라서 metatag에 두항목을 추가하는데 일단은 없어도 됨 -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../resources/bootstrap/css/startbootstrap-simple-sidebar.css" rel="stylesheet">
<link href="../resources/bootstrap/css/custom.css" rel="stylesheet">
</head>
<body>
<%@ include file="../include/adminheader.jsp" %>

<div class="container-fluid">
	<div class="row">
		<div id="wrapper">
				<div class="col-md-10">
					<h3>직원등록</h3>
					<br/>
					<form method="post" action="/admin/adminEmpAdd">
						<table class="table">
							<tr>
								<td>아이디</td>
								<td><input type="text" name="mem_email" class="form-control" 
									style="width: 30%" placeholder="아이디 입력"></td>
							</tr>
							<tr>
								<td>비밀번호</td>
								<td><input type="password" name="mem_pw" class="form-control" 
								style="width: 20%" placeholder="비밀번호 입력"></td>
							</tr>
							<tr>
								<td>이름</td>
								<td><input type="text" name="mem_name" class="form-control" 
								style="width: 20%" placeholder="이름 입력"></td>
							</tr>
							<tr>
								<td>직무</td>
								<td>
									<select class="form-control" style="width:20%">
										<option>총괄관리자</option>
										<option>회원관리자</option>
										<option>클럽관리자</option>
										<option>커뮤니티관리자</option>
										<option>모니터요원</option>
										<option>꾸미기요원</option>
									</select>
								</td>
							</tr>
							<tr>
								<td>권한</td>
								<td>
									<label for="all">모든권한</label><input type="checkbox" id="all" value="id">
									<label for="emp">직원관리</label><input type="checkbox" id="emp" value="id">
									<label for="mem">회원관리</label><input type="checkbox" id="mem" value="id">
									<label for="club">클럽</label><input type="checkbox" id="club" value="id">
									<label for="com">커뮤니티</label><input type="checkbox" id="com" value="id">
									<label for="edit">꾸미기</label><input type="checkbox" id="edit" value="id">
								</td>
							</tr>
						</table>
						<div align="right">
							<button class="btn btn-default" type="submit">등록</button>
							<button class="btn btn-default" type="reset">초기화</button>
						</div>
					</form>
				</div>
		</div>
	</div>
</div>
<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<script src="../resources/bootstrap/js/bootstrap.min.js"></script>
<script>
	var msg = "${msg}";
	if(msg == "SUCCESS"){
		alert("등록되었습니다.");
	}
</script>
</body>
</html>