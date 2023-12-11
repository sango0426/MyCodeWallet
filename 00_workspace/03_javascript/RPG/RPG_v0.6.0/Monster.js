function monster(name, hp, attack) {
    this.name = name;
    this.hp = hp;
    this.Nowhp = hp;
    this.attack = attack;
    this.info = function () {
        dw("[" + this.name + "(" + this.hp + "/" + this.Nowhp + ")" + "]");
    }
}