// 1. id, pw를입력받는폼을만들기		
// 2. 로그인 버튼 추가 버튼을 누르면 alert로 입력된 id, pw를출력

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
    alert("ID : "+id.value+" PW : "+pw.value+"");
}