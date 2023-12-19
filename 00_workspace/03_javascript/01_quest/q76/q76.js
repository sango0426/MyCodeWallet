// 로그인 성공 시 로그인 입력 박스 div내에 id 회원님 반갑습니다. 이런 메세지 출력하기   참고 : div변수.innerHTML="태그"
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