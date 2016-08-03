/**
 * formation.js
 */

//(function ($) {
//	//설정한 div에 축구장 그리기
//    $.fn.ground = function(){
//    	$("#ground").addClass("ground");
//    	$("#formation").html(	'<div id="ground" class="ground"></div>' +
//	    						'<div id="list">' +
//	    							'<div id="participate_wrapper" style="float: left;">' +
//	    								'<label for="#participate">라인업</label><br/>' +
//	    								'<select id="participate" size="20"></select>' +
//	    							'</div>' +
//	    							'<div id="member_wrapper">' +
//	    								'<label for="#member">등번호 이름</label><br/>' +
//	    								'<select id="member" size="20"></select><br/>' +
//	    								'<input type="button" value="등록" onclick="fnRegisterProc()"/>' +
//	    							'</div>' +
//	    						'</div>' +
//	    						'<form id="request" method="POST" action="test">' +
//	    							'<input type="button" value="멤버 가져오기" onclick="fnTest()"/>' +
//	    						'</form>');
//    };
//    
//}( jQuery ));

Location = function(top, left){
	this.top = top;		// 화면의 top 위치
	this.left = left;	// 화면의 left 위치
};

Location.prototype = {
	setTop: function(top){this.top = top;},
	setLeft: function(left){this.left = left;},
	getTop: function(){return this.top;},
	getLeft: function(){return this.left;}
};

Uniform = function(backnumber, name, position, location){
	this.backnumber = backnumber;	// 등번호
	this.name = name;				// 이름
	this.position = position;		// 포지션(GK, DF, MF, FW)
	this.location = location;		// 포메이션 상 위치, 유니폼 이미지의 좌측상단 꼭지점(location = new Location(top, left))
}

Uniform.prototype = {
	setBacknumber: function(backnumber){this.backnumber = backnumber;},
	setName: function(name){this.name = name;},
	setPosition: function(position){this.position = position;},
	setLocation: function(location){this.location = location;},
	getBacknumber: function(){return this.backnumber;},
	getName: function(){return this.name;},
	getPosition: function(){return this.position;},
	getLocation: function(){return this.location;}
};

//테스트용

// 등록된 선수 객체 저장 배열, 등록할 객체 인스턴스
var register_arr = new Array(),
	lineUp_arr = new Array(),
	register_instance;

var $member = $("#member");
var $firstLineUp = $("#firstLineUp");
var $subLineUp = $("#subLineUp");
var $ground = $("#ground");

// 등록할 사용자 이름, 등번호, 등록될 위치 
var name,
	backnumber,
	center_top,
	center_left;

// 유니폼 이미지 추가 시 위치 중앙 맞추는 offset
var offset = 40;

// 멤버 리스트 가져오기
function fnTest(){
	$member.html("");
	var num;
	for(var i=0; i<20; i++){
		num = i;
		if(i<10){
			num = "0" + i;
		}
		$member.append("<option id='"+num+"'>" + num + " name" + i + "</option>");
	}
}

//라인업 등록
function fnLineUpRegister(){
	var lineUpType = $(':radio[name="lineUpType"]:checked').val();
	var selectMember = $member.find('option:selected');
	selectMember.removeAttr("selected");
	if(lineUpType == "first") {
		addLineUpDoubleClick(selectMember);
		$firstLineUp.append(selectMember);
	} else {
		$subLineUp.append(selectMember);
	}
}

//라인업 제거
function fnLineUpRemove(){
	var firstMember = $firstLineUp.find('option:selected');
	var subMember = $subLineUp.find('option:selected');
	var selectMember = null;
	if(firstMember.length > 0) {
		selectMember = firstMember;
		removeLineUpDoubleClick(selectMember);
		var player = $ground.find("#player"+selectMember.attr("id"));
		if(player.length > 0) {
			player.remove();
		}
	}
	
	if(subMember.length > 0) {
		selectMember = subMember;
	}
	
	if(selectMember == null) {
		alert("제거할 선수를 선택하세요.");
		return;
	}
	$member.append(selectMember);
}

// 등록할 멤버가 이미 등록되었는지 확인하기
function isRegistered(backnumber){
	var result = false;
	for(var i=0; i<register_arr.length; i++){
		if(register_arr[i].getBacknumber() == backnumber){
			result = true;
		}
	}
	return result;
}

