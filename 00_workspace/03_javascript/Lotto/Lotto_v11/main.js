/********************
로또 프로그램 버전 11
- 1~45번 숫자 공에서 6개를 뽑아서 그걸로 당첨 여부를 확인하는 복권
- 내가 한 게임을 구매했다고 가정하고 변수 p1부터 ~ p6까지 값 6개 각각 주기
- 컴퓨터의 랜덤값도 변수명을 r1 ~ r6 까지 변경해주기
- 보너스 번호도 추가로 정하고 6개중 5개만 맞췄지만, 1개의 틀린 번호가 이 보너스 번호와 일치하면 2등.
- 다 맞추면 1등, 5개만 맞춘 사람은 3등.
- 컴퓨터의 6개의 숫자랑 내꺼랑 각각 비교해서(6*6회)몇개가 일치하는지 세어 출력하기
- 컴퓨터의 두번째 번호가 첫번째 번호와 같을 경우 다시 뽑도록 하기
- 컴퓨터의 세번째 번호가 첫번째,두번째 번호와 같을 경우 다시 뽑도록 하기
- 남은 네번째,다섯,여섯번째의 번호도 다 중복 검사하여 중복 시 다시 뽑게 하기
- 내 번호들을 기존 일반변수에서 배열로 바꾸기
- 컴 번호들을 기존 일반변수에서 배열로 바꾸기
- 기존 컴퓨터의 6개의 숫자랑 내꺼랑 비교해서 몇개가 일치하는 지 세는 작업을 반복문으로 처리
- 맞은갯수에 맞춰 등수도 출력하기
ex. 0~2개가 일치하면 꽝입니다. 출력
    3개가 일치하면 5등입니다. 출력
    4개가 일치하면 4등입니다. 출력
    5개가 일치하면 3등입니다. 출력
    6개가 일치하면 1등입니다. 출력
- 기존 랜덤 번호들 외에 보너스 번호를 하나 추가로 뽑게 하고 이 번호도 기존 번호들과 중복되면 다시뽑게하기(이번 버전에 추가)
- 보너스 번호도 화면에 출력하기(이번 버전에 추가)
********************/

//내 로또 번호들을 변수에 배열 선언
var LottoNum = [1, 2, 3, 4, 5, 6];

//내 보너스 번호 변수와 배열 선언
var BonusNum = [13];

//내 로또 번호와 보너스 번호 출력
document.write(LottoNum[0]);
document.write("<br>");
document.write("<hr>");
document.write(LottoNum[1]);
document.write("<br>");
document.write("<hr>");
document.write(LottoNum[2]);
document.write("<br>");
document.write("<hr>");
document.write(LottoNum[3]);
document.write("<br>");
document.write("<hr>");
document.write(LottoNum[4]);
document.write("<br>");
document.write("<hr>");
document.write(LottoNum[5]);
document.write("<br>");
document.write("<hr>");
document.write("내 보너스 번호 : " + BonusNum[0]);
document.write("<br>");
document.write("<hr>");

//컴퓨터의 랜덤 번호가 들어갈 배열을 변수에 저장
var comRanNum = [0, 0, 0, 0, 0, 0, 0];

//컴퓨터의 랜덤 보너스 번호가 들어갈 배열을 변수에 저장
var comRanBonusNum = [0];

//랜덤 복권 번호 생성 후 배열에 저장
comRanNum[0] = Math.floor(Math.random() * 45) + 1;
document.write(comRanNum[0]);
document.write("<br>");

//각 번호들이 서로 중복되는 것을 제거
//두번째 번호와 첫번째 번호와의 중복 제거
while(true) {
    comRanNum[1] = Math.floor(Math.random() * 45) + 1;
    if(comRanNum[1] != comRanNum[0]) {
        document.write(comRanNum[1]);
        document.write("<br>");
        break;
    }
}

