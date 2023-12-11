// 1. Cat 클래스 객체를 생성하기
function Cat() {
    this.name = "고영희";
    this.age = 8;
    this.weight = 8;
    this.color = "갈색";
}

new Cat;

// 2. 변수 kitty 를 선언하고 여기에 위의(1. 에다가) Cat 클래스 객체 생성문을 넣기(대입하기).
var kitty = new Cat;

// 3. 이 클래스형 변수 kitty 가 가진 name 변수에 "야옹이" 를 넣기( "야옹이" 라고 이름 지어주기)
kitty.name = "야옹이";

// 4. 위 고양이 이름을 출력하기
document.write(kitty.name);

// 5. 문46의 키티에 나머지 값들도 넣어주시고 각각 다 출력
kitty.name = "야옹이";
kitty.age = 8;
kitty.weight = 8;
kitty.color = "갈색";

document.write(kitty.name);
document.write(kitty.age);
document.write(kitty.weight);
document.write(kitty.color);