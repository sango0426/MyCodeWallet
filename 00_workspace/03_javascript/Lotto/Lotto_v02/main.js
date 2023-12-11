/********************
로또 프로그램 버전 2
- 1~45번 숫자 공에서 6개를 뽑아서 그걸로 당첨 여부를 확인하는 복권
- 내가 한 게임을 구매했다고 가정하고 변수 p1부터 ~ p6까지 값 6개 각각 주기
- 컴퓨터의 랜덤값도 변수명을 r1 ~ r6 까지 변경해주기
- 보너스 번호도 추가로 정하고 6개중 5개만 맞췄지만, 1개의 틀린 번호가 이 보너스 번호와 일치하면 2등.
- 다 맞추면 1등, 5개만 맞춘 사람은 3등.
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
document.write(lottoRanNum1);
document.write("<br>");

var lottoRanNum2 = Math.floor(Math.random() * 45) + 1;
document.write(lottoRanNum2);
document.write("<br>");

var lottoRanNum3 = Math.floor(Math.random() * 45) + 1;
document.write(lottoRanNum3);
document.write("<br>");

var lottoRanNum4 = Math.floor(Math.random() * 45) + 1;
document.write(lottoRanNum4);
document.write("<br>");

var lottoRanNum5 = Math.floor(Math.random() * 45) + 1;
document.write(lottoRanNum5);
document.write("<br>");

var lottoRanNum6 = Math.floor(Math.random() * 45) + 1;
document.write(lottoRanNum6);
document.write("<br>");

var RanBonusNum = Math.floor(Math.random() * 45) + 1;
document.write("보너스 번호 : " + RanBonusNum);
document.write("<br>");