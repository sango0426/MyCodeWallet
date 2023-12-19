// 1. html 에서 이 입력 항목들은 글자수를 제한하여 입력하게 처리하기(아이디, 암호, 암호 재입력, 이름, 이메일)
// <input class="ip" type="text" id="id" minlength="4" maxlength="12" required placeholder="(6자리이상,12자리이하)">
// 2. js 에서 입력 값들을 검사 처리
// 2-1. 글자 수 검사(아이디, 암호, 암호 재입력, 이름, 이메일)(4자이상 12자이하)
// ex. alert("id는 4글자이상 12자 이하로만 입력하세요");
// id.length 글자 수가 리턴됨

var ipId;
var ipPw;
var ipRePw;
var ipName;
var ipEmail;
var ipBirth_y;
var ipBirth_m;
var ipBirth_d;
var ipSex;
var ipTel_1;
var ipTel_2;
var ipTel_3;

var id;
var pw;
var rePw;
var name;
var email;
var birth_y;
var birth_m;
var birth_d;
//var sex;
var tel_1;
var tel_2;
var tel_3;

window.onload = function() {
    ipId=document.getElementById("register_id");
    ipPw=document.getElementById("register_pw");
    ipRePw=document.getElementById("register_repw");
    ipName=document.getElementById("register_name");
    ipEmail=document.getElementById("register_email");
    ipBirth_y=document.getElementById("register_birth_y");
    ipBirth_m=document.getElementById("register_birth_m");
    ipBirth_d=document.getElementById("register_birth_d");
    ipSex=document.getElementById("sex");
    ipTel_1=document.getElementById("tel_1");
    ipTel_2=document.getElementById("tel_2");
    ipTel_3=document.getElementById("tel_3");
    
}

function check() {
    id = ipId.value;
    pw = ipPw.value;
    rePw = ipRePw.value;
    name = ipName.value;
    email = ipEmail.value;
    // sex = ipSex.value;
    tel_1 = ipTel_1.value;
    tel_2 = ipTel_2.value;
    tel_3 = ipTel_3.value;

    if(checkId() && checkPw() && checkRePw() && checkName() && checkEmail()) {
        alert("회원가입 완료");
    } else {
        alert("회원가입 실패");
    }
}

function checkId() {
    if(id.length>=4 && id.length<=12) {
        console.log("id check complete!");
        return true;
    } else {
        console.log("id check don't complete,,");
        return false;
    }
}

function checkPw() {
    if(pw.length>=4 && pw.length<=12) {
        console.log("pw check complete!");
        return true;
    } else {
        console.log("pw check don't complete,,");
        return false;
    }
}

function checkRePw() {
    if(rePw.length>=4 && rePw.length<=12) {
        console.log("rePw check complete!");
        return true;
    } else {
        console.log("rePw check don't complete,,");
        return false;
    }
}

function checkName() {
    if(name.length>=4 && name.length<=12) {
        console.log("name check complete!");
        return true;
    } else {
        console.log("name check don't complete,,");
        return false;
    }
}

function checkEmail() {
    if(email.length>=4 && email.length<=12) {
        console.log("email check complete!");
        return true;
    } else {
        console.log("email check don't complete,,");
        return false;
    }
}

function phoneNumLim(el, maxlength) {
    if(el.value.length > maxlength)  {
        el.value = el.value.substr(0, maxlength);
    }
}