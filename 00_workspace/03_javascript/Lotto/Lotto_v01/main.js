/*
로또 프로그램 버전 1
로또 복권 1~45
1~45번 숫자 공에서 6개를 뽑아서 그걸로 당첨 여부를 확인하는 복권.
말 그대로 컴퓨터에 정해진 6개의 당첨 숫자를 컴퓨터에 저장하고, 내 복권 숫자를 랜덤으로 돌려서 정해진 당첨 숫자를 내가 스스로 비교하는 프로그램
보너스 번호도 추가로 정하고 5개 맞추고 1개 틀렸지만 그 틀린 번호가 이 보너스 번호와 일치하면 2등.
다 맞추면 1등, 5개만 맞춘 사람은 3등.
*/

//내 로또 번호(ex. 1, 7, 13, 19, 21, 37)
var LottoNum1 = 1;
var LottoNum2 = 7;
var LottoNum3 = 13;
var LottoNum4 = 19;
var LottoNum5 = 21;
var LottoNum6 = 37;

document.write("<br>");
document.write("내 1번 로또 번호 : " + LottoNum1);
document.write("<br>");
document.write("내 2번 로또 번호 : " + LottoNum2);
document.write("<br>");
document.write("내 3번 로또 번호 : " + LottoNum3);
document.write("<br>");
document.write("내 4번 로또 번호 : " + LottoNum4);
document.write("<br>");
document.write("내 5번 로또 번호 : " + LottoNum5);
document.write("<br>");
document.write("내 6번 로또 번호 : " + LottoNum6);
document.write("<br>");
document.write("<hr>");


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