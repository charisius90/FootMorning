<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link href="../../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../../resources/bootstrap/css/startbootstrap-simple-sidebar.css" rel="stylesheet">
<script type="text/javascript" src="/resources/SmartEditor2.8.2/js/HuskyEZCreator.js" charset="utf-8"></script>
</head>
<body>

<%@ include file="../../include/headerRoot.jsp" %>

<div class="container-fluid">
   <div class="row">
      <div id="wrapper">
         <div>
            <%@ include file="../../include/communitysidebar.jsp" %>
         </div>
         <form name="f1" method="post" action="/myclub/notice/update">
   		 <input type='hidden' name='myclub_notice_no' value="${dto.myclub_notice_no}">
         <div class="col-md-10">
            <div id="page-content-wrapper">
            <h1>클럽공지-수정하기</h1>          
            <br/><br/>
            
            <!-- 글쓰는 부분 -->
            <div class="container">
               <div class="row">
                  <table class="table">
                     <tr>
                        <td>제목</td>
                        <td><input type="text" id="myclub_notice_subject" name="myclub_notice_subject" value="${dto.myclub_notice_subject}"/></td>
                     </tr>
                     <tr>
                        <td>작성자</td>
                        <td><input type="text"  value="${dto.mem_no}"/></td>
                     </tr>
                     <tr>
                        <td>내용</td>
                        <td><textarea rows="10" cols="100" id="ir1" name="myclub_notice_content">${dto.myclub_notice_content}</textarea>
						<script type="text/javascript">
									var oEditors = [];

									// 추가 글꼴 목록
									//var aAdditionalFontSet = [["MS UI Gothic", "MS UI Gothic"], ["Comic Sans MS", "Comic Sans MS"],["TEST","TEST"]];

									nhn.husky.EZCreator
											.createInIFrame({
												oAppRef : oEditors,
												elPlaceHolder : "ir1",
												sSkinURI : "/resources/SmartEditor2.8.2/SmartEditor2Skin.html",
												htParams : {
													bUseToolbar : true, // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
													bUseVerticalResizer : true, // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
													bUseModeChanger : false, // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
													//aAdditionalFontList : aAdditionalFontSet,		// 추가 글꼴 목록
													fOnBeforeUnload : function() {
														alert("완료!");
													}
												}, //boolean
												fOnAppLoad : function() {
													//예제 코드
// 													oEditors.getById["ir1"]
// 															.exec(
// 																	"PASTE_HTML",
// 																	[ "로딩이 완료된 후에 본문에 삽입되는 text입니다." ]);
												},
												fCreator : "createSEditor2"
											});
									
									function pasteHTML() {
										var sHTML = "<span style='color:#FF0000;'>이미지도 같은 방식으로 삽입합니다.<\/span>";
										oEditors.getById["ir1"].exec("PASTE_HTML", [ sHTML ]);
									}
									
									function showHTML() {
										var sHTML = oEditors.getById["ir1"].getIR();
										alert(sHTML);
									}
									
									function submitContents(elClickedObj) {
										oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []); // 에디터의 내용이 textarea에 적용됩니다.

// 										에디터의 내용에 대한 값 검증은 이곳에서 document.getElementById("ir1").value를 이용해서 처리하면 됩니다.
										try {
											elClickedObj.form.submit();
										} catch (e) {
											alert("수정 실패" + e)
										}
									}

									function setDefaultFont() {
										var sDefaultFont = '궁서';
										var nFontSize = 24;
										oEditors.getById["ir1"].setDefaultFont(
												sDefaultFont, nFontSize);
									}
								</script></td>
                     </tr>
                  </table>
               </div>
            </div>
            <hr/>
            
            <div align="right">
               <button type="button" class="btn btn-default" onclick="submitContents(this);"><span class="glyphicon glyphicon-align-justify"></span>등록</button>
               <a href="/myclub/notice/main" class="btn btn-default"><span class="glyphicon glyphicon-remove"></span>목록</a>
            </div>      
            </div>
         </div>   
      </form>
      </div>
   </div>
</div>


<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
<script   src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<script src="../../resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>