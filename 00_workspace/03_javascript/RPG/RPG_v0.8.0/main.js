/***********************************************************************
rpg (v0.8.0)
************************************************************************

[v0.8.0 업데이트 내용]
- 전투 종료 후 경험치 획득 메세지 출력 ex. 불쌍한 토끼, 엠피스에게 경험치 100 을 주고 죽었습니다.
- 보상 추가. 몬스터 사냥 시 돈도 획득하도록 변경되었습니다.

***********************************************************************/

var orc = new monster("오크전사", 100, 10);
var elf = new character("엠피스", 200, 20, 0, 300, 0);

displayInfo();

// 전투시작 메세지 출력
dw("<hr>");
dw("전투시작");
dw("<hr>");

function procBattleTurn() {
    // 공격력을 해당 공격력 수치와 0사이의 값이 랜덤으로 나오도록 수정
    var elf_Dam = r(elf.attack);
    var orc_Dam = r(orc.attack);

    elf.Nowhp = elf.Nowhp - orc_Dam;
    orc.Nowhp = orc.Nowhp - elf_Dam;
    dw(elf.name + "가 " + orc.name + "에게 데미지를 " + elf_Dam + " 입혔습니다." + "<br>");
    dw(orc.name + "가 " + elf.name + "에게 데미지를 " + orc_Dam + " 입혔습니다." + "<br>");

    displayInfo();
}

while(true) {
    // hp 검사
    procBattleTurn();
    if(elf.Nowhp <= 0 || orc.Nowhp <= 0) {
        break;
    }
    
}

if(orc.Nowhp <= 0) {
    elf.exp = elf.exp + 100;
    elf.gold = elf.gold + 300;
}

if(elf.Nowhp <= 0) {
    dw("플레이어가 사망하였습니다.");
} else if(orc.Nowhp <= 0) {
    dw("축하합니다. " + orc.name + "를 쓰려트렸습니다!" + "<br>");
    dw("불쌍한 " + orc.name + "가 " + elf.name + "에게 경험치 100을 주고 세상에서 이직하였습니다.." + "<br>");
    dw(elf.gold + "를 획득하였습니다!" + "<br>");
}

displayInfo();

// info 출력 함수
function displayInfo() {
    hr();
    elf.info();
    orc.info();
    hr();
}