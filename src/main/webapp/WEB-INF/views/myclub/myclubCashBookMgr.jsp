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
<link href="../resources/bootstrap/css/custom.css" rel="stylesheet">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.0/themes/smoothness/jquery-ui.css">
</head>
<body>
<%@ include file="../include/header.jsp" %>

<div class="container-fluid">
	<div class="row">
		<div id="wrapper">
			<div>
				<%@ include file="../include/myclubSidebar.jsp" %>
			</div>
			<div id="page-content-wrapper">
				<div class="col-md-10">
					<!-- 메인폼  -->
					<div align="left">
						<!-- 팀 타이틀이 들어갈 장소 -->
						<h2>현금출납부</h2>
					</div>
					<div class="myteamheader" align="right">
						<!-- 버튼두개짜리 헤더  -->
						<%@include file="../include/myclubHeader.jsp" %>
					</div>
				</div>
				<div class="col-md-10">
					<table id="cashbook_table" class="table table-bordered table-hover" style="text-align: center;">
							<!-- 수정 list -->
							<thead style="font-weight: bold;">
								<tr id="rhead">
									<td>번호</td>
									<td>날짜</td>
									<td>유형</td>
									<td>금액</td>
									<td>내역</td>
									<td>잔고</td>
									<td>삭제</td>
								</tr>
							</thead>
<!-- 							<tr> -->
<!-- 								<td><span class="badge" style="margin-top: 7px;">1</span></td> -->
<!-- 								<td><input type="text" class="form-control" size="2" name="cashbook_date" placeholder="날짜선택"></td> -->
<!-- 								<td> -->
<!-- 									<select class="form-control" size="1"> -->
<!-- 										<option>지출</option> -->
<!-- 										<option>수입</option> -->
<!-- 									</select> -->
<!-- 								</td> -->
<!-- 								<td><input type="text" class="form-control" size="2" id="" value="150000"></td> -->
<!-- 								<td><input type="text" class="form-control" size="10" id="" value="회식비"></td> -->
<!-- 								<td><input type="text" class="form-control" size="2" id="" value="200000"></td> -->
<!-- 								<td><span class="glyphicon glyphicon-remove" aria-hidden="true" style="cursor: pointer; margin-top: 8px;" onclick="fnDelRow()"></span></td> -->
<!-- 							</tr> -->
							<tr id="addRow" style="cursor: pointer;" onclick="fnAddRow()">
								<td colspan="7" ><span class="glyphicon glyphicon-plus" aria-hidden="true" style="margin-top: 1px;">행추가</span></td>
							</tr>
						</table>
					<div align="right">
						<button class="btn btn-default" type="submit">등록</button>
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
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
<script>
	// 1. jquery로 +버튼 클릭하면 줄 추가되고 -버튼 클릭하면 해당 줄 삭제되는 기능을 구현 (줄 추가 삭제 시 마다 줄번호 update해야한다)
	// 2. jquery로 각 칸마다 onchange로 덧셈 뺄셈 합계기능 등을 지원하자(onchange에 활용할 함수도 구현할 것)
	// 3. 입력된 값은 한줄한줄 객체로 json 파싱하자.
	// 4. 서버단에서 requestBody로 받고 resoponseBody로 전송합시다.
	// 5. 년도별, 월별 페이징을 지원하자(일단 select-option 태그로 지원하자)
	function fnCalcBalance(e){
		var $row = $(e).parent().parent();
		
		var type = $row.contents().find("select").val();
	}
	
	function fnAddRow(){
		var $prevBadge = $("#addRow").prev().contents().find(".badge");
		var nextNo;
		if($prevBadge.html() == null){
			nextNo = 1;
		}
		else{
			nextNo = parseInt($prevBadge.text()) + 1;
		}
		
		$("#addRow").before(
			"<tr>" +
				"<td><div align='center' style='padding-top: 6px;'><span class='badge'>" + nextNo + "</span></div></td>" +
				"<td><input type='text' class='form-control' size='2' name='cashbook_date' placeholder='날짜선택'></td>" +
				"<td><select class='form-control' name='cashbook_type' size='1'><option value='SUB'>지출</option><option value='ADD'>수입</option></select></td>" +
				"<td><input type='text' class='form-control' size='2' name='cashbook_amount' value='150000'></td>" +
				"<td><input type='text' class='form-control' size='10' name='cashbook_content' value='회식비'></td>" +
				"<td><input type='text' class='form-control' size='2' name='cashbook_balance' onchange='fnCalcBalance(this)' disabled></td>" +
				"<td><div align='center' style='padding-top: 8px;'><span class='glyphicon glyphicon-remove' aria-hidden='true' style='cursor: pointer;' onclick='fnDelRow(this)'></span></div></td>" +
			"</tr>"
		);
		
		$("[name=cashbook_date]").datepicker({
			dateFormat:"yy-mm-dd",
			changeMonth:true,
			yearRange: "2016:2017"
		});
	}
	
	function fnDelRow(e){
		var $row = $(e).parent().parent().parent();
		var targetNo = $row.contents().find(".badge").text();
		
		$row.remove();
		
		$(".badge").each(function(){
			var thisNo = $(this).text();
			if(thisNo > targetNo){
				$(this).text(thisNo-1);
			}
		});
	}
	
	$(function(){
		$("[name=cashbook_date]").datepicker({
			dateFormat:"yy-mm-dd",
			changeMonth:true,
			yearRange: "2016:2016"
		});
	})
</script>
</body>
</html>