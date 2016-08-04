<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" session="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<!-- 부트스트랩은 모바일 우선이라서 metatag에 두항목을 추가하는데 일단은 없어도 됨 -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>회원가입</title>
<link href="../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../resources/bootstrap/css/startbootstrap-simple-sidebar.css" rel="stylesheet">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.0/themes/smoothness/jquery-ui.css">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<style>
	tr,td {padding:15px;}
	table{border-spacing:10px;}
</style>
</head>
<body>
<%@ include file="../include/header.jsp" %>

	<div class="container-fluid">
		<div class="row">
			<div id="wrapper">
				<div>
					<%@ include file="../include/clubsidebar.jsp"%>
				</div>
				<div id="page-content-wrapper">
					<div class="col-md-10" align="center">
						<h1>회원가입</h1><br/>

						<form id="signup_form" method="post" action="/member/memberSignUp">
							<table>
								<tr>
									<td>E-Mail</td>
									<td>
										<input id="inputEmail" type="text" name="mem_email"	placeholder="E-Mail 입력">
										<div id="emailCheck"></div>
									</td>
								</tr>
								<tr>
									<td>이름</td>
									<td>
										<input id="inputName" type="text" name="mem_name" placeholder="이름 입력">
										<div id="nameCheck"></div>
									</td>
								</tr>
								<tr>
									<td>비밀번호</td>
									<td>
										<input id="inputPassword" type="password" name="mem_pw" placeholder="비밀번호 입력">
										<div id="pwCheck"></div>
									</td>
								</tr>
								<tr>
									<td>비밀번호 확인</td>
									<td>
										<input id="rePassword" type="password" name="mem_pw_check" placeholder="비밀번호 재입력">
										<div id="repwCheck"></div>
									</td>
								</tr>
								<tr>
									<td>생년월일</td>
									<td><input type="text" name="mem_birth" placeholder="생년월일 입력"
										></td>
								</tr>
								<tr>
									<td>성별</td>
									<td><input type="radio" name="mem_gender" value="male">&nbsp;남자&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="radio" name="mem_gender" value="female">&nbsp;여자</td>
								</tr>
								<tr>
									<td>전화번호</td>
									<td><input type="text" name="mem_phone" placeholder="전화번호입력"
										></td>
								</tr>
								<tr >
									<td colspan="2" align="center"><input id="register_btn" class="btn btn-primary" type="button" value="가입">&nbsp;&nbsp;
									<input class="btn btn-default" type="reset" value="취소"></td>
								</tr>
							</table>
							<br/><span id="inputCheck" style="color:red"></span>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
<script src="../resources/bootstrap/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
<script>
	//데이트피커 연결
	var birth = $("[name=mem_birth]").datepicker({
		dateFormat:"yy-mm-dd",
		changeMonth:true,
		changeYear:true,
		yearRange: "1930:2016"
	});
	
	var flag1 = false;
	var flag2 = false;
	$(document).ready(function(){
	    $('#inputEmail').keyup(function(){	// 입력한 이메일 형식을 ajax를 사용하여 실시간으로 확인하여 메시지 띄워줌. by 소영
	        if ( $('#inputEmail').val().length > 0) {
	            var email = $(this).val();
	            $.ajax({
	                type : 'POST',
	                url : '/member/validationCheck',
	                data:{email:email, cmd:"email"},
	                success : function(data) {
	                	var result = data.trim();
	                	if (result == "yes"){
	                        $("#emailCheck").html("<span style='color:blue'>사용 가능한 이메일 입니다.</span>");
	                        flag1 = true;
	                    } 
	                	else if(result == "not"){
	                        $("#emailCheck").html("<span style='color:red'>잘못된 이메일 형식입니다.</span>");
	                        flag1 = false;
	                    }
	                	else if(result == "no"){
	                		$("#emailCheck").html("<span style='color:red'>중복된 이메일 입니다.</span>");
	                		flag1 = false;
	                	}
	                }
	            });
	        }
	        else{
	        	 $("#emailCheck").empty();
	        }
	    });
	    
	    $('#inputPassword').keyup(function(){	// 입력한 패스워드 형식을 ajax를 사용하여 실시간으로 확인하여 메시지 띄워줌.
	        if ( $('#inputPassword').val().length > 0) {
	            var pw = $(this).val();
	            $.ajax({
	                type : 'POST',
	                url : '/member/validationCheck',
	                data:{pw:pw, cmd:"pw"},
	                success : function(data) {
	                	var result = data.trim();
	                	if (result == "yes"){
	                        $("#pwCheck").html("<span style='color:blue'>사용 가능한 비밀번호 입니다.</span>");
	                        flag1 = true;
	                    } 
	                	else if(result == "no"){
	                		$("#pwCheck").html("<span style='color:red'>영문,숫자,특수문자 조합 8자 이상 16자 이하만 가능합니다.</span>");
	                		flag1 = false;
	                	}
	                }
	            });
	        }
	        else{
	        	 $("#pwCheck").empty();
	        }
	    });
	    
	    $('#rePassword').keyup(function(){
	    	if ( $('#rePassword').val().length > 0) {
		    	if($('#rePassword').val()!=$('#inputPassword').val()){
		    		$("#repwCheck").html("<span style='color:red'>비밀번호가 일치하지 않습니다.</span>");
		    		flag1 = false;
		    	}
		    	else{
		    		$("#repwCheck").empty();
		    		flag1 = true;
		    	}
	    	}
	    	else{
	        	 $("#repwCheck").empty();
	        }
	    	
	    });
	    
	    $('#inputName').keyup(function(){	// 입력한 이름 형식을 ajax를 사용하여 실시간으로 확인하여 메시지 띄워줌.
	        if ( $('#inputName').val().length > 0) {
	            var name = $(this).val();
	            $.ajax({
	                type : 'POST',
	                url : '/member/validationCheck',
	                data:{name:name, cmd:"name"},
	                success : function(data) {
	                	var result = data.trim();
	                	if (result == "yes"){
	                        $("#nameCheck").html("<span style='color:blue'>사용 가능한 이름입니다.</span>");
	                        flag1 = true;
	                    } 
	                	else if(result == "no"){
	                		$("#nameCheck").html("<span style='color:red'>6자 이하만 가능합니다.</span>");
	                		flag1 = false;
	                	}
	                }
	            });
	        }
	        else{
	        	 $("#nameCheck").empty();
	        }
	    });
	    
	    $("#register_btn").click(function(){	// 가입하기 버튼을 클릭했을 때 비어있는 값 확인하여 메시지 띄워줌. by 소영
	        if(!$('#inputName').val()){
	        	$('#inputCheck').html('이름을 입력해 주세요.');
	        	$('#inputName').focus();
	        	flag2 = false;
	        }	
	        else if(!$('#inputEmail').val()){
	        	$('#inputCheck').html('이메일을 입력해 주세요.');
	        	$('#inputEmail').focus();
	        	flag2 = false;
	        }
	        else if(!$('#inputPassword').val()){ 
	        	$('#inputCheck').html('비밀번호를 입력해 주세요.');
	        	$('#inputPassword').focus();
	            flag2 = false;
	        }
	        else{
	        	$('#inputCheck').empty();
	        	flag2 = true;
	        }
	        if(flag1 == true && flag2 == true){
	           	$('#signup_form').submit();
	        }
	    });
	});
</script>
</body>
</html>