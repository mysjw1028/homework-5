<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">

		<div class="mb-3 mt-3">
			<input id="mainadminName"  type="text" class="form-control" placeholder="Enter mainadminName" name="mainadminName">
		</div> 

		<div class="mb-3">
			<input id="password"  type="password" class="form-control" placeholder="Enter password" name="password">
		</div>

		<div class="mb-3">
			<input id="passwordMainadmin"  type="password" class="form-control" placeholder="Enter passwordMainadmin" name="passwordMainadmin">
		</div>
		<div class="form-check mb-3">
			<label class="form-check-label"> <input id="remember" class="form-check-input" type="checkbox">
				Remember me
			</label>
			<%-- 아이디 정보 저장하는 체크박스 --%>
		</div>
		<button id ="btnMainadminLogin" type="button" class="btn btn-primary">중앙 관리자 로그인</button>
</div>

<script src="/js/MainadminLogin.js"></script>
<%@ include file="../layout/footer.jsp"%>
