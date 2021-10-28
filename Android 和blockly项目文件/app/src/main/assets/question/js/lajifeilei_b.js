Blockly.Blocks['kehuishoulaji'] = {
  init: function() {
    this.appendStatementInput("kehuishou")
        .setCheck(null)
        .appendField("冬奥会雪上运动项目（限选两项）")
        .appendField(new Blockly.FieldImage("image1/1.jpg", 150, 150, { alt: "*", flipRtl: "FALSE" }));
    this.setColour(150);
 this.setTooltip("冬奥会雪上运动项目（限选两项）");
 this.setHelpUrl("");
  }
};

Blockly.Blocks['youhailaji'] = {
  init: function() {
    this.appendStatementInput("youhai")
        .setCheck(null)
        .appendField("冬奥会冰上运动项目（限选两项）")
        .appendField(new Blockly.FieldImage("image1/2.jpg", 150, 150, { alt: "*", flipRtl: "FALSE" }));
    this.setColour(345);
 this.setTooltip("冬奥会冰上运动项目（限选两项）");
 this.setHelpUrl("");
  }
};

Blockly.Blocks['chuyulaji'] = {
  init: function() {
    this.appendStatementInput("chuyu")
        .setCheck(null)
        .appendField("冬奥会运动服饰（限选两项）")
        .appendField(new Blockly.FieldImage("image1/3.jpg", 150, 150, { alt: "*", flipRtl: "FALSE" }));
    this.setColour(135);
 this.setTooltip("冬奥会运动服饰（限选两项）");
 this.setHelpUrl("");
  }
};

Blockly.Blocks['yilaguan'] = {
  init: function() {
    this.appendDummyInput()
        .appendField("单板滑雪")
        .appendField(new Blockly.FieldImage("image1/5.jpg", 150, 150, { alt: "*", flipRtl: "FALSE" }));
    this.setPreviousStatement(true, null);
    this.setNextStatement(true, null);
    this.setColour(120);
 this.setTooltip("单板滑雪");
 this.setHelpUrl("");
  }
};

Blockly.Blocks['suitiexie'] = {
  init: function() {
    this.appendDummyInput()
        .appendField("自由式滑雪")
        .appendField(new Blockly.FieldImage("image1/6.jpg", 150, 150, { alt: "*", flipRtl: "FALSE" }));
    this.setPreviousStatement(true, null);
    this.setNextStatement(true, null);
    this.setColour(150);
 this.setTooltip("自由式滑雪");
 this.setHelpUrl("");
  }
};

Blockly.Blocks['guopi'] = {
  init: function() {
    this.appendDummyInput()
        .appendField("滑雪棉袄和棉裤")
        .appendField(new Blockly.FieldImage("image1/10.jpg", 150, 150, { alt: "*", flipRtl: "FALSE" }));
    this.setPreviousStatement(true, null);
    this.setNextStatement(true, null);
    this.setColour(180);
 this.setTooltip("滑雪棉袄与棉裤");
 this.setHelpUrl("");
  }
};

Blockly.Blocks['fanhe'] = {
  init: function() {
    this.appendDummyInput()
        .appendField("冰壶")
        .appendField(new Blockly.FieldImage("image1/12.jpg", 150, 150, { alt: "*", flipRtl: "FALSE" }));
    this.setPreviousStatement(true, null);
    this.setNextStatement(true, null);
    this.setColour(135);
 this.setTooltip("冰壶");
 this.setHelpUrl("");
  }
};

Blockly.Blocks['feidianchi'] = {
  init: function() {
    this.appendDummyInput()
        .appendField("速度滑冰")
        .appendField(new Blockly.FieldImage("image1/7.jpg", 150, 150, { alt: "*", flipRtl: "FALSE" }));
    this.setPreviousStatement(true, null);
    this.setNextStatement(true, null);
    this.setColour(0);
 this.setTooltip("速度滑冰");
 this.setHelpUrl("");
  }
};

Blockly.Blocks['nongyaopingzi'] = {
  init: function() {
    this.appendDummyInput()
        .appendField("冰壶竞技")
        .appendField(new Blockly.FieldImage("image1/8.jpg", 150, 150, { alt: "*", flipRtl: "FALSE" }));
    this.setPreviousStatement(true, null);
    this.setNextStatement(true, null);
    this.setColour(75);
 this.setTooltip("冰壶竞技");
 this.setHelpUrl("");
  }
};

Blockly.Blocks['yugutou'] = {
  init: function() {
    this.appendDummyInput()
        .appendField("滑冰头盔与护膝")
        .appendField(new Blockly.FieldImage("image1/13.jpg", 150, 150, { alt: "*", flipRtl: "FALSE" }));
    this.setPreviousStatement(true, null);
    this.setNextStatement(true, null);
    this.setColour(240);
 this.setTooltip("滑冰头盔与护膝");
 this.setHelpUrl("");
  }
};

Blockly.Blocks['shucaikuye'] = {
  init: function() {
    this.appendDummyInput()
        .appendField("滑雪板，滑雪杖")
        .appendField(new Blockly.FieldImage("image1/11.jpg", 150, 150, { alt: "*", flipRtl: "FALSE" }));
    this.setPreviousStatement(true, null);
    this.setNextStatement(true, null);
    this.setColour(45);
 this.setTooltip("滑雪板，滑雪杖");
 this.setHelpUrl("");
  }
};

Blockly.Blocks['qitalaji'] = {
  init: function() {
    this.appendStatementInput("qita")
        .setCheck(null)
        .appendField("冬奥会运动器材（限选两项）")
        .appendField(new Blockly.FieldImage("image1/4.jpg", 150, 150, { alt: "*", flipRtl: "FALSE" }));
    this.setColour(210);
 this.setTooltip("冬奥会运动器材（限选两项）");
 this.setHelpUrl("");
  }
};