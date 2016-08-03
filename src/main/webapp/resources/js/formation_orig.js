/**
 * formation.js
 */

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

Uniform = function(seq, no, name, position, location){
	this.seq = seq;				// 포메이션 상 순서 (그림에서, GK(시작:0)부터 FW(끝:(총인원-1))까지 넘어가며 아래로 내려가면서 번호 증가)
	this.no = no;				// 등번호
	this.name = name;			// 이름
	this.position = position;	// 포지션(GK, DF, MF, FW)
	this.location = location;	// 포메이션 상 위치, 유니폼 이미지의 좌측상단 꼭지점(location = new Location(top, left))
}

Uniform.prototype = {
	setSeq: function(seq){this.seq = seq;},
	setNo: function(no){this.no = no;},
	setName: function(name){this.name = name;},
	setPosition: function(position){this.position = position;},
	setLocation: function(location){this.location = location;},
	getSeq: function(){return this.seq;},
	getNo: function(){return this.no;},
	getName: function(){return this.name;},
	getPosition: function(){return this.position;},
	getLocation: function(){return this.location;}
};

var uniform_arr = []; // 유니폼 인스턴스 저장 배열

var numOfPlayers,	// 게임 인원수
	formationNo;	// 포메이션 번호

// 
function initUniform(i, pos, top, left){
	uniform_arr.push(new Uniform());
	uniform_arr[i].setSeq(i);
	uniform_arr[i].setPosition(pos);
	uniform_arr[i].setLocation(new Location(top, left));
	
	// ground div에 유니폼 image 추가
	$("#ground").append("<img id='player" + i + "' class='uniform' src='/images/uniform.png' style='top:" + top + "px; left:" + left + "px'/>");
	
	// 추가된 img태그에 이벤트 등록
	$("#player"+i).click(function(){
		var uni = uniform_arr[i];
		console.log(uni.getPosition() + "]" + uni.getSeq() + ", left:" + uni.getLocation().getLeft() + ", top:" + uni.getLocation().getTop());
		// 선수등록 코드 위치
	});
}

// 선택한 포메이션 대로 uniform ground에 뿌려주는 함수
function setFormation(numOfPlayers, formation){
	// 포워드, 미드필더, 디펜더 인원수
	var df = parseInt(formation / 100);
	var mf = parseInt((formation%100) / 10);
	var fw = formation % 10;
	
	// 축구장 지정 div 위치
	var $ground = $("#ground"),
		$ground_position = $ground.position(),
		$ground_top = $ground_position.top,
		$ground_left = $ground_position.left,
		$ground_width = $ground.width(),
		$ground_height = $ground.height();
	
	// 포메이션 출력 시 선수간 거리
	var gap_left = $ground_width/4,
		gap_top = 0;
	
	
	// 출력될 유니폼 정보, 위치
	var param_pos, param_top, param_left;
	var offset = 30; // 상단 여백 조정
	
	// 이전에 그려진 포메이션 제거
	$ground.html("");
	
	for(var i=0; i<numOfPlayers; i++){
		if(i == 0){
			param_pos = "GK";
			param_top = eval($ground_top + $ground_height/2 - offset);
			param_left = eval($ground_left + 50);
		}
		else if(i <= df){
			param_pos = "DF";
			if(i == 1){
				param_top = $ground_top - offset;
				gap_top = $ground_height / eval(df+1);
				param_left = $ground_left + gap_left;
			}
			param_top += gap_top;
		}
		else if(i <= (df+mf)){
			param_pos = "MF";
			if(i == (df+1)){
				param_top = $ground_top - offset;
				gap_top = $ground_height / eval(mf+1);
				param_left += gap_left;
			}
			param_top += gap_top;
		}
		else if(i <= (df+mf+fw)){
			param_pos = "FW";
			if(i == (df+mf+1)){
				param_top = $ground_top - offset;
				gap_top = $ground_height / eval(fw+1);
				param_left += gap_left;
			}
			param_top += gap_top;
		}
		
		initUniform(i, param_pos, param_top, param_left);
	}
}

(function ($) {
	
	// 설정한 select위치에 태그 추가 및 포메이션 이벤트 등록
	$.fn.select = function(){
		var $select = $("#select");
		$select.html("<div id='players_div' class='player_select'>" +
				"<span id='players_span'>인원</span>" +
				"<select id='players'>" +
				"<option value='11' selected>11명</option>" +
				"<option value='10'>10명</option>" +
				"<option value='9'> 9명</option>" +
				"</select>" +
				"</div>" +
				"<div id='formations_div' class='formation_select'>" +
				"<span id='formations_span'>포메이션</span>" +
				"<select id='formations'>" +
				"<option value='451'>4-5-1</option>" +
				"<option value='442' selected>4-4-2</option>" +
				"<option value='433'>4-3-3</option>" +
				"<option value='352'>3-5-2</option>" +
				"</select>" +
				"</div>");
		
		// select태그가 default 값일 경우 ground에 uniform 뿌려줌
		numOfPlayers = $("#players").val();
		setFormation(numOfPlayers, $("#formations").val());
		
		// 인원 변경 시의 이벤트 설정
		$("#players").change(function(){
			var players = $("#players").val();
			var $formations = $("#formations");
			switch(players){
				case "11":
					numOfPlayers = 11;
					$formations.html(
							"<option value='451'>4-5-1</option>" +
							"<option value='442' selected>4-4-2</option>" +
							"<option value='433'>4-3-3</option>" +
							"<option value='352'>3-5-2</option>" +
							"<option value='343'>3-4-3</option>");
					break;
				case "10":
					numOfPlayers = 10;
					$formations.html(
							"<option value='441'>4-4-1</option>" +
							"<option value='432'>4-3-2</option>" +
							"<option value='423'>4-2-3</option>" +
							"<option value='342' selected>3-4-2</option>" +
							"<option value='333'>3-3-3</option>");
					break;
				case "9":
					numOfPlayers = 9;
					$formations.html(
							"<option value='341'>3-4-1</option>" +
							"<option value='332' selected>3-3-2</option>" +
							"<option value='323'>3-2-3</option>" +
							"<option value='342'>3-4-2</option>" +
							"<option value='333'>3-3-3</option>");
					break;
			};
			setFormation(numOfPlayers, $("#formations").val());
		});
		
		// 포메이션 변경 시의 이벤트 설정
		$("#formations").change(function(){
			setFormation(numOfPlayers, $("#formations").val());
		});
	};
	
	//설정한 div에 축구장 그리기
    $.fn.ground = function(){
    	$("#ground").addClass("ground");
    };
    
}( jQuery ));