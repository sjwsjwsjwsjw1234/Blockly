//鼠标放置函数
function ona(x){
    x.style.color = "white";
}
//鼠标移走函数
function outa(){
    var x = new Array();
    x[0] = document.getElementById("餐饮联盟-麦当劳");
    x[1] = document.getElementById("餐饮联盟-星巴克");
    x[2] = document.getElementById("餐饮联盟-德克士");
    x[3] = document.getElementById("餐饮联盟-肯德基");

    for (var i=0;i<x.length;i++){
            x[i].style.color = "brown";
        }
    
}
//点击按钮，下拉菜单在 显示/隐藏 之间切换 
function myFunction() {
    document.getElementById("myDropdown").classList.toggle("show");
}
function myFunction2() {
    document.getElementById("myDropdown2").classList.toggle("show");
}
function myFunction3() {
    document.getElementById("myDropdown3").classList.toggle("show");
}
function myFunction4() {
    document.getElementById("myDropdown4").classList.toggle("show");
}
// 点击下拉菜单意外区域隐藏
window.onclick = function(event) {
  if (!event.target.matches('.dropbtn')) {

    var dropdowns = document.getElementsByClassName("dropdown-content");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
}



