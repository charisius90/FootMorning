//댓글 등록 : re_no - 부모 댓글의 번호 (null시 root댓글)
function replyBtnClick(main_notice_re_no, main_notice_no, mem_no) {
 
 var param = {};
//데이터 확인용 앨럿   
//  alert("parent : "+main_notice_re_no);
//  alert("notice_no"+main_notice_no);
//  alert("mem_no"+$("#mem_no").val());
//  alert("content"+$("#parent_text").val());
 if(main_notice_re_no == "parent"){
    param.parent_no = main_notice_re_no;
    param.main_notice_re_content = $("#parent_text").val();
    param.main_notice_no = main_notice_no;
    param.mem_no = $("#mem_no").val();
    param.main_notice_re_writer = $("#main_notice_re_writer").val();
 }else{
//       alert("자식댓글 등록");
    param.parent_no = main_notice_re_no;
    param.main_notice_re_content = $("#child_text").val();
    param.main_notice_no = main_notice_no;
    param.mem_no = $("#mem_no").val();
    param.main_notice_re_writer = $("#main_notice_re_writer").val();
    alert(param);
 }
 
//    jQueryApp플젝에 ajax03.html 참고
   $.ajax({
      type: "POST",
      url: "/club/noticeReply/register",
      data: param,
//         여기서 서블릿으로 감
      success: function(result) {
          alert(result);
          console.dir(result);
          addReplyDiv($.parseJSON(result),main_notice_re_no);
       },
       fail: function(result) {
          alert('대댓글 등록 실패:'+result);
       }
   });         
}

// 댓글 등록함수 -> 등록 눌렀을때
function addReplyDiv(data,re_no) {
 var $replyList = $("#replyListDiv");
 $replyList.text('');
 var $replyAdd = $replyList;
 var replyDiv = "";
 var replyDiv2 = "";
// list받아와서 for문돌리는 함수 호출
 for(var i=0; i<data.length; i++){
//     replyDiv = 
//        "<div class='replyDiv_"+data[i].main_notice_re_no+"'>"+
//           "<span class='mem_name'>"+setDepth(data[i].main_notice_re_depth)+data[i].mem_no+" : </span>"+
//           "<span class='rev_re_content'>"+data[i].main_notice_re_content+"</span>"+
//           "<button onclick='displayReplyDiv("+data[i].main_notice_re_no+","+data[i].main_notice_no+")'>답글</button>"+               
//           "<button onclick='removeReply("+data[i].main_notice_re_no+")'>삭제</button>"+               
//        "</div>";
       
    replyDiv2="<div class='replyDiv_"+data[i].main_notice_re_no+"'>"+
             "<span class='mem_name'>"+setDepth(data[i].main_notice_re_depth,data[i].main_notice_re_writer)+checkWriter(data[i].main_notice_re_writer)+"</span>"+
                checkWriterContent(data[i].main_notice_re_writer,data[i].main_notice_re_content)+
                "<div align='right'>"
                   +checkWriterButton(data[i].main_notice_re_writer,data[i].main_notice_re_no,data[i].main_notice_no)+
                "</div>"+
            "</div>"+
            "<hr/>";
            
    $replyAdd.prepend(replyDiv2);
 }

 $("#parent_text").val("");
}
//ajax writer조건문(작성자);
function checkWriter(writer){
 var result="";
 if(writer !='999'){
    result+=writer+":";
 }
 return result;
}
//ajax writer조건문(작성한글);
function checkWriterContent(writer,content){
 var result="";
 if(writer =='999'){
    result+="<span style='color: red' class='rev_re_content'>"+content+"</span>";
 }
 else{
    result+="<span class='rev_re_content'>"+content+"</span>";
 }
 return result;
}
//ajax writer조건문(작성자버튼);
function checkWriterButton(writer,re_no,no){
 var result="";
 if(writer != '999'){
    result= "<button class='btn btn-xs btn-primary' onclick='displayReplyDiv("+re_no+","+no+")'>답글</button>&nbsp;"+               
          "<button class='btn btn-xs btn-danger'  onclick='removeReply("+re_no+")'>삭제</button>";
 }
 else{
    result="";
 }
 return result;
}
//SET DEPTH
function setDepth(depth,writer){
 if(depth == 0){
    return "";
 }else{
    var result = "";
    for(var i=0; i<depth*3; i++){
       result +="&nbsp;&nbsp&nbsp;";
    }
    if(writer != "999"){
       result +="<img src='../../resources/images/re.gif'/>&nbsp;";
    }
 }
 return result;
}



//대댓글 입력창 닫기.
function removeReplyDiv(parent_no) {
 $('.replyDivform_'+parent_no).remove();
}
//댓글삭제
function removeReply(re_no) {

 var param = {"re_no" : re_no};
 
 //ajax 로 댓글 삭제 후
  $.ajax({
      type: 'post',
      url: '/club/noticeReply/delete',
      data: param,
//         여기서 서블릿으로 감. 아래 result는 삭제 불린 값
      success: function(result) {
         data = $.parseJSON(result);
//        alert(data.writer);
       $('.replyDiv_'+data.re_no).empty().html(setDepth(data.depth,data.writer)+"<span style='color: red'>해당  댓글은 이미 삭제되었습니다.</span>");
       },
       fail: function(result) {
          alert('ajax 통신 실패');
       }
   });         
}