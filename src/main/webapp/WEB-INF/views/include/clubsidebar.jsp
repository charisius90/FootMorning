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
						<div class="tab-pane active" id="tab1">
							<ul id="new_club_list">
								<li><a href="#">오조아</a></li>
								<li><a href="#">KH팀</a></li>
								<li><a href="#">맨유</a></li>
								<li><a href="#">비전FC</a></li>
							</ul>
						</div>
						<div class="tab-pane" id="tab2">
							<ul id="rec_club_list">
								<li><a href="#">오시죠</a></li>
								<li><a href="#">첼시</a></li>
								<li><a href="#">바운스</a></li>
								<li><a href="#">한가람FC</a></li>
							</ul>
						</div>
				</div>
			</div>
			<div>
				<p style="text-align:center; height:30px; border-radius:5px; background:#ffcccc; padding-top:5px">공지사항</p>
				<ul>
					<li><a href="#">[공지]현금출납장 오류안내</a></li>
					<li><a href="#">[긴급]서버교체작업 긴급공지</a></li>
					<li><a href="#">[수정]닉네임변경</a></li>
					<li><a href="#">[수정]클럽이름 변경</a></li>
				</ul>
			</div>
		</div>
		<!-- /#sidebar-wrapper -->
	<!-- Menu Toggle Script -->
</body>
</html>