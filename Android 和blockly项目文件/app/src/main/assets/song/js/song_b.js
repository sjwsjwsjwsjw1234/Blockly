Blockly.Blocks['broadcast'] = {
  init: function() {
    this.appendStatementInput("song")
        .setCheck(null)
        .appendField("编辑乐章");
    this.setColour(135);
 this.setTooltip("选一首歌");
 this.setHelpUrl("");
  }
};
Blockly.Blocks['broadcast2'] = {
  init: function() {
    this.appendValueInput("song1")
        .setCheck(null);
    this.appendValueInput("song2")
        .setCheck(null);
    this.appendValueInput("song3")
        .setCheck(null);
    this.appendValueInput("song4")
        .setCheck(null);
    this.appendStatementInput("song5")
        .setCheck(null);
    this.appendStatementInput("song6")
        .setCheck(null);
    this.appendStatementInput("song7")
        .setCheck(null);
    this.appendStatementInput("song8")
        .setCheck(null);
    this.setColour(230);
 this.setTooltip("song");
 this.setHelpUrl("song");
  }
};

Blockly.Blocks['instruments'] = {
  init: function() {
    this.appendStatementInput("instrument")
        .setCheck(null)
        .appendField("选择乐器")
        .appendField(new Blockly.FieldDropdown([["钢琴","1"],  ["吉他","3"], ["架子鼓","4"]]), " instruments");
    this.setPreviousStatement(true, null);
    this.setNextStatement(true, null);
    this.setColour(60);
 this.setTooltip("");
 this.setHelpUrl("");
  }
};

Blockly.Blocks['repeat'] = {
  init: function() {
    this.appendStatementInput("repeat")
        .setCheck(null)
        .appendField("重复")
        .appendField(new Blockly.FieldDropdown([["1","1"], ["2","2"], ["3","3"], ["4","4"], ["5","5"], ["6","6"], ["7","7"]]), "num")
        .appendField("次");
    this.setPreviousStatement(true, null);
    this.setNextStatement(true, null);
    this.setColour(345);
 this.setTooltip("");
 this.setHelpUrl("");
  }
};

Blockly.Blocks['song1'] = {
  init: function() {
    this.appendDummyInput()
        .appendField(new Blockly.FieldDropdown([["A3","A3"], ["B3","B3"], ["C3","C3"], ["D3","D3"], ["E3","E3"], ["F3","F3"], ["G3","G3"]]), "song");
    this.setPreviousStatement(true, null);
    this.setNextStatement(true, null);
    this.setColour(230);
 this.setTooltip("");
 this.setHelpUrl("");
  }
};

Blockly.Blocks['song'] = {
  init: function() {
    this.appendDummyInput()
        .appendField(new Blockly.FieldNumber(1), "NAME");
    this.setPreviousStatement(true, null);
    this.setNextStatement(true, null);
    this.setColour(230);
 this.setTooltip("");
 this.setHelpUrl("");
  }
};
