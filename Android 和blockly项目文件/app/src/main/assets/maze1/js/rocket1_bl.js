Blockly.Blocks['moveforward'] = {
  init: function() {
    this.appendDummyInput()
        .appendField("向前飞行");
    this.appendStatementInput("NAME")
        .setCheck(null)
        .appendField("放入燃料");
    this.setPreviousStatement(true, null);
    this.setNextStatement(true, null);
    this.setColour(90);
 this.setTooltip("耗费一个燃料，向前飞行1km");
 this.setHelpUrl("");
  }
};

Blockly.Blocks['turnright'] = {
  init: function() {
    this.appendDummyInput()
        .appendField("向右转90°");
    this.setPreviousStatement(true, null);
    this.setNextStatement(true, null);
    this.setColour(120);
 this.setTooltip("不耗费燃料，向右转90°");
 this.setHelpUrl("");
  }
};

Blockly.Blocks['turnleft'] = {
  init: function() {
    this.appendDummyInput()
        .appendField("向左转90°");
    this.setPreviousStatement(true, null);
    this.setNextStatement(true, null);
    this.setColour(120);
 this.setTooltip("不耗费燃料，向左转90°");
 this.setHelpUrl("");
  }
};

Blockly.Blocks['repeatuntil'] = {
  init: function() {
    this.appendValueInput("repeat")
        .setCheck("Number")
        .appendField("重复");
    this.appendDummyInput()
        .appendField("次");
    this.appendStatementInput("NAME")
        .setCheck(null)
        .appendField("");
    this.setPreviousStatement(true, null);
    this.setNextStatement(true, null);
    this.setColour(150);
 this.setTooltip("重复执行块");
 this.setHelpUrl("");
  }
};

Blockly.Blocks['fuel'] = {
  init: function() {
    this.appendDummyInput()
        .appendField(new Blockly.FieldImage("https://www.gstatic.com/codesite/ph/images/star_on.gif", 15, 15, { alt: "*", flipRtl: "FALSE" }));
    this.setOutput(true, null);
    this.setColour(0);
 this.setTooltip("燃料");
 this.setHelpUrl("");
  }
};

Blockly.Blocks['fuelbin'] = {
  init: function() {
    this.appendValueInput("fuel1")
        .setCheck(null)
        .appendField("燃料仓");
    this.appendDummyInput();
    this.appendValueInput("fuel2")
        .setCheck(null);
    this.appendValueInput("fuel3")
        .setCheck(null);
    this.appendValueInput("fuel4")
        .setCheck(null);
    this.setPreviousStatement(true, null);
    this.setColour(45);
 this.setTooltip("");
 this.setHelpUrl("");
  }
};

Blockly.Blocks['run'] = {
  init: function() {
    this.appendStatementInput("run")
        .setCheck(null)
        .appendField("开始飞行");
    this.setColour(120);
 this.setTooltip("");
 this.setHelpUrl("");
  }
};


Blockly.Blocks['puzzle'] = {
  init: function() {
    this.appendDummyInput()
        .appendField("选择图纸")
        .appendField(new Blockly.FieldDropdown([[{"src":"image1/p1.png","width":150,"height":150,"alt":"*"},"1"], [{"src":"image1/p2.png","width":150,"height":150,"alt":"*"},"2"], [{"src":"image1/p3.png","width":150,"height":100,"alt":"*"},"3"]]), "puzzle");
    this.appendDummyInput()
        .appendField("窗口数量")
        .appendField(new Blockly.FieldTextInput("0"), "num");
    this.appendDummyInput()
        .appendField("尾翼数量")
        .appendField(new Blockly.FieldTextInput("0"), "num2");
    this.appendDummyInput()
        .appendField("顶端颜色")
        .appendField(new Blockly.FieldColour("#000099"), "col");
    this.appendDummyInput()
        .appendField("尾翼颜色")
        .appendField(new Blockly.FieldColour("#000099"), "col2");
    this.appendDummyInput()
        .appendField("主体颜色")
        .appendField(new Blockly.FieldColour("#000099"), "col3");
    this.setColour(230);
 this.setTooltip("");
 this.setHelpUrl("");
  }
};