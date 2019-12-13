<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<!-- include libraries(jQuery, bootstrap) -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 

<script type="text/javascript" src="/resources/ckeditor/ckeditor.js"></script>

<script type="text/javascript">
	function button_back() {
		if (confirm("정말 목록으로 돌아가시겠습니까??") == true) { //확인
			window.history.back();
		} else { //취소
			return;
		}
	}

</script>

<style type="text/css">
#content {
	width: 98%;
}

#write_div{
   margin: 0 auto;
   width: 1100px;
}   
#h1{
	margin-left: 21% ;

}
#hr{
	width: 60%
}
</style>

<br>
<div id="write_div">

<form action="/board/write" method="post" enctype="multipart/form-data" style="height: 100%;">
<table style="width: 100%;">
<tr>
   <td style="width: 20%">작성자</td>
   <c:if test="${login }">
   <td style="width: 40%">${name }(${id })</td>
   </c:if>
   <c:if test="${not login }">
   <td style="width: 80%">
   <input type="text" name="nick" id="nick" placeholder="닉네임" style="width: 300px;"/></td>
   </c:if>
</tr>
<tr>
   <td style="width: 20%">제목</td>
   <td style="width: 80%"><input type="text" name="title" id="title" placeholder="게시물 제목" style="width: 498px;"/></td>
</tr>
<tr>
	<td style="width: 20%">구분</td>
	<td style="width: 80%"><select name="kategorie">
    						<option value="일반">구분</option>
    						<option value="일반">일반</option>
    						<option value="공지사항">공지사항</option>
    						<option value="질문">질문</option>
    						<option value="유머">유머</option>
							</select>
	</td>
</tr>
<tr>
   <td style="width: 20%">공개여부</td>
   <td style="width: 80%"><input type="radio" value="0" name="blocksee" id="blocksee" checked="checked"/>공개
   						  <input type="radio" value="1" name="blocksee" id="blocksee"/>비공개
   	</td>
</tr>
<tr>
   <td style="width: 20%">중요여부</td>
   <td style="width: 80%"><input type="radio" value="0" name="basic" id="basic" checked="checked"/>일반
   						  <input type="radio" value="1" name="basic" id="basic"/>중요
   	</td>
</tr>
<tr>
   <td>파일첨부</td>
   <td><input multiple="multiple" type="file" name="file" style="width: 498px;" /></td>
</tr>
<tr>
   <td>내용</td>
</tr>
<tr>
   <td colspan="2">
      <!-- <textarea  rows="20" cols="100" name="content"></textarea> -->
      <textarea class="form-control" id="editor1" name="content"></textarea>
      <script>      
      CKEDITOR.replace('editor1' );
      </script>
      
   </td>
</tr>
</table>

<button class="btn btn-success" id="insert" >수정</button>
<input type="button" id="deleteBtn" value="취소" onclick="button_back();" class="btn btn-danger"/>
</form>

</div>

<c:import url="/WEB-INF/views/layout/footer.jsp" />



