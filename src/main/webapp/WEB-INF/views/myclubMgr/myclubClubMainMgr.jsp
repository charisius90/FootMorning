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
</head>
<body>
<%@ include file="../include/header.jsp" %>

<div class="container-fluid">
	<div class="row">
		<div id="wrapper">
			<div>
				<%@ include file="../include/myclubMgrSidebar.jsp" %>
			</div>
		<div id="page-content-wrapper">
			<div class="col-md-9" style="margin:30px">
				<div><h3>클럽대문관리</h3></div>
				<div class="myteamheader" align="right">
					<!-- 버튼두개짜리 헤더  -->
					<%@include file="../include/myclubHeader.jsp" %>
				</div>
				<br/><br/>
				<div class="row">
					<table class="table table-hover">
						<tr>
							<th>클럽메인사진</th>
							<td>
								<input type="button" value="파일선택"/><br/><br/>
								<p>클럽메인의 대표사진을 등록하세요. (최대 가로사이즈 200 x 150 픽셀 이하)<br/>
								이미지 파일확장자 jpg/gif/jpeg만 가능
								</p>
							</td>
						</tr>
						<tr>
							<th>인사말 제목</th>
							<td>
								<input type="text" size="30"/>
								<p>30자 이내로 입력하세요.</p>
							</td>
							
						</tr>
						<tr>
							<th>인사말 내용</th>
							<td>
								<textarea rows="5" cols="100"></textarea>
								<p>최대 100자 이내로 입력하세요.</p>
							</td>
						</tr>					
					</table>
				</div>
				<div align="center">
					<button class="btn btn-primary">등록확인</button>&nbsp;&nbsp;&nbsp;
				</div>
			</div>
		</div>
		</div>
	</div>
</div>
</body>
</html>