<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- 부트스트랩은 모바일 우선이라서 metatag에 두항목을 추가하는데 일단은 없어도 됨 -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../resources/bootstrap/css/startbootstrap-simple-sidebar.css" rel="stylesheet">
<style>
	td >div {
		width: 80px;
		float: left;
		padding-top: 1px;
	}
</style>
</head>
<body>
<%@ include file="../include/header.jsp" %>

<div class="container-fluid">
	<div class="row">
		<div id="wrapper">
			<div>
				<%@ include file="../include/myclubMgrSidebar.jsp" %>
			</div>
		<div id="page-content-wrapper">
			<div class="col-md-9" style="margin:30px">
				<div><h3>등급/권한관리</h3></div>
				<div class="myteamheader" align="right">
					<!-- 버튼두개짜리 헤더  -->
					<%@include file="../include/myclubHeader.jsp" %>
				</div>
				<br/><br/>
				<div class="row">
					<table class="table table-hover">
						<tr>
							<th>방문자 권한</th>
							<td>
								클럽에 방문한 외부 회원이며, 다음 권한을 부여할 수가 있습니다.<br/>
								<input name="user_mod" value="auth_mod" type="checkbox"/>&nbsp;자유게시판이용
							</td>
						</tr>
						<tr>
							<th>등급별 권한</th>
							<td>
								<div>1.일반회원</div>
								<input name="member_all" type="checkbox"/>&nbsp;모든권한&nbsp;&nbsp;&nbsp;&nbsp;
								<input name="member_mod" value="auth_mod"  type="checkbox"/>&nbsp;게시글 수정/삭제&nbsp;&nbsp;&nbsp;&nbsp;
								<input name="member_cash" value="auth_cash" type="checkbox"/>&nbsp;현금출납부 관리&nbsp;&nbsp;&nbsp;&nbsp;
								<input name="member_access" value="auth_access" type="checkbox"/>&nbsp;관리페이지 접근&nbsp;&nbsp;&nbsp;&nbsp;
								<input name="member_info" value="auth_info" type="checkbox"/>&nbsp;기본정보관리&nbsp;&nbsp;&nbsp;&nbsp;
								<input name="member_mem" value="auth_mem" type="checkbox"/>&nbsp;멤버관리&nbsp;&nbsp;&nbsp;&nbsp;
								<input name="member_club" value="auth_club" type="checkbox"/>&nbsp;클럽관리&nbsp;&nbsp;&nbsp;&nbsp;
								<br/>
								<div>2.스태프</div>
								<input name="staff_all" type="checkbox"/>&nbsp;모든권한&nbsp;&nbsp;&nbsp;&nbsp;
								<input name="staff_mod" value="auth_mod" type="checkbox"/>&nbsp;게시글 수정/삭제&nbsp;&nbsp;&nbsp;&nbsp;
								<input name="staff_cash" value="auth_cash" type="checkbox"/>&nbsp;현금출납부 관리&nbsp;&nbsp;&nbsp;&nbsp;
								<input name="staff_access" value="auth_access" type="checkbox"/>&nbsp;관리페이지 접근&nbsp;&nbsp;&nbsp;&nbsp;
								<input name="staff_info" value="auth_info" type="checkbox"/>&nbsp;기본정보관리&nbsp;&nbsp;&nbsp;&nbsp;
								<input name="staff_mem" value="auth_mem" type="checkbox"/>&nbsp;멤버관리&nbsp;&nbsp;&nbsp;&nbsp;
								<input name="staff_club" value="auth_club" type="checkbox"/>&nbsp;클럽관리&nbsp;&nbsp;&nbsp;&nbsp;
								<br/>
								<div>3.매니저</div>
								<input name="mgr_all" type="checkbox"/>&nbsp;모든권한&nbsp;&nbsp;&nbsp;&nbsp;
								<input name="mgr_mod" value="auth_mod" type="checkbox"/>&nbsp;게시글 수정/삭제&nbsp;&nbsp;&nbsp;&nbsp;
								<input name="mgr_cash" value="auth_cash" type="checkbox"/>&nbsp;현금출납부 관리&nbsp;&nbsp;&nbsp;&nbsp;
								<input name="mgr_access" value="auth_access" type="checkbox"/>&nbsp;관리페이지 접근&nbsp;&nbsp;&nbsp;&nbsp;
								<input name="mgr_info" value="auth_info" type="checkbox"/>&nbsp;기본정보관리&nbsp;&nbsp;&nbsp;&nbsp;
								<input name="mgr_mem" value="auth_mem" type="checkbox"/>&nbsp;멤버관리&nbsp;&nbsp;&nbsp;&nbsp;
								<input name="mgr_club" value="auth_club" type="checkbox"/>&nbsp;클럽관리&nbsp;&nbsp;&nbsp;&nbsp;
								<br/>
								<div>4.마스터</div>
								<input name="master_all" type="checkbox"/>&nbsp;모든권한&nbsp;&nbsp;&nbsp;&nbsp;
								<input name="master_mod" value="auth_mod" type="checkbox"/>&nbsp;게시글 수정/삭제&nbsp;&nbsp;&nbsp;&nbsp;
								<input name="master_cash" value="auth_cash" type="checkbox"/>&nbsp;현금출납부 관리&nbsp;&nbsp;&nbsp;&nbsp;
								<input name="master_access" value="auth_access" type="checkbox"/>&nbsp;관리페이지 접근&nbsp;&nbsp;&nbsp;&nbsp;
								<input name="master_info" value="auth_info" type="checkbox"/>&nbsp;기본정보관리&nbsp;&nbsp;&nbsp;&nbsp;
								<input name="master_mem" value="auth_mem" type="checkbox"/>&nbsp;멤버관리&nbsp;&nbsp;&nbsp;&nbsp;
								<input name="master_club" value="auth_club" type="checkbox"/>&nbsp;클럽관리&nbsp;&nbsp;&nbsp;&nbsp;
								<br/>
							</td>
							
						</tr>
