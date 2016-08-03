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
		<form action="#">
			<div class="col-md-6">
					<table>
						<tr>
							<td>게시판 선택</td>
							<td>
								<select name="selectType" class="form-control input-group-add" style="width: 156px;">
									<option value="boast" <c:out value="${cri.selectType eq 'boast'?'selected':''}"/>>클럽자랑 게시판</option>
									<option value="gallery" <c:out value="${cri.selectType eq 'gallery'?'selected':''}"/>>축구갤러리 게시판</option>
									<option value="video" <c:out value="${cri.selectType eq 'video'?'selected':''}"/>>축구동영상 게시판</option>
									<option value="kor" <c:out value="${cri.selectType eq 'kor'?'selected':''}"/>>국내축구 게시판</option>
									<option value="world" <c:out value="${cri.selectType eq 'world'?'selected':''}"/>>해외축구 게시판</option>
									<option value="free" <c:out value="${cri.selectType eq 'free'?'selected':''}"/>>자유 게시판</option>
								</select>
							<td>
							
						</tr>
					</table>
			</div>
		</form>	
	</div>

	<h3>전체 게시글 관리</h3>
	<div class="row">
		<div class="admin">
			<form action="#">
				<div>
					<table style="width: 100%">
						<tr>
							<td>게시글 검색</td>
							<td>
								<select name="searchType" class="form-control input-group-add">
									<option value="n" <c:out value="${cri.searchType == null?'selected':''}"/>>---</option>
									<option value="w" <c:out value="${cri.searchType eq 'w'?'selected':''}"/>>작성자</option>
									<option value="t" <c:out value="${cri.searchType eq 't'?'selected':''}"/>>제목</option>
								</select>
							</td>
							<td><input type="text"  name="keyword" value='${pageMaker.cri.keyword}' class="form-control" size="40" placeholder="클럽명/클럽장/아이디"></td>
							<td><button id="searchBtn" class="btn btn-default  input-group-add" type="button">검색</button></td>
						</tr>
					</table>
				</div>
			</form>	
		</div>
		<br/>
			
			게시글 <span style="color:red">${total}</span>개
			<table class="table table-bordered">
				<tr style="background-color:#dddddd;">
					<td><input type="checkbox" name="" value="" /> 작성자</td>
					<td>글번호</td>
					<td>등록일</td>
					<td>제목</td>
				</tr>
				
				<c:if test="${!empty listcomboast}">
					<c:forEach items="${listcomboast}" var="dto">
						<tr>
							<td><input type="checkbox" name="" value="" /> ${dto.com_boast_writer}</td>
							<td>${dto.com_boast_no}</td>
							<td><fmt:formatDate value="${dto.com_boast_regdate}" pattern="yyyy/MM/dd hh:mm:ss"/></td>
							<td>${dto.com_boast_subject}</td>
						</tr>
					</c:forEach>
				</c:if>
				
				<c:if test="${!empty listkor}">
					<c:forEach items="${listkor}" var="dto">
						<tr>
							<td><input type="checkbox" name="" value="" /> ${dto.com_discussion_kor_writer}</td>
							<td>${dto.com_discussion_kor_no}</td>
							<td><fmt:formatDate value="${dto.com_discussion_kor_regdate}" pattern="yyyy/MM/dd hh:mm:ss"/></td>
							<td>${dto.com_discussion_kor_subject}</td>
						</tr>
					</c:forEach>
				</c:if>
				
				<c:if test="${!empty listworld}">
					<c:forEach items="${listworld}" var="dto">
						<tr>
							<td><input type="checkbox" name="" value="" /> ${dto.com_discussion_world_writer}</td>
							<td>${dto.com_discussion_world_no}</td>
							<td><fmt:formatDate value="${dto.com_discussion_world_regdate}" pattern="yyyy/MM/dd hh:mm:ss"/></td>
							<td>${dto.com_discussion_world_subject}</td>
						</tr>
					</c:forEach>
				</c:if>
				
				<c:if test="${!empty listfree}">
					<c:forEach items="${listfree}" var="dto">
						<tr>
							<td><input type="checkbox" name="" value="" /> ${dto.com_free_writer}</td>
							<td>${dto.com_free_no}</td>
							<td><fmt:formatDate value="${dto.com_free_regdate}" pattern="yyyy/MM/dd hh:mm:ss"/></td>
							<td>${dto.com_free_subject}</td>
						</tr>
					</c:forEach>
				</c:if>
				
				<c:if test="${!empty listgallery}">
					<c:forEach items="${listgallery}" var="dto">
						<tr>
							<td><input type="checkbox" name="" value="" /> ${dto.com_gallery_writer}</td>
							<td>${dto.com_gallery_no}</td>
							<td><fmt:formatDate value="${dto.com_gallery_regdate}" pattern="yyyy/MM/dd hh:mm:ss"/></td>
							<td>${dto.com_gallery_subject}</td>
						</tr>
					</c:forEach>
				</c:if>
				
				<c:if test="${!empty listvideo}">
					<c:forEach items="${listvideo}" var="dto">
						<tr>
							<td><input type="checkbox" name="" value="" /> ${dto.com_video_writer}</td>
							<td>${dto.com_video_no}</td>
							<td><fmt:formatDate value="${dto.com_video_regdate}" pattern="yyyy/MM/dd hh:mm:ss"/></td>
							<td>${dto.com_video_subject}</td>
						</tr>
					</c:forEach>
				</c:if>
				
			</table>
			<hr/>
			
			<div class="span12" style="float: left;">
				<div style="float: left;">
					<table>
						<tr>
							<td style="padding-top: 25px;">선택한 게시글을</td>
							<td style="padding-top: 25px;">
								<button class="btn btn-default" onclick="delete()">삭제</button>
							</td>
						</tr>
					</table>
				</div>
						
				<!-- 페이징 -->
				<div style="float: right; margin-left: 250px;">
					<ul id="pagingul" class="pagination" class="col-xs-4 col-md-6">
						<c:if test="${pageMaker.prev}">
							<li><a 
								href="/admin/adminCommunityAll${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
						</c:if>
									
						<c:forEach begin="${pageMaker.startPage}" 
								end="${pageMaker.endPage}" var="idx">
							<li
								<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
								<a href="/admin/adminCommunityAll${pageMaker.makeSearch(idx)}">${idx}</a>
							</li>
						</c:forEach>
									
						<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
							<li><a 
								href="/admin/adminCommunityAll${pageMaker.makeSearch(pageMaker.endPage + 1) }">&raquo;</a></li>
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
	$('#searchBtn').on("click", function(event) {
		
		// 게시판선택 옵션 값 가져오기
		var selectType = $("select[name=selectType]").val();
		
		// 검색옵션 값 가져오기
		var searchType = $("select[name=searchType]").val();
		
		// 키워드 값 가져오기
		var keyword = $("input[name=keyword]").val();
		
		self.location = "/admin/adminCommunityAll"
			+ "${pageMaker.makeQuery(1)}"
			+ "&searchType=" 
		 	+ searchType 
			+ "&keyword=" 
			+ keyword
			+ "&selectType="
			+ selectType;
		
	});

</script>
</body>
</html>