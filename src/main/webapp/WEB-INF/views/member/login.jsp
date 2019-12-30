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

<div class="container">
<br><br>
<div id="login_div">

<span class="glyphicon glyphicon-home" style="font-size: 60px; margin-bottom: 40px; margin-top: 20px;"></span>
<form action="/member/login.do" method="post">

<label><input type="text" name="mem_id" placeholder=" 아이디"
			style="width: 200px; font-weight: lighter; border-radius: 10px;"
			maxlength="16"/></label><br>
<label><input type="password" name="mem_pw" placeholder=" 비밀번호" 
			style="width: 200px; font-weight: lighter; border-radius: 10px;"
			maxlength="16"/></label><br><br>

<button id="login_btn">로그인</button>
</form>

<br>

<a href="/member/join.do"><span style="font-weight: bold;">회원가입</span></a>
<br><br>
</div>
</div>
