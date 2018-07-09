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
        function keydown(e) {
            if(e.keyCode === 13){
                document.memberScan.submit();
            }else{
                document.getElementById("member").value = document.getElementById("member").value + String.fromCharCode(e.keyCode);
            }
        }
        window.onkeydown = keydown;
    }
    
}
window.onkeydown = keydown;