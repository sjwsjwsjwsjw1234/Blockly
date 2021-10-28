 /*
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


*/
Blockly.Blocks['edit'] = {
  init: function() {
    this.appendDummyInput()
        .appendField("操控小车")
        .appendField(new Blockly.FieldDropdown([["运行","y"], ["停止","x"]]), "start");
    this.appendStatementInput("edit")
        .setCheck(null);
    this.setColour(270);
 this.setTooltip("");
 this.setHelpUrl("");
  }
};

Blockly.Blocks['forwardandbackward'] = {
  init: function() {
    this.appendDummyInput()
        .appendField(new Blockly.FieldCheckbox("TRUE"), "check")
        .appendField("方向")
        .appendField(new Blockly.FieldDropdown([[{"src":"image/1.png","width":50,"height":50,"alt":"*"},"w"], [{"src":"image/2.png","width":50,"height":50,"alt":"*"},"s"]]), "direction")
        .appendField("速度")
        .appendField(new Blockly.FieldDropdown([[{"src":"image/5.png","width":50,"height":50,"alt":"*"},"1"], [{"src":"image/6.png","width":50,"height":50,"alt":"*"},"2"]]), "speed");
    this.setPreviousStatement(true, null);
    this.setNextStatement(true, null);
    this.setColour(240);
 this.setTooltip("");
 this.setHelpUrl("");
  }
};

Blockly.Blocks['leftandrightsimple'] = {
  init: function() {
    this.appendDummyInput()
        .appendField(new Blockly.FieldCheckbox("TRUE"), "check")
        .appendField("旋转")
        .appendField(new Blockly.FieldDropdown([[{"src":"image/31.png","width":50,"height":50,"alt":"*"},"11aa"], [{"src":"image/41.png","width":50,"height":50,"alt":"*"},"11dd"]]), "leftandrightsimple");
    this.setPreviousStatement(true, null);
    this.setNextStatement(true, null);
    this.setColour(210);
 this.setTooltip("");
 this.setHelpUrl("");
  }
};
Blockly.Blocks['leftandright'] = {
  init: function() {
    this.appendDummyInput()
        .appendField(new Blockly.FieldCheckbox("TRUE"), "check")
        .appendField("旋转")
        .appendField(new Blockly.FieldDropdown([[{"src":"image/32.png","width":50,"height":50,"alt":"*"},"a"], [{"src":"image/42.png","width":50,"height":50,"alt":"*"},"d"]]), "leftandright")
        .appendField("度数")
        .appendField(new Blockly.FieldDropdown([[{"src":"image/7.png","width":50,"height":50,"alt":"*"},"1"], [{"src":"image/8.png","width":50,"height":50,"alt":"*"},"2"]]), "angle");
    this.setPreviousStatement(true, null);
    this.setNextStatement(true, null);
    this.setColour(120);
 this.setTooltip("");
 this.setHelpUrl("");
  }
};

Blockly.Blocks['repeat'] = {
  init: function() {
    this.appendStatementInput("NAME")
        .setCheck(null)
        .appendField("重复")
        .appendField(new Blockly.FieldNumber(0, 1, 10), "num")
        .appendField("次");
    this.setPreviousStatement(true, null);
    this.setNextStatement(true, null);
    this.setColour(180);
 this.setTooltip("");
 this.setHelpUrl("");
  }
};




Blockly.Blocks['repeat2'] = {
  init: function() {
    this.appendStatementInput("repeat2")
        .setCheck(null)
        .appendField("重复")
        .appendField(new Blockly.FieldDropdown([["2","2"], ["3","3"], ["4","4"]]), "repeat2")
        .appendField("次");
    this.setPreviousStatement(true, null);
    this.setNextStatement(true, null);
    this.setColour(150);
 this.setTooltip("");
 this.setHelpUrl("");
  }
};


Blockly.Blocks['square'] = {
  init: function() {
    this.appendDummyInput()
        .appendField(new Blockly.FieldCheckbox("TRUE"), "check")
        .appendField("正方形轨迹");
    this.appendDummyInput()
        .appendField(new Blockly.FieldDropdown([[{"src":"image/square1.png","width":50,"height":50,"alt":"*"},"1313131"], [{"src":"image/square2.png","width":50,"height":50,"alt":"*"},"1414141"]]), "NAME");
    this.setPreviousStatement(true, null);
    this.setNextStatement(true, null);
    this.setColour(120);
 this.setTooltip("");
 this.setHelpUrl("");
  }
};

Blockly.Blocks['corner'] = {
  init: function() {
    this.appendDummyInput()
        .appendField(new Blockly.FieldCheckbox("TRUE"), "check")
        .appendField("直行转弯");
    this.appendDummyInput()
        .appendField(new Blockly.FieldDropdown([[{"src":"image/corner1.png","width":50,"height":50,"alt":"*"},"131"], [{"src":"image/corner2.png","width":50,"height":50,"alt":"*"},"141"]]), "NAME");
    this.setPreviousStatement(true, null);
    this.setNextStatement(true, null);
    this.setColour(90);
 this.setTooltip("");
 this.setHelpUrl("");
  }
};

Blockly.Blocks['elude'] = {
  init: function() {
    this.appendDummyInput()
        .appendField(new Blockly.FieldCheckbox("TRUE"), "check")
        .appendField("避障位移");
    this.appendDummyInput()
        .appendField(new Blockly.FieldDropdown([[{"src":"image/elude1.png","width":50,"height":50,"alt":"*"},"13131"], [{"src":"image/elude2.png","width":50,"height":50,"alt":"*"},"14141"]]), "NAME");
    this.setPreviousStatement(true, null);
    this.setNextStatement(true, null);
    this.setColour(60);
 this.setTooltip("");
 this.setHelpUrl("");
  }
};