<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>
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
	<h3>전체 클럽 관리</h3>
		
		<div class="admin">
			<div>
				<form action="#">
					<table style="width: 100%">
						<tr>
							<td>전체 검색</td>
							<td>
								<select name="searchType" class="form-control input-group-add">
									<option value="n" <c:out value="${cri.searchType == null?'selected':''}"/>>---</option>
									<option value="t" <c:out value="${cri.searchType eq 't'?'selected':''}"/>>클럽명</option>
									<option value="c" <c:out value="${cri.searchType eq 'c'?'selected':''}"/>>클럽장</option>
								</select>
							<td>
							<td><input type="text"  name="keyword" value='${pageMaker.cri.keyword}' class="form-control" size="40" placeholder="클럽명/클럽장/아이디"></td>
							<td><button id="searchBtn" class="btn btn-default  input-group-add" type="submit">검색</button></td>
						</tr>
					</table>
				</form>	
			</div>
		</div>
			
			클럽수 <span style="color:red">${total}</span> 개
			<table class="table table-bordered">
				<tr style="background-color:#dddddd;">
					<td><input id="checkAll" type="checkbox"/>&nbsp;&nbsp;클럽명</td>
					<td>클럽장</td>
					<td>연고지</td>
					<td>개설일</td>
					<td>회원수</td>
					<td>총경기 수</td>
					<td>속성</td>
				</tr>
			<c:forEach items="${list}" var="dto">
				<tr>
					<td><input type="checkbox" name="" value="" />&nbsp;&nbsp;${dto.club_name}</td>
					<td>${dto.club_master_name}</td>
					<td>${dto.club_loc}</td>
					<td>${dto.club_regdate}</td>
					<td>${dto.club_mem_count}</td>
					<td></td>
					<td>${dto.club_type}</td>
				</tr>
			</c:forEach>
			</table>
			
			<div class="span12" style="float: left;">
				<div style="float: left;">
					<table>
						<tr>
							<td style="padding-top: 25px;">선택한 클럽을</td>
							<td style="padding-top: 25px;">
								<select class="form-control">
									<option>추천클럽</option>
									<option>일반클럽</option>
									<option>특별클럽</option>
								</select>
							</td>
							<td style="padding-top: 25px;">(으)로 <button class="btn btn-default" type="submit">등록</button> <button class="btn btn-default" onclick="">클럽해제</button></td></tr>				
					</table>
				</div>
				
				<!-- 페이징 -->
	
				<div style="float: right; margin-left: 70px;">
					<ul id="pagingul" class="pagination" class="col-xs-4 col-md-6">
						<c:if test="${pageMaker.prev}">
							<li><a 
								href="/admin/adminClubAll${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
						</c:if>
									
						<c:forEach begin="${pageMaker.startPage}" 
								end="${pageMaker.endPage}" var="idx">
							<li
								<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
								<a href="/admin/adminClubAll${pageMaker.makeSearch(idx)}">${idx}</a>
							</li>
						</c:forEach>
									
						<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
							<li><a 
								href="/admin/adminClubAll${pageMaker.makeSearch(pageMaker.endPage + 1) }">&raquo;</a></li>
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
		$('#searchBtn').on("click", function(event) {
		
			// 검색옵션 값 가져오기
			var searchType = $("select[name=searchType]").val();
			
			// 키워드 값 가져오기
			var keyword = $("input[name=keyword]").val();
			
			self.location = "/admin/adminClubAll${pageMaker.makeQuery(1)}&searchType="+$("select option:selected").val() + "&keyword=" + $('#keywordInput').val();
		});
		
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
</script>
</body>
</html>