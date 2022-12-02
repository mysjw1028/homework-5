
$("#btnuadminUpdateCheck").click(() => {
	update();
})

function update() {

	if (adminNameCheck() == false) {
		alert("아이디를  다시 적어주세요!!");
		return;
	}
	if (emailCheck() == false) {
		alert("이메일을  다시 적어주세요");
		return;
	}

	let data = {
		adminName: $("#adminName").val(),
		email: $("#email").val(),
	};
	let id
		= $("#adminId").val();

	$.ajax("/Mainadmin/adminlist/" + id + "/edit", {
		type: "POST",
		dataType: "json",
		data: JSON.stringify(data), // http body에 들고갈 요청 데이터
		headers: { // http header에 들고갈 요청 데이터
			"Content-Type": "application/json; charset=utf-8"
		}
	}).done((res) => {
		console.log("실행")
		if (res.code == 1) { // 성공
			alert("회원수정에 성공하였습니다.");
			location.href = "/";
		} else { // 실패
			alert("회원수정에 실패하였습니다.");
			history.back();
		}
	});
}


function adminNameCheck() {
	let adminName = $("#adminName").val();

	if (adminName.length > 0) {
		return true;
	} else {
		return false;
	}
}


function emailCheck() {
	let email = $("#email").val();
	let emailRule = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;
	if (emailRule.test(email)) {
		return true;
	} else {
		return false;
	}

}
function emailCheck1() {
	let email = $("#email").val();

	if (email.length > 0) {
		return true;
	} else {
		return false;
	}

}



