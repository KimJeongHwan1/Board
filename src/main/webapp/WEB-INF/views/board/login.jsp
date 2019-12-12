<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<style>
#login_div{
	background-color: #FAFAFA;
	width: 400px;
	text-align: center;
	margin: 0 auto;
	border-radius: 50px;
}
#login_btn{
	background-color: #6E6E6E;
	color: white;
	border: 0px;
	width: 100px;
	height: 30px;
	font-weight: bold;
	border-radius: 5px;
}
</style>
<br><br>
<div id="login_div">

<span class="glyphicon glyphicon-home" style="font-size: 60px; margin-bottom: 40px; margin-top: 20px;"></span>
<form action="/board/login" method="post">

<label><input type="text" name="id" placeholder=" 아이디" style="width: 200px; font-weight: lighter; border-radius: 10px;"/></label><br>
<label><input type="password" name="pw" placeholder=" 비밀번호" style="width: 200px; font-weight: lighter; border-radius: 10px;"/></label><br><br>

<button id="login_btn">로그인</button>
</form>

<br>

<a href="/board/join"><span style="font-weight: bold;">회원가입</span></a>
<br><br>
</div>

<c:import url="/WEB-INF/views/layout/footer.jsp" />