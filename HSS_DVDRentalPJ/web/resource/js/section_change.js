/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//チェックボックスにすべてチェックをつけるまたは外す
function allcheck( tf ) {
   var ElementsCount = document.sampleform.elements.length; // チェックボックスの数
   for( i=0 ; i<ElementsCount ; i++ ) {
      document.sampleform.elements[i].checked = tf; // ON・OFFを切り替え
   }
}