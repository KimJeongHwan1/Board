<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

<form action="/board/join" name="joinForm" method="POST"
	onsubmit="return inputCheck()">
	<!-- 아이디 -->
	<div class="form-group">
		<label for="id">아이디</label>
		<input type="text" class="form-control" id="idcheck" name="id" placeholder="ID"
				 required><br>
		<button type="button" id="idck">중복확인</button> &nbsp;&nbsp;&nbsp;<span id="check_id"></span><br>
	</div>
	<!-- 비밀번호 -->
	<div class="form-group">
		<label for="pw">비밀번호</label> 
		<input type="password" class="form-control" name="pw" placeholder="PASSWORD" required>
		
	</div>
	<!-- 이름 -->
	<div class="form-group">
		<label for="name">이름</label> <input type="text"
			class="form-control" id="name" name="name"
			placeholder="Name" required>
	</div>
	
		<div class="reg_button">
		<a class="btn btn-danger px-3"
			href="/board/main;"> <i
			class="fa fa-rotate-right pr-2" aria-hidden="true"></i>취소하기
		</a>&emsp;&emsp;
		<button class="btn btn-primary px-3" id="reg_submit">
			<i class="fa fa-heart pr-2" aria-hidden="true"></i>가입하기
		</button>
	</div>
	
</form>

<c:import url="/WEB-INF/views/layout/footer.jsp" />