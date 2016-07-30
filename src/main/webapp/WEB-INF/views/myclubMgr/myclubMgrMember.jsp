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
			<div class="col-md-9">
			<h3>클럽멤버관리</h3>
			<div class="myteamheader" align="right">
					<!-- 버튼두개짜리 헤더  -->
					<%@include file="../include/myclubHeader.jsp" %>
			</div>
			<br/><br/>
			<div class="row">
				<div style="float:left">
					<select name="searchSelectBox" style="height:30px">
						<option value='mem_name' selected>이름</option>
						<option value='mem_id'>아이디</option>
					</select>
				</div>
				<div class="col-lg-3">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="Search"/>
						<span class="input-group-btn">
	        				<button class="btn btn-default" type="button">검색</button>
	     				</span>
					</div><!-- /input-group -->
				</div><!-- /.col-lg-4 -->
			</div><!-- /.row -->
			<br/><br/>
			<div class="row">
				<table class="table table-hover" text-align="center">
					<thead>
					<tr>
						<th><input id="checkAll" type="checkbox"/></th>
						<th>E-Mail</th>
						<th>회원등급</th>
						<th>이름</th>
						<th>생년월일</th>
						<th>성별</th>
						<th>클럽가입일</th>
					</tr>
					</thead>
					<c:forEach items="${list}" var="dto">
						<tr>
							<td><input type="checkbox" name="mem_no" id="checked_member_${dto.mem_no}" value="${dto.mem_no}"/></td>
							<td>${dto.mem_email}</td>
							<td id="col_select">
								<input id="hidden_grade" type="hidden" name="grade" value="${dto.mem_grade}">
								<select id="select_grade" name="mem_grade" style="height:30px" onchange="fnDoCheck(${dto.mem_no})">
									<option id="master" value='1'>마스터</option>
									<option id="manager" value='2'>매니저</option>
									<option id="staff" value='3'>스탭</option>
									<option id="member" value='4'>일반</option>
								</select>
							</td>
							<td>${dto.mem_name}</td>
							<td>${dto.mem_birth}</td>
							<td>${dto.mem_gender}</td>
							<td>${dto.club_mem_regdate}</td>
						</tr>
					</c:forEach>
				</table>
				
				<div style="float:right">
					<button class="btn btn-primary" onclick="fnSubmit()">선택회원수정</button>
				</div>
				</div><!-- /.row -->	
				<div class="row">
					<nav align="center">
						<ul class="pagination">
							<li><a href="#" aria-label="Previous">
								<span aria-hidden="true">&laquo;</span>
							</a></li>
							<li><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#" aria-label="Next">
								<span aria-hidden="true">&raquo;</span>
							</a></li>
						</ul>
					</nav>
				</div>
			</div><!-- /.col-md-9 -->
		</div><!-- page-content-wrapper -->
		</div>
	</div><!-- /.row -->
</div><!-- /.container -->

<script>
	function fnSubmit(){
		var memberArr = new Array();
		
		// 체크된 멤버의 번호와 수정된 등급을 JSON으로 변환
		$("[name=mem_no]:checked").each(function(i, e){
			var member = new Object();
			member.mem_no = $(e).val();
			member.mem_grade = $(e).parent().siblings("td:has(select)").children("select").val();
			memberArr.push(member);
		});
		var paramJSON = JSON.stringify(memberArr);
		
		// json데이터 전송
		$.ajax({
			url:"/myclubMgr/myclubMgrMember",
			type:"POST",
			contentType : "application/json; charset=utf-8",
			data:paramJSON,
			success:function(data){
				alert(data.length + "명 수정 완료");
			}
		});
	}

	// select태그가 사용자에 의해 수정된 경우 checkbox 체크
	function fnDoCheck(mem_no){
		$("#checked_member_" + mem_no).prop("checked", true);
	}

	$(function(){
		
		// 전체선택에 체크한 경우 변환
		$("#checkAll").click(function(){
			var check = $(this).prop("checked");
			if(check){
				$("input:checkbox").each(function(i, e){
					$(e).prop("checked", true);
				})
			}
			else{
				$("input:checkbox").each(function(i, e){
					$(e).prop("checked", false);
				})
			}
		});
		
		// select태그를 가지고 있는 td태그를 찾아 아래와 같이 반복문 활용
		$("td:has(select)").each(function(i, e){
			// 서버에서 전달받은 grade
			var grade = $(e).children().eq(0).val();
			
			// select태그 지정
			var $target = $(e).children().eq(1).children();
			
			// 1:마스터 / 2:매니저 / 3:스탭 / 4:일반
			switch(grade){
			case '1':
				$target.eq(0).attr("selected", "selected");
				break;				
			case '2':
				$target.eq(1).attr("selected", "selected");
				break;
			case '3':
				$target.eq(2).attr("selected", "selected");
				break;
			case '4':
				$target.eq(3).attr("selected", "selected");
				break;
			}
		});
	});

</script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<script src="../resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>