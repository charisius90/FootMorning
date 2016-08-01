<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
[<c:forEach var="reply" items="${replydto }" varStatus="stat"><c:if test="${not stat.first }">,</c:if>
{"com_boast_no":"${reply.com_boast_no }", 
"mem_no":"${reply.mem_no }", 
"com_boast_re_content":"${reply.com_boast_re_content }", 
"com_boast_re_regdate":"${reply.com_boast_re_regdate }", 
"com_boast_re_pos":"${reply.com_boast_re_pos }", 
"com_boast_re_depth":"${reply.com_boast_re_depth }", 
"com_boast_re_group":"${reply.com_boast_re_group }", 
"com_boast_re_no":"${reply.com_boast_re_no }",
"com_boast_reply_writer":"${reply.com_boast_reply_writer}"}
</c:forEach>]