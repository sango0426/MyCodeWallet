//문17의 별 표시를
//☆☆☆☆☆☆☆☆☆☆	<< 이런 모양으로 출력하기	
//...
//☆☆
//☆

for(var i = 1; i <= 10; i++) {
    for(var j = 10; j >= i; j--) {
        document.write("☆");
    }
    document.write("<br>");
}