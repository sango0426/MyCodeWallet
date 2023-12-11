function character() {
    this.name ="";
    this.hp = 0;
    this.Nowhp = 0;
    this.attack = 0;
    this.info = function() {
        dw("[" + this.name + "(" + this.hp + "/" + this.Nowhp + ")" + "]");
    }
}