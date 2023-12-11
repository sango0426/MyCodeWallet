// 랜덤을 이용하여 1 ~ 100까지 변하는 변수를 하나 추가하기
// 이 랜덤 값을 반복문의 조건문에 넣어 1 ~ 랜덤수까지 반복하게 수정
// 즉, 고양이가 1~100마리 랜덤하게 나오게 처리

// 변수 선언
var random;

// 1 ~ n 까지 범위내에서 랜덤하게 숫자 하나 뽑는다.
random = Math.floor(Math.random() * 100) + 1;

for(var i=1 ; i <= random ; i = i + 1 ){
    document.write("<img src='cat2.jfif'>");
}