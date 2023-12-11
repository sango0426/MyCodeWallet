/********************
로또 프로그램 버전 3
- 1~45번 숫자 공에서 6개를 뽑아서 그걸로 당첨 여부를 확인하는 복권
- 컴퓨터의 6개의 숫자랑 내꺼랑 각각 비교해서(6*6회)몇개가 일치하는지 세어 출력하기(이번 버전에 추가)
********************/


//내 로또 번호(ex. 1, 7, 13, 19, 21, 37, 보너스번호 : 27)
var LottoNum1 = 1;
var LottoNum2 = 7;
var LottoNum3 = 13;
var LottoNum4 = 19;
var LottoNum5 = 21;
var LottoNum6 = 37;
var BonusNum = 27;

//컴퓨터가 1~45중 랜덤으로 6개의 번호를 뽑아서 각각의 랜덤번호에 저장
var lottoRanNum1 = Math.floor(Math.random() * 45) + 1;

var lottoRanNum2 = Math.floor(Math.random() * 45) + 1;

var lottoRanNum3 = Math.floor(Math.random() * 45) + 1;

var lottoRanNum4 = Math.floor(Math.random() * 45) + 1;

var lottoRanNum5 = Math.floor(Math.random() * 45) + 1;

var lottoRanNum6 = Math.floor(Math.random() * 45) + 1;

var RanBonusNum = Math.floor(Math.random() * 45) + 1;

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
