/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// ---------------------------
// ▼A：Enter押下時に作動する。
// ---------------------------
function keydown(e) {
    if(e.keyCode === 13){
        var code = "";
        function keydown(e) {
            if(e.keyCode === 13){
                document.getElementById("tugi:mem").value = code;
//                document.cookie = 'MEMBER = ' + code;
                runBtnDisabled('tugi', 'next');
            }else{
                code = code + String.fromCharCode(e.keyCode);
            }
        }
        window.onkeydown = keydown;
    }
    
}
window.onkeydown = keydown;

function runBtnDisabled(formName, btnId) {
    var entryButton = document.getElementById(formName + ":senni");
    entryButton.click();
}