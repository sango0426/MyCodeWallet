//switch 사용
//1. prompt 함수를 이용하여 숫자 값을 하나 입력 받기			
//1	이면	1	라고 팝업 출력
//2	//	2	//
//3	//	3	//
//그 외의 경우이면		1,2,3 이 아닙니다

var s = prompt("숫자를 입력하시오");

switch(s) {
    case "1":
        alert("1");
        break;
    case "2":
        alert("2");
        break;
    case "3":
        alert("3");
        break;
    default:
        alert("1, 2, 3이 아닙니다.");
        break;
}