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
        alert('a');
        var code = "";
        function keydown(e) {
            if(e.keyCode === 13){
                alert('c');
                console.log(code);
                document.cookie = 'ID = ' + code;
            }else{
                alert('b');
                code = code + String.fromCharCode(e.keyCode);
                console.log(code);
                console.log(code);
//                document.getElementById("scan").value = document.getElementById("scan").value + String.fromCharCode(e.keyCode);
            }
        }
        window.onkeydown = keydown;
    }
    
}
window.onkeydown = keydown;