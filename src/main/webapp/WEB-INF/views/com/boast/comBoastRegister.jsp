<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link href="../../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../../resources/bootstrap/css/startbootstrap-simple-sidebar.css" rel="stylesheet">
</head>
<body>

<%@ include file="../../include/headerRoot.jsp" %>

<div class="container-fluid">
	<div class="row">
		<div id="wrapper">
			<div>
				<%@ include file="../../include/communitysidebar.jsp" %>
			</div>
			<div class="col-md-10">
				<div id="page-content-wrapper">
				<h1>클럽자랑-글쓰기</h1> 			
				<br/><br/>
				
				<!-- 글쓰는 부분 -->
				<form id="comBoastRegisterForm" role="form" method="POST" action="/com/boast/comBoastRegister">
					<input type="hidden" name="mem_no" value="${USER_KEY.mem_no}"/>
					<div class="container">
						<div class="row">
							<table class="table">
								<tr>
									<td>제목</td>
									<td><input type="text" name="com_boast_subject" value=""/></td>
								</tr>
								<tr>
									<td>작성자</td>
									<td><input type="text" value="${USER_KEY.mem_name}"/></td>
								</tr>
								<tr>
									<td>내용</td>
									<td><textarea rows="10" name="com_boast_content" cols="100"></textarea></td>
								</tr>
							</table>
						</div>
					</div>
				</form>
				<hr/>
			
				<div align="right">
					<a href="/com/boast/comBoastListAll" class="btn btn-default"><span class="glyphicon glyphicon-align-justify"></span>목록</a>
					<a href="javascript:fnSubmit()" class="btn btn-default"><span class="glyphicon glyphicon-pencil"></span>등록</a>
					<a href="/com/boast/comBoastListAll" class="btn btn-default"><span class="glyphicon glyphicon-remove"></span>취소</a>
				</div>		
				</div>
			</div>	
		</div>
	</div>
</div>


<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<script src="../../resources/bootstrap/js/bootstrap.min.js"></script>
<script>
	function fnSubmit(){
		$("#comBoastRegisterForm").submit();
	}
</script>
</body>
</html>