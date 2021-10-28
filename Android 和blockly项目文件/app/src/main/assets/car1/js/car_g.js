/*
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
  alert(code);
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



*/

Blockly.JavaScript['edit'] = function(block) {
  var dropdown_start = block.getFieldValue('start');
  var statements_edit = Blockly.JavaScript.statementToCode(block, 'edit');
  // TODO: Assemble JavaScript into code variable.
  if (dropdown_start=='y')
  {
    s=String(statements_edit).replace("  ","");
    var code = s;
    //alert(code);
    Android.control_car(code);
    //return code;
  }
  if (dropdown_start=='x')
  {

    alert("The car is suspended");
  }
};



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


Blockly.JavaScript['repeat2'] = function(block) {
  var dropdown_repeat2 = block.getFieldValue('repeat2');
  var statements_repeat2 = Blockly.JavaScript.statementToCode(block, 'repeat2');
  s=String(statements_repeat2).replace("  ","");
  var code = s;
  for(i=1;i<dropdown_repeat2;i++)
  {
    code+=s;
  }
  return code;
};



Blockly.JavaScript['forwardandbackward'] = function(block) {
  var checkbox_check = block.getFieldValue('check') == 'TRUE';
  var dropdown_direction = block.getFieldValue('direction');
  var dropdown_speed = block.getFieldValue('speed');
  // TODO: Assemble JavaScript into code variable.
  if(checkbox_check ==true)
  {
    var code=dropdown_speed+dropdown_speed+dropdown_direction+dropdown_direction;
    return code;
  }
  else
  return'';

};

Blockly.JavaScript['leftandrightsimple'] = function(block) {
  var checkbox_check = block.getFieldValue('check') == 'TRUE';
  var dropdown_leftandrightsimple = block.getFieldValue('leftandrightsimple');
  // TODO: Assemble JavaScript into code variable.
  if(checkbox_check ==true)
  {
    var code= dropdown_leftandrightsimple;
    return code;
  }
  else
  return'';
};



Blockly.JavaScript['leftandright'] = function(block) {
  var checkbox_check = block.getFieldValue('check') == 'TRUE';
  var dropdown_leftandright = block.getFieldValue('leftandright');
  var dropdown_angle = block.getFieldValue('angle');
  // TODO: Assemble JavaScript into code variable.
  if(checkbox_check ==true)
  {
    var code= dropdown_angle+dropdown_angle+dropdown_leftandright+dropdown_leftandright;
    return code;
  }
  else
  return'';
};

Blockly.JavaScript['square'] = function(block) {
  var checkbox_check = block.getFieldValue('check') == 'TRUE';
  var dropdown_name = block.getFieldValue('NAME');
  // TODO: Assemble JavaScript into code variable.
  if(checkbox_check ==true)
  {
    var code= dropdown_name;
    return code;
  }
  else
  return'';
};

Blockly.JavaScript['corner'] = function(block) {
  var checkbox_check = block.getFieldValue('check') == 'TRUE';
  var dropdown_name = block.getFieldValue('NAME');
  // TODO: Assemble JavaScript into code variable.
  if(checkbox_check ==true)
  {
    var code= dropdown_name;
    return code;
  }
  else
  return'';
};
Blockly.JavaScript['elude'] = function(block) {
  var checkbox_check = block.getFieldValue('check') == 'TRUE';
  var dropdown_name = block.getFieldValue('NAME');
  // TODO: Assemble JavaScript into code variable.
  if(checkbox_check ==true)
  {
    var code= dropdown_name;
    return code;
  }
  else
  return'';
};