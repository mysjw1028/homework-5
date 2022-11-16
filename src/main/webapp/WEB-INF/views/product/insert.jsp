<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<div id=cotainer>
	<form>
		<h3>추가하기</h3>

		<div class="mb-3 mt-3">
			<input id="productName" type="text" name="name" class="form-control" placeholder="상품이름">
			<button id="btnproductNameSameCheck" type="button" class="btn btn-primary">상품명 중복 확인</button>
		</div>

		<div class="mb-3 mt-3">
			<input id="productPrice" type="text" name="productPrice" class="form-control" placeholder="가격">
		</div>
		
		<div class="mb-3 mt-3">
			<input id="productQty" type="text" name="productQty" class="form-control" placeholder="재고">
		</div>

		<button id="btnInsert" type="button" class="btn btn-primary">상품등록 완료</button>
	</form>
</div>
<script src="/js/product.js"></script>
<%@ include file="../layout/footer.jsp"%>