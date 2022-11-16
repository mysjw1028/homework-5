<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<form action="/join/insert" method="post">
		<div class="mb-3 mt-3">
			<input id="userName" class="form-control" placeholder="Enter username" name="userName">
			<!--  <button id="btnuserNameSameCheck" type="button" class="btn btn-primary">상품명 중복 확인</button>-->
		</div>
		<div class="mb-3">
			<input id="password" type="password" class="form-control" placeholder="Enter password"
				name="password">
		</div>
		<div class="mb-3">
			<input id="email" type="email" class="form-control" placeholder="Enter email" name="email">
		</div>
		<button id="btnuserInsert"  type="submit" class="btn btn-primary">회원가입</button>

	</form>
</div>
<!-- <script src="/js/users.js"></script>  보류-->

<%@ include file="../layout/footer.jsp"%>
