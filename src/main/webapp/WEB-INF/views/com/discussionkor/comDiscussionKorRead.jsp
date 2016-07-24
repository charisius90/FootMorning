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
					<h1>국내 축구 토론방</h1> 			
					<br/><br/>
					
					<!-- 게시글 읽는 부분 -->
					<div class="container">
						<div class="row">
							<table class="table">
								<tr>
									<td class="span1">제목 - 국내 축구 토론방</td>
									<td>${comDiscussionKorDTO.com_discussion_kor_subject}</td>
									<td class="span1">조회수</td>
									<td>${comDiscussionKorDTO.com_discussion_kor_count}</td>
								</tr>
								<tr>
									<td>작성자</td>
									<td>${comDiscussionKorDTO.com_discussion_kor_writer}</td>
									<td>등록일</td>
									<td>${comDiscussionKorDTO.com_discussion_kor_regdate}</td>
								</tr>
								<tr>
									<td>내용</td>
									<td>${comDiscussionKorDTO.com_discussion_kor_content}
									</td>
								</tr>
							</table>
						
						<br/>
					<!-- 댓글 보이는 부분 -->
					<div>
						
					</div>
					
					<!-- 댓글 다는 부분 -->
						<div>
							<form method="post" action="">댓글
								<div class="row-fluid">
									<textarea id="parent_text" class="col-md-12" rows="5"></textarea>
								</div>
								<div align="right">
									<input class="btn btn-mini" type="button" onclick="" value="등록"/>
								</div>
							</form>
						</div>
													
							
							
						</div> <!-- /row -->
					</div>
					<hr/>
					<div align="right">
						<a href="/com/discussionkor/comDiscussionKorListAll" class="btn btn-default"><span class="glyphicon glyphicon-align-justify"></span>목록</a>
						<a href="/com/discussionkor/comDiscussionKorUpdate?no=${comDiscussionKorDTO.com_discussion_kor_no}" class="btn btn-default"><span class="glyphicon glyphicon-pencil"></span>수정</a>
						<a href="/com/discussionkor/comDiscussionKorDelete?no=${comDiscussionKorDTO.com_discussion_kor_no}" class="btn btn-default"><span class="glyphicon glyphicon-remove"></span>삭제</a>
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
</body>
</html>