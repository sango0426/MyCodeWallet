/**********************************************************************
가위 바위 보 게임 (v0.3.0)

[구현 기능]
- 가위바위보 기능
- 유저 가위바위보 입력 시 예외처리 추가
- 유저 가위바위보 입력을 입력창에서 받도록 수정
**********************************************************************/
// Rock Paper Scissors

alert("가위바위보 게임에 오신것을 환영합니다!");

// 선언
var userRpc = "";
var comRpc = "";
var rpcInputText;

// ***** 중요 *****//

window.onload = function() {
    rpcInputText = document.getElementById("rpc_input_text");       // 연결
}

function rpcInputButtonClick() {
    while(true) {
        userRpc = rpcInputText.value;
        if(userRpc == "가위" || userRpc == "바위" || userRpc == "보") {
            break;  // while 무한루프를 빠져나감
        } else {
            alert("장난치지마세요");
        }
    }
    
    comRpc = Math.floor(Math.random()*3)+1;   // 1~3 랜덤값 뽑아서 저장

    if(comRpc == 1){
        comRpc = "가위";
    }
    if(comRpc == 2){
        comRpc = "바위";
    }
    if(comRpc == 3){
        comRpc = "보";
    }
    
    document.write("유저:"+userRpc);
    document.write("<br>");
    document.write("컴:"+comRpc);
    document.write("<br>");
    
    var winDrawLose = "";
    switch(userRpc) {
        case "가위":
            switch(comRpc){
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
            switch(comRpc){
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
            switch(comRpc){
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
}