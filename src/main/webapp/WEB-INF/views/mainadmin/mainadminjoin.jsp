<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<form action="/Mainadmin/joinpage/insert" method="post">
		<div class="mb-3 mt-3">
			<input id="mainadminName" class="form-control" placeholder="Enter mainadminName" name="mainadminName">
		</div>
		<div class="mb-3">
			<input id="password" type="password" class="form-control" placeholder="Enter password"
				name="password">
		</div>
		<div class="mb-3">
			<input id="passwordMainadmin" type="password" class="form-control" placeholder="Enter Mainadmin password"
				name="passwordMainadmin" >
		</div>
		<div class="mb-3">
			<input id="email" type="email" class="form-control" placeholder="Enter email" name="email">
		</div>
		<button id="btnuserInsert" type="submit" class="btn btn-primary">중앙 관리자 회원가입</button>

	</form>
</div>

<%@ include file="../layout/footer.jsp"%>
