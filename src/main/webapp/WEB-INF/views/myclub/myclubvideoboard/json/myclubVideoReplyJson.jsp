<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
[<c:forEach var="reply" items="${replydto }" varStatus="stat"><c:if test="${not stat.first }">,</c:if>
{"myclub_video_no":"${reply.myclub_video_no }", 
"mem_no":"${reply.mem_no }", 
"myclub_video_re_content":"${reply.myclub_video_re_content }", 
"myclub_video_re_regdate":"${reply.myclub_video_re_regdate }", 
"myclub_video_re_pos":"${reply.myclub_video_re_pos }", 
"myclub_video_re_depth":"${reply.myclub_video_re_depth }", 
"myclub_video_re_group":"${reply.myclub_video_re_group }", 
"myclub_video_re_no":"${reply.myclub_video_re_no }",
"myclub_video_re_writer":"${reply.myclub_video_re_writer}"}
</c:forEach>]