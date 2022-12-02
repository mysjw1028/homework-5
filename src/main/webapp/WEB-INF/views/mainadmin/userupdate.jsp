<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<div id=cotainer>

	<h2>구매자 정보 수정하기</h2>

	<div class="mb-8 mt-8">
			<input id="userId" type="hidden" name="userId" class="form-control" value="${users.id}">
	
		<input id="userName" type="text" name="userName" class="form-control" value="${users.userName}">
	</div>
	<div class="mb-3 mt-3">
		<input id="email" type="email" name="email" class="form-control" value="${users.email}">
	</div>

	<%--value가 값이라서 기존에 값을 보여주고 수정이 가능하게 해줌!--%>
	<button id="btnusernameUpdateCheck" type="button" class="btn btn-primary">구매자 정보 수정 완료</button>

</div>
<script src="/js/userUpdate.js"></script>

<%@ include file="../layout/footer.jsp"%>