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
<link href="../resources/bootstrap/css/custom.css" rel="stylesheet">
</head>
<body>
<%@ include file="../include/adminheader.jsp" %>

<div class="container-fluid">
	<div class="row">
		<div id="wrapper">
				<div class="col-md-10">
					<h3>전체직원관리</h3>
					<div class="admin">
						<div>
						<table style="width: 100%">
							<tr>
								<td>직원검색</td>
								<td>
									<select class="form-control">
										<option>직무</option>
										<option>이름</option>
									</select>
								<td>
								<td><input type="text" class="form-control" size="40" placeholder="아이디/이름/직무로 검색가능" id=""></td>
								<td><button class="btn btn-default">검색</button></td>
							</tr>
						</table>
					</div>
				</div>
				<h3>직원수 6</h3>
				<div>
					<form method="post" action="">
						<table class="table">
							<tr style="background-color: #dddddd">
								<td><input type="checkbox" value="id">이름(아이디)</td>
								<td>직무</td>
								<td colspan="6">부여권한</td>
							</tr>
							<tr>
								<td><input type="checkbox" value="id">홍길동(hong1)</td>
								<td>총괄관리자</td>
								<td>모든권한<input type="checkbox" value="id"></td>
								<td>직원관리<input type="checkbox" value="id"></td>
								<td>회원관리<input type="checkbox" value="id"></td>
								<td>클럽<input type="checkbox" value="id"></td>
								<td>커뮤니티<input type="checkbox" value="id"></td>
								<td>꾸미기<input type="checkbox" value="id"></td>
							</tr>
							<tr>
								<td><input type="checkbox" value="id">홍길동(hong1)</td>
								<td>총괄관리자</td>
								<td>모든권한<input type="checkbox" value="id"></td>
								<td>직원관리<input type="checkbox" value="id"></td>
								<td>회원관리<input type="checkbox" value="id"></td>
								<td>클럽<input type="checkbox" value="id"></td>
								<td>커뮤니티<input type="checkbox" value="id"></td>
								<td>꾸미기<input type="checkbox" value="id"></td>
							</tr>
							<tr>
								<td><input type="checkbox" value="id">홍길동(hong1)</td>
								<td>총괄관리자</td>
								<td>모든권한<input type="checkbox" value="id"></td>
								<td>직원관리<input type="checkbox" value="id"></td>
								<td>회원관리<input type="checkbox" value="id"></td>
								<td>클럽<input type="checkbox" value="id"></td>
								<td>커뮤니티<input type="checkbox" value="id"></td>
								<td>꾸미기<input type="checkbox" value="id"></td>
							</tr>
							<tr>
								<td><input type="checkbox" value="id">홍길동(hong1)</td>
								<td>총괄관리자</td>
								<td>모든권한<input type="checkbox" value="id"></td>
								<td>직원관리<input type="checkbox" value="id"></td>
								<td>회원관리<input type="checkbox" value="id"></td>
								<td>클럽<input type="checkbox" value="id"></td>
								<td>커뮤니티<input type="checkbox" value="id"></td>
								<td>꾸미기<input type="checkbox" value="id"></td>
							</tr>
							<tr>
								<td><input type="checkbox" value="id">홍길동(hong1)</td>
								<td>총괄관리자</td>
								<td>모든권한<input type="checkbox" value="id"></td>
								<td>직원관리<input type="checkbox" value="id"></td>
								<td>회원관리<input type="checkbox" value="id"></td>
								<td>클럽<input type="checkbox" value="id"></td>
								<td>커뮤니티<input type="checkbox" value="id"></td>
								<td>꾸미기<input type="checkbox" value="id"></td>
							</tr>
						</table>
						<table>
							<tr><td>선택한직원을</td>
								<td>
									<select class="form-control">
										<option>총괄관리자</option>
										<option>회원관리자</option>
										<option>클럽관리자</option>
										<option>커뮤니티관리자</option>
										<option>모니터요원</option>
									</select>
								</td>
								<td>(으)로 <button class="btn btn-default" type="submit">변경</button> <button class="btn btn-default" onclick="delete()">삭제</button></td></tr>
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