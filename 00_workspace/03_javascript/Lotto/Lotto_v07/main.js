/********************
로또 프로그램 버전 7
- 1~45번 숫자 공에서 6개를 뽑아서 그걸로 당첨 여부를 확인하는 복권
- 내가 한 게임을 구매했다고 가정하고 변수 p1부터 ~ p6까지 값 6개 각각 주기
- 컴퓨터의 랜덤값도 변수명을 r1 ~ r6 까지 변경해주기
- 보너스 번호도 추가로 정하고 6개중 5개만 맞췄지만, 1개의 틀린 번호가 이 보너스 번호와 일치하면 2등.
- 다 맞추면 1등, 5개만 맞춘 사람은 3등.
- 컴퓨터의 6개의 숫자랑 내꺼랑 각각 비교해서(6*6회)몇개가 일치하는지 세어 출력하기
- 컴퓨터의 두번째 번호가 첫번째 번호와 같을 경우 다시 뽑도록 하기
- 컴퓨터의 세번째 번호가 첫번째,두번째 번호와 같을 경우 다시 뽑도록 하기
- 남은 네번째,다섯,여섯번째의 번호도 다 중복 검사하여 중복 시 다시 뽑게 하기
- 내 번호들을 기존 일반변수에서 배열로 바꾸기(이번 버전에 추가)
********************/

//내 로또 번호들을 변수에 배열 선언
var LottoNum = [0, 0, 0, 0, 0, 0];

//내 번호 배열에 각 번호를 대입
LottoNum[0] = 1;
LottoNum[1] = 2;
LottoNum[2] = 3;
LottoNum[3] = 4;
LottoNum[4] = 5;
LottoNum[5] = 6;

//내 로또 번호 출력
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

//랜덤 복권 번호 생성 후 변수에 저장
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

//두번째 번호와 첫번째 번호 중복 제거
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

//LottoNum[0] 비교
if(LottoNum[0] == lottoRanNum1) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum[0] == lottoRanNum2) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum[0] == lottoRanNum3) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum[0] == lottoRanNum4) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum[0] == lottoRanNum5) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum[0] == lottoRanNum6) {
    //당첨 번호 누적
    win = win + 1;
}

//LottoNum[1] 비교
if(LottoNum[1] == lottoRanNum1) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum[1] == lottoRanNum2) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum[1] == lottoRanNum3) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum[1] == lottoRanNum4) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum[1] == lottoRanNum5) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum[1] == lottoRanNum6) {
    //당첨 번호 누적
    win = win + 1;
}

//LottoNum[2] 비교
if(LottoNum[2] == lottoRanNum1) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum[2] == lottoRanNum2) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum[2] == lottoRanNum3) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum[2] == lottoRanNum4) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum[2] == lottoRanNum5) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum[2] == lottoRanNum6) {
    //당첨 번호 누적
    win = win + 1;
}

//LottoNum[3] 비교
if(LottoNum[3] == lottoRanNum1) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum[3] == lottoRanNum2) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum[3] == lottoRanNum3) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum[3] == lottoRanNum4) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum[3] == lottoRanNum5) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum[3] == lottoRanNum6) {
    //당첨 번호 누적
    win = win + 1;
}

//LottoNum[4] 비교
if(LottoNum[4] == lottoRanNum1) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum[4] == lottoRanNum2) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum[4] == lottoRanNum3) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum[4] == lottoRanNum4) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum[4] == lottoRanNum5) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum[4] == lottoRanNum6) {
    //당첨 번호 누적
    win = win + 1;
}

//LottoNum[5] 비교
if(LottoNum[5] == lottoRanNum1) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum[5] == lottoRanNum2) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum[5] == lottoRanNum3) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum[5] == lottoRanNum4) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum[5] == lottoRanNum5) {
    //당첨 번호 누적
    win = win + 1;
}
if(LottoNum[5] == lottoRanNum6) {
    //당첨 번호 누적
    win = win + 1;
}

//몇개가 당첨되었는지 출력
document.write(win + "개 맞췄습니다!");