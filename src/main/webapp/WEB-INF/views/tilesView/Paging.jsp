<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax Paging</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
		url : '/board/list.do', // request 서버경로
		type: 'GET',	
		},
		success: function(data) { // 정상 응답시 실행
			$()
		},
		error: function(err) { // 비정상 응답시 실행
			
		}
		
	});
});
</script>

</head>
<body>

</body>
</html>