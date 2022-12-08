<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<div id="container">
	<form action="/s/product/${product.productId}/delete" method="POST">


		<h1>상세보기</h1>
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

				<tr>
					<td>${product.productName}</td>
					<td>${product.productPrice}</td>
					<td>${product.productQty}</td>
					<td>${product.createdAt}</td>
				</tr>

			</tbody>
		</table>


		<c:if test="${principal.adminName != null}">
			<a href="/s/product/${productId}/editForm"><button id="btnUpdate" type="button" class="btn btn-primary">상품수정</button></a>

			<a href="/s/product/${productId}/delete"><button id="btnDelete" class="btn btn-danger">상품삭제</button></a>
		</c:if>
		<c:if test="${principal.mainadminName != null}">
			<a href="/s/product/${productId}/editForm"><button id="btnUpdate" type="button" class="btn btn-primary">상품수정</button></a>
			<a href="/s/product/${productId}/delete">
				<button id="btnDelete" class="btn btn-danger">상품삭제</button>
			</a>
		</c:if>
	</form>
	<c:if test="${principal.userName != null}">
		<a href="/s/buy/buyForm/${productId}"><button class="btn  btn-primary" type="button">상품구매</button></a>
	</c:if>
</div>

<%@ include file="../layout/footer.jsp"%>