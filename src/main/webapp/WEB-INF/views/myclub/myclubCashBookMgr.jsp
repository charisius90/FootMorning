<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
					<table>
						<tr id="sort">
							<td>
								<select id="cashbook_year" class="form-control" size="1" style="height:34px;">
									<option>2015년</option>
									<option selected>2016년</option>
								</select>
							</td>
							<td>
								<select id="cashbook_month" class="form-control" size="1">
									<option>1월</option>
									<option>2월</option>
									<option>3월</option>
									<option>4월</option>
									<option>5월</option>
									<option>6월</option>
									<option>7월</option>
									<option selected>8월</option>
									<option>9월</option>
									<option>10월</option>
									<option>11월</option>
									<option>12월</option>
								</select>
							</td>
						</tr>
					</table>
					<div style="height: 15px;"></div>
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
								<tr id="balance">
									<td><span class="badge" style="margin-top: 7px;">0</span></td>
									<td><input type="text" class="form-control" size="2" name="cashbook_date" disabled="disabled"></td>
									<td>
										<select class="form-control" size="1" name="cashbook_type" disabled>
											<option value="ADD" selected="selected">수입</option>
										</select>
									</td>
									<td><input type="text" class="form-control" size="2" name="cashbook_amount" value="0" disabled></td>
									<td><input type="text" class="form-control" size="10" name="cashbook_content" value="이월잔액" disabled></td>
									<td><input type="text" class="form-control" size="2" name="cashbook_balance" value="0" disabled></td>
								</tr>
							</thead>
							<c:forEach items="${BOOK}" var="row">
								<tr>
									<td><span class="badge" style="margin-top: 7px;">${row.cashbook_no}</span></td>
									<td><input type="text" class="form-control" size="2" name="cashbook_date" value="${row.cashbook_date}" placeholder="날짜선택" onchange="fnCalcBalance()"></td>
									<td>
										<input type="hidden" name="type" value="${row.cashbook_type}"/>
										<select class="form-control" size="1" name="cashbook_type" onchange="fnCalcBalance()">
											<option value="SUB" selected="selected">지출</option>
											<option value="ADD">수입</option>
										</select>
									</td>
									<td><input type="text" class="form-control" size="2" name="cashbook_amount" value="${row.cashbook_amount}" placeholder="금액을 입력하세요" onchange="fnCalcBalance()"></td>
									<td><input type="text" class="form-control" size="10" name="cashbook_content" value="${row.cashbook_content}" placeholder="내용을 입력하세요" onchange="fnCalcBalance()"></td>
									<td><input type="text" class="form-control" size="2" name="cashbook_balance" value="${row.cashbook_balance}" disabled></td>
									<td><span class="glyphicon glyphicon-remove" aria-hidden="true" style="cursor: pointer; margin-top: 8px;" onclick="fnDelRow(this)"></span></td>
								</tr>
							</c:forEach>
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
	
	// 모든 row 계산
	function fnCalcBalance(){
		// JSON생성용 변수 
		var dataJSON,
			dataArr = new Array(),
			data = new Object();
		
		// 필요한 모든 tr을 찾아 반복
		$("tr").not("#sort, #rhead, #balance, #addRow").each(function(i, e){
			var $row = $(e);				// 현재 row
			var $prevRow = $row.prev();		// 이전 row
			var cashbook_no = $row.contents().find(".badge").text();
			
			// 반복문을 잘못 도는 경우 cashbook_no가 없는 것을 종료시킴
			if(cashbook_no==null || cashbook_no==""){
				return;
			}
			
			// 테이블의 첫 행은 prev()가 작용하지 않다 처리하는 구문 
			if($prevRow.html() == null){
				$prevRow = $("#balance");
			}
			
			// 가장 최근 잔액
			var prevBalance = $prevRow.contents().find("[name=cashbook_balance]").val();
			// 현재 처리할 금액
			var amount = $row.contents().find("[name=cashbook_amount]").val();
			
			// 
			if(amount=="" || amount==null || isNaN(amount)){
				amount = 0;
			}
			
			// 현재 balance 계산
			var type = $row.contents().find("select[name=cashbook_type]").val();
			var result = 0;
			if(type=="ADD"){
				result = parseInt(prevBalance) + parseInt(amount);
				$row.contents().find("[name=cashbook_balance]").val(result);
			}
			else if(type=="SUB"){
				result = parseInt(prevBalance)-parseInt(amount);
				$row.contents().find("[name=cashbook_balance]").val(result);
			}
			
			alert("cashbook no : " + $row.contents().find(".badge").text());
			// json용 객체에 데이터 담기
			data.cashbook_no = cashbook_no;
			data.cashbook_date = $row.contents().find("[name=cashbook_date]").val();
			data.cashbook_type = $row.contents().find("[name=cashbook_type]").val();
			data.cashbook_content = $row.contents().find("[name=cashbook_content]").val();
			data.cashbook_amount = $row.contents().find("[name=cashbook_amount]").val();
			data.cashbook_balance = $row.contents().find("[name=cashbook_balance]").val();
			data.club_no = "${CLUB_KEY.club_no}";
			dataArr.push(data);
		});
		
		dataJSON = JSON.stringify(dataArr);
		
		$.ajax({
			url:"/myclub/myclubCashBookMgr?cmd=update",
			type:"POST",
			contentType : "application/json; charset=utf-8",
			data:dataJSON,
			success:function(data){
				console.log(data.length + "줄 갱신");
				// 돌아온 데이터로 각 row 모든 col 업데이트 하는 기능 추가하면 좋을 것 같다.
			}
		});
	}
	
	function fnAddRow(){
		var $prevBadge = $("#addRow").prev().contents().find(".badge");
		var nextNo;
		if($prevBadge.html()==null || $prevBadge.text()=="new"){
			nextNo = "new";
		}
		else{
			nextNo = parseInt($prevBadge.text()) + 1;
		}
		
		$("#addRow").before(
			"<tr>" +
				"<td><div align='center' style='padding-top: 6px;'><span class='badge'>" + nextNo + "</span></div></td>" +
				"<td><input type='text' class='form-control' size='2' name='cashbook_date' placeholder='날짜선택' onchange='fnCalcBalance()'></td>" +
				"<td><select class='form-control' name='cashbook_type' size='1' onchange='fnCalcBalance()'><option value='SUB'>지출</option><option value='ADD'>수입</option></select></td>" +
				"<td><input type='text' class='form-control' size='2' name='cashbook_amount' placeholder='금액을 입력하세요' onchange='fnCalcBalance()'></td>" +
				"<td><input type='text' class='form-control' size='10' name='cashbook_content' placeholder='내용을 입력하세요' onchange='fnCalcBalance()'></td>" +
				"<td><input type='text' class='form-control' size='2' name='cashbook_balance' value='-' disabled></td>" +
				"<td><span class='glyphicon glyphicon-remove' aria-hidden='true' style='cursor: pointer; margin-top: 8px;' onclick='fnDelRow(this)'></span></td>" +
			"</tr>"
		);
		
		$("[name=cashbook_date]").datepicker({
			dateFormat:"yy-mm-dd",
			changeMonth:true,
			yearRange: "2016:2017"
		});
		
		var dataJSON,
			dataArr = new Array(),
			data = new Object();
			data.club_no = "${CLUB_KEY.club_no}";
			dataArr.push(data);
			dataJSON = JSON.stringify(dataArr);
		// 추가할 때 마다 DB수정
		$.ajax({
			url:"/myclub/myclubCashBookMgr?cmd=add",
			type:"POST",
			contentType : "application/json; charset=utf-8",
			data:dataJSON,
			success:function(data){
				var arr_cashbook_no = data.split(" ");
			}
		});
	}
	
	function fnDelRow(e){
		var $row = $(e).parent().parent();
		var targetNo = $row.contents().find(".badge").text();
		$row.remove();
		
		$(".badge").each(function(){
			var thisNo = $(this).text();
			
			if(thisNo > targetNo){
				$(this).text(thisNo-1);
			}
		});
		
		// 제거 된 후 계산
		fnCalcBalance();
		
		// DB에서 해당 줄 삭제
		var dataJSON,
			dataArr = new Array(),
			data = new Object();
		data.cashbook_no = targetNo;
		dataArr.push(data);
		dataJSON = JSON.stringify(dataArr);
		
		$.ajax({
			url:"/myclub/myclubCashBookMgr?cmd=del",
			type:"POST",
			contentType : "application/json; charset=utf-8",
			data:dataJSON,
			success:function(data){
				console.log(data.length + "줄 제거");
			}
		});
	}
	
	$(function(){
		$("[name=type]").each(function(){
			var type = $(this).val();
			var $option = $(this).next();
			if(type=="ADD"){
				$option.val("ADD").prop("selected", true);
			}
			else if(type=="SUB"){
				$option.val("SUB").prop("selected", true);
			}
		})
		
		$("[name=cashbook_date]").datepicker({
			dateFormat:"yy-mm-dd",
			changeMonth:true,
			yearRange: "2016:2017"
		});
	})
</script>
</body>
</html>