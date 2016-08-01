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
<!-- <link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css"> -->
<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.0/themes/smoothness/jquery-ui.css">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<!-- <script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script> -->
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
									<td><input type="radio" name="sign" value="TERM" />거부기간설정 <input type="text" id="dateFrom" name="config_reject_from" placeholder="자동 거부 시작일">부터 <input type="text" id="dateTo" name="config_reject_to" placeholder="자동 거부 종료일">까지 거부</td>
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
									<td colspan="2"><input type="radio" name="age" value="SELECT" >연령선택 <input type="text" name="config_birth_from" placeholder="가입가능 최고 나이" />생 부터 <input type="text" name="config_birth_to" placeholder="가입가능 최소 나이" />생까지 허용</td>
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
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
<script>
	function fnSubmit(){
		// 거부기간설정에 체크 했지만 날짜가 선택되지 않은 경우 처리 구문
		if($("[value=TERM]").prop("checked")){
			if($("#dateFrom").val() == ""){
				$("#dateFrom").val("1000-01-01");
			}
			
			if($("#dateTo").val() == ""){
				$("#dateTo").val("9999-12-31");
			}
		}
		
		// 연령선택에 체크 했지만 날짜가 선택되지 않은 경우 처리 구문
		if($("[value=SELECT]").prop("checked")){
			if($("[name=config_birth_from]").val() == ""){
				$("[name=config_birth_from]").val("1000-01-01");
			}
			
			if($("[name=config_birth_to]").val() == ""){
				$("[name=config_birth_to]").val("9999-12-31");
			}
		}
		
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
			$("[value=MALE]").prop("checked", true);
		}
		else if(gender == "FEMALE"){
			$("[value=FEMALE]").prop("checked", true);
		}
		
		if(reject_from=="1000-01-01" && reject_to=="9999-12-31"){
			$("[value=FALSE]").prop("checked", true);
		}
		else if(reject_from=="1000-01-01" && reject_to=="1000-01-01"){
			$("[value=TRUE]").prop("checked", true);
		}
		else{
			$("[value=TERM]").prop("checked", true);
			$("[name=config_reject_from]").val(reject_from);
			$("[name=config_reject_to]").val(reject_to);
		}
		
		if(birth_from=="1000-01-01" && birth_to=="9999-12-31"){
			$("[value=ALL]").prop("checked", true);
		}		
		else{
			$("[value=SELECT]").prop("checked", true);
			$("[name=config_birth_from]").val(birth_from);
			$("[name=config_birth_to]").val(birth_to);
		}
	}
	
	$(function(){
		fnInitCheckBox();
		
		// input태그 선택시 자동으로 체크박스가 체크되게 하는 코드
		$("#dateFrom, #dateTo").click(function(){
			$("[value=TERM]").prop("checked", true);
		});
		$("[name=config_birth_from], [name=config_birth_to]").click(function(){
			$("[value=SELECT]").prop("checked", true);
		});
		
		// 데이트피커 연결
		var dateFrom = $("#dateFrom").datepicker({
			dateFormat:"yy-mm-dd",
			changeMonth:true,
			changeYear:true,
			yearRange: "2016:2017"
		}).on("change", function(){
			dateTo.datepicker("option", "minDate", getDate(this));
        });
		
		var dateTo = $("#dateTo").datepicker({
			dateFormat:"yy-mm-dd",
			changeMonth:true,
			changeYear:true,
			yearRange: "2016:2019"
		}).on("change", function(){
			dateFrom.datepicker("option", "maxDate", getDate(this));
        });

		var birthFrom = $("[name=config_birth_from]").datepicker({
			dateFormat:"yy-mm-dd",
			changeMonth:true,
			changeYear:true,
			yearRange: "1930:2016"
		}).on("change", function(){
			birthTo.datepicker("option", "minDate", getDate(this));
        });

		var birthTo = $("[name=config_birth_to]").datepicker({
			dateFormat:"yy-mm-dd",
			changeMonth:true,
			changeYear:true,
			yearRange: "1930:2016"
		}).on("change", function(){
			birthFrom.datepicker("option", "maxDate", getDate(this));
        });
		
		// 데이트피커에서 현재 선택된 날짜를 가져옴
		function getDate(element) {
			var date;
			try {
		        date = $.datepicker.parseDate("yy-mm-dd", element.value);
			}
			catch( error ) {
				date = null;
			}
		 
			return date;
		}
	})
</script>
</body>
</html>