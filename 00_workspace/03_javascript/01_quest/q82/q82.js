// 암호와 재확인 암호가 같은지도 체크 처리
// 각 체크에 대해 성공 실패 여부를 로그 남기기

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