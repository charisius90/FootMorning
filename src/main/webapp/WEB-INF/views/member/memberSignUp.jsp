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
				<%@ include file="../include/clubsidebar.jsp" %>
			</div>
		<div id="page-content-wrapper">
				<div class="col-md-10" align="left">
					<h1>회원가입</h1>
					<br/><br/>
					<p>
					성별	:
						<input type="radio" name="gender" value="man">남자
						<input type="radio" name="gender" value="woman">여자						
					</p>
					<table>
					<tr>
					<td>● 아이디 </td><td><input type="text" name="ID" placeholder="아이디 입력" required></td>
					</tr>

					<tr>
					<td>● 닉네임 </td><td><input type="text" name="NickName" placeholder="닉네임 입력" required></td>			
					</tr>
					<tr>
					<td>● 비밀번호 </td><td><input type="password" name="pwd" placeholder="비번번호 입력" required></td>	
					</tr>
					<tr>
					<td>● 비밀번호 확인</td><td><input type="password" name="pwdck" placeholder="비밀번호 재입력" required></td>
					</tr>
					<tr>					
					<td>● 이름</td><td><input type="text" name="Name" placeholder="이름입력" required></td>
					</tr>
					<tr>					
					<td>● 주민번호</td><td><input type="" name="RRN" placeholder="주민번호입력" required></td>
					</tr>
					<tr>
					<td>● 전화번호</td><td><input type="tel" name="Tel" placeholder="전화번호입력" required></td>
					</tr>
					<tr>
					<td>● E-Mail</td><td><input type="email" name="mail" placeholder="이메일주소 입력" required></td>
					</tr>
					<tr>
					<td><input type="submit" value="가입">&nbsp;&nbsp;<input type="submit" value="취소"></td><td></td>
					</tr>
					</table>
					
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