// 문48 복사하여 코드 추가
// Cat 클래스에 crying() 추가
// crying()는 고양이 소리를 출력(document.write)하는 함수로 작성
// 기존 두 객체의 crying() 각각 호출(실행)

// 1. Cat 클래스 객체를 생성하기
function Cat() {
    this.name = "";
    this.age = 0;
    this.weight = 0;
    this.color = "";
    this.crying = function () {
        document.write("야옹");
    }
}

new Cat;

// 2. 변수 kitty 를 선언하고 여기에 위의(1. 에다가) Cat 클래스 객체 생성문을 넣기(대입하기).
var kitty = new Cat();

// 3. 이 클래스형 변수 kitty 가 가진 name 변수에 "야옹이" 를 넣기( "야옹이" 라고 이름 지어주기)
kitty.name = "야옹이";

// 4. 위 고양이 이름을 출력하기
document.write(kitty.name + "<br>");

// 5. 문46의 키티에 나머지 값들도 넣어주시고 각각 다 출력
kitty.age = 8;
kitty.weight = 8;
kitty.color = "갈색";

document.write(kitty.age + "<br>");
document.write(kitty.weight + "<br>");
document.write(kitty.color + "<br>");

var yaongi = new Cat();

yaongi.name = "고영희";
yaongi.age = 7;
yaongi.weight = 10;
yaongi.color = "검정색";

document.write(yaongi.name + "<br>");
document.write(yaongi.age + "<br>");
document.write(yaongi.weight + "<br>");
document.write(yaongi.color + "<br>");

if(yaongi.age < kitty.age) {
    document.write("형님 고양이 : " + kitty.name + "<br>");
    document.write("동생 고양이 : " + yaongi.name + "<br>");
} else if(yaongi.age > kitty.age) {
    document.write("형님 고양이 : " + yaongi.name + "<br>");
    document.write("동생 고양이 : " + kitty.name + "<br>");
} else {
    document.write("둘은 친구임");
}

kitty.crying();
yaongi.crying();