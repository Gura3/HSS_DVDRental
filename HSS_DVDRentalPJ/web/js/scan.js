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
                document.cookie = 'ID = ' + document.getElementById("scan").value;
            }else{
                document.getElementById("scan").value = document.getElementById("scan").value + String.fromCharCode(e.keyCode);
                console.log(document.getElementById("scan").value);
            }
        }
        window.onkeydown = keydown;
    }
    
}
window.onkeydown = keydown;