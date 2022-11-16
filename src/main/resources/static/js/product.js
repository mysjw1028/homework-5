
let productNameSameCheck = false;
let productNamechecktag = 1;

$("#btnproductNameSameCheck").click(() => {
	checkProductName();
})

$("#btnInsert").click(() => {
	insert();
})



function checkProductName() {
	let productName = $("#productName").val();

	$.ajax("/product/productNameCheck?productName=" + productName, {
		type: "GET",
		dataType: "json",
	}).done((res) => {
		if (res.code == 1) { // 통신 성공
			if (res.data == false) {
				alert("중복되지 않았습니다.");
				productNameSameCheck = true;
				productNamechecktag = $("#productName").val();
			} else {
				alert("상품명이 중복되었어요. 다른 상품명 사용해주세요.");
			}
		}
	});
}

function insert() {

	if (checkProductName == false) {
		alert("상품명 다시 적어주세요");
		return;
	}
	if (productNamechecktag != $("#productName").val()) {
		alert("상품명 중복체크 다시 해주세요");
		return;
	}

	if (priceCheck() == false) {
		alert("가격을  다시 적어주세요");
		return;
	}
	if (qtyCheck() == false) {
		alert("재고 다시 적어주세요");
		return;
	}

	let data = {
		productName: $("#productName").val(),
		productPrice: $("#productPrice").val(),
		productQty: $("#productQty").val()
	};

	$.ajax("/product/insert", {
		type: "POST",
		dataType: "json",
		data: JSON.stringify(data), // http body에 들고갈 요청 데이터
		headers: { // http header에 들고갈 요청 데이터
			"Content-Type": "application/json; charset=utf-8"
		}
	}).done((res) => {
		if (res.code == 1) { // 성공
			alert("상품등록에 성공하였습니다.");
			location.href = "/";
		} else { // 실패
			alert("상품등록에 실패하였습니다.");
			history.back();
		}
	});
}


function priceCheck() {
	let price = $("#productPrice").val();
	let priceRule = /^[0-9]*$/;
	if (priceRule.test(price)) {
		return true;
	} else {
		return false;
	}
}

function qtyCheck() {
	let qty = $("#productQty").val();
	let qtyRule = /^[0-9]*$/;
	if (qtyRule.test(qty)) {
		return true;
	} else {
		return false;
	}
}

