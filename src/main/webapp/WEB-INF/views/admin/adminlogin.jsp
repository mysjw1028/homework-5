<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">
	<div class="mb-3 mt-3">
		<input type="text" class="form-control" id="adminName" placeholder="Enter adminName" name="adminName"  value="${adminName}">
	</div>
	<div class="mb-3">
		<input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
	</div>
	<div class="form-check mb-3">
		<label class="form-check-label"> <input id="rememberadmin" class="form-check-input" type="checkbox">
			Remember me
		</label>
		<%-- 아이디 정보 저장하는 체크박스 --%>
	</div>
	<button id="btnadminLogin" type="button" class="btn btn-primary">관리자 로그인</button>

</div>

<script src="/js/adminLogin.js"></script>
<%@ include file="../layout/footer.jsp"%>