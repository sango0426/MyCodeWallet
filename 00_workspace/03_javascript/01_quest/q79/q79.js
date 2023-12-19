// 1. html 에서 이 입력 항목들은 글자수를 제한하여 입력하게 처리하기(아이디, 암호, 암호 재입력, 이름, 이메일)
// <input class="ip" type="text" id="id" minlength="4" maxlength="12" required placeholder="(6자리이상,12자리이하)">
// 2. js 에서 입력 값들을 검사 처리
// 2-1. 글자 수 검사(아이디, 암호, 암호 재입력, 이름, 이메일)(4자이상 12자이하)
// ex. alert("id는 4글자이상 12자 이하로만 입력하세요");
// id.length 글자 수가 리턴됨

var id;
var pw;
var divX;

window.onload = function () {
    id = document.getElementById("id");
    pw = document.getElementById("pw");
    divX = document.getElementById("X");
}

function login() {
    var local_id = id.value;
    var local_pw = pw.value;
    //alert("ID : "+id+" PW : "+pw);
    if(local_id == "박상오" && local_pw == "123123") {
        alert("로그인 성공");
        divX.innerHTML = local_id + "회원님, 반갑습니다.";
    } else {
        alert("로그인 실패");
    }
    alert("ID : "+local_id+" PW : "+local_pw);
}