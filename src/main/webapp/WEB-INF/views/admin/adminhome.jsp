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
</head>
<style>
	div .thumbnail{height:300px; background: #e6e6e6; padding:20px}
</style>
<body>
<%@ include file="../include/adminheader.jsp" %>

<div class="container" style="margin-top:20px">
	<div class="row">
	  <div class="col-md-6">
	    <div class="thumbnail">
	    	<div style="float:right">
	    		<a class="btn btn-default" role="button" href="#"><i class="glyphicon glyphicon-cog"></i>변경</a>
	      	</div>
	      	<div style="position:relative; top:50px; left:50px;">
	      		<img src="../resources/images/koala.jpg" style="width:150px; height:150px; float:left">
	      		<br/><p>&nbsp;&nbsp;&nbsp;반갑습니다. <span style="color:blue">김소영</span> 님</p><br/>
	      		<p>&nbsp;&nbsp;&nbsp;직무 : 총괄관리자</p>
			</div>
	    </div>
	  </div>
	  <div class="col-md-6">
	    <div class="thumbnail">
	    	<div style="float:right">
	    		<a class="btn btn-default" role="button" href="#">더보기<i class="glyphicon glyphicon-triangle-right"></i></a>
	      	</div>
	    	<div style="float:left">
	    		<h4>DB 업데이트</h4><br/>
	    	</div>
	      	<div style="clear: both">
	      		회원 DB 업데이트(최종 2016-07-18)&nbsp;&nbsp;<input type="button" value="실행"/><br/><br/>
	      		클럽 DB 업데이트(최종 2016-07-18)&nbsp;&nbsp;<input type="button" value="실행"/><br/><br/>
	      		매칭 DB 업데이트(최종 2016-07-18)&nbsp;&nbsp;<input type="button" value="실행"/><br/>
	      	</div>
	    </div>
	  </div>
	</div>
	<div class="row">
	  <div class="col-md-6">
	    <div class="thumbnail">
	    	<div style="float:right">
	    		<a class="btn btn-default" role="button" href="#">더보기<i class="glyphicon glyphicon-triangle-right"></i></a>
	      	</div>
	    	<div style="float:left"><h4>관리자 공지사항</h4><br/></div>
	      	<div style="clear: both"><p>공지사항이 없습니다.</p></div>
	    </div>
	  </div>
	  <div class="col-md-6">
	    <div class="thumbnail">
	    	<div style="float:right">
	    		<a class="btn btn-default" role="button" href="#">더보기<i class="glyphicon glyphicon-triangle-right"></i></a>
	      	</div>
	    	<div style="float:left"><h4>관리자 게시판</h4><br/></div>
	      	<div style="clear: both"><p>새 글이 없습니다.</p></div>
	    </div>
	  </div>
	</div>
</div>

	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="../resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>