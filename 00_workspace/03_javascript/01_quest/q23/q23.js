//for - break
//참고탭 참고
//1 ~ 10 랜덤값 준비
//반복문 1~10 돌면서 1~10 출력
//반복 도중 반복용 변수 값( var i ) 이 랜덤값과 일치하는 경우 반복문을 중지

var random = Math.floor(Math.random() * 10) + 1;

for(var i = 1; i <= 10; i++) {
    document.write(i);
    if(i == random) {
        break;
    }
}