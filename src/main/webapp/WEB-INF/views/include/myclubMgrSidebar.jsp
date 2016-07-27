<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<!-- Sidebar -->
	<div id="sidebar-wrapper">
			<ul class="sidebar-nav">
				<li><a href="javascript:;" data-toggle="collapse"
					data-target="#nomalmgr"> 기본정보관리 <i class="glyphicon glyphicon-triangle-bottom"></i></a>
					<ul id="nomalmgr" class="collapse">
						<li><a href="myteaminfoMgr.jsp">기본정보관리</a></li>
						<li><a href="myteamjoinconditionMgr.jsp">가입정보관리</a></li>
					</ul>
				</li>
				<li><a href="javascript:;" data-toggle="collapse"
					data-target="#clubmain"> 클럽메인관리 <i class="glyphicon glyphicon-triangle-bottom"></i></a>
					<ul id="clubmain" class="collapse">
						<li><a href="myteamclubmainMgr.jsp">클럽대문관리</a></li>
						<li><a href="myteamclubmenuMgr.jsp">클럽메뉴관리</a></li>
					</ul>
				</li>
				<li><a href="javascript:;" data-toggle="collapse"
					data-target="#membermgr"> 멤버관리 <i class="glyphicon glyphicon-triangle-bottom"></i></a>
					<ul id="membermgr" class="collapse">
						<li><a href="myteammemberMgr.jsp">클럽멤버관리</a></li>
						<li><a href="myteamregisterMgr.jsp">가인신청관리</a></li>
						<li><a href="myteammembergradeMgr.jsp">등급/직책관리</a></li>
						<li><a href="myteamoutmemberMgr.jsp">탈퇴멤버관리</a></li>
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
						<li><a href="myteamclubClosingMgr.jsp">클럽폐쇄</a></li>
						<li><a href="myteamclubTransferMgr.jsp">클럽양도</a></li>
					</ul>
				</li>				
			</ul>
	</div>
	<!-- /#sidebar-wrapper -->
<!-- Menu Toggle Script -->
</body>
</html>