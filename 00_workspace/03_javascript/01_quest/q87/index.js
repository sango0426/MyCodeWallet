// 1. 4단 화면 그리기(상단,좌,우,하)
// 2. div  absolute 로 가운데에 팝업 영역 만들기
// 3. 2번에 닫기 버튼을 놓고 버튼이 눌리면 팝업 창이 닫히게

var popup;

function xxx() {
    popup = document.getElementById("popup");
    popup.style.background = "pink";
    popup.style.width = "100px";
    popup.style.height = "100px";
    popup.style.transitionProperty = "background, width, height";
    popup.style.transitionDuration = "1s";
}