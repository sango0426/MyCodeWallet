/***********************************************************************
rpg (v0.3.0)
************************************************************************

[v0.3.0 업데이트 내용]
- 공격력을 해당 공격력 수치와 0사이의 값이 랜덤으로 나오도록 수정
- 공격 메세지 출력 추가( ex. 오크전사가 엠피스에게 데미지를 10 입혔습니다.)

***********************************************************************/

function monster() {
    this.name ="";
    this.hp = 0;
    this.attack = 0;
    this.info = function () {
        dw("<hr>");
        dw("["+this.name+"]["+this.hp+"][atk:"+this.attack+"]");
        dw("<hr>");
    }
}

function character() {
    this.name ="";
    this.hp = 0;
    this.attack = 0;
    this.info = function() {
        dw("<hr>");
        dw("["+this.name+"]["+this.hp+"][atk:"+this.attack+"]");
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

// info() 실행
orc.info();
elf.info();

// 전투시작 메세지 출력
dw("<hr>");
dw("전투시작");
dw("<hr>");

var elf_Dam = r(elf.attack);
var orc_Dam = r(orc.attack);

dw("<hr>");
// 플레이어 데미지 표시
dw("플레이어 데미지 : " + elf_Dam);
dw("<hr>");
// 몬스터 데미지 표시
dw("몬스터 데미지 : " + orc_Dam);
dw("<hr>");

// 오크와 엘프 간 전투 처리(서로 한번씩만 때려 피해를 입히는 처리)
// 상대의 공격력(attack) 수치 만큼 hp(체력)에 피해 (마이너스) 처리
// 공격력을 해당 공격력 수치와 0사이의 값이 랜덤으로 나오도록 수정
orc.hp = orc.hp - elf_Dam;
elf.hp = elf.hp - orc_Dam;

// 공격 메세지 출력 추가( ex. 오크전사가 엠피스에게 데미지를 10 입혔습니다.)
dw(orc.name + "가 " + elf.name + "에게 데미지를 " + orc_Dam + " 입혔습니다." + "<br>");
dw(elf.name + "가 " + orc.name + "에게 데미지를 " + elf_Dam + " 입혔습니다." + "<br>");

// 각 객체의 info 를 호출하여 현재 정보 출력
orc.info();
elf.info();
