<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>



<div class="container">
	<div class="mb-3 mt-3">
		<input type="text" class="form-control" id="userName" placeholder="Enter username" name="userName"  value="${userName}">
	</div><%--value해서 이름값을 넣어줘야 저장이 된다!! --%>
	<div class="mb-3">
		<input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
	</div>
	<div class="form-check mb-3">
		<label class="form-check-label"> <input id="remember" class="form-check-input" type="checkbox">
			Remember me
		</label>
		<%-- 아이디 정보 저장하는 체크박스 --%>
	</div>
	<button id="btnuserLogin" type="button" class="btn btn-primary">개인 로그인</button>
	<a class="btn btn-primary" href="/admin/loginForm"> 관리자 로그인 페이지로 이동</a> <a class="btn btn-primary"
		href="/mainadmin/loginpageForm">중앙 관리자 로그인 페이지로 이동</a>
	<%--a태그는 무조건 get을 때림 / 버튼 디자인은  class ="btn btn-primary "에 맞춰주면 됨--%>
</div>

<script src="/js/usersLogin.js"></script>
<%@ include file="../layout/footer.jsp"%>