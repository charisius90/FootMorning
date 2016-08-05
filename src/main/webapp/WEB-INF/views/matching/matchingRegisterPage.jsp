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
<link href="../resources/bootstrap/css/startbootstrap-simple-sidebar.css" rel="stylesheet">
<link href="/resources/css/jquery.timepicker.css" rel="stylesheet">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">

<style>
   #register_table{height:200px;}
</style>
</head>
<body>
<%@ include file="../include/header.jsp" %>

<div class="container-fluid">
   <div class="row">
      <div id="wrapper">
         <div>
            <%@ include file="../include/clubsidebar.jsp"%>
         </div>
         <div id="page-content-wrapper">
            <div class="col-md-9" align="center">
               <h3>매칭 등록하기</h3>
               <br />
               <div
                  style="width: 500px; border: 1px solid gray; padding: 30px; border-radius: 10px"
                  align="center">



                  <form method="post" action="/matching/register">
                     <input type="hidden" name="club_no" value="${USER_KEY.club_no}">
                     <input type="hidden" name=game_flag value="HOME">
                     <table id="register_table">
                        <tr>
                           <td style="width: 50px">날 짜</td>
                           <td><input class="form-control" type="text" name="game_date" /></td>
                        </tr>
                        <tr>
                           <td>시 간</td>
                           <td><input class="form-control" type="text" name="game_time" /></td>
                        </tr>
                        <tr>
                           <td>지 역</td>
                           <td><input class="form-control" type="text" name="game_addr" />&nbsp;&nbsp;</td>
                              <!-- 현재 검색기능은 제외 -->
<!--                            <td><input class="form-control" type="text" name="game_addr" />&nbsp;&nbsp; <input -->
<!--                               type="button" value="검색"></td> -->
                        </tr>
                        <tr>
                           <td>실 력</td>
                           <td><select class="form-control" name="club_ability" style="width: 170px">
                                 <option value="1">★</option>
                                 <option value="2">★★</option>
                                 <option value="3">★★★</option>
                                 <option value="4">★★★★</option>
                                 <option value="5">★★★★★</option>
                           </select></td>
                        </tr>
                     </table>
                     <div style="margin-top: 20px">
                        <button class="btn btn-primary" type="submit">등록</button>
                        &nbsp;&nbsp;&nbsp;
                        <!--                      <button class="btn btn-danger" data-dismiss="modal" aria-hidden="true">취소</button> -->
                     </div>
                  </form>



               </div>
            </div>
         </div>
      </div>
   </div>
</div>
<script src="../resources/bootstrap/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
<script src="/resources/js/jquery.timepicker.js"></script>
<script>
   //데이트피커 연결
   var date = $("[name=game_date]").datepicker({
      dateFormat:"yy/mm/dd",
      changeMonth:true,
      changeYear:true
//       yearRange: "2016"
   });
   
   var time = $('[name=game_time]').timepicker({
       'minTime': '06:00am',
       'maxTime': '16:30pm',
       'showDuration': true
   });
   </script>
</body>
</html>