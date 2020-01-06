<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript"
 src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
 
   
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	$("#chkBtn").click(function(event){	
		if (confirm("게시글을 삭제하시겠습니까??") == true) { //확인
			$('#pw_check').submit();
		} else {
			return false; 
		}
	});
	$('#back').click(function(event){	
		if (confirm("게시글로 돌아가시겠습니까??") == true) { //확인
			window.history.back();
		} else {
			return false; 
		}
	});
});
</script>
<style type="text/css">
#pw_check{
	eight: 100%; 
	margin: auto; 
	text-align: center;
}
#button{
	margin-left: 1200px;
}
#chkBtn{
	margin: 10px ;
}
#back{
	margin: 10px;
}
</style>
</head>
<body>

<form action="/board/pwDelCheck.do" method="post" enctype="multipart/form-data" id="pw_check">
<input type="hidden" id="ojt_board_no" name="ojt_board_no" value="${viewBoard.ojt_board_no }">
<label>비회원 글 입니다.</label><br>
<label>비밀번호를 입력해주세요.</label><br>
<input type="text" id="ojt_board_nick_pw" name="ojt_board_nick_pw" >
</form>
<div id=button>
<input type="button" id="chkBtn" value="작성" class="btn btn-success"/>
<input type="button" id="back" value="뒤로가기" class="btn btn-warning pull-left">
</div>
</body>
</html>