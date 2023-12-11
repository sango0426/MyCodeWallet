//while 사용
//준비. html body 내에 <div id="a"> </div> 를 추가 해 놓기
//1. while(true) {  }	를 이용해서 무한 루프 걸기. 이 안에 아래를 코딩하기.
//2. prompt 함수를 이용하여 숫자 값을 하나 입력 받기
//3. 숫자가 100이면 while 반복문을 끝내도록 처리
//4. 입력 받은 값 중 마지막 값을 div 태그 내에 출력하기.


/*
window.onload = function(){ ~~코드~~ }  <<  이게 뭐지?
document.getElementById("a"); 라는 코드는 a라는 id 인 태그를 가져옴. 그런데 그냥 이 코드를 이용해서 구현해보면 안될 것임.
이유는.. html 파일 body 안에 해당 a id 태그가 js 파일보다 늦게 나타나기 때문임.
무슨 이야기냐면 실행흐름 상 js 의 모든 코드가 먼저 실행되고 (태그 가져와라는 저 명령 포함) 그 후에 html body가 그려짐.
이때 태그 가져와 명령시 가져올 수 있는 태그가 없음. 왜냐면 이 시점에 태그가 안 만들어졌기 때문.
그래서 html이 다 그려지고 나서 js 가 실행되게 해야 말이되는데 이를 도와주는 게 저 window.onload = function() { ~~코드~~ } 임.
{ } 안에 쓴 코드는 html 의 body가 다 그려지고 나서 실행됨. 그래서 이제 해당 a id 태그를 읽어오는 것이 가능해지고 그거 가지고 이것 저것 할 수 있게 됨.
*/										
window.onload = function () {
    var t = document.getElementById("a");
    var s = "";

    while (true) {
        s = prompt("값을 입력하세요 :");
        if (s == 100) {
            break;
        } else {
            t.innerHTML = "마지막 입력값:" + s + "<br>";
        }
    }

}
