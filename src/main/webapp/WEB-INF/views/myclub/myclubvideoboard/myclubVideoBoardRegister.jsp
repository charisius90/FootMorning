<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<link href="../../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../../resources/bootstrap/css/startbootstrap-simple-sidebar.css" rel="stylesheet">
<script type="text/javascript" src="/resources/SmartEditor2.8.2/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript" >
	function resize_Image(event) {
		resize_X=event.x;
		resize_Y=event.y;
		event.srcElement.width=resize_X;
		event.srcElement.height=resize_Y;
	}
	
	 function fnUploadFile () {
		 //var $fileForm = $("#fileForm");
		 	
		 var formData = new FormData();
       	 formData.append("uploadfile", $("input[name=uploadfile]")[0].files[0]);
       	 
       	 $.ajax({
       	    url: '/video/fileUpload',
       	    data: formData,
       	    processData: false,
       	    contentType: false,
       	    type: 'POST',
       	    success: function(data){
        	       data = $.parseJSON(data);
        	       console.dir(data);
        	       if(data.result) {
        	    	   alert('성공');;
        	    	   var video= '<video width="400" height="300" autoplay="autoplay"><source src="'+data.fileName+'" type="video/mp4" /></video><br />';
	  	    	      $("#videoDiv").append(video);
	  	    	    } else {
        	    	   alsert("동영상 추가가 제대로 이루어지지 않았습니다.");
        	       }
        	    }
       	  });
 	
	    }
	 
	 function submitContents() {
		 $form = $("#videoForm");
		 var video_content = $form.find('input[name=myclub_video_content]').val($("#videoDiv").html());
		 $form.append(video_content);
		 if($form.find('input[name=myclub_video_subject]').val()=="") {
			 return alert('동영상 게시판 제목을 입력하세요.')
		 }
		 if($form.find('input[name=myclub_video_content]').val()=="") {
			 return alert('동영상 업로드 해주세요.')
		 }
		 
		 $form.submit();
	 }

</script>

</head>
<body>

<%@ include file="../../include/headerRoot.jsp" %>

<div class="container-fluid">
	<div class="row">
		<div id="wrapper">
			<div>
				<%@ include file="../../include/communitysidebar.jsp" %>
			</div>
			<form id="videoForm" name="videoForm" method="post" action="/myclub/video/register">
		    <input type="hidden" name="mem_no" value="${USER_KEY.mem_no}"/>
		    <input type="hidden" name="club_no" value="${CLUB_KEY.club_no}"/>
			<div class="col-md-10">
				<div id="page-content-wrapper">
				<h1>앨범게시판-글쓰기</h1> 			
				<div class="container">
					<div class="row">
						<table class="table">
			
		                     <tr>
		                        <td>제목</td>
		                        <td><input type="text" id="myclub_video_subject" name="myclub_video_subject" /></td>
		                     </tr>
		                     <tr>
		                        <td>작성자</td>
		                        <td><input type="text" name="myclub_video_writer" value="${USER_KEY.mem_name}"/></td>
		                     </tr>
							<tr>
								<td colspan="2">동경상 미리보기</td>
							</tr>
							<tr>
								<td colspan="2">
									<div id="videoDiv">
									</div>
								</td>
							</tr>
							<tr>
								<td colspan="2">
									<input type="file" id="uploadfile" name="uploadfile" required="required"> <input id="uploadbutton" type="button" onclick="fnUploadFile()" value="게시글에 추가"/>
									<input type="hidden" name="myclub_video_content" />
								</td>
							</tr>
						</table>
					</div>
				</div>			
			</div>
			<hr/>
			
			<div align="right">
				<a href="/myclub/video/main" class="btn btn-default"><span class="glyphicon glyphicon-align-justify"></span>목록</a>
				<button type="button" class="btn btn-default" onclick="submitContents();"><span class="glyphicon glyphicon-pencil"></span>등록</button>
				<a href="/myclub/video/main" class="btn btn-default"><span class="glyphicon glyphicon-remove"></span>취소</a>
			</div>		
			</div>	
			</form>
		</div>
	</div>
</div>


<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<script src="../../resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>