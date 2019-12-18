<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<br>
<div style="text-align: center;">

 <!-- 비로그인상태 -->
<c:if test="${not login }">
<strong>환영합니다</strong><br>
<button onclick='location.href="/member/login.do";'>로그인</button>
<button onclick='location.href="/member/join.do";'>회원가입</button><br>
<a href="/board/list.do">비로그인 진입</a>
</c:if>

<!-- 로그인상태 -->
<c:if test="${login }">
<strong><c:if test="${admin eq 1}">관리자 :: </c:if>${name } 님, 환영합니다</strong><br>
<button onclick='location.href="/board/list.do";'>게시판 가기</button>
<button onclick='location.href="/member/logout.do";'>로그아웃</button>
</c:if>
</div> 


