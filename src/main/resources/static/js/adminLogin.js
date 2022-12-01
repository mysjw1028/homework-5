
$("#btnadminLogin").click(() => {
	login();
})

function login() {
	let data = {
		adminName: $("#adminName").val(),
		password: $("#password").val(),
		remember: $("#rememberadmin").prop("checked")
	};

	$.ajax("/admin/login", {
		type: "POST",
		dataType: "json", // 응답 데이터
		data: JSON.stringify(data), // http body에 들고갈 요청 데이터
		headers: { // http header에 들고갈 요청 데이터
			"Content-Type": "application/json; charset=utf-8"
		}
	}).done((res) => {
		if (res.code == 1) {
			alert("로그인 성공");
			location.href = "/";
		} else {
			alert("로그인 실패, 아이디 패스워드를 확인해주세요");
		}
	});
}
