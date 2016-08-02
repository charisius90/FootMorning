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
	.thumbnail{padding-top:25px; padding-left:25px; padding-right:25px; padding-bottom: 0px}
	.thumbnail img{background: #e6e6e6;}
	p >a{margin-top:10px}
</style>
<body>
<%@ include file="../include/adminheader.jsp" %>

	<div class="container" style="margin-top: 20px">
		<h3>현재 배너</h3>
		<div class="row">
			<div class="col-md-12">
				<div class="thumbnail">
					<span id="bannerImgSpan" style="cursor: pointer; cursor: hand;">
						<img src="../resources/images/banner.jpg"
						style="width: 100%; height: 200px;">
					</span>
					<div align="center" style="vertical-align: middle">
						<p>
							<a href="#" class="btn btn-primary" role="button">등록</a>
						</p>
					</div>
				</div>
			</div>
		</div>
		<h3>현재 메인 이미지</h3>
		<div class="row">
			<div class="col-md-12">
				<div class="thumbnail">
					<span id="mainImgSpan" style="cursor: pointer; cursor: hand;">
						<img src="" style="width: 100%; height: 200px">
					</span>
					<div align="center">
						<p>
							<a href="#" class="btn btn-primary" role="button">등록</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="../resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>