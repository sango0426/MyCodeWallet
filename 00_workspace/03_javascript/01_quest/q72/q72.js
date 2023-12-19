// 문71에 특정 id 특정 pw를 입력했을 때 "로그인성공" 팝업 출력
// 하지 못했을 때 "로그인실패" 팝업 출력

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