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
		cursor: pointer;
		width: 300px;
		height: 300px;
		border: 1px solid #ddd;
		border-radius: 4px;
		padding: 4px;
	}
	
	td >span {
		color: darkblue;
	}
	
	div >span {
		color: red;
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
			<div class="col-md-12" style="margin:10px;">
					<div class="col-md-10" style="padding-bottom: 20px;">
							<!-- 메인폼  -->
						<div align="left">
							<!-- 팀 타이틀이 들어갈 장소 -->
							<h3>기본정보관리</h3>
						</div>
						<div class="myteamheader" align="right">
							<!-- 버튼두개짜리 헤더  -->
							<%@include file="../include/myclubHeader.jsp" %>
						</div>
					</div><br/><br/>
					<div id="preview_wrapper" class="col-md-3" style="float: left;">
						<label>로고 미리보기</label><br/>
						<div id="preview" onclick="fnFile()"></div>
					</div>
					<div class="col-md-6" style="margin-top: 20px;">
						<form method="post" action="/myclubMgr/myclubMgrInfo">
							<input type="hidden" name="club_no" value="${CLUB_KEY.club_no}"/>
							<input type="hidden" name="club_regdate" value="${CLUB_KEY.club_regdate}"/>
							<input type="hidden" name="club_master" value="${USER_KEY.mem_no}"/>
							<input type="hidden" name="club_master_name" value="${CLUB_KEY.club_master_name}"/>
							<input type="hidden" name="club_mem_count" value="${CLUB_KEY.club_mem_count}"/>
							<table id="inputs" class="table table-hover">
								<tr>
									<td><span>클럽로고</span></td>
									<td><input id="file" type="file" name="club_image"/></td>
								</tr>
								<tr>
									<td><span>클럽명</span></td>
									<td><input id="name" type="text" name="club_name" value="${CLUB_KEY.club_name}" /><input type="button" value="중복확인"/></td>
								</tr>
								<tr>
									<td><span>클럽지역</span></td>
									<td><input id="loc" type="text" name="club_loc" value="${CLUB_KEY.club_loc}" placeholder="연고지를 등록하세요"/><input id="addr" type="button" value="지역찾기"/></td>
								</tr>
								<tr>
									<td><span>클럽설명</span></td>
									<td><textarea id="content" name="club_content" cols="50" rows="5" placeholder="가입을 위한 설명글을 등록하세요">${CLUB_KEY.club_content}</textarea></td>
								</tr>
								<tr>
									<td><span>클럽유형</span></td>
									<td><input id="r1" type="radio" name="club_type" value="1" checked="checked">공개&nbsp;&nbsp;<input id="r2" type="radio" name="club_type" value="0">비공개</td>
								</tr>
							</table>
							<div align="right">
								<button class="btn btn-primary" type="button" onclick="fnSubmit()">수정</button>&nbsp;&nbsp;&nbsp;
								<button class="btn btn-default" type="reset">취소</button>
							</div>
						</form>
					</div>
				</div>
		</div>
	</div>
	</div>
	</div>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
	//@author 박수항
	function fnSubmit(){
		var $file = $("#file");
		if($file.val()==null || $file.val()==""){
			$file.parent().html("<span style='color:red'>새 로고를 전송하지 않습니다.</span>");
		}
		$("form").submit();
	}

	function fnFile(){
		$("#file").click();
	}

	$(function(){
		var type = "${CLUB_KEY.club_type}";
		
		if(type == '0'){
			$("#r1").prop("checked", false);
			$("#r2").prop("checked", true);
		}
		
		// 업로드 없이 클라이언트페이지에서 이미지 미리보기 기능
		var $file = $("#file"),
			$preview = $("#preview");
		
		var image = "${CLUB_KEY.club_image}";
		if(image!=null && image!=""){
			var img = new Image();
			img.src = image;
			img.alt = "이미지를 불러 올 수 없습니다.";
			$preview.html(img);
		}
		else{
			$preview.html("<div align='center' style='margin-top:120px;'><span>'이 곳' 혹은 '파일 선택' 버튼을</span><br/><span>클릭하고 이미지를 등록하세요.</span></div>");
		}
		
		$file.change(function(e){
			e.preventDefault();
			
			var file = $file[0].files[0],
				reader = new FileReader();
			
			reader.onload = function (event) {
				var img = new Image();
				img.src = event.target.result;
				
				$preview.html(img);
				
				var $img = $("img");
				$img.width("290");
				$img.height("290");
			};
			
			reader.readAsDataURL(file);
			
			return false;
		});
		
		// 주소 찾기 API
		$("#addr").click(function(){
		    new daum.Postcode({
		        oncomplete: function(data) {
		            $("#loc").val(data.sido + " " + data.sigungu);
		        }
		    }).open();
		});
	});
</script>
</body>
</html>