<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link href="../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../resources/bootstrap/css/startbootstrap-simple-sidebar.css" rel="stylesheet">
<link href="../resources/bootstrap/css/custom.css" rel="stylesheet">
<style>
	div{
		margin: 10px;
	}
	
	h5{
		display: inline;
	}
</style>
</head>
<body>
<div class="container">
	<div class="row">
		<div>
			제목 : 여기가 Q&A게시판인가요?
		</div>
		<div class="custom-textarea" style="border: 1px solid;">
			<div>
				asdfasdfkjaslkdfjklasdjlkfjaskldfjlkasdjfklasj<br/>
				asdfasdfkjaslkdfjklasdjlkfjaskldfjlkasdjfklasj<br/>
				asdfasdfkjaslkdfjklasdjlkfjaskldfjlkasdjfklasj<br/>
					
				여기는 질의 게시판의 질의 보기 입니다
			</div>
		</div>
		<div align="right">
			<h5 align="right">작성자(아이디) 님이 쓴 글</h5>&nbsp;
			<h5 align="right">작성시간 : 2016-07-20</h5>
		</div>
		
		<div>
			<textarea class="form-control" rows="10" placeholder="답변Text Area"></textarea>
		</div>
		<br/>
		<div align="right">
			<button class="btn btn-default">답변등록</button>&nbsp;&nbsp;
			<a href="" class="btn btn-default" role="button">비밀글로 등록</a>
		</div>
	</div><!-- /.row -->
</div><!-- /.container -->

<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<script src="../resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>