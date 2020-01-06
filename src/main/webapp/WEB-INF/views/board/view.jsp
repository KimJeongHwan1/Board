<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<script type="text/javascript"
 src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
<!-- Bootstrap 3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>


<c:import url="/WEB-INF/views/tilesView/body.jsp"/>


<script type="text/javascript">
$(document).ready(function() {
	
/* 	$("#btnUpdate").click(function(){
		var pw = prompt( "비밀번호를 입력해주세요" + "" );
		console.log(pw);
	}); */
/* 	$("#btnUpdate").click(function(){
		$(location).attr("href",
		"/board/update.do?ojt_board_no=${viewBoard.ojt_board_no}");
	}); */
	
	$("#rec_btn").click(function(){
		
		$.ajax({
			type:"get"
			, url: "/board/rec/recommend.do?ojt_board_no=${viewBoard.ojt_board_no}"
			, data: { }
			, dataType: "html"
			, success: function( res ) {
				$("#recommend").html( res );
				console.log("성공");
			}
			, error: function() {
				console.log("실패");
			}
		})
		
		$.ajax({
			type: "get"
			, url: "/board/rec/recBtn.do?ojt_board_no=${viewBoard.ojt_board_no}"
			, data: { }
			, dataType: "html"
			, success: function( res ) {
				$("#rec_btn").html( res );
				console.log("성공");
				console.log( res );
			}
			, error: function() {
				console.log("실패");
			}
		})
	});
});

	function goBack() {
		window.history.back();
	}

/* 	function button_event() {
		if (confirm("정말 삭제하시겠습니까??") == true) { //확인
			$(location).attr("href",
					"/board/delete.do?ojt_board_no=${viewBoard.ojt_board_no}");
		} else { //취소
			return;
		} */
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
<td class="info">구분</td><td colspan="3">${viewBoard.ojt_board_category }</td>
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
<td class="info">추천수</td><td><span id="recommend">${rec_no }</span></td>

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


<table>
<tr>
<th>첨부파일</th>
</tr>
<c:forEach items="${boardFileDto }" var="boardFileDto">
<tr>
<td><a href="/board/down/file.do?file_no=${boardFileDto.file_no}">${boardFileDto.file_stored_name }</a></td>
</tr>
</c:forEach>
</table>

<div class="text-center">	
	<button id="btnList" class="btn btn-primary" onclick="goBack();">목록</button>
<c:if test="${loginid eq viewBoard.mem_id }"> 
	<!-- <button id="btnUpdate" class="btn btn-info" type="button" onclick=>수정</button> -->
<button id="btnUpdate" class="btn btn-info" type="button" onclick="location.href='/board/pwViewCheck.do?ojt_board_no=${viewBoard.ojt_board_no}'">수정</button>
	<input type="button" id="deleteBtn" value="삭제" onclick="location.href='/board/pwDelCheck.do?ojt_board_no=${viewBoard.ojt_board_no}'" class="btn btn-danger"/>
</c:if>

<c:if test="${login }">
<c:if test="${recCheck == 1}">
	<button type="button" id="rec_btn" class="btn btn-primary" ><span class="glyphicon glyphicon-star"></span></button>
</c:if>

<c:if test="${recCheck == 0}">
	<button type="button" id="rec_btn" class="btn btn-primary" ><span class="glyphicon glyphicon-star-empty"></span></button>
</c:if>
</c:if>

	</div>
</div>
