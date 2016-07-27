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
	#preview {
		border: 1px solid gray;
		width: 300px;
		height: 300px;
	}
	
	#inputs >tr{
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
			<div class="col-md-12" style="margin:10px;">
					<div class="col-md-12" style="padding-bottom: 20px;"><h3>기본정보관리</h3></div><br/><br/>
					<div id="preview_wrapper" class="col-md-3" style="float: left;">
						<label>로고 미리보기</label><br/>
						<div id="preview"></div>
					</div>
					<div class="col-md-6" style="margin-top: 20px;">
						<form method="post" action="clubRegister">
							<input type="hidden" name="club_master" value="${USER_KEY.mem_no}"/>
							<input type="hidden" name="mem_email" value="${USER_KEY.mem_email}"/>
							<table id="inputs" class="table table-hover">
								<tr>
									<td><span>클럽로고</span></td>
									<td><input id="file" type="file" name="club_image"/></td>
								</tr>
								<tr>
									<td><span>클럽명</span></td>
									<td><input id="name" type="text" name="club_name" /><input type="button" value="중복확인"/></td>
								</tr>
								<tr>
									<td><span>클럽지역</span></td>
									<td><input id="loc" type="text" name="club_loc"/><input id="addr" type="button" value="지역찾기"/></td>
								</tr>
								<tr>
									<td><span>클럽설명</span></td>
									<td><textarea id="content" name="club_content" cols="50" rows="5"></textarea></td>
								</tr>
								<tr>
									<td><span>클럽유형</span></td>
									<td><input type="radio" name="club_type" value="1" checked="checked">공개&nbsp;&nbsp;<input type="radio" name="club_type" value="0">비공개</td>
								</tr>
							</table>
							<div align="right">
								<button class="btn btn-primary" type="submit">수정</button>&nbsp;&nbsp;&nbsp;
								<button class="btn btn-default" type="reset">취소</button>
							</div>
						</form>
					</div>
				</div>
		</div>
	</div>
	</div>
	</div>
</body>
</html>