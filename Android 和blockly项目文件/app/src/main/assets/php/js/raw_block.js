/*
Blockly.Blocks['firstblock'] = {
  init: function() {
    this.appendDummyInput()
        .appendField("raw(5)");
    this.setOutput(true, null);
    this.setColour(330);
 this.setTooltip("这是我的第一个块");
 this.setHelpUrl("http://baidu.com");
  }
};
*/
Blockly.Blocks['firstblock'] = {
  init: function() {
    this.appendValueInput('VALUE')
        .setCheck('String')
        .appendField('length of');
    this.setOutput(true, 'Number');
    this.setColour(160);
    this.setTooltip('Returns number of letters in the provided text.');
    this.setHelpUrl('http://www.w3schools.com/jsref/jsref_length_string.asp');
  }
};
