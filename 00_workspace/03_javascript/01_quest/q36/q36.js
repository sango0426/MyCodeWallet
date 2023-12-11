//1. addCatAndInputText라는 이름의 함수 만들기(선언하기)
function addCatAndInputText() {
    //2. 이 함수안에서 문자열을 하나를 입력 받아 변수에 저장하고, 이 값을 "고양이" 랑 더해서 화면에 출력하게 하기
    var inputText = prompt("값을 입력하세요.");
    document.write("고양이" + inputText);
}

//3. 위 함수를 호출(실행)하기
addCatAndInputText();