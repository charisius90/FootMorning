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
				<h1>Q&A 게시판 - 수정하기</h1> 			
				<br/><br/>
				
				<!-- 글쓰는 부분 -->
				<form method="POST" action="/com/qna/comQnAUpdate">
				<input type="hidden" name="com_qna_no" value="${comQnADTO.com_qna_no}"/>
				<input type="hidden" name="mem_no" value="${comQnADTO.mem_no}"/>
				<input type="hidden" name="com_qna_regdate" value="${comQnADTO.com_qna_regdate}"/>
				<input type="hidden" name="com_qna_count" value="${comQnADTO.com_qna_count}"/>
				<div class="container">
					<div class="row">
						<table class="table">
							<tr>
								<td>제목</td>
								<td><input type="text" name="com_qna_subject" value="${comQnADTO.com_qna_subject}"/></td>
							</tr>
							<tr>
								<td>작성자</td>
								<td><input type="text" name="com_qna_writer" value="${comQnADTO.com_qna_writer}"/></td>
							</tr>
							<tr>
								<td>내용</td>
								<td><textarea name="com_qna_content" rows="10" cols="100">${comQnADTO.com_qna_content}</textarea></td>
							</tr>
						</table>
					</div>
				</div>
				</form>
				<hr/>
				
				<div align="right">
					<a href="/com/qna/comQnAListAll" class="btn btn-default"><span class="glyphicon glyphicon-align-justify"></span>목록</a>
					<a href="javascript:fnSubmit()" class="btn btn-default"><span class="glyphicon glyphicon-pencil"></span>등록</a>
					<a href="/com/qna/comQnARead?no=${comQnADTO.com_qna_no}" class="btn btn-default"><span class="glyphicon glyphicon-remove"></span>취소</a>
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
		$("form").submit();
	}
</script>
</body>
</html>