// 라인업에 선수 등록
//function fnRegisterProc(){
//	var backnumber = $member.find('option:selected').attr('id');
//	name = $member.val().split(" ")[1];
//	
//	if(isRegistered(backnumber)){
//		alert("이미 등록된 선수 입니다.");
//		return;
//	}
//	
//	fnLineUpRegister(backnumber, name, center_top, center_left);
//}

// 그라운드 멤버 등록
//function fnGroundRegisterProc(){
//	var pos_top = $ground.position().top,
//		pos_left = $ground.position().left,
//		off_top = $ground.height()/2,
//		off_left = $ground.width()/2;
//	
//	center_top = eval(pos_top + off_top) - offset;
//	center_left = eval(pos_left + off_left) - offset;
//	
//	var select_val = $member.val();
//	
//	backnumber = select_val.split(" ")[0];
//	name = select_val.split(" ")[1];
//	
//	if(isRegistered(backnumber)){
//		alert("이미 등록된 선수 입니다.");
//		return;
//	}
//	
//	fnRegister(backnumber, name, center_top, center_left);
//}

// 실제 등록
function fnRegister(backnumber, name, center_top, center_left){
	// 유니폼 이미지 추가
	$ground.append("<div id='player" + backnumber + "' class='uniform' style='top:" + center_top + "px; left:" + center_left + "px'><span class='backnumber'>"+backnumber+"</span></div>");
	
	// 유니폼 객체 생성하고 정보저장
	register_instance = new Uniform();
	register_instance.setBacknumber(backnumber);
	register_instance.setName(name);
	register_instance.setLocation(new Location(center_top, center_left));
	register_arr.push(register_instance);
	
	// draggable 설정
	$("#player" + backnumber).draggable({
		containment: "#ground",		// 지정된곳 안에서만 드래그 가능
		scroll: false,
		addClasses: true,
		create: function(event, ui){
			// 추가된 div 태그에 이벤트 등록
			$("#player" + backnumber).dblclick(function(){
				$("#player" + backnumber).remove();
				register_arr.splice(fnFindByBacknumber(backnumber));
			});
		},
		start: function(event, ui){
			console.log("drag start!!!");
		},
		drag: function(event, ui){
			console.log("dragging!!!");
		},
		stop: function(event, ui){
			console.log("drag stop!!! left: " + $("#player"+backnumber).position().left + ", top: " + $("#player"+backnumber).position().top + ", test : " + $(this).position().top);
			var loc = register_instance.getLocation();
			loc.setTop($(this).position().top);
			loc.setLeft($(this).position().left);
		}
	});
	
	// 다음에 추가될 div 위치 변경
	offset -= 10;
}

// 등번호로 등록된 객체 인덱스 찾기
function fnFindByBacknumber(backnumber){
	for(var i=0; i<register_arr.length; i++){
		if(register_arr[i].getBacknumber() == backnumber){
			return i;
		}
	}
}

//멤버 제거
function fnDelete(backnumber){
	$member.find("#"+backnumber).remove();
	
}

// 선발이 선택될 경우 후보선수 셀렉트 박스 체크된 사항 지움.
function fnFirstLineUpSelect() {
	$subLineUp.find("option:selected").removeAttr("selected");
}

// 후보가 선택될 경우, 선발 셀렉트 박스에 체크된 사항 지움
function fnSubLineUpSelect() {
	$firstLineUp.find("option:selected").removeAttr("selected");
}

// 선발 더블 클릭시 - ground에 선발 등록
function addLineUpDoubleClick(selectMember) {
	selectMember.on("dblclick", function () {
		fnLineUpGroundRegister(selectMember);
	});
}

//그라운드 멤버 등록
function fnLineUpGroundRegister(selectMember){
	var pos_top = $ground.position().top,
		pos_left = $ground.position().left,
		off_top = $ground.height()/2,
		off_left = $ground.width()/2;
	
	center_top = eval(pos_top + off_top) - offset;
	center_left = eval(pos_left + off_left) - offset;
	
	backnumber = selectMember.attr("id");
	name = selectMember.val().split(" ")[1];
	
	if(isRegistered(backnumber)){
		alert("이미 등록된 선수 입니다.");
		return;
	}
	
	fnRegister(backnumber, name, center_top, center_left);
}

// 선발 제거시 더블 클릭 등록 이벤트 off
function removeLineUpDoubleClick(selectMember){
	selectMember.off("dblclick");
}

// 창닫기
function fnClose(backnumber){
	$("#popover" + backnumber).hide();
}
