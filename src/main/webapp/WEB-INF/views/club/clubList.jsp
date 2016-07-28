<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				<%@ include file="../include/clubsidebar.jsp" %>
			</div>
		<div id="page-content-wrapper">
			<div class="col-md-9">
			<h3>클럽</h3>
			
			<!-- 클럽 검색 -->
			<div class="row">
					<div class="">
					<form action="#">
						<div class="scol-lg-3 form-inline" style="float: left;">
							<select name="searchType" class="btn btn-default">
								<option value="n" >----</option>
								<option value="t" >클럽명</option>
								<option value="c" >클럽장</option>
								<option value="l" >지역</option>
							</select>
							<input type="text" class="form-control" name="keyword" value="" placeholder="Search"/>
		        			<button id="searchBtn" class="btn btn-default" type="submit">검색</button>
						</div><!-- /input-group -->
				</form>
					</div><!-- /.col-lg-4 -->
			</div><!-- /.row -->
			
			<!-- 클럽 정보가 들어가는 부분 -->
			<div class="row">
				<table class="table table-hover" text-align="center">
					<!-- 상당 메뉴 부분 -->
					<thead>
					<tr>
						<th>NO</th><th>로고</th><th>클럽명</th><th>마스터</th><th>클럽인원</th><th>지역</th><th>클럽소개</th>
					</tr>
					</thead>
					<!-- 실제 데이터가 들어가는 부분 -->
					
					<c:forEach items="${list}" var="clubDTO">
						<tr>
							<td>${clubDTO.club_no}</td>
							<td>${clubDTO.club_image}</td>
							<td>${clubDTO.club_name}</td>
							<td>${clubDTO.club_master}</td>
							<td>클럽인원</td>
							<td>${clubDTO.club_loc}</td>
							<td>${clubDTO.club_content}</td>
						</tr>
					</c:forEach>
					
				</table>
				
				<!-- 페이징 -->
					<nav align="center">
						<ul id="pagingul" class="pagination">
							<c:if test="${cpageMaker.prev}">
								<li><a
									href="/club/clubList${cpageMaker.makeSearch(cpageMaker.startPage - 1)}">&laquo;
								</a>
							</c:if>
							
							<c:forEach begin="${cpageMaker.startPage}"
										end="${cpageMaker.endPage}" var="idx">
								<li
									<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
									<a href="/club/clubList${cpageMaker.makeSearch(idx)}">${idx}</a>
								</li>
							</c:forEach>
								
							<c:if test="${cpageMaker.next && cpageMaker.endPage > 0}">
								<li><a
									href="/club/clubList${cpageMaker.makeSearch(cpageMaker.endPage + 1)}">&raquo;</a>
							</c:if>	
						</ul>
					</nav>
				</div><!-- /.row -->	
			</div><!-- /.col-md-9 -->
		</div><!-- page-content-wrapper -->
		</div>
	</div><!-- /.row -->
</div><!-- /.container -->

<!-- jQuery 플러그인을 가져옵니다. -->
<script src="../../resources/bootstrap/js/jQuery-2.1.4.min.js"></script>
<script>
	$(function(){
		$('#searchBtn').on("click", function(event) {
			// 검색옵션 값 가져오기
			var searchType = $("select[name=searchType]").val();
				
			// 키워드 값 가져오기
			var keyword = $("input[name=keyword]").val();
			
			self.location = "/club/clubList${pageMaker.makeQuery(1)}&searchType="+$("select option:selected").val() + "&keyword=" + $('#keywordInput').val();
		});
	})
</script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<script src="../resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>