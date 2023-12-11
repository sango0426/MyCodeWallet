function character(name, hp, attack, exp, nextExp) {
    this.name = name;
    this.hp = hp;
    this.Nowhp = hp;
    this.attack = attack;
    this.info = function() {
        dw("[" + this.name + "(" + this.hp + "/" + this.Nowhp + ")" + "]" + "(exp : " + this.exp + "/" + this.nextExp + ")");
    }
    this.exp = exp;
    this.nextExp = nextExp;
}