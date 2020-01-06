<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<script type="text/javascript"
 src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
<!-- include libraries(jQuery, bootstrap) -->
<!-- Bootstrap 3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
 
<c:import url="/WEB-INF/views/tilesView/body.jsp"/>
<script type="text/javascript" src="/resources/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="/resources/ckeditor/plugins/wordcount/plugin.js"></script>

<script type="text/javascript">
	function button_back() {
		if (confirm("정말 목록으로 돌아가시겠습니까??") == true) { //확인
			window.history.back();
		} else { //취소
			return;
		}
	}

	function insert() {
		if (confirm("등록하시겠습니까??") == true) { //확인
			document.getElementById('write').submit();
		} else { //취소
			return;
		} 
		/* var f = document.writeForm;
		var content = f.ckeditor.value;
		alert(content); */
	}
	
	function patternChk() {
		var patternChk_nick_pw = document.getElementById('ojt_board_nick_pw');
		var blank_pattern = /[\s]/g;
		
		if( blank_pattern.test( patternChk_nick_pw.value) == true){
		    alert(' 공백은 사용할 수 없습니다. ');
		    return false;
		}
		
	}
	
	$(document).ready(function(){
		  var count = 1;
		  $("#add").click(function(){
		   if(count >= 10){
		    alert("최대 업로드수는 " + count + "개입니다.");
		   } else {
		    count++;
		    $("#file_table").after("<input type='file' name='file' id='file" + count + "' />");
		   }
		  });
		  $("#del").click(function(){
		   if(count <= 1){
		    alert("최소 업로드수는 " + count + "개입니다.");
		   } else {
		    $("#file" + count).remove();
		    count--;
		   }
		  });
	});
	
	
</script>
      
<div class="container">
<br>
<div id="write_div">


<form action="/board/write.do" method="post" enctype="multipart/form-data" style="height: 100%;" id="write" name="writeForm">
<table style="width: 100%;" >
<tr>
   <td style="width: 20%">작성자</td>
   <c:if test="${login }">
   <td style="width: 40%">${name }(${id })</td>
   </c:if>
   <c:if test="${not login }">
   <td style="width: 40%">
   <input type="text" name="ojt_board_nick" id="ojt_board_nick" placeholder="닉네임" style="width: 200px;" required maxlength="16"/></td>
   <tr>
   <td style="width: 20%">비밀번호</td>
   <td style="width: 40%"><input type="password" name="ojt_board_nick_pw" id="ojt_board_nick_pw" placeholder="비밀번호" style="width: 200px;" required
   							onkeydown="patternChk()" maxlength="16" /></td></tr>
   </c:if>
</tr>
<tr>
   <td style="width: 20%">제목</td>
   <td style="width: 80%"><input type="text" name="ojt_board_title" id="ojt_board_title" placeholder="게시물 제목" style="width: 498px;" required
 	  maxlength="100"/></td>
</tr>
<tr>
	<td style="width: 20%">구분</td>
	<td style="width: 80%"><select name="ojt_board_category">
    						<option value="일반">일반</option>
    						<option value="공지사항">공지사항</option>
    						<option value="질문">질문</option>
    						<option value="유머">유머</option>
							</select>
	</td>
</tr>
<tr>
<%-- 	<c:if test="${login }"> --%>
   <td style="width: 20%">공개여부</td>
   <td style="width: 80%"><input type="radio" value="0" name="ojt_board_block" id="ojt_board_block" checked="checked"/>공개
   						  <input type="radio" value="1" name="ojt_board_block" id="ojt_board_block"/>비공개
   	</td>
<%--    	</c:if>
   	<c:if test="${id == null }">
   	<td style="width: 20%">공개여부</td>
   	<td style="width: 80%">공개여부는 로그인 후 사용 가능합니다.</td>
   	</c:if> --%>
</tr>
<tr>
   <td style="width: 20%">중요여부</td>
   <td style="width: 80%"><input type="radio" value="0" name="ojt_board_import" id="ojt_board_import" checked="checked"/>일반
   						  <input type="radio" value="1" name="ojt_board_import" id="ojt_board_import"/>중요
   	</td>
</tr>
<!-- <tr>
   <td>파일첨부</td>
   <td><input multiple="multiple" type="file" name="file" style="width: 498px;" /></td>
</tr> -->
<tr>
   <td>내용</td>
</tr>
<tr>
   <td colspan="2">
      <!-- <textarea  rows="20" cols="100" name="content"></textarea> -->
      <textarea class="ckeditor" id="ckeditor" name="ojt_board_content" required></textarea>
   </td>   
</tr>
</table>

<div id="fileDiv">
<table id="file_table">
<tr id="tr_file">
<th>
첨부파일 : 
</th>
<td>
<input type="file" name="file"/>
</td>
<td>
<button type="button" id="add">추가</button>
</td>
<td>
<button type="button" id="del">삭제</button>
</td>
</tr>
</table>
</div>

<input type="button" id="insertBtn" value="작성" onclick="insert();" class="btn btn-success"/>
<input type="button" id="deleteBtn" value="취소" onclick="button_back();" class="btn btn-back"/>

</form>

</div>
</div>



