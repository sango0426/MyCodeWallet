/***********************************************************************
rpg (v0.2.0)
************************************************************************

[v0.2.0 업데이트 내용]
- 전투 시작 메세지 출력

***********************************************************************/

function monster() {
    this.name ="";
    this.hp = 0;
    this.attack = 0;
    this.info = function () {
        document.write("<hr>");
        document.write("["+this.name+"]["+this.hp+"][atk:"+this.attack+"]");
        document.write("<hr>");
    }
}

function character() {
    this.name ="";
    this.hp = 0;
    this.attack = 0;
    this.info = function() {
        document.write("<hr>");
        document.write("["+this.name+"]["+this.hp+"][atk:"+this.attack+"]");
        document.write("<hr>");
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
document.write("<hr>");
document.write("전투시작");
document.write("<hr>");

// 오크와 엘프 간 전투 처리(서로 한번씩만 때려 피해를 입히는 처리)
// 상대의 공격력(attack) 수치 만큼 hp(체력)에 피해 (마이너스) 처리
orc.hp = orc.hp - elf.attack;
elf.hp = elf.hp - orc.attack;

// 각 객체의 info 를 호출하여 현재 정보 출력
orc.info();
elf.info();