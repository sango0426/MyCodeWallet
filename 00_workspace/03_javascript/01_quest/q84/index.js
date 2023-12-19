// 버튼 토글로 이미지가 보였다 안보였다 하도록 처리

var btn;
var imgCat;
var isPopupOpened;

window.onload = function () {
    btn = document.getElementById("button");
    imgCat = document.getElementById("img_cat");
    btn.addEventListener("click", popUp);
}

function popUp() {
    if(isPopupOpened == false) {
        imgCat.style.display = "inline";
        isPopupOpened = true;
    } else {
        imgCat.style.display = "none";
        isPopupOpened = false;
    }
}