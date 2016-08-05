<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- 부트스트랩은 모바일 우선이라서 metatag에 두항목을 추가하는데 일단은 없어도 됨 -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../resources/bootstrap/css/startbootstrap-simple-sidebar.css" rel="stylesheet">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<jsp:useBean id="now" class="java.util.Date" />
<fmt:formatDate value="${now}" pattern="yyyy-MM-dd" var="today" /> 
<style>
   .logo{
      width: 50px;
      height: 50px;
   }
   hr {
    margin-top: 5px; 
    margin-bottom: 5px;
    border: 0;
    border-top: 1px dotted #eee;
}
</style>
<script type="text/javascript">

   function fnModal(myclubNo, yourclubNo) {
      var yourclubNo = yourclubNo;
      alert(yourclubNo);

      $("#yourclubNo").val(yourclubNo);
      $('#send_invite_modal').modal('show');
   }

   function popOver(num) {
      $("#thePopover_" + num).popover({
         html : true
      });
   }

   function popOverClose(num) {
      $("#thePopover_" + num).popover('hide');
   }

   function valiChallenge(club_no, user_club_no) {

      var param = {};
      param.sander_club_no = user_club_no;
      param.receiver_club_no = club_no;
      //          param.game_no=game_no;

      $.ajax({
         type : "POST",
         url : "/challenge/register",
         data : param,
         //                 여기서 서블릿으로 감
         success : function(result) {
            alert("success");
            alert(result);
            data = $.parseJSON(result);
            //                  alert(data);
            alert(data.result);
            //팝오버제거함수
            popOverClose(club_no);
            if (data.result == "SAMENAME") {
               alert("다른회원이 이미 도전장을 보냈습니다.");
            } else if (data.result == "SAMECLUB") {
               alert("본인클럽에 도전장을 보내실 수 없습니다.");
            } else {
               fnModal(user_club_no, club_no);
            }
         },
         fail : function(result) {
            alert('실패:' + result);
         }
      });
   }

   function fnThirdModal(club_no, user_club_no) {

      //             alert(club_name);
      var param = {};
      param.sander_club_no = user_club_no;
      param.receiver_club_no = club_no;

      $.ajax({
         type : "POST",
         url : "/challenge/register",
         data : param,
         //                    여기서 서블릿으로 감
         success : function(result) {
            alert("success");
            alert(result);
            data = $.parseJSON(result);
            //                     alert(data);
            alert(data.result);
            //팝오버제거함수
            popOverClose(club_no);
            if (data.result == "SAMENAME") {
               alert("다른회원이 이미 도전장을 보냈습니다.");
            } else if (data.result == "SAMECLUB") {
               alert("본인클럽에 도전장을 보내실 수 없습니다.");
            } else {
               //open modal
               $('#send_chellenge_modal').modal('show');
               //추후에 
               $("#receiver_club_name").val(data.HOME_NAME);
               $("#sender_club_name").val(data.AWAY_NAME);
               $("#receiver_club_no").val(club_no);
            }
         },
         fail : function(result) {
            alert('실패:' + result);
         }
      });
   }
</script>
</head>
<body>
<%@ include file="../include/header.jsp" %>

<div class="container-fluid">
   <div class="row">
      <div id="wrapper">
         <div>
            <%@ include file="../include/clubsidebar.jsp" %>
         </div>
      <div id="page-content-wrapper">
         <div class="col-md-9">
         <h3>클럽</h3>
         
         <!-- 클럽 검색 -->
         <div class="row">
               <div class="">
               <form action="#">
                  <div class="scol-lg-3 form-inline" style="float: left;">
                     <select name="searchType" class="btn btn-default">
                        <option value="n" >----</option>
                        <option value="t" >클럽명</option>
                        <option value="c" >클럽장</option>
                        <option value="l" >지역</option>
                     </select>
                     <input type="text" class="form-control" name="keyword" value="" placeholder="Search"/>
                       <button id="searchBtn" class="btn btn-default" type="submit">검색</button>
                     <br/><br/><br/><br/>
                  </div><!-- /input-group -->
            </form>
               </div><!-- /.col-lg-4 -->
         </div><!-- /.row -->
         
         <!-- 클럽 정보가 들어가는 부분 -->
         <div class="row">
         <c:out value="today : ${today}"/>
            <table class="table table-hover" text-align="center">
               <!-- 상당 메뉴 부분 -->
               <thead style="background-color: #e6e6e6">
               <tr>
                  <th>NO</th><th>로고</th><th>클럽명</th><th>마스터</th><th>클럽인원</th><th>지역</th><th>클럽소개</th>
               </tr>
               </thead>
               <!-- 실제 데이터가 들어가는 부분 -->
               
               
               
               
               <c:forEach items="${list}" var="clubDTO">
                  <tr>
                     <td>${clubDTO.club_no}</td>
                     <td><a href="/myclub/myclubMain?no=${clubDTO.club_no}"><img class="logo" src="${clubDTO.club_image}" alt="LOGO 위치"/></a></td>
