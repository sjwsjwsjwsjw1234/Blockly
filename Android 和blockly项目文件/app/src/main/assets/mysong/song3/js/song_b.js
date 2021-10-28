
Blockly.Blocks['choose1'] = {
  init: function() {
    this.appendDummyInput()
        .appendField("使用钢琴弹奏《欢乐颂》首句")
        .appendField(new Blockly.FieldDropdown([["查看提示","OPTIONNAME1"], ["E3-E3-F3-G3-G3-F3-E3-D3-C3-C3-D3-E3-E3-D3-D3-休止","OPTIONNAME2"]]), "check");
    this.appendStatementInput("song")
        .setCheck(null);
    this.setColour(270);
 this.setTooltip("");
 this.setHelpUrl("");
  }
};
Blockly.Blocks['choose2'] = {
  init: function() {
    this.appendDummyInput()
        .appendField("使用小提琴弹奏《雪绒花》首句")
        .appendField(new Blockly.FieldDropdown([["查看提示","OPTIONNAME1"], ["E3-G3-B3-休止-A3-G3-F3-休止-E3-E3-E3-F3-G3-A3-休止-G3-休止","OPTIONNAME2"]]), "check");
    this.appendStatementInput("song")
        .setCheck(null);
    this.setColour(240);
 this.setTooltip("");
 this.setHelpUrl("");
  }
};
Blockly.Blocks['broadcast'] = {
  init: function() {
    this.appendDummyInput()
        .appendField("选择乐谱")
        .appendField(new Blockly.FieldDropdown([["自由创作","1"], [{"src":"song3/image1/1.jpg","width":400,"height":200,"alt":"*"},"OPTIONNAME1"], [{"src":"song3/image1/2.jpg","width":400,"height":200,"alt":"*"},"OPTIONNAME2"], [{"src":"song3/image1/3.jpg","width":400,"height":300,"alt":"*"},"OPTIONNAME3"], [{"src":"song3/image1/4.jpg","width":350,"height":400,"alt":"*"},"OPTIONNAME4"], [{"src":"song3/image1/5.jpg","width":400,"height":200,"alt":"*"},"OPTIONNAME5"]]), "broadcast");
    this.appendStatementInput("song")
        .setCheck(null);
    this.setColour(360);
 this.setTooltip("");
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
        .appendField(new Blockly.FieldDropdown([["钢琴","1"], ["小提琴","2"] ,["吉他","3"], ["喇叭","5"],["架子鼓","4"],["合唱指挥（人声）","6"]]), " instruments");
    this.setPreviousStatement(true, null);
    this.setNextStatement(true, null);
    this.setColour(330);
 this.setTooltip("");
 this.setHelpUrl("");
  }
};
Blockly.Blocks['instrument2'] = {
  init: function() {
    this.appendDummyInput()
        .appendField("合唱指挥")
        .appendField(new Blockly.FieldImage("https://www.gstatic.com/codesite/ph/images/star_on.gif", 15, 15, { alt: "*", flipRtl: "FALSE" }));
    this.appendStatementInput("instrument2")
        .setCheck(null);
    this.setPreviousStatement(true, null);
    this.setNextStatement(true, null);
    this.setColour(230);
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
    this.setColour(270);
 this.setTooltip("");
 this.setHelpUrl("");
  }
};

Blockly.Blocks['song1'] = {
  init: function() {
    this.appendDummyInput()
        .appendField(new Blockly.FieldDropdown([ ["C3","C3"], ["D3","D3"], ["E3","E3"], ["F3","F3"], ["G3","G3"],["A3","A3"], ["B3","B3"]]), "song");
    this.setPreviousStatement(true, null);
    this.setNextStatement(true, null);
    this.setColour(300);
 this.setTooltip("");
 this.setHelpUrl("");
  }
};
Blockly.Blocks['xiuzhi'] = {
  init: function() {
    this.appendDummyInput()
        .appendField("休止")
        .appendField(new Blockly.FieldImage("song3/image1/xiuzhi.png", 30, 30, { alt: "*", flipRtl: "FALSE" }));
    this.setPreviousStatement(true, null);
    this.setNextStatement(true, null);
    this.setColour(240);
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

Blockly.Blocks['change'] = {
  init: function() {
    this.appendDummyInput()
        .appendField("变速")
        .appendField(new Blockly.FieldDropdown([["0.25倍速","0.25"], ["0.5倍速","0.5"], ["2倍速","2"]]), "change");
    this.appendStatementInput("song")
        .setCheck(null);
    this.setPreviousStatement(true, null);
    this.setNextStatement(true, null);
    this.setColour(210);
 this.setTooltip("");
 this.setHelpUrl("");
  }
};
Blockly.Blocks['xiaoxingxing'] = {
  init: function() {
    this.appendDummyInput()
        .appendField("《小星星》")
        .appendField(new Blockly.FieldImage("song3/image1/xiao.png", 30, 30, { alt: "*", flipRtl: "FALSE" }));
    this.setPreviousStatement(true, null);
    this.setNextStatement(true, null);
    this.setColour(180);
 this.setTooltip("");
 this.setHelpUrl("");
  }
};
Blockly.Blocks['huanlesong'] = {
  init: function() {
    this.appendDummyInput()
        .appendField("《欢乐颂》")
        .appendField(new Blockly.FieldImage("song3/image1/huan.png", 30, 30, { alt: "*", flipRtl: "FALSE" }));
    this.setPreviousStatement(true, null);
    this.setNextStatement(true, null);
    this.setColour(150);
 this.setTooltip("");
 this.setHelpUrl("");
  }
};
