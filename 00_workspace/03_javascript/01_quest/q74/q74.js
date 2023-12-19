// 계속 로그인 입력박스를 (div) 전체화면의 가로, 세로 중앙위치에 정렬하기

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