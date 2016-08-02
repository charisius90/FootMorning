<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
[<c:forEach var="reply" items="${replydto }" varStatus="stat"><c:if test="${not stat.first }">,</c:if>
{"main_notice_no":"${reply.main_notice_no }", 
"mem_no":"${reply.mem_no }", 
"main_notice_re_content":"${reply.main_notice_re_content }", 
"main_notice_re_regdate":"${reply.main_notice_re_regdate }", 
"main_notice_re_pos":"${reply.main_notice_re_pos }", 
"main_notice_re_depth":"${reply.main_notice_re_depth }", 
"main_notice_re_group":"${reply.main_notice_re_group }", 
"main_notice_re_no":"${reply.main_notice_re_no }",
"main_notice_re_writer":"${reply.main_notice_re_writer}"}
</c:forEach>]