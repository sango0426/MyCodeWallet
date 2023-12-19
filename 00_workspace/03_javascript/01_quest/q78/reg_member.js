// reg_member.html 회원가입 페이지에 form 태그를 추가하고 다음 항목들을 입력 받기
// 아이디
// 암호
// 암호재입력
// 이름
// 이메일
// 생년월일
// 생년4자리    생월 select tag   생일 select tag   참고코드 : <select class="ip_birth2" id="birth_m">
// (일반 input type="text"등으로 처리) <option value="1">1</option>
// (일반 input type="number"등으로 처리) <option value="2">2</option>
// (value="2022")
// 성별     남     여
// <input type="radio" name="sex" value="M">남성
// <input type="radio" name="sex" value="G" checked>여성
// 핸드폰번호   번호 세자리 010     번호 네자리     번호 네자리
// 회원가입 버튼

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

function phoneNumLim(el, maxlength) {
    if(el.value.length > maxlength)  {
        el.value = el.value.substr(0, maxlength);
    }
}