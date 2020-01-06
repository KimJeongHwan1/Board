<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript"
 src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
 <!-- Bootstrap 3 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>



 
<c:import url="/WEB-INF/views/tilesView/body.jsp"/>




<script type="text/javascript">
	function patternChk() {
		var patternChk_id = document.getElementById('idcheck');
		var patternChk_pw = document.getElementById('mem_pw');
		var patternChk_name = document.getElementById('mem_name');
		var blank_pattern = /[\s]/g;
		var special_pattern = /[`~!@#$%^&*|\\\'\";:\/?]/gi;

		if( blank_pattern.test( patternChk_id.value) == true){
		    alert(' 공백은 사용할 수 없습니다. ');
		    return false;
		}
		if( blank_pattern.test( patternChk_pw.value) == true){
		    alert(' 공백은 사용할 수 없습니다. ');
		    return false;
		}
		if( blank_pattern.test( patternChk_name.value) == true){
		    alert(' 공백은 사용할 수 없습니다. ');
		    return false;
		}
		if( special_pattern.test( patternChk_id.value) == true ){
		    alert('특수문자는 사용할 수 없습니다.');
		    return false;
		}
		if( special_pattern.test( patternChk_name.value) == true ){
		    alert('특수문자는 사용할 수 없습니다.');
		    return false;
		}
	}

	function inputCheck() {

		var patternChk_id = document.getElementById('idcheck');
		var patternChk_pw = document.getElementById('mem_pw');
		var patternChk_name = document.getElementById('mem_name');
		var blank_pattern = /[\s]/g;
		var special_pattern = /[~!@#$%^&*()_+|<>?:{}]/;
		var E_pattern = /[A-Z]/;
		var special_pw = /[~!@#$%^&*()_+|<>?:{}]{3,}/;
		
		if( blank_pattern.test( patternChk_id.value) == true){
		    alert(' 공백은 사용할 수 없습니다. ');
		    return false;
		}
		if( blank_pattern.test( patternChk_pw.value) == true){
		    alert(' 공백은 사용할 수 없습니다. ');
		    return false;
		}
		if( blank_pattern.test( patternChk_name.value) == true){
		    alert(' 공백은 사용할 수 없습니다. ');
		    return false;
		}
		if( special_pattern.test( patternChk_id.value) == true ){
		    alert('특수문자는 사용할 수 없습니다.');
		    return false;
		}
		if( special_pattern.test( patternChk_name.value) == true ){
		    alert('특수문자는 사용할 수 없습니다.');
		    return false;
		}
		
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
		if(patternChk_pw.value.length<7||!special_pw.test(patternChk_pw.value)||!E_pattern(patternChk_pw.value)){
			alert("비밀번호는 8~16자리 영문 대문자 1개 특수문자 3개를 포함해야합니다.")
			join.mem_pw.focus();
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
				url : "/member/check/idCheck.do",
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
		<input type="text" class="form-control" id="idcheck" name="mem_id" placeholder="아이디를 입력해주세요." required
			onkeypress="patternChk()" maxlength="16"><br>
		<button type="button" id="idck">중복확인</button> &nbsp;&nbsp;&nbsp;<span id="check_id"></span><br>
		<div class="check_font" id="id_check"></div>
	</div>
	<!-- 비밀번호 -->
	<div class="form-group">
		<label for="mem_pw">비밀번호</label> 
		<input type="password" class="form-control" id="mem_pw" name="mem_pw" placeholder="비밀번호는 8~16자리 영문 대문자 1개 특수문자 3개를 포함해야합니다." 
			required onkeypress="patternChk()" maxlength="16">
		
	</div>
	<!-- 비밀번호 재확인 -->
	<div class="form-group">
		<label for="member_pw2">비밀번호 확인</label> <input type="password"
			class="form-control" name="mem_pwCheck"
			placeholder="비밀번호를 동일하게 입력해주세요." required>
		<!-- 			<div class="check_font" id="pw2_check"></div> -->

	</div>
	<!-- 이름 -->
	<div class="form-group">
		<label for="mem_name">이름</label> <input type="text"
			class="form-control" id="mem_name" name="mem_name"
			placeholder="이름을 적어주세요." required onkeypress="patternChk()" maxlength="5">
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