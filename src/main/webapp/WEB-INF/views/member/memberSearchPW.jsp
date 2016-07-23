<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- 부트스트랩은 모바일 우선이라서 metatag에 두항목을 추가하는데 일단은 없어도 됨 -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>비밀번호 찾기</title>
<link href="../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../resources/bootstrap/css/startbootstrap-simple-sidebar.css"
	rel="stylesheet">
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
						<div align="center"><h1>비밀번호 찾기</h1></div>
						<form action="/member/memberSearchPW" method="post">
							<table align="center" height="40" width="430" border="0"
								style="border: solid 2px #87CEEEB; margin-top: 4%">
	
								<tr>
									<td><input type="text" name="mem_email"
										style="height: 40px; width: 430px; margin: 10px" placeholder="E-Mail 입력"></td>
								</tr>
								<tr>
									<td><input type="text" name="mem_phone"
										style="height: 40px; width: 430px; margin: 10px" placeholder="전화번호 입력"></td>
								</tr>
								<tr>
									<td><input type="submit" value="E-Mail 전송"
										style="height: 40px; width: 430px; margin: 10px; font-size: 16px; border: solid 1px #808080;"></td>
								</tr>
							</table>
						</form>
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