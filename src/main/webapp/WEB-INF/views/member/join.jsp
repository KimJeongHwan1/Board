<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Bootstrap 3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script type="text/javascript"
 src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
 
<c:import url="/WEB-INF/views/tilesView/body.jsp"/>
<script type="text/javascript">
	function inputCheck() {

		var join = document.joinForm;

		if (join.mem_id.value == "") {
			alert("아이디를 입력해주세요");
			join.mem_id.focus();
			return false;
		}
		if (join.mem_pw.value == "") {
			alert("비밀번호를 입력해주세요");
			join.mem_pw.focus();
			return false;
		}
		if (join.mem_pw.value != join.mem_pwCheck.value) {
			alert("비밀번호를 동일하게 입력해주세요");
			join.mem_pwCheck.focus();
			return false;
		}
		if (join.mem_name.value == "") {
			alert("이름을 입력해주세요");
			join.mem_name.focus();
			return false;
		}
	}
	$(document).ready(function() {

		$('#check_id').hide();

		$("#idck").click(function() {

			var state = $('#check_id').css('display');
			if (state == 'none') {
				$('#check_id').show();
			}

			$.ajax({
				type : "get",
				url : "/member/idCheck",
				data : $("#idcheck"),
				dataType : "html",
				success : function(res) {
					$("#check_id").html(res);
				},
				error : function() {
					console.log("실패");
				}
			})
		});

	});
</script>
<div class="container">
<form action="/member/join.do" name="joinForm" method="POST"
	onsubmit="return inputCheck()">
	<!-- 아이디 -->
	<div class="form-group">
		<label for="mem_id">아이디</label>
		<input type="text" class="form-control" id="idcheck" name="mem_id" placeholder="ID" onkeydown="inputIdCheck()" required><br>
		<button type="button" id="idck">중복확인</button> &nbsp;&nbsp;&nbsp;<span id="check_id"></span><br>
		<div class="check_font" id="id_check"></div>
	</div>
	<!-- 비밀번호 -->
	<div class="form-group">
		<label for="mem_pw">비밀번호</label> 
		<input type="password" class="form-control" id="mem_pw" name="mem_pw" placeholder="PASSWORD" required>
		
	</div>
	<!-- 비밀번호 재확인 -->
	<div class="form-group">
		<label for="member_pw2">비밀번호 확인</label> <input type="password"
			class="form-control" name="mem_pwCheck"
			placeholder="Confirm Password" required>
		<!-- 			<div class="check_font" id="pw2_check"></div> -->

	</div>
	<!-- 이름 -->
	<div class="form-group">
		<label for="mem_name">이름</label> <input type="text"
			class="form-control" id="mem_name" name="mem_name"
			placeholder="Name" required>
	</div>
	
		<div class="reg_button">
		<a class="btn btn-danger px-3"
			href="/main.do;"> <i
			class="fa fa-rotate-right pr-2" aria-hidden="true"></i>취소하기
		</a>&emsp;&emsp;
		<button class="btn btn-primary px-3" id="reg_submit">
			<i class="fa fa-heart pr-2" aria-hidden="true"></i>가입하기
		</button>
	</div>
	
</form>
</div>