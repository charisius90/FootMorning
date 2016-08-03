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
<style>
	td >div {
		width: 80px;
		float: left;
		padding-top: 1px;
	}
</style>
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
				<div><h3>등급/권한관리</h3></div>
				<div class="myteamheader" align="right">
					<!-- 버튼두개짜리 헤더  -->
					<%@include file="../include/myclubHeader.jsp" %>
				</div>
				<br/><br/>
				<div class="row">
					<table class="table table-hover">
						<tr>
							<th>방문자 권한</th>
							<td>
								등업되지 않은 임시회원이며, 다음 권한을 부여할 수가 있습니다.<br/>
								<input type="checkbox"/>&nbsp;글쓰기 권한
							</td>
						</tr>
						<tr>
							<th>등급별 권한</th>
							<td>
								<div>1.일반회원</div><input type="checkbox"/>&nbsp;게시글 수정/삭제&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="checkbox"/>&nbsp;현금출납부 관리&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="checkbox"/>&nbsp;관리페이지 접근&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="checkbox"/>&nbsp;기본정보관리&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="checkbox"/>&nbsp;멤버관리&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="checkbox"/>&nbsp;운영관리&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="checkbox"/>&nbsp;클럽관리&nbsp;&nbsp;&nbsp;&nbsp;
								<br/>
								<div>2.스태프</div><input type="checkbox"/>&nbsp;게시글 수정/삭제&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="checkbox"/>&nbsp;현금출납부 관리&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="checkbox"/>&nbsp;관리페이지 접근&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="checkbox"/>&nbsp;기본정보관리&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="checkbox"/>&nbsp;멤버관리&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="checkbox"/>&nbsp;운영관리&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="checkbox"/>&nbsp;클럽관리&nbsp;&nbsp;&nbsp;&nbsp;
								<br/>
								<div>3.매니저</div><input type="checkbox"/>&nbsp;게시글 수정/삭제&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="checkbox"/>&nbsp;현금출납부 관리&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="checkbox"/>&nbsp;관리페이지 접근&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="checkbox"/>&nbsp;기본정보관리&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="checkbox"/>&nbsp;멤버관리&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="checkbox"/>&nbsp;운영관리&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="checkbox"/>&nbsp;클럽관리&nbsp;&nbsp;&nbsp;&nbsp;
								<br/>
								<div>4.마스터</div><input type="checkbox"/>&nbsp;게시글 수정/삭제&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="checkbox"/>&nbsp;현금출납부 관리&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="checkbox"/>&nbsp;관리페이지 접근&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="checkbox"/>&nbsp;기본정보관리&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="checkbox"/>&nbsp;멤버관리&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="checkbox"/>&nbsp;운영관리&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="checkbox"/>&nbsp;클럽관리&nbsp;&nbsp;&nbsp;&nbsp;
								<br/>
							</td>
							
						</tr>
<!-- 						<tr> -->
<!-- 							<th>스텝회원</th> -->
<!-- 							<td> -->
<!-- 								1.총무<br/> -->
<!-- 								<input type="checkbox"/>&nbsp;회원관리&nbsp;&nbsp;<input type="checkbox"/>&nbsp;게시판 관리(쓰기, 삭제) 권한 사용<br/> -->
<!-- 								2.운영자1<br/> -->
<!-- 								<input type="checkbox"/>&nbsp;회원관리&nbsp;&nbsp;<input type="checkbox"/>&nbsp;게시판 관리(쓰기, 삭제) 권한 사용<br/> -->
<!-- 								3.운영자2<br/> -->
<!-- 								<input type="checkbox"/>&nbsp;회원관리&nbsp;&nbsp;<input type="checkbox"/>&nbsp;게시판 관리(쓰기, 삭제) 권한 사용<br/> -->
<!-- 							</td> -->
<!-- 						</tr>					 -->
					</table>
				</div>
				<div align="right">
					<button class="btn btn-primary">권한변경</button>&nbsp;&nbsp;&nbsp;
				</div>
			</div>
		</div>
		</div>
	</div>
</div>
</body>
</html>