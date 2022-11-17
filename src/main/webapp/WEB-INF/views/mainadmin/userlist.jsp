<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.hidden {
	display: none;
}
</style>
<html>
<head>
<meta charset="UTF-8">

<title>숙제</title>
</head>
<body>
	<div id="cotainer'">


		<h2>구매자 리스트</h2>
		<table class="table table-product" id="datatable" border="2">
			<thead>
				<tr>
					<th>번호</th>
					<th>구매자 이름</th>
					<th>구매자 정보 수정</th>
					<th>구매자 삭제</th>					
					<th>구매자 구매내역 삭제</th>
				</tr>
			</thead>

		<%--	<tbody>
				<c:forEach var="buy" items="${buy}">
					<tr>
						<td>${buy.no}</td>
						<td>${buy.buyName}</td>
						<td>${buy.buyQty}</td>
						<td>${buy.buyPrice}</td>
						<td>${buy.createdAt}</td>
						<form action="/buy/buylist/${buy.id}/delete" method="POST">
							<input type="hidden" value="${buy.buyQty}" , name="buyQty"> <input type="hidden"
								value="${buy.productId}" , name="productId">
							<td><button type="submit" class="btn btn-danger">구매취소</button></td> 
						</form>

					</tr>
				</c:forEach> 정보값 수정하기--%>

			</tbody>
		</table>

	</div>

</body>

</html>
<%@ include file="../layout/footer.jsp"%>