//세번째 번호가 두번째 번호, 첫번째 번호와의 중복 제거
while(true) {
    comRanNum[2] = Math.floor(Math.random() * 45) + 1;
    if(comRanNum[2] != comRanNum[0] && comRanNum[2] != comRanNum[1]) {
        document.write(comRanNum[2]);
        document.write("<br>");
        break;
    }
}

//네번째 번호가 첫,둘, 세번째 번호와의 중복 제거
while(true) {
    comRanNum[3] = Math.floor(Math.random() * 45) + 1;
    if(comRanNum[3] != comRanNum[0] && comRanNum[3] != comRanNum[1] && comRanNum[3] != comRanNum[2]) {
        document.write(comRanNum[3]);
        document.write("<br>");
        break;
    }
}
    


//다섯번째 번호가 첫,둘, 셋, 네번째 번호와의 중복 제거
while(true) {
    comRanNum[4] = Math.floor(Math.random() * 45) + 1;
    if(comRanNum[4] != comRanNum[0] && comRanNum[4] != comRanNum[1] && comRanNum[4] != comRanNum[2] && comRanNum[4] != comRanNum[3]) {
        document.write(comRanNum[4]);
        document.write("<br>");
        break;
    }
}

//두번째 번호와 첫번째 번호 중복 제거
while(true) {
    comRanNum[5] = Math.floor(Math.random() * 45) + 1;
    if(comRanNum[5] != comRanNum[0] && comRanNum[5] != comRanNum[1] && comRanNum[5] != comRanNum[2] && comRanNum[5] != comRanNum[3] && comRanNum[5] != comRanNum[4]) {
        document.write(comRanNum[5]);
        document.write("<br>");
        break;
    }
}

//보너스 번호와 나머지 번호와의 중복 제거
while(true) {
    comRanBonusNum[0] = Math.floor(Math.random() * 45) + 1;
    if(comRanBonusNum[0] != comRanNum[0] && comRanBonusNum[0] != comRanNum[1] && comRanBonusNum[0] != comRanNum[2] && comRanBonusNum[0] != comRanNum[3] && comRanBonusNum[0] != comRanNum[4] && comRanBonusNum[0] != comRanNum[5]) {
        document.write("컴퓨터의 보너스 번호 : " + comRanBonusNum[0]);
        document.write("<br>");
        break;
    }
}

//당첨 로또 번호와 컴퓨터가 랜덤으로 돌려준 내 로또 번호를 비교해서 몇개나 당첨되었는지 확인
//당첨 번호를 저장해둘 변수 선언
var win = 0;

//기존 컴퓨터의 6개의 숫자랑 내꺼랑 비교해서 몇개가 일치하는 지 세는 작업을 반복문으로 처리
for(var i = 0; i <= 5; i++) {
    for(var j = 0; j <= i; j++) {
        if(LottoNum[i] == comRanNum[j]) {
            win = win + 1;
        }
    }
}

//몇개가 당첨되었는지 출력
document.write(win + "개 맞췄습니다!");
document.write("<br>");

//맞은갯수에 맞춰 등수도 출력하기
//ex. 0~2개가 일치하면 꽝입니다. 출력
//    3개가 일치하면 5등입니다. 출력
//    4개가 일치하면 4등입니다. 출력
//    5개가 일치하면 3등입니다. 출력
//    6개가 일치하면 1등입니다. 출력
var str = "";
switch(win) {
    case 0:
    case 1:
    case 2:
        //document.write("꽝입니다.");
        str = "꽝입니다!";
        break;
    case 3:
        //document.write("5등입니다.");
        str = "5등입니다!";
        break;
    case 4:
        //document.write("4등입니다.");
        str = "4등입니다!";
        break;
    case 5:
        //document.write("3등입니다.");
        str = "3등입니다~!";
        break;
    case 6:
        //document.write("1등입니다.");
        str = "축하드립니다! 1등입니다~!";
        break;
}

document.write(str);
