<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- 부트스트랩은 모바일 우선이라서 metatag에 두항목을 추가하는데 일단은 없어도 됨 -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>아이디 찾기</title>
<link href="../resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="../resources/bootstrap/css/startbootstrap-simple-sidebar.css"
	rel="stylesheet">
<style type="text/css">
line {
	border-bottom: 2px solid;
	black
}
</style>
</head>
<body>
	<%@ include file="../include/header.jsp"%>

	<div class="container-fluid">
		<div class="row">
			<div id="wrapper">
				<div>
					<%@ include file="../include/clubsidebar.jsp"%>
				</div>
				<div id="page-content-wrapper">
					<div class="col-md-10">
						<div align="center">
							<table align="center" height="90">
								<tr>
									<td><h1>아이디찾기</h1></td>
								</tr>
							</table>
							<table align="center" height="40" width="430" border="0"
								style="border: solid 2px #87CEEEB; margin-top: 4%">
	
								<tr>
									<td>이름 <input type="text" name="Name" value=""
										style="height: 40px; width: 430px;" placeholder="이름입력"></td>
								</tr>
							</table>
	
							<table align="center" height="40" width="430" border="0"
								style="border: solid 2px #87CEEEB; margin-top: 1%">
	
								<tr>
									<td>전화번호 <input type="tel" name="tel" value=""
										style="height: 40px; width: 430px" placeholder="전화번호 입력"></td>
								</tr>
	
							</table>
							<table align="center" height="40" style="margin-top: 1%">
								<tr>
									<td><input type="button" name="login" value="찾기"
										style="height: 50px; width: 430px; background-color: border: solid 2px #808080; margin-top: 4%; color: black; font-size: 16px; border: solid 1px #808080;"></td>
								</tr>
	
							</table>
							<table align="center" height="0" width="440" border="1"
								style="border: solid 1px #050099; margin-top: 2%">
							</table>
						</div>
					</div>
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