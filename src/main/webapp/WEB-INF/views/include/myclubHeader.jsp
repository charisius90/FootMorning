<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<a class="btn btn-default" role="button" href="/myclub/myclubMain?no=${CLUB_KEY.club_no}"><i class="glyphicon glyphicon-home"></i>홈</a>
<c:if test="${USER_KEY.club_no==CLUB_KEY.club_no && USER_KEY.mem_grade<3}">
	<a class="btn btn-default" role="button" href="/myclubMgr/myclubMgrInfo"><i class="glyphicon glyphicon-cog"></i>관리</a>
</c:if>
</body>
</html>