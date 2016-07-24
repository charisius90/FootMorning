<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link href="../../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../../resources/bootstrap/css/startbootstrap-simple-sidebar.css" rel="stylesheet">
<style>
	.caption_title{
		font-size: 15pt;
	}
	
	.caption_user{
		font-size: 10pt;
	}
	
	.caption_info{
		font-size: 10pt;
	}
</style>
</head>
<body>

<%@ include file="../../include/header.jsp" %>


<div class="container-fluid">
	<div class="row">
		<div id="wrapper">
			<div>
				<%@ include file="../../include/communitysidebar.jsp" %>
			</div>
		<div id="page-content-wrapper">
				<div class="col-md-10">
					<div class="col-md-12">
						<h1>축구 동영상</h1>
						
						<div class="container">
							<div class="row">
								<!-- 글쓰기 -->
								<div style="float: right;">
									<a href="javascript:fnWrite()" class="btn btn-default" ><span class="glyphicon glyphicon-pencil"></span>글쓰기</a>
								</div>
								
								<!-- 검색하는 부분 -->
								<div class="col-lg-4" >
									<div class="input-group" align="center">
										<select style="float: left">
											<option>제목+내용</option>
									        <option>제목</option>
									        <option>작성자</option>
										</select>
										<input type="text" class="form-control" />
										<span class="input-group-btn">
											<button type="button" onclick="" class="btn btn-default">검색</button>
										</span>
									</div>
								</div>
							</div>
							
							<div class="row">
					<c:forEach begin="1" end="12" step="1">
								<div class="col-sm-6 col-md-4">
									<div class="thumbnail">
										<a href="#">
											<img src="../../resources/images/koala.jpg" alt="..."/>
<!-- 											<video width="340px"> -->
<!-- 												<source src="../../resources/video/animation.mp4" type="video/mp4"> -->
<!-- 												<p>Your browser does not support HTML5 video.</p> -->
<!-- 											</video> -->
										</a>
								    	<div class="caption" align="left">
								    		<span class="caption_title"><a href="#">${comVideoDTO.com_video_subject}</a></span><br/>
								    		<span class="caption_user"><a href="#">${comVideoDTO.com_video_writer}</a></span><br/>
								    		<span class="caption_info">조회수 ${comVideoDTO.com_video_count} / 게시일 ${comVideoDTO.com_video_regdate}</span>
								 		</div>
								    </div>
								</div>
					</c:forEach>
							</div>
							
						</div>
						
						
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
	// 박수항
	// 글 등록 완료 시 성공메시지 출력 구문
	var msg = "${msg}";
	if(msg == "success"){
		alert("등록 성공");
	}
	
	// 박수항
	// 로그인 확인 후 글쓰기로 이동 혹은 로그인필요를 알리는 함수
	function fnWrite(){
		var user_key = "${USER_KEY}";
		if(user_key!=null && user_key!=""){
			location.replace("/com/video/comVideoRegister");
		}
		else{
			alert("로그인 하세요.");
		}
	}
</script>
</body>
</html>