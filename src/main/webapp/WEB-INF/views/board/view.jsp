<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!-- Bootstrap 3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>



<c:import url="/WEB-INF/views/tilesView/body.jsp"/>

<script type="text/javascript"
 src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript">

function goBack(){
	window.history.back() ;
}
</script>

<script type="text/javascript">
	function button_event() {
		if (confirm("정말 삭제하시겠습니까??") == true) { //확인
			$(location).attr("href",
					"/board/delete.do?ojt_board_no=${viewBoard.ojt_board_no}");
		} else { //취소
			return;
		}
	}

</script>

<div class="container">

<h1 class="pull-left">게시판 - VIEW</h1>


<div class="clearfix"></div>
<hr>

<table class="table table-bordered">

<tr>
<td class="info">제목</td><td colspan="3">${viewBoard.ojt_board_title }</td>
</tr>
<tr>
<td class="info">구분</td><td colspan="3">${viewBoard.ojt_board_no }</td>
</tr>
<c:if test="${viewBoard.mem_id != null }">
<tr>
<td class="info">아이디</td><td>${viewBoard.mem_id }</td>
<td class="info">이름</td><td>${viewBoard.mem_name }</td>
</tr>
</c:if>
<c:if test="${viewBoard.mem_id eq null }">
<tr>
<td class="info">닉네임</td><td>${viewBoard.ojt_board_nick }</td>
</tr>
</c:if>
<tr>
<td class="info">조회수</td><td>${viewBoard.ojt_board_hit }</td>
<td class="info">추천수</td><td id="recommend">${viewBoard.ojt_board_recommend }</td>

</tr>

<tr>
<td class="info">작성일</td><td colspan="3">${viewBoard.last_date }</td>
</tr>

<tr><td class="info"  colspan="4">본문</td></tr>

<tr><td colspan="4">${viewBoard.ojt_board_content }</td></tr>
</table>
<%-- <div>
<a href="/file/download?fileno=${boardFile.fileno }">${boardFile.originName }</a>
</div> --%>

<div class="text-center">	
	<button id="btnList" class="btn btn-primary" onclick="goBack();">목록</button>
	<%-- <c:if test="${userid eq viewBoard.id }"> --%>
	<button id="btnUpdate" class="btn btn-info" type="button" onclick="location.href='/board/update.do?ojt_board_no=${viewBoard.ojt_board_no }'">수정</button>
	<input type="button" id="deleteBtn" value="삭제" onclick="button_event();" class="btn btn-danger"/>

		<c:if test="${login }">
			<button id="btnRecommend" class="btn pull-right"
				style="margin-top: 30px;"></button>
		</c:if>
		<%-- </c:if> --%>
</div>
</div>
