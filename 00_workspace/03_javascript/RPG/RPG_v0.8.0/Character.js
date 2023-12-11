function character(name, hp, attack, exp, nextExp, gold) {
    this.name = name;
    this.hp = hp;
    this.Nowhp = hp;
    this.attack = attack;
    this.info = function() {
        dw("[" + this.name + "(" + this.hp + "/" + this.Nowhp + ")" + "]" + "(exp : " + this.exp + "/" + this.nextExp + ")" + "(현재 골드 : " + this.gold + "골드)");
    }
    this.exp = exp;
    this.nextExp = nextExp;
    this.gold = gold;
}