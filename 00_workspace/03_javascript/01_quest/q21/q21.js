//문17의 별 표시를
//_________________☆   << 이런 모양으로 출력하기	
//_______________☆☆
//...
//☆☆☆☆☆☆☆☆☆☆
//주의:	웹문서는 공백을 한칸만 인식함.
//document.write("&nbsp;");
//따라서 공백을 여러칸 주려면 특수문자 &nbsp;를 줘야함.
//ex. 공백3칸 :	&nbsp; &nbsp; &nbsp;

for(var i = 1; i <= 10; i++){

    for(var k = 9; k >= i; k--){
        document.write("&nbsp;")
    }

    for(var j = 1; j <= i; j++){
        document.write("*");
    }
    document.write("<br>");
}