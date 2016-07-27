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
	#preview {
		border: 1px solid gray;
		width: 300px;
		height: 300px;
	}
	
	#inputs >tr{
	}
</style>
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
				<div class="col-md-12" style="margin:10px;">
					<div class="col-md-12" style="padding-bottom: 20px;"><h3>클럽 생성</h3></div><br/><br/>
					<div id="preview_wrapper" class="col-md-3" style="float: left;">
						<label>로고 미리보기</label><br/>
						<div id="preview"></div>
					</div>
					<div class="col-md-6" style="margin-top: 20px;">
						<form method="post" action="clubRegister">
							<input type="hidden" name="club_master" value="${USER_KEY.mem_no}"/>
							<input type="hidden" name="mem_email" value="${USER_KEY.mem_email}"/>
							<table id="inputs" class="table table-hover">
								<tr>
									<td><span>클럽로고</span></td>
									<td><input id="file" type="file" name="club_image"/></td>
								</tr>
								<tr>
									<td><span>클럽명</span></td>
									<td><input id="name" type="text" name="club_name" /><input type="button" value="중복확인"/></td>
								</tr>
								<tr>
									<td><span>클럽지역</span></td>
									<td><input id="loc" type="text" name="club_loc"/><input id="addr" type="button" value="지역찾기"/></td>
								</tr>
								<tr>
									<td><span>클럽설명</span></td>
									<td><textarea id="content" name="club_content" cols="50" rows="5"></textarea></td>
								</tr>
								<tr>
									<td><span>클럽유형</span></td>
									<td><input type="radio" name="club_type" value="1" checked="checked">공개&nbsp;&nbsp;<input type="radio" name="club_type" value="0">비공개</td>
								</tr>
							</table>
							<div align="right">
								<button class="btn btn-primary" type="submit">등록</button>&nbsp;&nbsp;&nbsp;
								<button class="btn btn-default" type="reset">취소</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<script src="../resources/bootstrap/js/bootstrap.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
	// @박수항
	$(function(){
		
		// 업로드 없이 이미지 미리보기 기능
		var $file = $("#file"),
			$preview = $("#preview");
		
		$file.change(function(e){
			e.preventDefault();
			
			var file = $file[0].files[0],
				reader = new FileReader();
			
			reader.onload = function (event) {
				var img = new Image();
				img.src = event.target.result;
				
				if(img.width > 300){
					img.width = 300;
				}
				
				if(img.height > 300){
					img.height = 300;
				}
				
				$preview.html("");
				$preview.append(img);
			};
			
			reader.readAsDataURL(file);
			
			return false;
		});
		
		// 주소 찾기 API
		$("#addr").click(function(){
		    new daum.Postcode({
		        oncomplete: function(data) {
		            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
		            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
		        }
		    }).open();
		});
	});
</script>
</body>
</html>