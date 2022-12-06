<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<div id=cotainer>
	<form action="/s/buy/${productId}" method="POST">
		<h3>구매하기</h3>
		<table class="table table-product" id="datatable" border="2">
			<thead>
				<tr>
					<th>이름</th>
					<th>가격</th>
					<th>재고</th>
					<th>시간</th>
				</tr>
			</thead>
			<tbody>
				<input type="hidden" name="productId" value="${product.productId }">
				<input type="hidden" name="id" value="${principal.id}">
				<input type="hidden" id="productPricenumber" name="buyPrice" value="${product.productPrice}">
				<input type="hidden" name="buyName" value="${product.productName}">
				<tr>
					<td>${product.productName}</td>
					<td>${product.productPrice}</td>
					<td>${product.productQty}</td>
					<td>${product.createdAt}</td>
				</tr>
			</tbody>
		</table>
		<div class="mb-3 mt-3">
			<label for="assNumber">구매갯수</label> <input type="hidden" value="${product.productQty}" /> <select
				name="buyQty">
				<!-- name을 왜 안걸엇니... -->
				<option value="">선택해주세요.</option>
				<c:forEach begin="1" end="10" var="i">
					<option>${i}</option>
				</c:forEach>
			</select> &nbsp;개
			<button type="submit" class="btn btn-primary">상품구매 완료</button>
		</div>
</div>
</form>
</div>

<%@ include file="../layout/footer.jsp"%>