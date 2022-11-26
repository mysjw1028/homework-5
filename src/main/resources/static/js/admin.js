
let adminNameSameCheck = false;
let adminNamechecktag = 1;

$("#btnadminNameSameCheck").click(() => {
	checkadminName();
})

$("#btnadminInsert").click(() => {
	insert();
})



function checkadminName() {
	let adminName = $("#adminName").val();

	$.ajax("/admin/join/adminNameCheck?adminName=" + adminName, {
		type: "GET",
		dataType: "json",
	}).done((res) => {
		if (res.code == 1) { // 통신 성공
			if (res.data == false) {
				alert("중복되지 않았습니다.");
				adminNameSameCheck = true;
				adminNamechecktag = $("#adminName").val();
			} else {
				alert("아이디가 중복되었어요. 다른 아이디를 사용해주세요.");
			}
		}
	});
}

function insert() {

	if (checkadminName == false) {
		alert("아이디를 다시 적어주세요");
		return;
	}
	if (adminNamechecktag != $("#adminName").val()) {
		alert("아이디 중복체크 다시 해주세요");
		return;
	}

	if (passwordCheck() == false) {
		alert("패스워드를  다시 적어주세요");
		return;
	}
	if (emailCheck() == false) {
		alert("이메일을  다시 적어주세요");
		return;
	}

	if (passwordsameCheck() == false) {
		alert("패스워드를  다시 적어주세요");
		return;
	}

	let data = {
		adminName: $("#adminName").val(),
		password: $("#password").val(),
		email: $("#email").val(),
	};

	$.ajax("/admin/join", {
		type: "POST",
		dataType: "json",
		data: JSON.stringify(data), // http body에 들고갈 요청 데이터
		headers: { // http header에 들고갈 요청 데이터
			"Content-Type": "application/json; charset=utf-8"
		}
	}).done((res) => {
		if (res.code == 1) { // 성공
			alert("회원가입에 성공하였습니다.");
			location.href = "/";
		} else { // 실패
			alert("회원가입에 실패하였습니다.");
			history.back();
		}
	});
}


function passwordCheck() {
	let price = $("#password").val();
	let priceRule = /^[a-zA-Z0-9]*$/;
	if (priceRule.test(price)) {
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
function passwordsameCheck() {
	let password = $("#password").val();

	if (password.length > 0) {
		return true;
	} else {
		return false;
	}
}
function emailsameCheck() {
	let email = $("#email").val();

	if (email.length > 0) {
		return true;
	} else {
		return false;
	}
}