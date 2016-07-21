<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<style>
.sidebar-nav>li>ul>li {
    display: block;
    list-style: none;
}
</style>
</head>
<body>
<!-- Sidebar -->
	<div id="sidebar-wrapper">
			<ul class="sidebar-nav">
				<li class="active"><a href="/myclub/notice"> 공지사항</a></li>
				<li class="divider"></li>
				<li><a href="javascript:;" data-toggle="collapse"
					data-target="#comm">커뮤니티<i class="glyphicon glyphicon-triangle-bottom"></i></a>
					<ul id="comm" class="collapse">
						<li><a href="#">자유게시판</a></li>
						<li><a href="#">앨범</a></li>
						<li><a href="#">동영상</a></li>
						<li><a href="#">방명록</a></li>
					</ul>
				</li>
				<li class="divider"></li>
				<li><a href="javascript:;" data-toggle="collapse"
					data-target="#mattch"> 경기 <i class="glyphicon glyphicon-triangle-bottom"></i></a>
					<ul id="mattch" class="collapse">
						<li><a href="#">일정 및 결과</a></li>
						<li><a href="#">기록실</a></li>
					</ul>
				</li>
				<li class="divider"></li>
				<li><a href="#">현금출납부</a></li>
			</ul>
	</div>
	<!-- /#sidebar-wrapper -->
<!-- Menu Toggle Script -->
</body>
</html>