<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<div class="mb-3 mt-3">
		<input id="adminName" class="form-control" placeholder="Enter adminname" name="adminName">
		<button id="btnadminNameSameCheck" type="button" class="btn btn-primary">관리자 중복 확인</button>
	</div>
	<div class="mb-3">
		<input id="password" type="password" class="form-control" placeholder="Enter password" name="password">
	</div>
	<div class="mb-3">
		<input id="email" type="email" class="form-control" placeholder="Enter email" name="email">
	</div>
	<button id="btnuserInsert" type="submit" class="btn btn-primary">관리자회원가입</button>

</div>
<script src="/js/admin.js"></script>


<%@ include file="../layout/footer.jsp"%>
