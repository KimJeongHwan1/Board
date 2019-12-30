<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%response.setStatus(HttpServletResponse.SC_OK);%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript"
 src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript">

	function main() {
		if (confirm("메인페이지로 돌아갑니다.") == true) { //확인
			location.href="/main.do";
		} else { //취소
			return;
		}
	}
	
	function back() {
		if (confirm("이전 페이지로 돌아갑니다.") == true) { //확인
			window.history.back();
		} else { //취소
			return;
		}
	}
	
</script>
</head>
<body>

<div style="margin: auto; text-align: center;">
<h1>404 Not Found</h1>
<input type="button" value="Main" onclick="main();">
<input type="button" value="Back" onclick="back();">
</div>
</body>

</html>