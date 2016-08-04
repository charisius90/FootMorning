<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<style>
.sidebar-nav>li>ul>li {
    display: block;
    list-style: none;
}

.menu-a{
}
</style>
</head>
<body>
<!-- Sidebar -->
	<div id="sidebar-wrapper">
			<ul class="sidebar-nav">
				<li class="active"><a href="/myclub/notice/main" class="menu-a">공지사항</a></li>
				<li class="divider"></li>
				<li><a href="javascript:;" data-toggle="collapse"
					data-target="#comm">커뮤니티<i class="glyphicon glyphicon-triangle-bottom"></i></a>
					<ul id="comm" class="collapse">
						<li><a href="/myclub/free/main">자유게시판</a></li>
						<li><a href="/myclub/team/main" class="menu-a">팀게시판</a></li>
						<li><a href="/myclub/album/main" class="menu-a">앨범</a></li>
						<li><a href="/myclub/video/main" class="menu-a">동영상</a></li>
						<li><a href="#">방명록</a></li>
					</ul>
				</li>
				<li class="divider"></li>
				<li><a href="javascript:;" data-toggle="collapse"
					data-target="#match"> 경기 <i class="glyphicon glyphicon-triangle-bottom"></i></a>
					<ul id="match" class="collapse">
						<li><a href="/myclub/myclubGameSchedule?club_no=${CLUB_KEY.club_no}" class="menu-a">일정 및 결과</a></li>
						<li><a href="/myclub/myclubRecord" class="menu-a">기록실</a></li>
					</ul>
				</li>
				<li class="divider"></li>
				<li><a href="/myclub/myclubCashBook" class="menu-a">현금출납부</a></li>
			</ul>
	</div>
	<!-- /#sidebar-wrapper -->
<!-- Menu Toggle Script -->
<script>
	$(function(){
		var userGrade = "${USER_KEY.mem_grade}",
			userClubNo = "${USER_KEY.club_no}",
			clubNo = "${CLUB_KEY.club_no}";
			
		if(userGrade=="" || userGrade>4 || (userClubNo != clubNo)){
			$(".menu-a").each(function(i, e){
				$(e).click(function(){
					alert("접근 권한이 없습니다.");
					return false;
				});
			})
		}
	})
</script>
</body>
</html>