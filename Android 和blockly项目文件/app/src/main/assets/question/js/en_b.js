Blockly.Blocks['en1'] = {
  init: function() {
    this.appendDummyInput()
        .appendField("英文字母元音因素归类")
        .appendField("获取提示")
        .appendField(new Blockly.FieldDropdown([[{"src":"https://www.gstatic.com/codesite/ph/images/star_on.gif","width":15,"height":15,"alt":"*"},"OPTIONNAME1"], [{"src":"image1/tip1.png","width":250,"height":250,"alt":"*"},"OPTIONNAME2"], [{"src":"image1/tip2.png","width":300,"height":200,"alt":"*"},"OPTIONNAME3"]]), "tishi");
    this.appendStatementInput("NAME1")
        .setCheck(null)
        .appendField("1 选择与Aa相同因素的元音音标");
    this.appendValueInput("NAME00")
        .setCheck(null)
        .appendField("选择字母");
    this.appendDummyInput();
    this.appendValueInput("NAME01")
        .setCheck(null);
    this.appendValueInput("NAME02")
        .setCheck(null);
    this.appendValueInput("NAME03")
        .setCheck(null);
    this.appendValueInput("NAME04")
        .setCheck(null);
    this.appendValueInput("NAME05")
        .setCheck(null);
    this.appendValueInput("NAME06")
        .setCheck(null);
    this.appendValueInput("NAME07")
        .setCheck(null);
    this.appendStatementInput("NAME18")
        .setCheck(null)
        .appendField("2 选择与Ee相同因素的元音音标");
    this.appendValueInput("NAME10")
        .setCheck(null)
        .appendField("选择字母");
    this.appendValueInput("NAME11")
        .setCheck(null);
    this.appendValueInput("NAME12")
        .setCheck(null);
    this.appendValueInput("NAME13")
        .setCheck(null);
    this.appendValueInput("NAME14")
        .setCheck(null);
    this.appendValueInput("NAME15")
        .setCheck(null);
    this.appendValueInput("NAME16")
        .setCheck(null);
    this.appendValueInput("NAME17")
        .setCheck(null);
    this.appendStatementInput("NAME19")
        .setCheck(null)
        .appendField("3 选择与Ff相同因素的元音音标");
    this.appendValueInput("NAME20")
        .setCheck(null)
        .appendField("选择字母");
    this.appendValueInput("NAME21")
        .setCheck(null);
    this.appendValueInput("NAME22")
        .setCheck(null);
    this.appendValueInput("NAME23")
        .setCheck(null);
    this.appendValueInput("NAME24")
        .setCheck(null);
    this.appendValueInput("NAME25")
        .setCheck(null);
    this.appendValueInput("NAME26")
        .setCheck(null);
    this.appendValueInput("NAME27")
        .setCheck(null);
    this.appendStatementInput("NAME28")
        .setCheck(null)
        .appendField("4 选择与Ii相同因素的元音音标");
    this.appendValueInput("NAME30")
        .setCheck(null)
        .appendField("选择字母");
    this.appendValueInput("NAME31")
        .setCheck(null);
    this.appendValueInput("NAME32")
        .setCheck(null);
    this.appendValueInput("NAME33")
        .setCheck(null);
    this.appendValueInput("NAME34")
        .setCheck(null);
    this.appendValueInput("NAME35")
        .setCheck(null);
    this.appendValueInput("NAME36")
        .setCheck(null);
    this.appendValueInput("NAME37")
        .setCheck(null);
    this.appendStatementInput("NAME38")
        .setCheck(null)
        .appendField("5 选择与Oo相同因素的元音音标");
    this.appendValueInput("NAME40")
        .setCheck(null)
        .appendField("选择字母");
    this.appendValueInput("NAME41")
        .setCheck(null);
    this.appendValueInput("NAME42")
        .setCheck(null);
    this.appendValueInput("NAME43")
        .setCheck(null);
    this.appendValueInput("NAME44")
        .setCheck(null);
    this.appendValueInput("NAME45")
        .setCheck(null);
    this.appendValueInput("NAME46")
        .setCheck(null);
    this.appendValueInput("NAME47")
        .setCheck(null);
    this.appendStatementInput("NAME48")
        .setCheck(null)
        .appendField("6 选择与Uu相同因素的元音音标");
    this.appendValueInput("NAME50")
        .setCheck(null)
        .appendField("选择字母");
    this.appendValueInput("NAME51")
        .setCheck(null);
    this.appendValueInput("NAME52")
        .setCheck(null);
    this.appendValueInput("NAME53")
        .setCheck(null);
    this.appendValueInput("NAME54")
        .setCheck(null);
    this.appendValueInput("NAME55")
        .setCheck(null);
    this.appendValueInput("NAME56")
        .setCheck(null);
    this.appendValueInput("NAME57")
        .setCheck(null);
    this.appendStatementInput("NAME58")
        .setCheck(null)
        .appendField("7 选择与Rr相同因素的元音音标");
    this.appendValueInput("NAME60")
        .setCheck(null)
        .appendField("选择字母");
    this.appendValueInput("NAME61")
        .setCheck(null);
    this.appendValueInput("NAME62")
        .setCheck(null);
    this.appendValueInput("NAME63")
        .setCheck(null);
    this.appendValueInput("NAME64")
        .setCheck(null);
    this.appendValueInput("NAME65")
        .setCheck(null);
    this.appendValueInput("NAME66")
        .setCheck(null);
    this.appendValueInput("NAME67")
        .setCheck(null);
    this.setColour(170);
 this.setTooltip("");
 this.setHelpUrl("");
  }
};

Blockly.Blocks['letter'] = {
  init: function() {
    this.appendDummyInput()
        .appendField("字母")
        .appendField(new Blockly.FieldDropdown([["Aa","1"], ["Bb","22"], ["Cc","222"], ["Dd","2222"], ["Ee","2"], ["Ff","3"], ["Gg","22222"], ["Hh","11"], ["Ii","4"], ["Jj","111"], ["Kk","1111"], ["Ll","33"], ["Mm","333"], ["Nn","3333"], ["Oo","5"], ["Pp","222222"], ["Qq","66"], ["Rr","7"], ["Ss","33333"], ["Tt","2222222"], ["Uu","6"], ["Vv","22222222"], ["Ww","666"], ["Xx","333333"], ["Yy","44"], ["Zz","3333333"]]), "letter");
    this.setOutput(true, null);
    this.setColour(230);
 this.setTooltip("");
 this.setHelpUrl("");
  }
};

Blockly.Blocks['yinbiao'] = {
  init: function() {
    this.appendDummyInput()
        .appendField("音标")
        .appendField(new Blockly.FieldDropdown([["/ei/","1"], ["/i:/ ","2"], ["/e/","3"], ["/ai/","4"], ["/ou/","5"], ["/ju:/","6"], ["/a:/","7"]]), "yinbiao");
    this.setPreviousStatement(true, null);
    this.setColour(270);
 this.setTooltip("");
 this.setHelpUrl("");
  }
};