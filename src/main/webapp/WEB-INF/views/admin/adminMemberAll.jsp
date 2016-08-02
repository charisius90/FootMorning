<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link href="../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../resources/bootstrap/css/startbootstrap-simple-sidebar.css" rel="stylesheet">
<link href="../resources/bootstrap/css/custom.css" rel="stylesheet">
</head>
<body>

<%@ include file="../include/adminheader.jsp" %>

<div class="container">
	<div class="row">
		<h3>전체 회원 관리</h3>
		
		<div class="admin">
			<div>
				<form action="#">
					<table style="width: 100%">
						<tr>
							<td>회원검색</td>
							<td>
								<select name="searchType" class="form-control input-group-add">
									<option value="n" <c:out value="${cri.searchType == null?'selected':''}"/>>---</option>
									<option value="e" <c:out value="${cri.searchType eq 'e'?'selected':''}"/>>E-Mail</option>
									<option value="m" <c:out value="${cri.searchType eq 'm'?'selected':''}"/>>이름</option>
									<option value="s" <c:out value="${cri.searchType eq 's'?'selected':''}"/>>차단여부</option>
								</select>
							<td>
							<td><input type="text"  name="keyword" value='${pageMaker.cri.keyword}' class="form-control" size="40" placeholder="E-Mail/이름으로 검색가능" id=""></td>
							<td><button id="searchBtn" class="btn btn-default  input-group-add" type="submit">검색</button></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
			
		회원수 <span style="color:red">${total}</span>명
		<form method="post" action="">
			<table class="table table-bordered">
				<tr style="background-color:#dddddd;">
					<td><input id="checkAll" type="checkbox"/>&nbsp;&nbsp;E-Mail</td>
					<td>이름</td>
					<td>소속 클럽</td>
					<td>가입일</td>
					<td>최종방문일</td>
					<td>게시글 수</td>
					<td>댓글 수</td>
					<td>성별</td>
					<td>차단여부</td>
				</tr>
			<c:forEach items="${list}" var="dto">
				<tr>
					<td><input type="checkbox" name="mem_no" value="${dto.mem_no}" />&nbsp;&nbsp;${dto.mem_email}</td>
					<td>${dto.mem_name}</td>
					<td>${dto.club_no}</td>
					<td>${dto.mem_regdate}</td>
					<td>${dto.mem_logdate}</td>
 					<td></td>
 					<td></td>
 					<td>${dto.mem_gender}</td>
 					<td></td>
				</tr>
			</c:forEach>
			</table>
		</form>
			<hr/>
			<div class="span12" style="float: left;">
				<div style="float: left;">
					<table>
						<tr>
							<td style="padding-top: 25px;">선택한 회원을&nbsp;</td>
							<td style="padding-top: 25px;"><input type="button" name="" value="차단" />&nbsp;&nbsp;</td>
							<td style="padding-top: 25px;"><input type="button" name="" value="해제" />&nbsp;&nbsp;</td>
							<td style="padding-top: 25px;"><input type="button" name="" value="삭제" />&nbsp;&nbsp;</td>
						</tr>
					</table>	
				</div>
		<!-- 페이징-->
				<div style="float: right; margin-left: 250px;">
					<ul id="pagingul" class="pagination" class="col-xs-4 col-md-6">
						<c:if test="${pageMaker.prev}">
							<li><a 
								href="/admin/adminMemberAll${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
						</c:if>
									
						<c:forEach begin="${pageMaker.startPage}" 
								end="${pageMaker.endPage}" var="idx">
							<li
								<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
								<a href="/admin/adminMemberAll${pageMaker.makeSearch(idx)}">${idx}</a>
							</li>
						</c:forEach>
									
					<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
						<li><a 
							href="/admin/adminMemberAll${pageMaker.makeSearch(pageMaker.endPage + 1) }">&raquo;</a></li>
					</c:if>
				</ul>
			</div>
			</div>
		
	</div><!-- /.row -->
</div><!-- /.container -->
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<script src="../resources/bootstrap/js/bootstrap.min.js"></script>
<script>
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
	});

	$('#searchBtn').on("click", function(event) {
	
		// 검색옵션 값 가져오기
		var searchType = $("select[name=searchType]").val();
		
		// 키워드 값 가져오기
		var keyword = $("input[name=keyword]").val();
		
		self.location = "/admin/adminMemberAll${pageMaker.makeQuery(1)}&searchType="+$("select option:selected").val() + "&keyword=" + $('#keywordInput').val();
	});

</script>
</body>
</html>