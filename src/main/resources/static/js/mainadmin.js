
let mainadminNameSameCheck = false;
let mainadminNamechecktag = 1;

$("#btnmainadminNameSameCheck").click(() => {
	checkmainadminName();
})

$("#btnmainadminInsert").click(() => {
	insert();
})



function checkmainadminName() {
	let mainadminName = $("#mainadminName").val();

	$.ajax("/join/MainAdminNameCheck?mainadminName=" + mainadminName, {
		type: "GET",
		dataType: "json",
	}).done((res) => {
		if (res.code == 1) { // 통신 성공
			if (res.data == false) {
				alert("중복되지 않았습니다.");
				mainadminNameSameCheck = true;
				mainadminNamechecktag = $("#mainadminName").val();
			} else {
				alert("아이디가 중복되었어요. 다른 아이디를 사용해주세요.");
			}
		}
	});
}

function insert() {

	if (checkmainadminName == false) {
		alert("아이디를 다시 적어주세요");
		return;
	}
	if (mainadminNamechecktag != $("#mainadminName").val()) {
		alert("아이디 중복체크 다시 해주세요");
		return;
	}

	if (passwordCheck() == false) {
		alert("패스워드를  다시 적어주세요");
		return;
	}
	if (passwordMainadminCheck() == false) {
		alert("중앙관리자용 패스워드를  다시 적어주세요");
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
		mainadminName: $("#mainadminName").val(),
		password: $("#password").val(),
		passwordMainadmin: $("#passwordMainadmin").val(),
		email: $("#email").val(),
	};

	$.ajax("/Mainadmin/joinpage/insert", {
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
			alert("회원가입에 실패하였습니다. 중앙관리자용 비밀번호 확인해주세요");
			history.back();
		}
	});
}


function passwordCheck() {
	let password = $("#password").val();
	let passwordRule = /^[a-zA-Z0-9]*$/;
	if (passwordRule.test(password)) {
		return true;
	} else {
		return false;
	}
}
function passwordMainadminCheck() {
	let passwordMainadmin = $("#passwordMainadmin").val();
	let passwordMainadminRule = /^[a-zA-Z0-9]*$/;
	if (passwordMainadminRule.test(passwordMainadmin)) {
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
function passwordMainadminsameCheck() {
	let passwordMainadmin = $("#passwordMainadmin").val();

	if (passwordMainadmin.length > 0) {
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