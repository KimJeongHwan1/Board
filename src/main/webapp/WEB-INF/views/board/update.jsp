<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<script type="text/javascript"
 src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script type="text/javascript" src="/resources/ckeditor/ckeditor.js"></script>

<c:import url="/WEB-INF/views/tilesView/body.jsp"/>
<script type="text/javascript">
	function button_back() {
		if (confirm("정말 목록으로 돌아가시겠습니까??") == true) { //확인
			window.history.back();
		} else { //취소
			return;
		}
	}
 
	function update() {
		if (confirm("수정하시겠습니까??") == true) { //확인
			document.getElementById('update').submit();
		} else { //취소
			return;
		}
	}
</script>
<div class="container">
<br>
<div id="write_div">

<form action="/board/update.do" method="post" enctype="multipart/form-data" style="height: 100%;" id="update">
<input type="hidden" id="ojt_board_no" name="ojt_board_no" value="${viewBoard.ojt_board_no }">
<table style="width: 100%;">
<tr>
   <td style="width: 20%">작성자</td>
   <c:if test="${login }">
   <td style="width: 40%">${viewBoard.mem_name }(${viewBoard.mem_id })</td>
   </c:if>
   <c:if test="${not login }">
   <td style="width: 80%">${viewBoard.ojt_board_nick}</td>
   </c:if>
</tr>
<tr>
   <td style="width: 20%">제목</td>
   <td style="width: 80%"><input type="text" name="ojt_board_title" id="ojt_board_title" placeholder="게시물 제목" style="width: 498px;" 
   							value="${viewBoard.ojt_board_title}" required maxlength="50"/></td>
</tr>
<tr>
	<td style="width: 20%">구분</td>
	<td style="width: 80%"><c:if test="${viewBoard.ojt_board_category eq '일반' }">
							<select name="ojt_board_category">
							<option value="${viewBoard.ojt_board_category}">${viewBoard.ojt_board_category}</option>
    						<option value="공지사항">공지사항</option>
    						<option value="질문">질문</option>
    						<option value="유머">유머</option>
							</select>
						</c:if>
						<c:if test="${viewBoard.ojt_board_category eq '공지사항' }">
							<select name="ojt_board_category">
							<option value="${viewBoard.ojt_board_category}">${viewBoard.ojt_board_category}</option>
    						<option value="일반">일반</option>
    						<option value="질문">질문</option>
    						<option value="유머">유머</option>
							</select>
						</c:if><c:if test="${viewBoard.ojt_board_category eq '질문' }">
							<select name="ojt_board_category">
							<option value="${viewBoard.ojt_board_category}">${viewBoard.ojt_board_category}</option>
    						<option value="일반">일반</option>
    						<option value="공지사항">공지사항</option>
    						<option value="유머">유머</option>
							</select>
						</c:if><c:if test="${viewBoard.ojt_board_category eq '유머' }">
							<select name="ojt_board_category">
							<option value="${viewBoard.ojt_board_category}">${viewBoard.ojt_board_category}</option>
    						<option value="일반">일반</option>
    						<option value="공지사항">공지사항</option>
    						<option value="질문">질문</option>
							</select>
						</c:if>			
	</td>
</tr>
<tr>
<%-- 	<c:if test="${login }"> --%>
	<c:if test="${viewBoard.ojt_board_block eq 0 }">
   <td style="width: 20%">공개여부</td>
   <td style="width: 80%"><input type="radio" value="0" name="ojt_board_block" id="ojt_board_block" checked="checked"/>공개
   						  <input type="radio" value="1" name="ojt_board_block" id="ojt_board_block"/>비공개
   	</td>
<%--    	</c:if>
   	
	<c:if test="${viewBoard.ojt_board_block eq 1 }">
   <td style="width: 20%">공개여부</td>
   <td style="width: 80%"><input type="radio" value="0" name="ojt_board_block" id="ojt_board_block" />공개
   						  <input type="radio" value="1" name="ojt_board_block" id="ojt_board_block" checked="checked"/>비공개
   	</td>
   	</c:if> --%>
   	</c:if>
   	
   	<c:if test="${id == null }">
   	<td style="width: 20%">공개여부</td>
   	<td style="width: 80%">공개여부는 로그인 후 사용 가능합니다.</td>
   	</c:if>
   	
</tr>
<tr>
	<c:if test="${viewBoard.ojt_board_import eq 0 }">
   <td style="width: 20%">중요여부</td>
   <td style="width: 80%"><input type="radio" value="0" name="ojt_board_import" id="ojt_board_import" checked="checked"/>일반
   						  <input type="radio" value="1" name="ojt_board_import" id="ojt_board_import"/>중요
   	</td>
   	</c:if>
   	
	<c:if test="${viewBoard.ojt_board_import eq 1 }">
   <td style="width: 20%">중요여부</td>
   <td style="width: 80%"><input type="radio" value="0" name="ojt_board_import" id="ojt_board_import" >일반
   						  <input type="radio" value="1" name="ojt_board_import" id="ojt_board_import" checked="checked"//>중요
   	</td>
   	</c:if>
</tr>
<!-- <tr>
   <td>파일첨부</td>
   <td><input multiple="multiple" type="file" name="ojt_file" style="width: 498px;" /></td>
</tr> -->
<tr>
   <td>내용</td>
</tr>
<tr>
   <td colspan="2">
      <!-- <textarea  rows="20" cols="100" name="content"></textarea> -->
      <textarea class="form-control" id="editor1" name="ojt_board_content" required
      			maxlength="1000">${viewBoard.ojt_board_content }</textarea>
      <script>      
      CKEDITOR.replace('editor1' );
      </script>
      
   </td>
</tr>
</table>

<input type="button" id="insertBtn" value="작성" onclick="update();" class="btn btn-success"/>
<input type="button" id="deleteBtn" value="취소" onclick="button_back();" class="btn btn-back"/>
</form>

</div>
</div>