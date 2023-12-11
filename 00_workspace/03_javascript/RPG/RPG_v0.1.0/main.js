/***********************************************************************

rpg (v0.1.0)

************************************************************************

[v0.1.0 업데이트 내용]
- 몬스터 클래스 생성
- 플레이어 클래스 생성
- 몬스터 객체 생성(orc)
- 플레이어 객체 생성(elf)


***********************************************************************/

// 1. 클래스생성 >>	클래스 속성 함수
// 몬스터	name	 이름      캐릭터      name        이름
//          hp	     체력                  hp          체력
//          attack   공격력                attack      공격력
// 함수 info() : 각 속성 값들을 출력하는 함수
// 2. orc 객체생성하기. 이 객체의 변수값들을 임의로 입력하기 ex. orc.hp = 100;
// 3. elf 객체생성하기. 이 객체의 변수값들은 임의로 입력하기
// 4. 두 객체의 info() 실행

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