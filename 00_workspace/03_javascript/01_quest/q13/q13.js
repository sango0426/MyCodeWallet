//1. prompt 함수를 이용하여 숫자 값을 하나 입력 받기
//2. 이 값이 100 보다 크면		100 보다 큽니다	라고 팝업 출력
//3. 이 값이 100 보다 작으면		100 보다 작습니다	라고 팝업 출력
//4. 그 외에는		100 입니다.	라고 팝업 출력

var r = prompt("숫자를 입력하시오");

if(r > 100) {
    alert("100보다 큽니다.");
} else if(r < 100) {
    alert("100보다 작습니다.");
} else {
    alert("100입니다.");
}