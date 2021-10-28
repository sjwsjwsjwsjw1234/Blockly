Blockly.JavaScript['repeat'] = function(block) {
  var number_num = block.getFieldValue('num');
  var statements_name = Blockly.JavaScript.statementToCode(block, 'NAME');
  s=String(statements_name).replace("  ","");
  var code = s;
  for(i=1;i<number_num;i++)
  {
    code+=s;
  }
  return code;
};

Blockly.JavaScript['edit'] = function(block) {
  var statements_edit = Blockly.JavaScript.statementToCode(block, 'edit');
  s=String(statements_edit).replace("  ","");
  var code = s;
  Android.control_car(code);
  return code;
};

Blockly.JavaScript['forwardandbackward'] = function(block) {
  var dropdown_direction = block.getFieldValue('direction');
  var dropdown_distance = block.getFieldValue('distance');
  var code=dropdown_direction+dropdown_distance;
  return code;
};

Blockly.JavaScript['leftandright'] = function(block) {
  var dropdown_direction2 = block.getFieldValue('direction2');
  var dropdown_distance2 = block.getFieldValue('distance2');
  var code = dropdown_direction2+dropdown_distance2;
  //alert(code);
  return code;
};