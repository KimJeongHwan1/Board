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

<script type="text/javascript">
	function button_event() {
		if (confirm("정말 삭제하시겠습니까??") == true) { //확인
			$(location).attr("href",
					"/board/delete?no=${viewBoard.no}");
		} else { //취소
			return;
		}
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
<c:if test="${viewBoard.id != null }">
<tr>
<td class="info">아이디</td><td>${viewBoard.id }</td>
<td class="info">이름</td><td>${viewBoard.name }</td>
</tr>
</c:if>
<c:if test="${viewBoard.id eq null }">
<tr>
<td class="info">닉네임</td><td>${viewBoard.nick }</td>
</tr>
</c:if>
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
	<button id="btnUpdate" class="btn btn-info" type="button" onclick="location.href='/board/delete?no=${viewboard.no }'">수정</button>
	<input type="button" id="deleteBtn" value="삭제" onclick="button_event();" class="btn btn-danger"/>
	<%-- </c:if> --%>
</div>

<c:import url="/WEB-INF/views/layout/footer.jsp" />
