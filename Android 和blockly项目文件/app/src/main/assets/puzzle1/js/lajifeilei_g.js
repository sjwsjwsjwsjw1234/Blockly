var sss=0;
Blockly.JavaScript['kehuishoulaji'] = function(block) {
sss++;
if(sss%2==0)
{
  var statements_kehuishou = Blockly.JavaScript.statementToCode(block, 'kehuishou');
  if((statements_kehuishou==1)||(statements_kehuishou==2))
  alert('恭喜你，你的得分是50分，你是一位垃圾分类小能手!!!');
  else if((statements_kehuishou==12)||(statements_kehuishou==21))
  alert('恭喜你，你的得分是100分，你是一位天才的垃圾分类小能手!!!');
  else if((statements_kehuishou==11)||(statements_kehuishou==22))
  alert('恭喜你，你的得分是50分，你是一位垃圾分类小能手！！！但请注意不要重复选择该种垃圾！');
  else
  alert('别灰心，下次加油！！!');
  }
};

Blockly.JavaScript['youhailaji'] = function(block) {
sss++;
if(sss%2==0)
{
  var statements_youhai = Blockly.JavaScript.statementToCode(block, 'youhai');
  // TODO: Assemble JavaScript into code variable.
  if((statements_youhai==5)||(statements_youhai==6))
  alert('恭喜你，你的得分是50分，你是一位垃圾分类小能手!!!');
  else if((statements_youhai==56)||(statements_youhai==65))
  alert('恭喜你，你的得分是100分，你是一位天才的垃圾分类小能手!!!');
  else if((statements_youhai==55)||(statements_youhai==66))
  alert('恭喜你，你的得分是50分，你是一位垃圾分类小能手！！！但请注意不要重复选择该种垃圾！');
  else
  alert('别灰心，下次加油！！!');
  }
};

Blockly.JavaScript['chuyulaji'] = function(block) {
sss++;
if(sss%2==0)
{
  var statements_chuyu = Blockly.JavaScript.statementToCode(block, 'chuyu');
  // TODO: Assemble JavaScript into code variable.
  if((statements_chuyu==7)||(statements_chuyu==8))
  alert('恭喜你，你的得分是50分，你是一位垃圾分类小能手!!!');
  else if((statements_chuyu==78)||(statements_chuyu==87))
  alert('恭喜你，你的得分是100分，你是一位天才的垃圾分类小能手!!!');
  else if((statements_chuyu==77)||(statements_chuyu==88))
  alert('恭喜你，你的得分是50分，你是一位垃圾分类小能手！！！但请注意不要重复选择该种垃圾！');
  else
  alert('别灰心，下次加油！！!');
  }
};
Blockly.JavaScript['qitalaji'] = function(block) {
sss++;
if(sss%2==0)
{
  var statements_qita = Blockly.JavaScript.statementToCode(block, 'qita');
  // TODO: Assemble JavaScript into code variable.
  if((statements_qita==3)||(statements_qita==4))
  alert('恭喜你，你的得分是50分，你是一位垃圾分类小能手!!!');
  else if((statements_qita==34)||(statements_qita==43))
  alert('恭喜你，你的得分是100分，你是一位天才的垃圾分类小能手!!!');
  else if((statements_qita==33)||(statements_qita==44))
  alert('恭喜你，你的得分是50分，你是一位垃圾分类小能手！！！但请注意不要重复选择该种垃圾！');
  else
  alert('别灰心，下次加油！！!');
  }
};

Blockly.JavaScript['yilaguan'] = function(block) {
   // TODO: Assemble JavaScript into code variable.
   var code = '1';
   return code;
};

Blockly.JavaScript['suitiexie'] = function(block) {
  // TODO: Assemble JavaScript into code variable.
  var code = '2';
  return code;
};

Blockly.JavaScript['guopi'] = function(block) {
  // TODO: Assemble JavaScript into code variable.
  var code = '7';
  return code;
};

Blockly.JavaScript['fanhe'] = function(block) {
  // TODO: Assemble JavaScript into code variable.
  var code = '3';
  return code;
};

Blockly.JavaScript['feidianchi'] = function(block) {
  // TODO: Assemble JavaScript into code variable.
  var code = '5';
  return code;
};

Blockly.JavaScript['nongyaopingzi'] = function(block) {
  // TODO: Assemble JavaScript into code variable.
  var code = '6';
  return code;
};

Blockly.JavaScript['yugutou'] = function(block) {
  // TODO: Assemble JavaScript into code variable.
  var code = '8';
  return code;
};

Blockly.JavaScript['shucaikuye'] = function(block) {
  // TODO: Assemble JavaScript into code variable.
  var code = '4';
  return code;
};
