//***********************************
//****  By www.onek.cn  速水.铁  ****
//***********************************

function setTab(m,n){

 var timeoutId;
 var tli=document.getElementById("menu"+m).getElementsByTagName("li");
 var mli=document.getElementById("main"+m).getElementsByTagName("div");
 for(i=0;i<tli.length;i++){
  tli[i].className=i==n?"hover":"";
  mli[i].style.display=i==n?"block":"none";
 }
}
