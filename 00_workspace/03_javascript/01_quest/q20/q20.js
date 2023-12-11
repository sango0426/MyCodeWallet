//문17의 별 표시를
//☆☆☆☆☆☆☆☆☆☆  << 이런 모양으로 출력하기	
//...
//_______________☆☆
//_________________☆
//주의:	웹문서는 공백을 한칸만 인식함.
//document.write("&nbsp;");
//따라서 공백을 여러칸 주려면 특수문자 &nbsp;를 줘야함.
//ex. 공백3칸 :	&nbsp; &nbsp; &nbsp;

for(var i=1; i<=10; i=i+1){

    for(var k=1; k <= i - 1; k=k+1){
        document.write("&nbsp;")
    }

    for(var j=10; j>=i; j=j-1){
        document.write("*");
    }
    document.write("<br>");
}