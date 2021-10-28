var sss=0;
Blockly.JavaScript['title'] = function(block) {
sss++;
if(sss%2==0)
{
  //var dropdown_title = block.getFieldValue('title');
  var statements_title = Blockly.JavaScript.statementToCode(block, 'title');
  // TODO: Assemble JavaScript into code variable.
  s=String(statements_title).replace("  ","");
  if(s=="1234")
  alert("拼接正确！")
  else
  alert("拼接错误，再试试！")
  }
};

Blockly.JavaScript['chunxiao'] = function(block) {
  var dropdown_chunxiao = block.getFieldValue('1');
  // TODO: Assemble JavaScript into code variable.
  var code = dropdown_chunxiao;
  return code;
};
/*
Blockly.JavaScript['jingyesi'] = function(block) {
  var dropdown_jingyesi = block.getFieldValue('jingyesi');
  // TODO: Assemble JavaScript into code variable.
  var code = '2'+dropdown_jingyesi;
  return code;
};

Blockly.JavaScript['cunju'] = function(block) {
  var dropdown_cunju = block.getFieldValue('cunju');
  // TODO: Assemble JavaScript into code variable.
  var code = '3'+dropdown_cunju;
  return code;
};
*/