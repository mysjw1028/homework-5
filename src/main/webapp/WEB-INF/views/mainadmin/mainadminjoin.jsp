<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<form>
		<div class="mb-3 mt-3">
			<input id="mainadminName" class="form-control" placeholder="Enter mainadminName" name="mainadminName">
			<button id="btnmainadminNameSameCheck" type="button" class="btn btn-primary">중앙관리자 중복 확인</button>

		</div>
		<div class="mb-3">
			<input id="password" type="password" class="form-control" placeholder="Enter password" name="password">
		</div>
		<div class="mb-3">
			<input id="passwordMainadmin" type="password" class="form-control" placeholder="Enter Mainadmin password"
				name="passwordMainadmin">
		</div>
		<div class="mb-3">
			<input id="email" type="email" class="form-control" placeholder="Enter email" name="email">
		</div>
		<button id="btnmainadminInsert" type="submit" class="btn btn-primary">중앙 관리자 회원가입</button>

	</form>
</div>
<script src="/js/mainadmin.js"></script>

<%@ include file="../layout/footer.jsp"%>
