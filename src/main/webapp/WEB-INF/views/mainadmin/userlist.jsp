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


		<h2>개인회원 리스트</h2>
		<table class="table table-users" id="datatable" border="2">
			<thead>
				<tr>
					<th>번호</th>
					<th>구매자 이름</th>
					<th>구매자 이메일</th>
					<th>구매자 정보 수정</th>
					<th>구매자 탈퇴</th>
					<th>구매자 구매내역 삭제</th>
					<th class="hidden" name="id">구매자 아이디</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="users" items="${users}">
					<tr>
						<td>${users.no}</td>
						<td>${users.userName}</td>
						<td>${users.email}</td>
						<th class="hidden" name="id">구매자 아이디</th>

						<form action="/Mainadmin/userlist/${users.id}/edit" method="GET">
							<input type="hidden" value="${users.id}" name="userId">
							<td><button type="submit" class="btn btn-primary">구매자 정보 수정</button></td>
						</form>

						<form action="/Mainadmin/userlist/${users.id}/delete" method="POST">
							<input type="hidden" value="${users.id}" name="userId">
							<td><button type="submit" class="btn btn-danger">구매자 강제탈퇴</button></td>
						</form>
						<%--	<form action="/Mainadmin/adminlist/${admin.id}/delete" method="GET">
							<input type="hidden" value="${admin.adminId}" name="adminId">
							<td><button type="submit" class="btn btn-danger"> 구매 내역 페이지 이동</button></td>
						</form> --%>
						<td class="hidden" name="id">${users.id}</td>

					</tr>
				</c:forEach>

			</tbody>
		</table>

	</div>

</body>

</html>
<%@ include file="../layout/footer.jsp"%>