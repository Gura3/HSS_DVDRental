/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function showPopup()
{
    wOBJ = window.createPopup();
    popOBJ = wOBJ.document.body;
    popOBJ.style.border = "solid blue 2px";
    popOBJ.innerHTML = "サンプル";
    wOBJ.show(-100, 80, 320, 32, document.body);
}