<%--                      <td><a href="/myclub/myclubMain?no=${clubDTO.club_no}">${clubDTO.club_name}</a></td> --%>
                     <td>
                        <a href="javascript:popOver(${clubDTO.club_no})" 
                              data-content="<a href='/myclub/myclubMain?no=${clubDTO.club_no}'>클럽페이지 가기</a>
                                       <hr>
                                       <a href='javascript:valiChallenge(${USER_KEY.club_no},${clubDTO.club_no})'>매칭 초대하기</a>
                                       <!-- 여기추가 -->
                                       <hr>
                                       <a href='javascript:fnThirdModal(${clubDTO.club_no},${USER_KEY.club_no})'>도전장 보내기</a>"
                                       
                                       id="thePopover_${clubDTO.club_no}">${clubDTO.club_name}</a>
                     </td>
<%--                      <td><a href="javascript:fnModal(${USER_KEY.club_no},${clubDTO.club_no})">${clubDTO.club_name}</a></td> --%>
                     <td><a href="#${clubDTO.club_master}">${clubDTO.club_master_name}</a></td>
                     <td>${clubDTO.club_mem_count}</td>
                     <td>${clubDTO.club_loc}</td>
                     <td>${clubDTO.club_content}</td>
                  </tr>
               </c:forEach>
               
               
               
               
            </table>
            <!-- 페이징 -->
               <nav align="center">
                  <ul id="pagingul" class="pagination">
                     <c:if test="${cpageMaker.prev}">
                        <li><a
                           href="/club/clubList${cpageMaker.makeSearch(cpageMaker.startPage - 1)}">&laquo;
                        </a>
                     </c:if>
                     
                     <c:forEach begin="${cpageMaker.startPage}"
                              end="${cpageMaker.endPage}" var="idx">
                        <li
                           <c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
                           <a href="/club/clubList${cpageMaker.makeSearch(idx)}">${idx}</a>
                        </li>
                     </c:forEach>
                        
                     <c:if test="${cpageMaker.next && cpageMaker.endPage > 0}">
                        <li><a
                           href="/club/clubList${cpageMaker.makeSearch(cpageMaker.endPage + 1)}">&raquo;</a>
                     </c:if>   
                  </ul>
               </nav>
            </div><!-- /.row -->   
         </div><!-- /.col-md-9 -->
      </div><!-- page-content-wrapper -->
      </div>
   </div><!-- /.row -->
