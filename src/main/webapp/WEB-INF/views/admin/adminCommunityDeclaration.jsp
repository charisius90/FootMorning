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
<script>
function popupLink(popHeight,popWidth){ 
	var winHeight = document.body.clientHeight;	// 현재창의 높이
	var winWidth = document.body.clientWidth;	// 현재창의 너비
	var winX = window.screenLeft;	// 현재창의 x좌표
	var winY = window.screenTop;	// 현재창의 y좌표

	var popX = winX + (winWidth - popWidth)/2;
	var popY = winY + (winHeight - popHeight)/2;
	window.open("adminCommunityDeclarationPopup.jsp","popup","width="+popWidth+"px,height="+popHeight+"px,top="+popY+",left="+popX);
}
</script>
</head>
<body>

<%@ include file="../include/adminheader.jsp" %>

<div class="container">
	<div class="row">
		<h3>신고 접수 관리</h3>
		<div class="admin">
			<div>
				<form action="#">
					<table style="width: 100%">
						<tr>
							<td>신고 검색</td>
							<td>
								<select name="searchType" class="form-control input-group-add">
										<option value="n" <c:out value="${cri.searchType == null?'selected':''}"/>>---</option>
										<option value="t" <c:out value="${cri.searchType eq 't'?'selected':''}"/>>피신고글</option>
										<option value="c" <c:out value="${cri.searchType eq 'c'?'selected':''}"/>>신고사유</option>
										<option value="s" <c:out value="${cri.searchType eq 's'?'selected':''}"/>>처리여부</option>
								</select>
							</td>
							<td><input type="text"  name="keyword" value='${pageMaker.cri.keyword}' class="form-control" size="40" placeholder="피신고글/신고사유/처리여부"></td>
							<td><button id="searchBtn" class="btn btn-default  input-group-add" type="submit">검색</button></td>
						</tr>
					</table>
				</form>	
			</div>
		</div>
			
			신고수 <span style="color:red">${total}</span> 명
			<table class="table table-bordered">
				<tr style="background-color:#dddddd;">
					<td><input type="checkbox" name="" value="" /> 신고번호</td>
					<td>피신고글번호</td>
					<td>신고일</td>
					<td>신고사유</td>
					<td>처리여부</td>
				</tr>
				
				<c:forEach items="${list}" var="dto">
					<tr>
<%-- 						<td><input type="checkbox" name="" value="" /> ${dto}</td> --%>
<%-- 						<td>${dto}</td> --%>
<%-- 						<td>${dto}</td> --%>
<%-- 						<td>${dto}</td> --%>
<%-- 						<td>${dto}</td> --%>
					</tr>
				</c:forEach>
			</table>
			<hr/>
			
			<table style="float: left;">
				<tr>
					<td>선택한 신고</td>
					<td>
						<select class="form-control">
							<option>처리중</option>
							<option>처리완료</option>
							<option>미처리</option>
						</select>
					</td>
					<td>(으)로 <button class="btn btn-default" type="submit">변경</button> 
			</table>

			<!-- 페이징 -->
	
			
			<div style="float: right; margin-left: 70px;">
				<ul id="pagingul" class="pagination" class="col-xs-4 col-md-6">
					<c:if test="${pageMaker.prev}">
						<li><a 
							href="/admin/adminCommunityDeclaration${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
					</c:if>
									
					<c:forEach begin="${pageMaker.startPage}" 
							end="${pageMaker.endPage}" var="idx">
						<li
							<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
							<a href="/admin/adminCommunityDeclaration${pageMaker.makeSearch(idx)}">${idx}</a>
						</li>
					</c:forEach>
									
					<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
						<li><a 
							href="/admin/adminCommunityDeclaration${pageMaker.makeSearch(pageMaker.endPage + 1) }">&raquo;</a></li>
					</c:if>
				</ul>
			</div>			
			<div style="float: right;">
				피신고게시글 <button class="btn btn-default" onclick="popupLink(200,600)">보기</button>				
			</div>
			
	</div><!-- /.row -->
</div><!-- /.container -->

<script>
	$('#searchBtn').on("click", function(event) {
	
		// 검색옵션 값 가져오기
		var searchType = $("select[name=searchType]").val();
		
		// 키워드 값 가져오기
		var keyword = $("input[name=keyword]").val();
		
		self.location = "/admin/adminCommunityDeclaration${pageMaker.makeQuery(1)}&searchType="+$("select option:selected").val() + "&keyword=" + $('#keywordInput').val();
	});

</script>

<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<script src="../resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>