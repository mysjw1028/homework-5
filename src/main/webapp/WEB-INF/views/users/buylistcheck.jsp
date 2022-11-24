<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<div id=cotainer>
	<form action="/buy/buylist/${id}/buylistcheck" method="POST">

		<h2>주문 정보 수정하기</h2>
		<input id="productId" type="hidden" name="productId" class="form-control"
			value=" ${buy.productId}">

		<div class="mb-3 mt-3">
			<input id="buyQty" type="text" name="buyQty" class="form-control" value=" ${buy.buyQty}">
			<input id="usersId" type="hidden" name="usersId" class="form-control" value=" ${buy.usersId}">
			<input id="buyName" type="hidden" name="buyName" class="form-control" value=" ${buy.buyName}">

		</div>

		<a href="/"> <%--value가 값이라서 기존에 값을 보여주고 수정이 가능하게 해줌!--%>
			<button id="btnupdate" type="submit" class="btn btn-primary">구매 정보 수정 완료</button>
		</a>
	</form>
</div>

<%@ include file="../layout/footer.jsp"%>