//논리연산자	&& ||
//(a 가 b 보다 큼 그리고 c 가 d 보다 작음) 또는 (e 가 100과 같음 그리고 f 가 100이 아님)
//1.위의 긴 조건을 if 조건문으로 만들기
//2.위 조건을 다 만족(ok, 참, true) 시키게끔 a, b, c, d, e, f 값을 적절하게 주기
//ex. a = 1	3.조건을 만족하면 고양이 문자열 출력하기

var a = 20;
var b = 10;
var c = 30;
var d = 39;
var e = 100;
var f = 110;

if((a > b && c < d) || (e == 100 && f != 100)) {
    document.write("고양이");
}