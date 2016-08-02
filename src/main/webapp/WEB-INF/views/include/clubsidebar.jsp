<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
	#sidebar-wrapper{
		background: #fff;
		padding-left: 10px;
	}
	
	.tab-content{padding: 10px}
	
	#new_club{
		cursor:pointer;
		height:100px; 
		text-align:center;
		background:#ffcccc; 
		border-radius:5px;
		padding:5px;
		padding-top:35px;
		margin-bottom: 10px;
		margin-top:20px;
	}
	
	#new_club:hover {
		background:#ffd5d5;
	}
	
	#new_club:hover >span{
		color: #135a97;
	}
	
	#new_club >span{
		font-size: x-large;
		font-weight: bolder;
		color: #337ab7;
	}
</style>
</head>
<body>
		<!-- Sidebar -->
		<div id="sidebar-wrapper">
			<c:if test="${USER_KEY.club_no == null}">
				<div id="new_club" onclick="location.href='/club/clubRegister'">
					<span>클럽 만들기</span>
				</div>
			</c:if>
			<c:if test="${USER_KEY.club_no != null}">
				<div id="new_club" onclick="location.href='/myclub/myclubMain?no=${USER_KEY.club_no}'">
					<span>소속 클럽 가기</span>
				</div>
			</c:if>
			<div id="club_menu" class="tabbable" style="height:200px;  margin-bottom: 10px">
				<ul class="nav nav-tabs nav-justified" id="club_category">
					<li class="active" data-order="0"><a href="#tab1" data-toggle="tab">신규클럽</a></li>
					<li data-order="1"><a href="#tab2" data-toggle="tab">추천클럽</a></li>
				</ul>
				<div class="tab-content">
						<!-- 신상클럽 -->
						<div class="tab-pane active" id="tab1">
							<ul id="new_club_list">
								<c:forEach items="${club}" var="sidebar" begin="0" end="3" step="1">
									<li><a href="/myclub/myclubMain?no=${sidebar.club_no}">${sidebar.club_name}</a></li>
								</c:forEach>
							</ul>
						</div>
						<!-- 인기클럽 -->
						<div class="tab-pane" id="tab2">
							<ul id="rec_club_list">
							<c:forEach items="${popular}" var="pop" begin="0" end="3" step="1">
								<li><a href="/myclub/myclubMain?no=${pop.club_no}">${pop.club_name}</a></li>
							</c:forEach>
							</ul>
						</div>
				</div>
			</div>
			<div>
				<p style="text-align:center; height:30px; border-radius:5px; background:#ffcccc; padding-top:5px">
					<a href="/club/notice/main">공지사항</a>
				</p>
				<ul>
					<c:forEach items="${notice}" var="clubNotice" begin="0" end="3" step="1">
						<li><a href="/club/notice/read?main_notice_no=${clubNotice.main_notice_no}">${clubNotice.main_notice_content}</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<!-- /#sidebar-wrapper -->
	<!-- Menu Toggle Script -->
</body>
</html>