/********************
로또 프로그램 버전 6
- 1~45번 숫자 공에서 6개를 뽑아서 그걸로 당첨 여부를 확인하는 복권
- 컴퓨터의 6개의 숫자랑 내꺼랑 각각 비교해서(6*6회)몇개가 일치하는지 세어 출력하기
- 컴퓨터의 두번째 번호가 첫번째 번호와 같을 경우 다시 뽑도록 하기
- 컴퓨터의 세번째 번호가 첫번째,두번째 번호와 같을 경우 다시 뽑도록 하기
- 남은 네번째,다섯,여섯번째의 번호도 다 중복 검사하여 중복 시 다시 뽑게 하기(이번 버전에 추가)
********************/

//내 로또 번호(ex. 1, 7, 13, 19, 21, 37)
var LottoNum1 = 1;
var LottoNum2 = 7;
var LottoNum3 = 13;
var LottoNum4 = 19;
var LottoNum5 = 21;
var LottoNum6 = 37;

//첫 랜덤 복권 번호 생성 후 변수에 저장
var lottoRanNum1 = Math.floor(Math.random() * 45) + 1;
document.write(lottoRanNum1);
document.write("<br>");

//각 번호들이 서로 중복되는 것을 제거
while(true) {
    //두번째 번호와 첫번째 번호와의 중복 제거
    var lottoRanNum2 = Math.floor(Math.random() * 45) + 1;
    if(lottoRanNum2 != lottoRanNum1) {
        document.write(lottoRanNum2);
        document.write("<br>");
        break;
    }
}

//세번째 번호가 두번째 번호, 첫번째 번호와의 중복 제거
while(true) { 
    var lottoRanNum3 = Math.floor(Math.random() * 45) + 1;
    if(lottoRanNum3 != lottoRanNum1 && lottoRanNum3 != lottoRanNum2) {
        document.write(lottoRanNum3);
        document.write("<br>");
        break;
    }
}

//네번째 번호가 첫,둘, 세번째 번호와의 중복 제거
while(true) {  
    var lottoRanNum4 = Math.floor(Math.random() * 45) + 1;
    if(lottoRanNum4 != lottoRanNum1 && lottoRanNum4 != lottoRanNum2 && lottoRanNum4 != lottoRanNum3) {
        document.write(lottoRanNum4);
        document.write("<br>");
        break;
    }
}
    
//다섯번째 번호가 첫,둘, 셋, 네번째 번호와의 중복 제거
while(true) {
    var lottoRanNum5 = Math.floor(Math.random() * 45) + 1;
    if(lottoRanNum5 != lottoRanNum1 && lottoRanNum5 != lottoRanNum2 && lottoRanNum5 != lottoRanNum3 && lottoRanNum5 != lottoRanNum4) {
        document.write(lottoRanNum5);
        document.write("<br>");
        break;
    }
}

//여섯번째 번호와 나머지 번호와의 중복 제거
while(true) {
    var lottoRanNum6 = Math.floor(Math.random() * 45) + 1;
    if(lottoRanNum6 != lottoRanNum1 && lottoRanNum6 != lottoRanNum2 && lottoRanNum6 != lottoRanNum3 && lottoRanNum6 != lottoRanNum4 && lottoRanNum6 != lottoRanNum5) {
        document.write(lottoRanNum6);
        document.write("<br>");
        break;
    }
}
    

//보너스 번호 랜덤 생성
var RanBonusNum = Math.floor(Math.random() * 45) + 1;
document.write("보너스 번호 : " + RanBonusNum);
document.write("<br>");

//당첨 로또 번호와 컴퓨터가 랜덤으로 돌려준 내 로또 번호를 비교해서 몇개나 당첨되었는지 확인
//당첨 번호를 저장해둘 변수 선언
var win = 0;

//LottoNum1 비교
if(LottoNum1 == lottoRanNum1) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum1 == lottoRanNum2) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum1 == lottoRanNum3) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum1 == lottoRanNum4) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum1 == lottoRanNum5) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum1 == lottoRanNum6) {
    //당첨 번호 누적
    win = win + 1;
}

//LottoNum2 비교
if(LottoNum2 == lottoRanNum1) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum2 == lottoRanNum2) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum2 == lottoRanNum3) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum2 == lottoRanNum4) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum2 == lottoRanNum5) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum2 == lottoRanNum6) {
    //당첨 번호 누적
    win = win + 1;
}

//LottoNum3 비교
if(LottoNum3 == lottoRanNum1) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum3 == lottoRanNum2) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum3 == lottoRanNum3) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum3 == lottoRanNum4) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum3 == lottoRanNum5) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum3 == lottoRanNum6) {
    //당첨 번호 누적
    win = win + 1;
}

//LottoNum4 비교
if(LottoNum4 == lottoRanNum1) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum4 == lottoRanNum2) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum4 == lottoRanNum3) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum4 == lottoRanNum4) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum4 == lottoRanNum5) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum4 == lottoRanNum6) {
    //당첨 번호 누적
    win = win + 1;
}

//LottoNum5 비교
if(LottoNum5 == lottoRanNum1) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum5 == lottoRanNum2) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum5 == lottoRanNum3) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum5 == lottoRanNum4) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum5 == lottoRanNum5) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum5 == lottoRanNum6) {
    //당첨 번호 누적
    win = win + 1;
}

//LottoNum6 비교
if(LottoNum6 == lottoRanNum1) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum6 == lottoRanNum2) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum6 == lottoRanNum3) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum6 == lottoRanNum4) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum6 == lottoRanNum5) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum6 == lottoRanNum6) {
    //당첨 번호 누적
    win = win + 1;
}

//몇개가 당첨되었는지 출력
document.write(win + "개 맞췄습니다!");