<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<!-- 부트스트랩은 모바일 우선이라서 metatag에 두항목을 추가하는데 일단은 없어도 됨 -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="/resources/bootstrap/css/startbootstrap-simple-sidebar.css" rel="stylesheet">
</head>
<body>
<%@ include file="include/header.jsp" %>

<div class="container-fluid">
	<div class="row">
		<div id="wrapper">
			<div>
				<%@ include file="include/clubsidebar.jsp" %>
			</div>
		<div id="page-content-wrapper">
				<div class="col-md-10">
					<div id="banner">
						<div style="background-image: url('/resources/images/banner.jpg'); background-size: cover; height: 200px;"></div>
					</div>
					<div id="matching">
					<h4>매칭현황</h4>
						<table class="table table-hover" text-align="center">
							<thead>
								<tr>
									<th>NO</th><th>날짜</th><th>시간</th><th>지역</th>
									<th>장소</th><th>HOME</th><th>AWAY</th>
									
								</tr>
							</thead>
								<tr>
									<td>1</td><td>7/14</td><td>12:00</td><td>서울</td>
									<td>경기장1</td><td>맨유</td><td>첼시</td>
								</tr>
								<tr>
									<td>2</td><td>7/14</td><td>13:00</td><td>부산</td>
									<td>경기장2</td><td>광명FC</td><td>청계천돌핀스</td>
								</tr>
								<tr>
									<td>3</td><td>7/15</td><td>15:00</td><td>광주</td>
									<td>미정</td><td>무등산FC</td><td>나주곰탕FC</td>
								</tr>
								<tr>
									<td>4</td><td>7/18</td><td>16:00</td><td>서울</td>
									<td>경기장3</td><td>레알마드리드</td><td>바르셀로나</td>
								</tr>
						
						</table>
					</div>
					<div id="gallery">
					<h4>갤러리</h4>
						<div class="row">
						<c:forEach items="${gallery}" var="GallDTO" begin="0" end="3" step="1">
						  <c:if test="${not empty GallDTO.com_gallery_main_thumnail}">
						  <div class="col-xs-6 col-md-3">
						    <a href="/com/gallery/read?com_gallery_no=${GallDTO.com_gallery_no}" class="thumbnail">
						      <img src="${GallDTO.com_gallery_main_thumnail}">
	<!-- 					      <img src="resources/images/vincent.jsp" alt="..."> -->
						    </a>
						  </div>
						  </c:if>
						  </c:forEach>
<!-- 						  <div class="col-xs-6 col-md-3"> -->
<!-- 						    <a href="#" class="thumbnail"> -->
<!-- 						      <img src="/resources/images/vincent.jpg"> -->
<!-- 						    </a> -->
<!-- 						  </div> -->
<!-- 						  <div class="col-xs-6 col-md-3"> -->
<!-- 						    <a href="#" class="thumbnail"> -->
<!-- 						      <img src="/resources/images/vincent.jpg"> -->
<!-- 						    </a> -->
<!-- 						  </div> -->
<!-- 						  <div class="col-xs-6 col-md-3"> -->
<!-- 						    <a href="#" class="thumbnail"> -->
<!-- 						      <img src="/resources/images/vincent.jpg"> -->
<!-- 						    </a> -->
<!-- 						  </div> -->
						</div>
					</div>
					<div id="clubswag">
					<h4>클럽자랑</h4>
						<table class="table table-boardead table-hover" style="text-align: center;">
							<tr>
								<td>클럽명</td>
								<td>제목</td>
								<td>작성일</td>
								<td>조회수</td>
							</tr>
							
							
							
							
							<!-- 게시글 내용이 들어가는 부분 -->
							<c:forEach items="${boast}" var="dto" begin="0" end="3" step="1">
							<tr>
								<td>${dto.club_name}</td>
								<td><a href="com/boast/read?com_boast_no=${dto.com_boast_no}">${dto.com_boast_subject}</a></td>
								<td><fmt:formatDate value="${dto.com_boast_regdate}" pattern="yy/MM/dd hh:mm:ss"/></td>
								<td>${dto.replycount}</td>
							</tr>
							</c:forEach>
							
							
							
							
						</table>
					</div>				
				</div>

			</div>	
		</div>
	</div>
</div>
<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
<script>
	var msg = "${msg}";
	if(msg!=""){
		alert(msg);
	}
</script>
</body>
</html>