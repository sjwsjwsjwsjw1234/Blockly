Blockly.Blocks['repeat'] = {
  init: function() {
    this.appendStatementInput("NAME")
        .setCheck(null)
        .appendField("重复")
        .appendField(new Blockly.FieldNumber(0, 1, 10), "num")
        .appendField("次");
    this.setPreviousStatement(true, null);
    this.setNextStatement(true, null);
    this.setColour(300);
 this.setTooltip("");
 this.setHelpUrl("");
  }
};

Blockly.Blocks['edit'] = {
  init: function() {
    this.appendStatementInput("edit")
        .setCheck(null)
        .appendField("编辑路径");
    this.setColour(230);
 this.setTooltip("");
 this.setHelpUrl("");
  }
};

Blockly.Blocks['forwardandbackward'] = {
  init: function() {
    this.appendDummyInput()
        .appendField("方向")
        .appendField(new Blockly.FieldDropdown([["前进","1"], ["后退","2"]]), "direction")
        .appendField("档")
        .appendField(new Blockly.FieldDropdown([["一档","1"], ["二档","2"], ["三档","5"]]), "distance");
    this.setPreviousStatement(true, null);
    this.setNextStatement(true, null);
    this.setColour(180);
 this.setTooltip("");
 this.setHelpUrl("");
  }
};

Blockly.Blocks['leftandright'] = {
  init: function() {
    this.appendDummyInput()
        .appendField("方向")
        .appendField(new Blockly.FieldDropdown([["左转","3"], ["右转","4"]]), "direction2")
        .appendField("方向")
        .appendField(new Blockly.FieldDropdown([["45°","1"], ["90°","2"]]), "distance2");
    this.setPreviousStatement(true, null);
    this.setNextStatement(true, null);
    this.setColour(105);
 this.setTooltip("");
 this.setHelpUrl("");
  }
};