<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
[<c:forEach var="member" items="${memberList }" varStatus="stat"><c:if test="${not stat.first }">,</c:if>
{"mem_no":"${member.mem_no }", 
"mem_name":"${member.mem_name }", 
"mem_backno":"${member.mem_backno }"}
</c:forEach>]