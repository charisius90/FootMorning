<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link href="../../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../../resources/bootstrap/css/startbootstrap-simple-sidebar.css" rel="stylesheet">
<style>
	#pagingul{
		margin-top: 0px;
		margin-bottom: 0px;
	}
</style>
<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<script src="../../resources/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

<%@ include file="../../include/headerRoot.jsp" %>


<div class="container-fluid">
	<div class="row">
		<div id="wrapper">
			<div>
				<%@ include file="../../include/myclubSidebar.jsp" %>
			</div>
		<div id="page-content-wrapper">
			<div class="col-md-10">
				<div class="row">
				<h1>앨범</h1><br/>
					<!-- 게시글 내용이 들어가는 부분 -->
					<c:forEach items="${list}" var="myclubDTO" varStatus="status">
		                  <c:if test="${not empty myclubDTO.myclub_notice_main_thumnail}">
			                  <div class="col-xs-6 col-md-3" >
									<a href="/myclub/notice/read?myclub_notice_no=${myclubDTO.myclub_notice_no}" class="thumbnail" style="height: 180px">${myclubDTO.myclub_notice_no}
								   	<img src="${myclubDTO.myclub_notice_main_thumnail}" style="max-width: 200px; max-height: 140px" /></a>
							 	제목 : ${myclubDTO.myclub_notice_subject}<br/>
		                		작성자 : ${myclubDTO.myclub_notice_writer}<br/>
		                		날짜 : ${myclubDTO.myclub_notice_regdate}<br/><br/>
							  </div></c:if>
              		</c:forEach>
              	</div>
				<br/>
					
				<div class="container-fluid">
					<div class="row">
						<form action="#">
							<!-- 검색하는 부분 -->
							<div class="col-md-5 form-search" style="float: left;">
								<select style="width: 100px; height: 30px;" name="searchType" class="btn btn-default input-group-add" size="1">
									<option value="n" <c:out value="${cri.searchType == null?'selected':''}"/>>---</option>
									<option value="t" <c:out value="${cri.searchType eq 't'?'selected':''}"/>>제목</option>
									<option value="c" <c:out value="${cri.searchType eq 'c'?'selected':''}"/>>내용</option>
									<option value="w" <c:out value="${cri.searchType eq 'w'?'selected':''}"/>>작성자</option>
								</select>
								<input type="text" name="keyword" value='${pageMaker.cri.keyword}' style="height: 28px;">
								<button id="searchBtn" class="btn btn-default input-group-add" type="submit" style="heigt: 25px;padding-top: 4px;padding-bottom: 4px;">검색</button>
							</div>
						</form>	
								
						<!-- 페이징-->
						<div class="col-md-4">
							<ul id="pagingul" class="pagination">
													
									<c:if test="${pageMaker.prev}">
										<li><a 
											href="/myclub/notice/main${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
									</c:if>
									
									<c:forEach begin="${pageMaker.startPage}" 
												end="${pageMaker.endPage}" var="idx">
										<li
											<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
											<a href="/myclub/notice/main${pageMaker.makeSearch(idx)}">${idx}</a>
										</li>
									</c:forEach>
									
									<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
										<li><a 
											href="/myclub/notice/main${pageMaker.makeSearch(pageMaker.endPage + 1) }">&raquo;</a></li>
									</c:if>
								</ul>
						</div>
						
						<script>
							$('#searchBtn').on("click", function(event) {
								
								// 검색옵션 값 가져오기
								var searchType = $("select[name=searchType]").val();
								
								// 키워드 값 가져오기
								var keyword = $("input[name=keyword]").val();
								
								self.location = "/myclub/notice/main${pageMaker.makeQuery(1)}&searchType="+$("select option:selected").val() + "&keyword=" + $('#keywordInput').val();
							});
						</script>
								
						<!-- 글쓰기 -->
						<div style="float: right;">
							<a href="/myclub/notice/register" class="btn btn-default" type="submit"><span class="glyphicon glyphicon-pencil"></span>글쓰기</a>
						</div>
					</div>
				</div> <!-- /container-fluid -->

				</div> <!-- /col-md-10 -->
			</div> <!-- /page-content-wrapper -->
		</div> 
	</div> <!-- /row -->
</div> <!-- /container-fluid -->
</body>
</html>