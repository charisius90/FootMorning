<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<!-- 부트스트랩은 모바일 우선이라서 metatag에 두항목을 추가하는데 일단은 없어도 됨 -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="../resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="../resources/bootstrap/css/startbootstrap-simple-sidebar.css"
	rel="stylesheet">
</head>
<body>
	<%@ include file="../include/header.jsp"%>

	<div class="container-fluid">
		<div class="row">
			<div id="wrapper">
				<div>
					<%@ include file="../include/myPagesidebar.jsp"%>
				</div>
				<div id="page-content-wrapper">
					<div class="col-md-12">
						<div class="row">
							<div align="right"></div>
							<table class="table table-hover" text-align="center">

								<thead style="background-color:#dddddd;">
									<tr>
										<td><strong>커뮤니티</strong></td>
										<td><strong>제목</strong></td>
										<td><strong>작성날짜</strong></td>
									</tr>
								</thead>
								<tbody>
									<c:if test="${!empty comcoast}">
										<c:forEach items="${comboast}" var="dto">
											<tr>
												<td>클럽자랑</td>
												<td><a href="/com/boast/read?com_boast_no=${dao.com_boast_no}">${dto.com_boast_subject}</a></td>
												<td><fmt:formatDate value="${dto.com_boast_regdate}" pattern="yyyy/MM/dd hh:mm:ss"/></td>
											</tr>
										</c:forEach>
									</c:if>
									
									<c:if test="${!empty comkor}">
										<c:forEach items="${comkor}" var="dto">
											<tr>
												<td>국내축구토론</td>
												<td><a href="/com/kor/read?com_discussion_kor_no=${dao.com_discussion_kor_no}">${dto.com_discussion_kor_subject}</a></td>
												<td><fmt:formatDate value="${dto.com_discussion_kor_regdate}" pattern="yyyy/MM/dd hh:mm:ss"/></td>
											</tr>
										</c:forEach>
									</c:if>	

									<c:if test="${!empty comworld}">
										<c:forEach items="${comworld}" var="dto">
											<tr>
												<td>해외축구토론</td>
												<td><a href="/com/world/read?com_discussion_world_no=${dao.com_discussion_world_no}">${dto.com_discussion_world_subject}</a></td>
												<td><fmt:formatDate value="${dto.com_discussion_world_regdate}" pattern="yyyy/MM/dd hh:mm:ss"/></td>
											</tr>
										</c:forEach>	
									</c:if>										
									
									<c:if test="${!empty comfree}">
										<c:forEach items="${comfree}" var="dto">
											<tr>
												<td>자유게시판</td>
												<td><a href="/com/free/read?com_free_no=${dao.com_free_no}">${dto.com_free_subject}</a></td>
												<td><fmt:formatDate value="${dto.com_free_regdate}" pattern="yyyy/MM/dd hh:mm:ss"/></td>
											</tr>
										</c:forEach>	
									</c:if>

									<c:if test="${!empty comgallery}">
										<c:forEach items="${comgallery}" var="dto">
											<tr>
												<td>갤러리</td>
												<td><a href="/com/gallery/read?com_gallery_no=${dao.com_gallery_no}">${dto.com_gallery_subject}</a></td>
												<td><fmt:formatDate value="${dto.com_gallery_regdate}" pattern="yyyy/MM/dd hh:mm:ss"/></td>
											</tr>
										</c:forEach>	
									</c:if>										

									<c:if test="${!empty comqan}">
										<c:forEach items="${comqan}" var="dto">
											<tr>
												<td>Q&A</td>
												<td><a href="/com/qna/read?com_qna_no=${dao.com_qan_no}">${dto.com_qan_subject}</a></td>
												<td><fmt:formatDate value="${dto.com_qan_regdate}" pattern="yyyy/MM/dd hh:mm:ss"/></td>
											</tr>
										</c:forEach>
									</c:if>										

									<c:if test="${!empty comvideo}">
										<c:forEach items="${comvideo}" var="dto">
											<tr>
												<td>동영상</td>
												<td><a href="/com/video/read?com_video_no=${dao.com_video_no}">${dto.com_video_subject}</a></td>
												<td><fmt:formatDate value="${dto.com_video_regdate}" pattern="yyyy/MM/dd hh:mm:ss"/></td>
											</tr>
										</c:forEach>	
									</c:if>										
								</tbody>
								
								
								<thead style="background-color:#dddddd;">
									<tr>
										<td><strong>my클럽</strong></td>
										<td><strong>제목</strong></td>
										<td><strong>작성날짜</strong></td>
									</tr>
								</thead>
								<tbody>
								
									<c:if test="${!empty myclubalbum}">
										<c:forEach items="${myclubalbum}" var="dto">
											<tr>
												<td>앨범</td>
												<td><a href="/myclub/album/read?myclub_album_no=${dao.myclub_notice_no}">${dto.myclub_album_subject}</a></td>
												<td><fmt:formatDate value="${dto.myclub_album_regdate}" pattern="yyyy/MM/dd hh:mm:ss"/></td>
											</tr>
										</c:forEach>	
									</c:if>	
								
									<c:if test="${!empty myclubfree}">
										<c:forEach items="${myclubfree}" var="dto">
											<tr>
												<td>자유게시판</td>
												<td><a href="/myclub/free/read?myclub_free_no=${dao.myclub_notice_no}">${dto.myclub_free_subject}</a></td>
												<td><fmt:formatDate value="${dto.myclub_free_regdate}" pattern="yyyy/MM/dd hh:mm:ss"/></td>
											</tr>
										</c:forEach>	
									</c:if>	
								
									<c:if test="${!empty myclubnotice}">
										<c:forEach items="${myclubnotice}" var="dto">
											<tr>
												<td>공지사항</td>
												<td><a href="/myclub/notice/read?myclub_notice_no=${dao.myclub_notice_no}">${dto.myclub_notice_subject}</a></td>
												<td><fmt:formatDate value="${dto.myclub_notice_regdate}" pattern="yyyy/MM/dd hh:mm:ss"/></td>
											</tr>
										</c:forEach>	
									</c:if>	
								
									<c:if test="${!empty myclubteam}">
										<c:forEach items="${myclubteam}" var="dto">
											<tr>
												<td>팀</td>
												<td><a href="/myclub/team/read?myclub_team_no=${dao.myclub_notice_no}">${dto.myclub_team_subject}</a></td>
												<td><fmt:formatDate value="${dto.myclub_team_regdate}" pattern="yyyy/MM/dd hh:mm:ss"/></td>
											</tr>
										</c:forEach>	
									</c:if>	
								
									<c:if test="${!empty myclubvideo}">
										<c:forEach items="${myclubvideo}" var="dto">
											<tr>
												<td>동영상</td>
												<td><a href="/myclub/video/read?myclub_video_no=${dao.myclub_notice_no}">${dto.myclub_video_subject}</a></td>
												<td><fmt:formatDate value="${dto.myclub_video_regdate}" pattern="yyyy/MM/dd hh:mm:ss"/></td>
											</tr>
										</c:forEach>	
									</c:if>	
								
								</tbody>	
							</table>
							<nav align="center"></nav>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>	
		<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
		<script src="../resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>