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


		<h2>구매내역 보기</h2>
		<table class="table table-product" id="datatable" border="2">
			<thead>
				<tr>
					<th>번호</th>
					<th>상품이름</th>
					<th>구매갯수</th>
					<th>상품개당가격</th>
					<th>구매시간</th>
					<th>구매 취소</th>
					<th>갯수 선택</th>
					<th>구매 부분취소</th>
					<th class="hidden" name="id">물건아이디</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="buy" items="${buy}">
					<tr>
						<td>${buy.no}</td>
						<td>${buy.buyName}</td>
						<td>${buy.buyQty}</td>
						<td>${buy.buyPrice}</td>
						<td>${buy.createdAt}</td>
						<td class="hidden" name="id">${buy.id}</td>

						<form action="/buy/buylist/${buy.id}/delete" method="POST">
							<input type="hidden" value="${buy.buyQty}" name="buyQty"> <input type="hidden"
								value="${buy.productId}" , name="productId">
							<td><button type="submit" class="btn btn-danger">구매취소</button></td>
						</form>

						<form action="/buy/buylist/${buy.id}/delete" method="POST">
							<input type="hidden" value="${buy.buyQty}" name="buyQty"> <input type="hidden"
								value="${buy.productId}" , name="productId">
							</td>
							<td><select name="buyQty">
									<option value="">선택해주세요.</option>
									<c:forEach begin="1" end="10" var="i">
										<option>${i}</option>
									</c:forEach>
							</select> &nbsp;개</td>
							<td>
								<button type="submit" class="btn btn-danger">구매 부분 취소</button>
							</td>
						</form>



					</tr>
				</c:forEach>

			</tbody>
		</table>

	</div>

</body>

</html>
<%@ include file="../layout/footer.jsp"%>