<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../layout/header.jsp"%>

<div id=cotainer>

	<h2>관리자 정보 수정하기</h2>

	<div class="mb-8 mt-8">
		<input id="adminId" type="hidden" name="adminId" class="form-control" value="${admin.id}"> <input
			id="adminName" type="text" name="adminName" class="form-control" value="${admin.adminName}">
	</div>
	<div class="mb-3 mt-3">
		<input id="email" type="email" name="email" class="form-control" value="${admin.email}">
	</div>

	<%--value가 값이라서 기존에 값을 보여주고 수정이 가능하게 해줌!--%>
	<button id="btnuadminUpdateCheck" type="submit" class="btn btn-primary">관리자 정보 수정 완료</button>
</div>
<script src="/js/adminUpdate.js"></script>

<%@ include file="../layout/footer.jsp"%>