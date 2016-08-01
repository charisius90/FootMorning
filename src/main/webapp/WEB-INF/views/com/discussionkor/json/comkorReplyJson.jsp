<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
[<c:forEach var="reply" items="${replydto }" varStatus="stat"><c:if test="${not stat.first }">,</c:if>
{"com_discussion_kor_no":"${reply.com_discussion_kor_no }", 
"mem_no":"${reply.mem_no }", 
"com_discussion_kor_re_content":"${reply.com_discussion_kor_re_content }", 
"com_discussion_kor_re_regdate":"${reply.com_discussion_kor_re_regdate }", 
"com_discussion_kor_re_pos":"${reply.com_discussion_kor_re_pos }", 
"com_discussion_kor_re_depth":"${reply.com_discussion_kor_re_depth }", 
"com_discussion_kor_re_group":"${reply.com_discussion_kor_re_group }", 
"com_discussion_kor_re_no":"${reply.com_discussion_kor_re_no }",
"com_discussion_kor_re_writer":"${reply.com_discussion_kor_re_writer}"}
</c:forEach>]