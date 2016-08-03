<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="now" class="java.util.Date" />

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
				<%@ include file="../../include/communitysidebar.jsp" %>
			</div>
		<div id="page-content-wrapper">
			<div class="col-md-10">
				<div class="row">
				<h1>앨범</h1><br/>
					<!-- 게시글 내용이 들어가는 부분 -->
					<c:forEach items="${list}" var="comDTO" varStatus="status">
		                  <c:if test="${not empty comDTO.com_gallery_main_thumnail}">
			                  <div class="col-xs-6 col-md-3" >
									<a href="/com/gallery/read?com_gallery_no=${comDTO.com_gallery_no}" class="thumbnail" style="height: 180px">${comDTO.com_gallery_no}
								   	<img src="${comDTO.com_gallery_main_thumnail}" style="max-width: 200px; max-height: 140px" /></a>
							 	제목 : ${comDTO.com_gallery_subject}
							 		<c:if test="${comDTO.replycount > 0}"> [${comDTO.replycount}]</c:if> 
							 		
							 		<fmt:parseNumber var="date" value="${(now.time - comDTO.com_gallery_regdate.time)/(1000*60*60*24*60)}" integerOnly="true"/>
			                  		<c:if test="${date > 0}">
			                  			<img src="/resources/images/ico-new.gif"/>
			                  		</c:if> 
							 	<br/>
		                		작성자 : ${comDTO.com_gallery_writer}<br/>
		                		날짜 : <fmt:formatDate value="${comDTO.com_gallery_regdate}" pattern="yyyy/MM/dd hh:mm:ss"/><br/><br/>
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
								<input type="text" name="keyword" value='${pageMaker.cri.keyword}' style="height: 28px;" id="keywordInput">
								<button id="searchBtn" class="btn btn-default input-group-add" type="button" style="heigt: 25px;padding-top: 4px;padding-bottom: 4px;">검색</button>
							</div>
						</form>	
								
						<!-- 페이징-->
						<div class="col-md-4">
							<ul id="pagingul" class="pagination">
													
									<c:if test="${pageMaker.prev}">
										<li><a 
											href="/com/gallery/main${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
									</c:if>
									
									<c:forEach begin="${pageMaker.startPage}" 
												end="${pageMaker.endPage}" var="idx">
										<li
											<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
											<a href="/com/gallery/main${pageMaker.makeSearch(idx)}">${idx}</a>
										</li>
									</c:forEach>
									
									<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
										<li><a 
											href="/com/gallery/main${pageMaker.makeSearch(pageMaker.endPage + 1) }">&raquo;</a></li>
									</c:if>
								</ul>
						</div>
						
						<script>
							
						   var msg = "${msg}";
						   if(msg == "SUCCESS"){
						      alert("등록 되었습니다");
						   }
						   else if(msg == "UPSUCCESS"){
						      alert("수정 되었습니다");
						   }
						   else if(msg == "DELSUCCESS"){
						      alert("삭제 되었습니다");
						   }
						   
						   // 박수항
						   // 로그인 확인 후 글쓰기로 이동 혹은 로그인필요를 알리는 함수
						   function fnWrite(){
						      var user_key = "${USER_KEY}";
						      if(user_key!=null && user_key!=""){
						         location.replace("/com/gallery/register");
						      }
						      else{
						         alert("로그인 하세요.");
						      }
						   }
						
							$('#searchBtn').on("click", function(event) {
								
								// 검색옵션 값 가져오기
								var searchType = $("select[name=searchType]").val();
								
								// 키워드 값 가져오기
								var keyword = $("input[name=keyword]").val();
								
								self.location = "/com/gallery/main${pageMaker.makeQuery(1)}&searchType="+$("select option:selected").val() + "&keyword=" + $('#keywordInput').val();
							});
						</script>
								
						<!-- 글쓰기 -->
						<div style="float: right;">
							<a href="javascript:fnWrite()" class="btn btn-default" type="submit"><span class="glyphicon glyphicon-pencil"></span>글쓰기</a>
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