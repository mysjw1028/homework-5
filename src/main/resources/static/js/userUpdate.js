
$("#btnusernameUpdateCheck").click(() => {
	update();
})

function update() {

	if (usereamilsameCheck() == false) {
		console.log(1)
		alert("아이디를  다시 적어주세요!!");
		console.log(2)
		return;
	}
	if (emailCheck() == false) {
		console.log(3)
		alert("이메일을  다시 적어주세요");
		console.log(4)
		return;
	}

	let data = {
		userName: $("#userName").val(),
		email: $("#email").val(),
	};
	let id
		= $("#userId").val();

	$.ajax("/s/Mainadmin/userlist/" + id + "/edit", {
		type: "POST",
		dataType: "json",
		data: JSON.stringify(data), // http body에 들고갈 요청 데이터
		headers: { // http header에 들고갈 요청 데이터
			"Content-Type": "application/json; charset=utf-8"
		}
	}).done((res) => {
		console.log("실행")
		if (res.code == 1) { // 성공
			console.log("1");
			alert("회원수정에 성공하였습니다.");
			location.href = "/";
			console.log("2");
		} else { // 실패
			console.log("3");
			alert("회원수정에 실패하였습니다.");
			history.back();
			console.log("4");
		}
	});
}


function usereamilsameCheck() {
	let userName = $("#userName").val();

	if (userName.length > 0) {
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
function usernamesameCheck() {
	let email = $("#email").val();

	if (email.length > 0) {
		return true;
	} else {
		return false;
	}

}



