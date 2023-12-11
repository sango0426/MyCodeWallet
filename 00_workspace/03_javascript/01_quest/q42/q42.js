/*
1.클래스 선언(정의 또는 설계) 하기
rule.
function 클래스명() {
    // 속성 또는 프로퍼티들
    this.name;      // 이름
    this.age;       // 나이
    this.weight;    // 몸무게
    this.family;    // 종류 (ex. 코리안숏헤어, 페르시아고양이)
    this.color = "" // 털색
}
		
ex.
function Cat(){
    // 속성 또는 프로퍼티들
    this.name = "";  // 이름
    this.age = 0;    // 나이
    this.weight = 0; // 몸무게
    this.family = "" // 종류 (ex. 코리안숏헤어, 페르시아고양이)
    this.color = ""  // 털색
}
*/

// 1. 100을 리턴하는 함수 만들기
// 2. 200을 리턴하는 함수 만들기
// 3. 숫자 둘을 매개변수로 받아서 이 둘을 더하여 그 결과를 리턴하는 함수 만들기
// 4. 세 함수의 첫번째 매개변수에 1번 함수(실행문)를 넣고 두번째 매개변수에 2번 함수(실행문)를 넣은다음 3 함수가 실행되서 리턴 되는 값을 출력하기
function cat() {
    return 100;
}

function cat2() {
    return 200;
}

function x_plus_y(x, y) {
    var xy = x + y;
    return xy;
}

// 함수 실행
var a = x_plus_y(cat(), cat2());

document.write(a);