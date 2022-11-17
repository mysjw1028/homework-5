﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>


<div class="container">
	<form action="/login" method="post">
		<div class="mb-3 mt-3">
			<input type="text" class="form-control" placeholder="Enter username" name="userName">
		</div>
		<div class="mb-3">
			<input type="password" class="form-control" placeholder="Enter password" name="password">
		</div>
		<button type="submit" class="btn btn-primary">개인 로그인</button>
		<button type="submit" class="btn btn-primary" onclick="javascript: form.action='/admin/login';">관리자
			로그인</button>
		<a class="btn btn-primary" href="/mainadmin/loginpage">중앙 관리자 로그인 페이지로 이동</a>
</div>


<%@ include file="../layout/footer.jsp"%>