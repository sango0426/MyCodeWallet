// 계속 로그인 입력 태그들을 하나의 div로 묶고 보더, 높이, 폭, 배경, border-radius등을 넣기
// input 태그에 placeholder속성을 이용하여 힌트 삽입.    ex. 아이디 암호

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