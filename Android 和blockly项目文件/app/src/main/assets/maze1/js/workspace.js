/* TODO: Change toolbox XML ID if necessary. Can export toolbox XML from Workspace Factory. */
var toolbox = document.getElementById("toolbox");

var options = { 
	toolbox : toolbox, 
	collapse : true, 
	comments : true, 
	disable : true, 
	maxBlocks : Infinity, 
	trashcan : true, 
	horizontalLayout : false, 
	toolboxPosition : 'start', 
	css : true, 
	media : 'https://blockly-demo.appspot.com/static/media/', 
	rtl : false, 
	scrollbars : true, 
	sounds : true, 
	oneBasedIndex : true, 
	grid : {
		spacing : 20, 
		length : 1, 
		colour : '#888', 
		snap : false
	}
};

/* Inject your workspace */ 
var workspace = Blockly.inject("myblocklywp", options);

/* Load Workspace Blocks from XML to workspace. Remove all code below if no blocks to load */

/* TODO: Change workspace blocks XML ID if necessary. Can export workspace blocks XML from Workspace Factory. */
var workspaceBlocks = document.getElementById("workspaceBlocks"); 

/* Load blocks to workspace. */
Blockly.Xml.domToWorkspace(workspaceBlocks, workspace);
function button_click()
{
	document.getElementById("runButton").addEventListener("click",button_click);
	var code=Blockly.JavaScript.workspaceToCode(workspace);
	if(code.match('##1'))
	{alert("111");}
	if(code.match('##2'))
	{alert("222");}
	else
	{alert("nothing");}

}
document.getElementById("runButton").addEventListener("click",button_click);
//鼠标放置函数
function ona(x){
    x.style.color = "white";
}
//鼠标移走函数
function outa(){
    var x = new Array();
    x[0] = document.getElementById("--");
    x[1] = document.getElementById("--");
    x[2] = document.getElementById("--");
    x[3] = document.getElementById("--");

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
function myFunction5() {
  document.getElementById("runButton").classList.toggle("show");
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
/*
  if (!event.target.matches('.notext primary')) {

    var dropdowns = document.getElementsByClassName("dropdown-content");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
*/
}



