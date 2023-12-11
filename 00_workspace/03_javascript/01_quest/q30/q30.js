/**********************************************************************
가위 바위 보 게임 (v0.2.0)

[구현 기능]
- 가위바위보 기능
- 유저 가위바위보 입력 시 예외처리 추가
**********************************************************************/
// Rock Paper Scissors
var userRpc = prompt("가위,바위,보 중에 하나를 입력하세요:");

if(userRpc == "가위" || userRpc == "바위" || userRpc == "보") {
    var comRpcNumber = Math.floor(Math.random()*3+1);   // 1~3 랜덤값 뽑아서 저장
var comRpcStr = ""; // 컴퓨터가 낸 가위,바위,보 중 하나 텍스트로 저장할 변수.
if(comRpcNumber == 1){
    comRpcStr = "가위";
}
if(comRpcNumber == 2){
    comRpcStr = "바위";
}
if(comRpcNumber == 3){
    comRpcStr = "보";
}

document.write("유저:"+userRpc);
document.write("<br>");
document.write("컴:"+comRpcStr);
document.write("<br>");

var winDrawLose = "";
switch(userRpc){
    case "가위":
        switch(comRpcStr){
            case "가위":
                winDrawLose = "DRAW";
                break;
            case "바위":
                winDrawLose = "패배";
                break;
            case "보":
                winDrawLose = "승리";
                break;
        }
        break;
    case "바위":
        switch(comRpcStr){
            case "가위":
                winDrawLose = "승리";
                break;
            case "바위":
                winDrawLose = "DRAW";
                break;
            case "보":
                winDrawLose = "패배";
                break;
        }        
        break;
    case "보":
        switch(comRpcStr){
            case "가위":
                winDrawLose = "패배";
                break;
            case "바위":
                winDrawLose = "승리";
                break;
            case "보":
                winDrawLose = "DW";
                break;
        }        
        break;
}
document.write(winDrawLose);
} else {
    document.write("입력하신 값이 가위, 바위, 보가 아닙니다.");
}