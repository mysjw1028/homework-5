<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<div id=cotainer>

	<h3>상품수정하기</h3>

	<div class="mb-8 mt-8">
		<input id="productName" type="text" name="productName" class="form-control" value="${product.productName}">
		<button id="btnproductNameSameCheck" type="button" class="btn btn-primary">상품명 중복 확인</button>

	</div>
	<div class="mb-3 mt-3">
		<input id="productPrice" type="text" name="productPrice" class="form-control"
			value="${product.productPrice}">
	</div>
	<div class="mb-3 mt-3">
		<input id="productQty" type="text" name="productQty" class="form-control" value="${product.productQty}">
	</div>
	<a href="/product">
		<%--value값이라서 기존에 값을 보여주고 수정이 가능하게 해줌!--%>
		<button id="btnupdate" type="submit" class="btn btn-primary">상품수정 완료</button>
	</a>

</div>

<%@ include file="../layout/footer.jsp"%>