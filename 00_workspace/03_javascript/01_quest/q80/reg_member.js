// 암호와 재확인 암호가 같은지도 체크 처리
// 각 체크에 대해 성공 실패 여부를 로그 남기기

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
var sex;
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
    ipSex=document.getElementsByName("sex");
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
    sex = ipSex.value;
    tel_1 = ipTel_1.value;
    tel_2 = ipTel_2.value;
    tel_3 = ipTel_3.value;

    for(var i = 0; i < ipSex.length; i++) {
        if(ipSex[i].checked == true) {
            sex = ipSex[i].value;
            console.log("Sex check complete!");
        }
    }

    checkPw_Re();

    var userInfo = 
        "id: "+id+"\n"
        +"pw: "+pw+"\n"
        +"pw_re: "+rePw+"\n"
        +"userName: "+name+"\n"
        +"email: "+email+"\n"
        +"birth_y: "+birth_y+"\n"
        +"birth_m: "+birth_m+"\n"
        +"birth_d: "+birth_d+"\n"
        +"tel_1: "+tel_1+"\n"
        +"tel_2: "+tel_2+"\n"
        +"tel_3: "+tel_3+"\n"
        +"sex: "+sex;
    
    alert(userInfo);

    if(checkId() && checkPw() && checkRePw() && checkName() && checkEmail() && checkPw_Re()) {
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

function checkPw_Re() {
    if(pw == rePw) {
        console.log("암호가 일치합니다.");
        return true;
    } else {
        console.log("암호가 일치하지 않습니다.");
        return false;
    }
}
