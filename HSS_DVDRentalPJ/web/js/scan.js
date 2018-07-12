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
                document.cookie = 'ID = ' + code;
                tugi();
            }else{
                code = code + String.fromCharCode(e.keyCode);
            }
        }
        window.onkeydown = keydown;
    }
    
}
window.onkeydown = keydown;

// ---------------------------
// ▼B：Servletを呼び出す。
// ---------------------------
function submit(){
 if(window.XMLHttpRequest){
  req = new XMLHttpRequest();
 }else if(window.ActiveXObject){
  req = new ActiveXObject("Microsoft.XMLHTTP");
 }else{
  return false;
 }
 req.onreadystatechange=callback;
 req.open("GET","MemberScanCompleteServlet.java",true);
 req.send(null);
}
function callback(){
 if(req.readyState==4 && req.status==200){
  document.getElementById("result").innerHTML=req.responseText;
 }
}

// ---------------------------
// ▼C：BackingBeanを呼び出す。
// ---------------------------
function next(){
    MemberScanCompleteBb.next();
}

// ---------------------------
// ▼D：Servletを呼び出す。
// ---------------------------
function tugi(){
    location.href = "http://localhost:8080/HSS_DVDRentalPJ/faces/index.xhtml";
}