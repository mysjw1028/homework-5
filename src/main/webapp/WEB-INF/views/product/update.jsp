<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<div id=cotainer>
	<form action="/product/${product.productId}/edit" method="POST">

		<h3>상품수정하기</h3>

		<div class="mb-8 mt-8">
			<input id="name" type="text" name="productName" class="form-control" placeholder="상품이름">
		</div>
		<div class="mb-3 mt-3">
			<input id="price" type="text" name="productPrice" class="form-control" placeholder="가격">
		</div>
		<div class="mb-3 mt-3">
			<input id="name" type="text" name="productQty" class="form-control" placeholder="재고">
		</div>
		<a href="/product">
			<button id="btnupdate" type="submit" class="btn btn-primary">상품수정 완료</button>
		</a>
	</form>
</div>

<%@ include file="../layout/footer.jsp"%>