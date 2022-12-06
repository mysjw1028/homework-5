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


		<h2>관리자 리스트</h2>
		<table class="table table-admin" id="datatable" border="2">
			<thead>
				<tr>
					<th>번호</th>
					<th>관리자 이름</th>
					<th>관리자 이메일</th>
					<th>관리자 정보 수정</th>
					<th>관리자 삭제</th>
					<th class="hidden" name="adminId">관리자 아이디</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="admin" items="${admin}">
					<tr>
						<td>${admin.no}</td>
						<td>${admin.adminName}</td>
						<td>${admin.email}</td>
						<form action="/s/Mainadmin/adminlist/${admin.id}/editForm" method="GET">
							<input type="hidden" value="${admin.adminId}" name="adminId">
							<td><button type="submit" class="btn btn-primary">관리자 정보 수정</button></td>
						</form>

						<form action="/s/Mainadmin/adminlist/${admin.id}/delete" method="POST">
							<input type="hidden" value="${admin.adminId}" name="adminId">
							<td><button type="submit" class="btn btn-danger">관리자 삭제</button></td>
						</form>
						<td>${admin.createdAt}</td>
						<td class="hidden" name="id">${admin.id}</td>

					</tr>
				</c:forEach>

			</tbody>
		</table>

	</div>

</body>

</html>
<%@ include file="../layout/footer.jsp"%>