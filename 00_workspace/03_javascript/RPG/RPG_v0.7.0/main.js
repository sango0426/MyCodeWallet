/***********************************************************************
rpg (v0.7.0)
************************************************************************

[v0.7.0 업데이트 내용]
- 전투 종료 처리(종료메세지 출력, 경험치 획득)
- 케릭터 클래스에 현재 경험치, 다음 레벨업에 필요한 경험치 두 변수를 추가하기. (현재 경험치는 초기값 0. 필요 경험치는 초기값 300 주기)
- 몬스터를 잡고 받은 경험치 획득 처리는 플레이어의 현재 경험치에 100을 추가해주기
- 플레이어 간략 정보 표시에 현재 경험치/다음 레벨업 필요 경험치 표시 추가 ex. [엠피스(70/100)](exp: 100/300)
(레벨업 경험치 기획은 현재 미정. 300값 하드코딩.)
- 전투 종료 후 얻은 경험치를 확인하기 위해 플레이어 info 함수 한번 호출하기
- 적 전투력 높혀서 플레이어도 잘 죽는지 확인

***********************************************************************/

var orc = new monster("오크전사", 100, 10);
var elf = new character("엠피스", 200, 20, 0, 300);

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
}

if(elf.Nowhp <= 0) {
    dw("플레이어가 사망하였습니다.");
} else if(orc.Nowhp <= 0) {
    dw("축하합니다. " + orc.name + "를 쓰려트렸습니다! 경험치(100exp)를 획득하였습니다.");
}

displayInfo();

// info 출력 함수
function displayInfo() {
    hr();
    elf.info();
    orc.info();
    hr();
}