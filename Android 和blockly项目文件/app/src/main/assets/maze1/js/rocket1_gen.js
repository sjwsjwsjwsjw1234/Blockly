var aaa=0;
var sss=0;
Blockly.JavaScript['moveforward'] = function(block) {
  var statements_name = Blockly.JavaScript.statementToCode(block, 'NAME');

if(statements_name==0)
{var code='00';}
if(statements_name==1)
{var code='01';}
if(statements_name==2)
{var code='02';}
if(statements_name==3)
{var code='03';}
if(statements_name==4)
{var code='04';}
  return code;
};

Blockly.JavaScript['turnright'] = function(block) {

  var code = '05'; 
  return code; 

};

Blockly.JavaScript['turnleft'] = function(block) {

  var code = '06'; 
  return code;
};

Blockly.JavaScript['repeatuntil'] = function(block) {
sss++;
if(sss%2==0)
{
  var value_repeat = Blockly.JavaScript.valueToCode(block, 'repeat', Blockly.JavaScript.ORDER_ATOMIC);
  var statements_name = Blockly.JavaScript.statementToCode(block, 'NAME');

  var arr=statements_name;
  alert(arr);
  return code;
  }
};



Blockly.JavaScript['fuel'] = function(block) {

  var code = '#fuel';

  return [code, Blockly.JavaScript.ORDER_NONE];
};

Blockly.JavaScript['fuelbin'] = function(block) {
  var value_fuel1 = Blockly.JavaScript.valueToCode(block, 'fuel1', Blockly.JavaScript.ORDER_ATOMIC);
  var value_fuel2 = Blockly.JavaScript.valueToCode(block, 'fuel2', Blockly.JavaScript.ORDER_ATOMIC);
  var value_fuel3 = Blockly.JavaScript.valueToCode(block, 'fuel3', Blockly.JavaScript.ORDER_ATOMIC);
  var value_fuel4 = Blockly.JavaScript.valueToCode(block, 'fuel4', Blockly.JavaScript.ORDER_ATOMIC);

  var num1=(value_fuel1=='(#fuel)');
  var num2=(value_fuel2=='(#fuel)');
  var num3=(value_fuel3=='(#fuel)');
  var num4=(value_fuel4=='(#fuel)');
if(num1+num2+num3+num4==0)
{var code='0';}
if(num1+num2+num3+num4==1)
{var code='1';}
if(num1+num2+num3+num4==2)
{var code='2';}
if(num1+num2+num3+num4==3)
{var code='3';}
if(num1+num2+num3+num4==4)
{var code='4';}
  return code;
};

Blockly.JavaScript['run'] = function(block) {
sss++;
if(sss%2==0)
{
  var statements_run = Blockly.JavaScript.statementToCode(block, 'run');
  var code = (statements_run==206010504);
  if(code)
  {alert("太好了！我们到达啦！");}
  else
  {alert("我们还没有到达月球呢~");
  /*var objImg = document.createElement("img");
  objImg.src="image1/tip1.png";
  var objDiv = document.getElementById("mydiv");
  objDiv.appendChild(objImg);
*/
aaa=1;
}
}
};
function myFunction8() {
  if(aaa==1)
  {
      document.getElementById("myDropdown2").classList.toggle("show");
      aaa=0;
  }

}


Blockly.JavaScript['puzzle'] = function(block) {
sss++;
if(sss%2==0)
{
  var dropdown_puzzle = block.getFieldValue('puzzle');
  var text_num = block.getFieldValue('num');
  var text_num2 = block.getFieldValue('num2');
  var colour_col = block.getFieldValue('col');
  var colour_col2 = block.getFieldValue('col2');
  var colour_col3 = block.getFieldValue('col3');
  // TODO: Assemble JavaScript into code variable.
  if(dropdown_puzzle+text_num+text_num2=='124')
  {
    if((colour_col=="#cc0000")&&(colour_col2=="#000099")&&(colour_col3=="#ffffff"))
    {alert("火箭搭建成功！");return;}
  }
  else if(dropdown_puzzle+text_num+text_num2=='244')
  {
    if((colour_col=="#cc0000")&&(colour_col2=="#c0c0c0")&&(colour_col3=="#ff9900"))
    {alert("火箭搭建成功！");return;}
  }
  else if(dropdown_puzzle+text_num+text_num2=='344')
  {
    if((colour_col=="#000099")&&(colour_col2=="#000099")&&(colour_col3=="#ff9900"))
    {alert("火箭搭建成功！");return;}
    
  }
 
    alert("火箭搭建失败，再试试！")
  
}
};