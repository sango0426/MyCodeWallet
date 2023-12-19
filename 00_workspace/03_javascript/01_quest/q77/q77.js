// 로그인 폼에 회원가입 버튼 추가
// 회원가입 버튼 클 시 reg_member.html 페이지로 링크 이동 처리
// reg_member.html 추가
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