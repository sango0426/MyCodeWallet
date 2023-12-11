var random;
random = Math.floor(Math.random() * 100) + 1;

for(var i = 1; i <= random; i++) {
    if(i == 7) {
        //황금고양이 출력
        document.write(i);
        document.write("<img id=goldcat src='cat.jfif'>");
    }

    else {
        document.write(i);
        document.write("<img src='cat.jfif'>");
    }
}