</div><!-- /.container -->

   <div id="send_invite_modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-dialog">
         <div class="modal-content">
            <div class="modal-header">
               <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
               <h3>매치 초대하기</h3>
            </div>
            <form id="modalForm" method="post" action="/challenge/invite">
               <input type="hidden" name="yourclubNo" id="yourclubNo"/>
               <table class="table table-hover" text-align="center">
                  <thead style="background-color: #e6e6e6">
                     <tr>
                        <th>NO</th><th>날짜</th><th>시간</th><th>지역</th>
                        <th>클럽명</th><th>클럽장</th><th>실력</th><th>선택</th>
                        
                     </tr>
                  </thead>
                  <c:forEach items="${MATCH_KEY}" var="dto">
                     <tr>
                        <td>${dto.game_no}</td>
                        <td><fmt:formatDate value="${dto.game_date}" pattern="yyyy-MM-dd"/></td>
                        <td>${dto.game_time}</td>
                        <td>${dto.game_addr}</td>
                        <td>${dto.club_name}</td>
                        <td>${dto.club_master_name}</td>
                        <td><c:forEach begin="1" end="${dto.club_ability}"><i class="glyphicon glyphicon-star"></i></c:forEach></td>
                        <td><input name="checkbox" id="checkbox_${dto.game_no}" type="checkbox" value="${dto.game_no}"/></td>
                     </tr>
                  </c:forEach>
               </table>
               <textarea class="form-control" name="challenge_content" rows="5" cols="50" style="width: 100%" placeholder="한마디"></textarea>
               <div class="modal-footer">
                      <button class="btn btn-primary" type="submit">보내기</button>
                      <button class="btn" data-dismiss="modal" aria-hidden="true">취소</button>
                     </div>
                  </form>
         </div>
      </div>
   </div>
   
   
   
   
   
   
   <!-- 3번 도전장을 보내는 방식. -->
   <div id="send_chellenge_modal" class="modal fade" tabindex="-1"
      role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-dialog">
         <div class="modal-content">
            <div class="modal-header">
               <button type="button" class="close" data-dismiss="modal"
                  aria-hidden="true">×</button>
               <h3 id="myModalLabel">도전장 보내기</h3>
            </div>
<!-- form -->
            <form method="post" action="/challenge/thirdregister">
                  <input type="hidden" name="receiver_club_no" id="receiver_club_no"/>
                  <input type="hidden" name="sender_club_no" id="sender_club_no" value="${USER_KEY.club_no}"/>
                  <input type="hidden" name="game_flag" id="game_flag" value="AWAY"/>
                   <div class="modal-body">
                     <div class="container-fluid">
                        <div class="row">
                           <div class="col-md-10">
                                       날짜&nbsp;<input class="form-control" type="text" id="challengeDate" placeholder="매칭이 성사 된 이후에 설정 하실 수 있습니다." readonly="readonly" value=""/><br/>
                                                  시간&nbsp;<input class="form-control" type="text" id="challengeTime" placeholder="매칭이 성사 된 이후에 설정 하실 수 있습니다." readonly="readonly"><br/>
                                                   지역&nbsp;<input class="form-control" type="text" id="challengeAddr" placeholder="매칭이 성사 된 이후에 설정 하실 수 있습니다." readonly="readonly"><br/>
                                       HOME팀&nbsp;<input class="form-control" type="text" id="receiver_club_name" readonly="readonly"/><br/>   
                                          AWAY팀&nbsp;<input class="form-control" type="text" id="sender_club_name" readonly="readonly"/><br/>
                                          실력&nbsp;<select class="form-control" name="club_ability" style="width:170px">
                                             <option value="1">★</option>
                                             <option value="2">★★</option>
                                             <option value="3">★★★</option>
                                             <option value="4">★★★★</option>
                                             <option value="5">★★★★★</option>
                                       </select><br/>
                                    <textarea class="form-control" id="challenge_content" name="challenge_content" rows="5" cols="50" style="width: 100%" placeholder="한마디"></textarea>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="modal-footer">
                  <button class="btn btn-primary" type="submit">보내기</button>
                  <button class="btn" data-dismiss="modal" aria-hidden="true">취소</button>
               </div>
            </form>
<!-- /form -->            
         </div>
      </div>
   </div>

<!-- jQuery 플러그인을 가져옵니다. -->
<script src="../../resources/bootstrap/js/jQuery-2.1.4.min.js"></script>
<script>
   var result = '${msg}';
   
   if(result == 'SUCCESS'){
      alert("처리가 완료되었습니다.");
   }
   
   $(function(){
      $('#searchBtn').on("click", function(event) {
         // 검색옵션 값 가져오기
         var searchType = $("select[name=searchType]").val();
            
         // 키워드 값 가져오기
         var keyword = $("input[name=keyword]").val();
         
         self.location = "/club/clubList${pageMaker.makeQuery(1)}&searchType="+$("select option:selected").val() + "&keyword=" + $('#keywordInput').val();
      });
   })
</script>
<script   src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<script src="../resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>