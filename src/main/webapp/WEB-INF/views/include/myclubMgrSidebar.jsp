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
				<li><a href="javascript:;" data-toggle="collapse"
					data-target="#nomalmgr"> 기본정보관리 <i class="glyphicon glyphicon-triangle-bottom"></i></a>
					<ul id="nomalmgr" class="collapse">
						<li><a href="/myclubMgr/myclubInfoMgr">기본정보관리</a></li>
						<li><a href="/myclubMgr/myclubJoinConditionMgr">가입정보관리</a></li>
					</ul>
				</li>
				<li><a href="javascript:;" data-toggle="collapse"
					data-target="#clubmain"> 클럽메인관리 <i class="glyphicon glyphicon-triangle-bottom"></i></a>
					<ul id="clubmain" class="collapse">
						<li><a href="/myclubMgr/myclubClubMainMgr">클럽대문관리</a></li>
						<li><a href="/myclubMgr/myclubClubMenuMgr">클럽메뉴관리</a></li>
					</ul>
				</li>
				<li><a href="javascript:;" data-toggle="collapse"
					data-target="#membermgr"> 멤버관리 <i class="glyphicon glyphicon-triangle-bottom"></i></a>
					<ul id="membermgr" class="collapse">
						<li><a href="/myclubMgr/myclubMemberMgr">클럽멤버관리</a></li>
						<li><a href="/myclubMgr/myclubRegisterMgr">가인신청관리</a></li>
						<li><a href="/myclubMgr/myclubMemberGradeMgr">등급/직책관리</a></li>
						<li><a href="/myclubMgr/myclubOutMemberMgr">탈퇴멤버관리</a></li>
					</ul>
				</li>				
				<li><a href="javascript:;" data-toggle="collapse"
					data-target="#operationmgr"> 운영관리 <i class="glyphicon glyphicon-triangle-bottom"></i></a>
					<ul id="operationmgr" class="collapse">
						<li><a href="#">도전장관리</a></li>
					</ul>
				</li>				
				<li><a href="javascript:;" data-toggle="collapse"
					data-target="#operationclub"> 클럽운영 <i class="glyphicon glyphicon-triangle-bottom"></i></a>
					<ul id="operationclub" class="collapse">
						<li><a href="/myclubMgr/myclubClubClosingMgr">클럽폐쇄</a></li>
						<li><a href="/myclubMgr/myclubClubTransferMgr">클럽양도</a></li>
					</ul>
				</li>				
			</ul>
	</div>
	<!-- /#sidebar-wrapper -->
<!-- Menu Toggle Script -->
</body>
</html>