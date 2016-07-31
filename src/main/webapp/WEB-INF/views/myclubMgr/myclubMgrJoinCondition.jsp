<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- 부트스트랩은 모바일 우선이라서 metatag에 두항목을 추가하는데 일단은 없어도 됨 -->
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../resources/bootstrap/css/startbootstrap-simple-sidebar.css" rel="stylesheet">
<link href="../resources/bootstrap/css/custom.css" rel="stylesheet">
<!-- JQUERY -->
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<!-- 부트스트랩 데이트피커 -->
<link href="../resources/bootstrap/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
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
				<div class="col-md-10">
					<!-- 메인폼  -->
					<div align="left">
						<!-- 팀 타이틀이 들어갈 장소 -->
						<h2>가입조건관리</h2>
					</div>
					<div class="myteamheader" align="right">
						<!-- 버튼두개짜리 헤더  -->
						<%@include file="../include/myclubHeader.jsp" %>
					</div>
				</div>
				<div class="col-md-10">
					<div style="margin-left: 10%;">
						<form action="/myclubMgr/myclubMgrJoinCondition" method="post">
							<input type="hidden" name="club_no" value="${CLUB_KEY.club_no}"/>
							<table id="inputs" class="table table-hover">
								<tr>
									<td><span>가입신청여부</span></td>
									<td><input type="radio" name="sign" value="TRUE" checked />항상허용</td>
									<td><input type="radio" name="sign" value="FALSE" />항상거부</td>
									<td><input type="radio" name="sign" value="TERM" />거부기간설정 <input type="text" id="dateFrom" name="config_reject_from" placeholder="자동 거부 시작일"> ~ <input type="text" id="dateTo" name="config_reject_to" placeholder="자동 거부 종료일"></td>
								</tr>
								<tr>
									<td><span>성별조건</span></td>
									<td><input type="radio" name="config_gender" value="BOTH" checked="checked"/>모두</td>
									<td><input type="radio" name="config_gender" value="MALE"/>남자</td>
									<td><input type="radio" name="config_gender" value="FEMALE"/>여자</td>
								</tr>
								<tr>
									<td><span>연령조건</span></td>
									<td><input type="radio" name="age" value="ALL" checked/>모두</td>
									<td colspan="2"><input type="radio" name="age" value="SELECT" >연령선택 <input type="text" name="config_birth_from" placeholder="가입가능 최소 나이" /> ~ <input type="text" name="config_birth_to" placeholder="가입가능 최고 나이" /></td>
								</tr>
							</table>
						</form>
					</div>
					<div align="right">
						<button class="btn btn-primary" onclick="fnSubmit()">가입조건변경</button>&nbsp;&nbsp;&nbsp;
					</div>
				</div>	
			</div>
		</div>
	</div>
</div>
<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<!-- 라이브러리 로드 순서는 아래와 같다. cdnjs 저장소에서 라이브러리를 로드하였다. -->
<script src="../resources/bootstrap/js/bootstrap.min.js"></script>
<script src="../resources/bootstrap/js/bootstrap-datetimepicker.min.js"></script>
<script>
	function fnSubmit(){
		$("form").submit();
	}
	
	function fnInitCheckBox(){
		// 모든 조건을 기존 설정으로 세팅
		var gender = "${CONFIG.config_gender}";
		var reject_from = "${CONFIG.config_reject_from}";
		var reject_to = "${CONFIG.config_reject_to}";
		var birth_from = "${CONFIG.config_birth_from}";
		var birth_to = "${CONFIG.config_birth_to}";
		
		if(gender == "MALE"){
			$("input [value=MALE]").prop("checked", true);
		}
		else if(gender == "FEMALE"){
			$("input [value=FEMALE]").prop("checked", true);
		}
		
		if(reject_from=="1000-01-01" && reject_to=="9999-12-31"){
			$("input [value=FALSE]").prop("checked", true);
		}
		else if(reject_from=="1000-01-01" && reject_to="1000-01-01"){
			$("input [value=TRUE]").prop("checked", true);
		}
		else{
			$("input [value=TERM]").prop("checked", true);
			$("input [name=config_reject_from]").val(reject_from);
			$("input [name=config_reject_to]").val(reject_to);
		}
		
		if(birth_from=="1000-01-01" && birth_to=="9999-12-31"){
			$("input [value=ALL]").prop("checked", true);
		}		
		else{
			$("input [value=SELECT]").prop("checked", true);
			$("input [name=config_birth_from]").val(birth_from);
			$("input [name=config_birth_to]").val(birth_to);
		}
	}
	
	$(function(){
		fnInitCheckBox();
		
		// input태그 선택시 자동으로 체크박스가 체크되게 하는 코드
		$("#dateFrom, #dateTo").click(function(){
			$("[value=term]").prop("checked", true);
		});
		$("[name=age_min], [name=age_max]").click(function(){
			$("[value=select]").prop("checked", true);
		});
		
		// 데이트피커 연결
		$("#dateFrom, #dateTo").datetimepicker({
			language : "ko", // 화면에 출력될 언어를 한국어로 설정한다.
			pickTime : false, // 사용자로부터 시간 선택을 허용하려면 true를 설정하거나 pickTime 옵션을 생략한다.
			defalutDate : new Date() // 기본값으로 오늘 날짜를 입력한다. 기본값을 해제하려면 defaultDate 옵션을 생략한다.
		});

		$("[name=age_min], [name=age_max]").datetimepicker({
			language : 'ko',
			pickTime : false,
			defalutDate : new Date()
		});
	})
</script>
</body>
</html>