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
<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

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
				<%@ include file="../include/clubsidebar.jsp" %>
			</div>
			<div id="page-content-wrapper">
				<div class="col-md-12" style="margin:10px;">
					<div class="col-md-12" style="padding-bottom: 20px;"><h3>클럽 생성</h3></div><br/><br/>
					<div id="preview_wrapper" class="col-md-3" style="float: left;">
						<label>로고 미리보기</label><br/>
						<div id="preview" onclick="fnFile()"></div>
					</div>
					<div class="col-md-6" style="margin-top: 20px;">
						<form id="club_form" method="post" action="/club/clubRegister" enctype="multipart/form-data">
							<input type="hidden" name="club_master" value="${USER_KEY.mem_no}"/>
							<input type="hidden" name="club_master_name" value="${USER_KEY.mem_name}"/>
							<input type="hidden" name="club_mem_count" value="1"/>
							<input type="hidden" name="mem_email" value="${USER_KEY.mem_email}"/>
							<table id="inputs" class="table table-hover">
								<tr>
									<td><span>클럽로고</span></td>
									<td><input id="file" type="file" name="uploadfile"/></td>
								</tr>
								<tr>
									<td><span>클럽명</span></td>
									<td>
										<input id="name" type="text" name="club_name" />
										<div id="duplicateResult"></div>
									</td>
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
								<button class="btn btn-primary" type="button" onclick="fnSubmit()">등록</button>&nbsp;&nbsp;&nbsp;
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
	var flag1 = false;
	var flag2 = false;

	$(document).ready(function(){
	    $('#name').blur(function(){	// 입력한 클럽명을 ajax를 사용하여 실시간으로 중복확인하여 메시지 띄워줌. by 김소영
	        if ( $('#name').val().length > 0) {
	        	var club_name = $(this).val();
				$.ajax({
					url : "/club/duplicationCheck",
					type : "post",
					data : {club_name:club_name},
					success : function(data) {
						var result = data.trim();
						if (result=="no") {
							$("#duplicateResult").html("<span style='color:red'>사용중인 클럽명입니다.</span>");
							flag1 = false;
						} 
						else if(result=="yes"){
							$("#duplicateResult").html("<span style='color:blue'>사용가능한 클럽명입니다.</span>");
							flag1 = true;
						}
					},
					error : function(error) {
						alert(error.statusText);
					}
				});
			}
	        else{
	        	 $("#duplicateResult").empty();
	        }
	    });
	});
	
	function fnSubmit(){
		if(!$('#name').val()){
        	$('#duplicateResult').html("<span style='color:red'>클럽명을 입력해 주세요.</span>");
        	$('#name').focus();
        	flag2 = false;
        }
		
		if(flag1 == true && flag2 == true){
           	$('#club_form').submit();
        }
	}

	function fnFile(){
		$("#file").click();
	}

	//@author 박수항
	$(function(){
		
		// 업로드 없이 이미지 미리보기 기능
		var $file = $("#file"),
			$preview = $("#preview");
		
		$preview.html("<div align='center' style='margin-top:120px;'><span>'이 곳' 혹은 '파일 선택' 버튼을</span><br/><span>클릭하고 이미지를 등록하세요.</span></div>");
		
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
		$("#addr, #loc").click(function(){
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