<!-- 						<tr> -->
<!-- 							<th>스텝회원</th> -->
<!-- 							<td> -->
<!-- 								1.총무<br/> -->
<!-- 								<input type="checkbox"/>&nbsp;회원관리&nbsp;&nbsp;<input type="checkbox"/>&nbsp;게시판 관리(쓰기, 삭제) 권한 사용<br/> -->
<!-- 								2.운영자1<br/> -->
<!-- 								<input type="checkbox"/>&nbsp;회원관리&nbsp;&nbsp;<input type="checkbox"/>&nbsp;게시판 관리(쓰기, 삭제) 권한 사용<br/> -->
<!-- 								3.운영자2<br/> -->
<!-- 								<input type="checkbox"/>&nbsp;회원관리&nbsp;&nbsp;<input type="checkbox"/>&nbsp;게시판 관리(쓰기, 삭제) 권한 사용<br/> -->
<!-- 							</td> -->
<!-- 						</tr>					 -->
					</table>
				</div>
				<div align="right">
					<button class="btn btn-primary" onclick="fnSubmit()">권한변경</button>&nbsp;&nbsp;&nbsp;
				</div>
			</div>
		</div>
		</div>
	</div>
</div>
<script>
	$(function(){
		$("input[name=master_all]").click(function(){
			if($(this).prop("checked")){
				$("input[name*=master]").prop("checked", true);
			}
			else{
				$("input[name*=master]").prop("checked", false);
			}
		});
		$("input[name=mgr_all]").click(function(){
			if($(this).prop("checked")){
				$("input[name*=mgr]").prop("checked", true);
			}
			else{
				$("input[name*=mgr]").prop("checked", false);
			}
		});
		$("input[name=staff_all]").click(function(){
			if($(this).prop("checked")){
				$("input[name*=staff]").prop("checked", true);
			}
			else{
				$("input[name*=staff]").prop("checked", false);
			}
		});
		$("input[name=member_all]").click(function(){
			if($(this).prop("checked")){
				$("input[name*=member]").prop("checked", true);
			}
			else{
				$("input[name*=member]").prop("checked", false);
			}
		});
		
		$("input[name*=master]").change(function(){
			if(!$(this).prop("checked")){
				$("input[name=master_all]").prop("checked", false);
			}
		});
		$("input[name*=mgr]").change(function(){
			if(!$(this).prop("checked")){
				$("input[name=mgr_all]").prop("checked", false);
			}
		});
		$("input[name*=staff]").change(function(){
			if(!$(this).prop("checked")){
				$("input[name=staff_all]").prop("checked", false);
			}
		});
		$("input[name*=member]").change(function(){
			if(!$(this).prop("checked")){
				$("input[name=member_all]").prop("checked", false);
			}
		});
		// 이하 기존 권한값 세팅
		$("input[name=master_mod]").prop("checked", "${AUTH_MASTER.auth_mod}"==1?true:false);
		$("input[name=master_cash]").prop("checked", "${AUTH_MASTER.auth_cash}"==1?true:false);
		$("input[name=master_access]").prop("checked", "${AUTH_MASTER.auth_access}"==1?true:false);
		$("input[name=master_info]").prop("checked", "${AUTH_MASTER.auth_info}"==1?true:false);
		$("input[name=master_mem]").prop("checked", "${AUTH_MASTER.auth_member}"==1?true:false);
		$("input[name=master_club]").prop("checked", "${AUTH_MASTER.auth_club}"==1?true:false);
		
		$("input[name=mgr_mod]").prop("checked", "${AUTH_MGR.auth_mod}"==1?true:false);
		$("input[name=mgr_cash]").prop("checked", "${AUTH_MGR.auth_cash}"==1?true:false);
		$("input[name=mgr_access]").prop("checked", "${AUTH_MGR.auth_access}"==1?true:false);
		$("input[name=mgr_info]").prop("checked", "${AUTH_MGR.auth_info}"==1?true:false);
		$("input[name=mgr_mem]").prop("checked", "${AUTH_MGR.auth_member}"==1?true:false);
		$("input[name=mgr_club]").prop("checked", "${AUTH_MGR.auth_club}"==1?true:false);
		
		$("input[name=staff_mod]").prop("checked", "${AUTH_STAFF.auth_mod}"==1?true:false);
		$("input[name=staff_cash]").prop("checked", "${AUTH_STAFF.auth_cash}"==1?true:false);
		$("input[name=staff_access]").prop("checked", "${AUTH_STAFF.auth_access}"==1?true:false);
		$("input[name=staff_info]").prop("checked", "${AUTH_STAFF.auth_info}"==1?true:false);
		$("input[name=staff_mem]").prop("checked", "${AUTH_STAFF.auth_member}"==1?true:false);
		$("input[name=staff_club]").prop("checked", "${AUTH_STAFF.auth_club}"==1?true:false);
		
		$("input[name=member_mod]").prop("checked", "${AUTH_MEMBER.auth_mod}"==1?true:false);
		$("input[name=member_cash]").prop("checked", "${AUTH_MEMBER.auth_cash}"==1?true:false);
		$("input[name=member_access]").prop("checked", "${AUTH_MEMBER.auth_access}"==1?true:false);
		$("input[name=member_info]").prop("checked", "${AUTH_MEMBER.auth_info}"==1?true:false);
		$("input[name=member_mem]").prop("checked", "${AUTH_MEMBER.auth_member}"==1?true:false);
		$("input[name=member_club]").prop("checked", "${AUTH_MEMBER.auth_club}"==1?true:false);
		
		$("input[name=user_mod]").prop("checked", "${AUTH_USER.auth_mod}"==1?true:false);
		
	})
	
	function fnSubmit(){
		var master = new Object(),
			mgr = new Object(),
			staff = new Object(),
			member = new Object(),
			user = new Object();
		
		var dataArr = new Array();
		
		var dataJSON;
		
		master.auth_mod = $("input[name=master_mod]").prop("checked") ? 1 : 0;
		master.auth_cash = $("input[name=master_cash]").prop("checked") ? 1 : 0;
		master.auth_access = $("input[name=master_access]").prop("checked") ? 1 : 0;
		master.auth_info = $("input[name=master_info]").prop("checked") ? 1 : 0;
		master.auth_member = $("input[name=master_mem]").prop("checked") ? 1 : 0;
		master.auth_club = $("input[name=master_club]").prop("checked") ? 1 : 0;
		
		mgr.auth_mod = $("input[name=mgr_mod]").prop("checked") ? 1 : 0;
		mgr.auth_cash = $("input[name=mgr_cash]").prop("checked") ? 1 : 0;
		mgr.auth_access = $("input[name=mgr_access]").prop("checked") ? 1 : 0;
		mgr.auth_info = $("input[name=mgr_info]").prop("checked") ? 1 : 0;
		mgr.auth_member = $("input[name=mgr_mem]").prop("checked") ? 1 : 0;
		mgr.auth_club = $("input[name=mgr_club]").prop("checked") ? 1 : 0;
		
		staff.auth_mod = $("input[name=staff_mod]").prop("checked") ? 1 : 0;
		staff.auth_cash = $("input[name=staff_cash]").prop("checked") ? 1 : 0;
		staff.auth_access = $("input[name=staff_access]").prop("checked") ? 1 : 0;
		staff.auth_info = $("input[name=staff_info]").prop("checked") ? 1 : 0;
		staff.auth_member = $("input[name=staff_mem]").prop("checked") ? 1 : 0;
		staff.auth_club = $("input[name=staff_club]").prop("checked") ? 1 : 0;
		
		member.auth_mod = $("input[name=member_mod]").prop("checked") ? 1 : 0;
		member.auth_cash = $("input[name=member_cash]").prop("checked") ? 1 : 0;
		member.auth_access = $("input[name=member_access]").prop("checked") ? 1 : 0;
		member.auth_info = $("input[name=member_info]").prop("checked") ? 1 : 0;
		member.auth_member = $("input[name=member_mem]").prop("checked") ? 1 : 0;
		member.auth_club = $("input[name=member_club]").prop("checked") ? 1 : 0;
		
		user.auth_mod = $("input[name=user_mod]").prop("checked") ? 1 : 0;
		
		dataArr.push(master);
		dataArr.push(mgr);
		dataArr.push(staff);
		dataArr.push(member);

		dataJSON = JSON.stringify(dataArr);
		
		$.ajax({
			url:"/myclubMgr/myclubMgrMemberGrade?no=${CLUB_KEY.club_no}",
			type:"POST",
			contentType : "application/json; charset=utf-8",
			data:dataJSON,
			success:function(data){
				alert(data);
			}
		});
	}
</script>
</body>
</html>