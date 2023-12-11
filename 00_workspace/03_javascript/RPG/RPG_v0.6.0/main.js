/***********************************************************************
rpg (v0.6.0)
************************************************************************

[v0.6.0 업데이트 내용]
- 전투 처리부분과 케릭터들의 상태 정보를 출력하는 부분을 하나의 함수로 묶어 처리
- 전투 무한 루프 처리 : 전투 시 플레이어나 적의 Nowhp가 0 이하로 될 때까지(죽을때까지) 전투 반복 처리

***********************************************************************/

var orc = new monster("오크전사", 100, 10);
var elf = new character("엠피스", 200, 20);

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

if(elf.Nowhp <= 0) {
    dw("플레이어가 사망하였습니다.");
} else if(orc.Nowhp <= 0) {
    dw("축하합니다. " + orc.name + "를 쓰려트렸습니다!");
}

// info 출력 함수
function displayInfo() {
    hr();
    elf.info();
    orc.info();
    hr();
}