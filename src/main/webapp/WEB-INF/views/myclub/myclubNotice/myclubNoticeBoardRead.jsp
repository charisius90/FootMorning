<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link href="../../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../../resources/bootstrap/css/startbootstrap-simple-sidebar.css" rel="stylesheet">
<script type="text/javascript" src="../../resources/reply_js/myclubNoticeReply.js" charset="utf-8"></script>
<style>
hr {
    margin-top: 0px; 
    margin-bottom: 5px;
    border: 0;
    border-top: 1px dotted #eee;
}
</style>
<script>
//   대댓글 입력창 -> 답글 눌렀을때
function displayReplyDiv(parent_no, rev_no) {
	alert(parent_no);
   var $replyList = $("#replyListDiv");
   var replyDiv2 = "<div class='replyDivform_"+parent_no+"'>"+
                  "<form method='post' action='/myclub/noticeReply/register'>댓글"+
                      "<input type='hidden' id='myclub_notice_no' name='myclub_notice_no' value='${dto.myclub_notice_no}'>"+
                     "<input type='hidden' id='mem_no' name='mem_no' value='${USER_KEY.mem_no}'"+
                     "<input type='hidden' id='myclub_notice_re_writer' name='myclub_notice_re_writer' value='${USER_KEY.mem_name}'>"+
                      "<div class='row-fluid'>"+
                         "<textarea id='child_text' name='myclub_notice_re_content' class='col-md-12' rows='5'></textarea>"+
                      "</div>"+
                      "<div align='right'>"+
                         "<input class='btn btn-default' type='button'  onclick='replyBtnClick("+parent_no+","+rev_no+")' value='등록'/>"+
                         "<input class='btn btn-default' type='button'  onclick='removeReplyDiv("+parent_no+")' value='취소'/>"+
                      "</div>"+
                   "</form>"+
                "</div>"
   alert(replyDiv2);
   $replyList.find('.replyDiv_'+parent_no).append(replyDiv2);
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
         <div class="col-md-10">
            <div id="page-content-wrapper">
            <h1>공지사항</h1>          
            <br/><br/>
               
            <!-- 게시글 읽는 부분 -->
            <div class="container">
               <div class="row">
                  <table class="table">
                     <tr align="center">
                        <td style="width: 8%;" bgcolor="F7F7F7" valign="middle">제목</td>
                        <td style="width: 50%;" colspan="8">${dto.myclub_notice_subject}</td>
                     </tr>
                     <tr align="center">
                      	<td style="width: 8%" bgcolor="F7F7F7">글번호</td>
                     	<td style="width: 8%" colspan="1">${dto.myclub_notice_no}</td>
                        <td style="width: 8%" bgcolor="F7F7F7">조회수</td>
                        <td style="width: 8%">${dto.myclub_notice_count}</td>
                     </tr>
                     <tr align="center">
                        <td bgcolor="F7F7F7">작성자</td>
                        <td colspan="1">${dto.myclub_notice_writer}</td>
                        <td bgcolor="F7F7F7">등록일</td>
                        <td>${dto.myclub_notice_regdate}</td>
                     </tr>
                     <tr style="border-left: none; border-right: none;">
                         <td colspan="10" class="col-sm-5" style="text-align: left;">${dto.myclub_notice_content}</td>
                     </tr>
                  </table>
                  <br/>
                              <!-- 댓글 보이는 부분 -->
            <div id="replyListDiv">
                     <!--
                      역순으로 출력하기 위해서 리스트의 길이를 알아옴 
                     전체리스트의 길이에서 status를 빼주면서 반복   
                      -->
               <c:set var="listlength" value="${fn:length(replydto)}"/>
               <c:forEach  items="${replydto}" var="replylist" varStatus="status">
                  <div class='replyDiv_${replydto[listlength-status.count].myclub_notice_re_no}'>
                     <span class='mem_name'>
                        <c:if test="${replydto[listlength-status.count].myclub_notice_re_depth > 0}">
                           <c:forEach begin="0" end="${replydto[listlength-status.count].myclub_notice_re_depth}" step="1">
                              <!-- 들여쓰기 -->
                              &nbsp;&nbsp;&nbsp;
                           </c:forEach>
                           <c:if test="${replydto[listlength-status.count].myclub_notice_re_writer != '999'}">
                              <img src='../../resources/images/re.gif'/>
                           </c:if>
                        </c:if>
                        <c:if test="${replydto[listlength-status.count].myclub_notice_re_writer != '999'}">
                           <!-- re이미지 -->
                           <!-- 이름이 들어갈곳 -->
                        ${replydto[listlength-status.count].myclub_notice_re_writer}:</c:if>
                     </span>
                     <c:if test="${replydto[listlength-status.count].myclub_notice_re_writer == '999'}">      
                        <span style="color: red" class='rev_re_content'>${replydto[listlength-status.count].myclub_notice_re_content}</span>
                     </c:if>
                     <c:if test="${replydto[listlength-status.count].myclub_notice_re_writer != '999'}">      
                        <span class='rev_re_content'>${replydto[listlength-status.count].myclub_notice_re_content}</span>
                     </c:if>
                     <c:if test="${replydto[listlength-status.count].myclub_notice_re_writer != '999'}">
                        <!-- 버튼 -->
                        <div align="right">
                           <button class="btn btn-xs btn-primary" onclick='displayReplyDiv(${replydto[listlength-status.count].myclub_notice_re_no},${replydto[listlength-status.count].myclub_notice_no})'>답글</button>               
                           <button class="btn btn-xs btn-danger"  onclick='removeReply(${replydto[listlength-status.count].myclub_notice_re_no})'>삭제</button>
                        </div>
                     </c:if>   
                  </div>
                  <hr/>
               </c:forEach>
            </div>               
               <br/>
               <!-- 댓글 다는 부분 -->
                  <div id="firstReply">
                     <form method="post" action="/myclub/noticeReply/register">댓글
                        <input type="hidden" id="myclub_notice_no" name="myclub_notice_no" value="${dto.myclub_notice_no}">
                        <input type="hidden" id="mem_no" name="mem_no" value="${USER_KEY.mem_no}">
                        <input type="hidden" id="myclub_notice_re_writer" name="myclub_notice_re_writer" value="${USER_KEY.mem_name}">
                        <div class="row-fluid">
                           <textarea id="parent_text" name="myclub_notice_re_content" class="col-md-12" rows="5"></textarea>
                        </div>
                        <div align="right">
                           <input class="btn btn-default" type="button"  onclick="replyBtnClick('parent',${dto.myclub_notice_no})" value="등록"/>
                        </div>
                     </form>
                  </div>
                  
               </div><!-- /row -->
            </div>
            
            <br/>
            <hr/>
            <br/>
            
               <div align="right">
                  <a href="/myclub/notice/main" class="btn btn-default"><span class="glyphicon glyphicon-align-justify"></span>목록</a>
                  <a href="/myclub/notice/update?myclub_notice_no=${dto.myclub_notice_no}" class="btn btn-default"><span class="glyphicon glyphicon-pencil"></span>수정</a>
                  <a href="/myclub/notice/delete?myclub_notice_no=${dto.myclub_notice_no}" class="btn btn-default"><span class="glyphicon glyphicon-remove"></span>삭제</a>
               </div>         
            </div>
         </div>
      </div>
   </div>
</div>

<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
<script   src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<script src="../../resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>