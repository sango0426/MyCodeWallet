// 계속 박스에 그림자도 추가    box-shadow: 5px 5px 5px;
var id;
var pw;
var button;

window.onload = function () {
    id = document.getElementById("id");
    pw = document.getElementById("pw");
    button = document.getElementById("button");
}

function login() {
    //alert("ID : "+id+" PW : "+pw);
    if(id.value == "123123" && pw.value == "123123") {
        alert("로그인 성공");
    } else {
        alert("로그인 실패");
    }
    alert("ID : "+id.value+" PW : "+pw.value+"");
}