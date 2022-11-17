<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<form action="/login" method="post">

		<div class="mb-3 mt-3">
			<input type="text" class="form-control" placeholder="Enter username" name="userName">
		</div>

		<div class="mb-3">
			<input type="password" class="form-control" placeholder="Enter password" name="password">
		</div>

		<div class="mb-3">
			<input type="password" class="form-control" placeholder="Enter password" name="passwordMainadmin">
		</div>
		<%-- 중앙관리자 전용 패스워드 넣기 ex) 숫자 + 영어 섞어서 --%>

		<button type="submit" class="btn btn-primary">중앙 관리자 로그인</button>
	</form>
</div>

<%@ include file="../layout/footer.jsp"%>
