<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<script type="text/javascript">

function goBack(){
	window.history.back() ;
}
</script>

<h1 class="pull-left">게시판 - VIEW</h1>

<div class="clearfix"></div>
<hr>

<table class="table table-bordered">
<tr>
<td class="info">제목</td><td colspan="3">${viewBoard.title }</td>
</tr>

<tr>
<td class="info">구분</td><td colspan="3">${viewBoard.no }</td>
</tr>

<tr>
<td class="info">아이디</td><td>${viewBoard.id }</td>
<td class="info">이름</td><td>${viewBoard.name }</td>
</tr>

<tr>
<td class="info">조회수</td><td>${viewBoard.view }</td>
<td class="info">추천수</td><td id="recommend">${viewBoard.hit }</td>
</tr>

<tr>
<td class="info">작성일</td><td colspan="3"><fmt:formatDate value="${viewBoard.date }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
</tr>

<tr><td class="info"  colspan="4">본문</td></tr>

<tr><td colspan="4">${viewBoard.content }</td></tr>
</table>

<%-- <div>
<a href="/file/download?fileno=${boardFile.fileno }">${boardFile.originName }</a>
</div> --%>

<div class="text-center">	
	<button id="btnList" class="btn btn-primary" onclick="goBack();">목록</button>
	<%-- <c:if test="${userid eq viewBoard.id }"> --%>
	<button id="btnUpdate" class="btn btn-info">수정</button>
	<button id="btnDelete" class="btn btn-danger">삭제</button>
	<%-- </c:if> --%>
</div>

<c:import url="/WEB-INF/views/layout/footer.jsp" />
