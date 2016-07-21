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
				<%@ include file="../include/myteammgrsidebar.jsp" %>
			</div>
		<div id="page-content-wrapper">
			<div class="col-md-9" style="margin:30px">
				<div><h3>클럽메뉴관리</h3></div>
				<div class="myteamheader" align="right">
					<!-- 버튼두개짜리 헤더  -->
					<%@include file="../include/myteamheader.jsp" %>
				</div>
				<br/><br/>
				<div class="row">
					<table class="table table-hover">
						<tr>
							<td>
								메뉴명 <select name="menuSelectBox">
								    <option value='' selected>-- 선택 --</option>
								    <option value='defaultBoard'>일반게시판</option>
								    <option value='pictureBoard'>사진게시판</option>
								    <option value='videoBoard'>동영상게시판</option>
								</select>&nbsp;&nbsp;
								<input type="text"/>&nbsp;&nbsp;
								<input type="button" value="추가"/><br/><br/>
							</td>
						</tr>
						<tr>
							<td>
								<select name="menuListBox" size='10' style="width:300px">
								    <option value='' selected>---- 선 택 ----</option>
								    <option value=''>알립니다</option>
								    <option value=''>가입인사</option>
								    <option value=''>클럽앨범</option>
								    <option value=''>자유게시판</option>
								    <option value=''>방명록</option>
								</select>
								
							</td>
						</tr>
						<tr>
							<td>
								<input type="button" value="삭제"/>&nbsp;&nbsp;
								<input type="button" value="수정"/>&nbsp;&nbsp;
								<input type="button" value="아래로"/>&nbsp;&nbsp;
								<input type="button" value="위로"/>&nbsp;&nbsp;
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