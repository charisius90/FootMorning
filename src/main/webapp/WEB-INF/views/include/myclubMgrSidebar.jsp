<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
						<li><a href="/myclubMgr/myclubMgrInfo">기본정보관리</a></li>
						<li><a href="/myclubMgr/myclubMgrJoinCondition">가입조건관리</a></li>
					</ul>
				</li>
<!-- 				<li><a href="javascript:;" data-toggle="collapse" -->
<!-- 					data-target="#clubmain"> 클럽메인관리 <i class="glyphicon glyphicon-triangle-bottom"></i></a> -->
<!-- 					<ul id="clubmain" class="collapse"> -->
<!-- 						<li><a href="/myclubMgr/myclubMgrMain">클럽대문관리</a></li> -->
<!-- 						<li><a href="/myclubMgr/myclubMgrMenu">클럽메뉴관리</a></li> -->
<!-- 					</ul> -->
<!-- 				</li> -->
				<li><a href="javascript:;" data-toggle="collapse"
					data-target="#membermgr"> 멤버관리 <i class="glyphicon glyphicon-triangle-bottom"></i></a>
					<ul id="membermgr" class="collapse">
						<li><a href="/myclubMgr/myclubMgrMember">멤버등급관리</a></li>
						<li><a href="/myclubMgr/myclubMgrRegister">가입신청관리</a></li>
						<li><a href="/myclubMgr/myclubMgrMemberGrade">등급권한관리</a></li>
						<li><a href="/myclubMgr/myclubMgrOutMember">멤버탈퇴관리</a></li>
<!-- 						<li><a href="/myclubMgr/myclubMgrMember">클럽멤버관리</a></li> -->
<!-- 						<li><a href="/myclubMgr/myclubMgrRegister">가입신청관리</a></li> -->
<!-- 						<li><a href="/myclubMgr/myclubMgrMemberGrade">등급/직책관리</a></li> -->
<!-- 						<li><a href="/myclubMgr/myclubMgrOutMember">탈퇴멤버관리</a></li> -->
					</ul>
				</li>				
				<li><a href="javascript:;" data-toggle="collapse"
					data-target="#operationmgr"> 운영관리 <i class="glyphicon glyphicon-triangle-bottom"></i></a>
					<ul id="operationmgr" class="collapse">
						<li><a href="/myclubMgr/myclubChallengeMgr?no=${USER_KEY.club_no}">도전장관리</a></li>
					</ul>
				</li>
				<c:if test="${USER_KEY.mem_grade<2}">				
				<li><a href="javascript:;" data-toggle="collapse"
					data-target="#operationclub"> 클럽운영 <i class="glyphicon glyphicon-triangle-bottom"></i></a>
					<ul id="operationclub" class="collapse">
						<li><a href="/myclubMgr/myclubMgrClosing">클럽폐쇄</a></li>
						<li><a href="/myclubMgr/myclubMgrTransfer">클럽양도</a></li>
					</ul>
				</li>			
				</c:if>	
			</ul>
	</div>
	<!-- /#sidebar-wrapper -->
<!-- Menu Toggle Script -->
</body>
</html>