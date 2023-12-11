/***********************************************************************
rpg (v0.4.0)
************************************************************************

[v0.4.0 업데이트 내용]
- 체력 표시를 [최대체력/현재체력] 식으로 변경하였습니다.
- 케릭터 정보 표시를 수정하였습니다. ex. [엠피스(100/70)]
- 케릭터 정보 표시에서 공격력 수치를 제거하였습니다.

***********************************************************************/

function monster() {
    this.name ="";
    this.hp = 0;
    this.Nowhp = 0;
    this.attack = 0;
    this.info = function () {
        dw("<hr>");
        dw("[" + this.name + "(" + this.hp + "/" + this.Nowhp + ")" + "]");
        dw("<hr>");
    }
}

function character() {
    this.name ="";
    this.hp = 0;
    this.Nowhp = 0;
    this.attack = 0;
    this.info = function() {
        dw("<hr>");
        dw("[" + this.name + "(" + this.hp + "/" + this.Nowhp + ")" + "]");
        dw("<hr>");
    }
}

// var orc = new monster("오크전사", 100, 10);
var orc = new monster();
orc.name = "오크전사";
orc.hp = 100;
orc.attack = 10;

// var elf = new character("엠피스", 200, 20);
var elf = new character();
elf.name = "엠피스";
elf.hp = 200;
elf.attack = 20;

// 공격력을 해당 공격력 수치와 0사이의 값이 랜덤으로 나오도록 수정
var elf_Dam = r(elf.attack);
var orc_Dam = r(orc.attack);

elf.Nowhp = elf.hp
orc.Nowhp = orc.hp

// info() 실행
orc.info();
elf.info();

// 전투시작 메세지 출력
dw("<hr>");
dw("전투시작");
dw("<hr>");


dw("<hr>");
// 플레이어 데미지 표시
dw("플레이어 데미지 : " + elf_Dam);
dw("<hr>");
// 몬스터 데미지 표시
dw("몬스터 데미지 : " + orc_Dam);
dw("<hr>");

// 오크와 엘프 간 전투 처리(서로 한번씩만 때려 피해를 입히는 처리)
// 상대의 공격력(attack)의 랜덤 수치 만큼 hp(체력)에 피해 (마이너스) 처리
elf.Nowhp = elf.hp - orc_Dam
orc.Nowhp = orc.hp - elf_Dam

// 공격 메세지 출력 추가( ex. 오크전사가 엠피스에게 데미지를 10 입혔습니다.)
dw(orc.name + "가 " + elf.name + "에게 데미지를 " + orc_Dam + " 입혔습니다." + "<br>");
dw(elf.name + "가 " + orc.name + "에게 데미지를 " + elf_Dam + " 입혔습니다." + "<br>");

// 각 객체의 info 를 호출하여 현재 정보 출력
orc.info();
elf.info();
