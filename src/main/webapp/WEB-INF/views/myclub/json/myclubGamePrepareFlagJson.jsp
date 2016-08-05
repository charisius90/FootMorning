<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

{
"result":"${result }", 
"firstLineUp":[<c:forEach var="member" items="${firstLineUp }" varStatus="stat"><c:if test="${not stat.first }">,</c:if>
{"mem_no":"${member.mem_no }", 
"mem_name":"${member.mem_name }", 
"mem_backno":"${member.mem_backno }"}
</c:forEach>],
"subLineUp":[<c:forEach var="member" items="${subLineUp }" varStatus="stat"><c:if test="${not stat.first }">,</c:if>
{"mem_no":"${member.mem_no }", 
"mem_name":"${member.mem_name }", 
"mem_backno":"${member.mem_backno }"}
</c:forEach>],
"formations": ${formations},
"members" :[<c:forEach var="member" items="${members }" varStatus="stat"><c:if test="${not stat.first }">,</c:if>
{"mem_no":"${member.mem_no }", 
"mem_name":"${member.mem_name }", 
"mem_backno":"${member.mem_backno }"}
</c:forEach>]
}