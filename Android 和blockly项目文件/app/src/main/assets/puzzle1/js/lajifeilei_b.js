Blockly.Blocks['kehuishoulaji'] = {
  init: function() {
    this.appendStatementInput("kehuishou")
        .setCheck(null)
        .appendField("可回收垃圾(最多选择两种垃圾)")
        .appendField(new Blockly.FieldImage("image1/1.jpg", 150, 150, { alt: "*", flipRtl: "FALSE" }));
    this.setColour(150);
 this.setTooltip("可回收垃圾");
 this.setHelpUrl("https://image.baidu.com/search/index?tn=baiduimage&ipn=r&ct=201326592&cl=2&lm=-1&st=-1&fm=result&fr=&sf=1&fmq=1618060000885_R&pv=&ic=&nc=1&z=&hd=&latest=&copyright=&se=1&showtab=0&fb=0&width=&height=&face=0&istype=2&ie=utf-8&sid=&word=%E5%8F%AF%E5%9B%9E%E6%94%B6%E5%9E%83%E5%9C%BE");
  }
};

Blockly.Blocks['youhailaji'] = {
  init: function() {
    this.appendStatementInput("youhai")
        .setCheck(null)
        .appendField("有害垃圾(最多选择两种垃圾)")
        .appendField(new Blockly.FieldImage("image1/2.jpg", 150, 150, { alt: "*", flipRtl: "FALSE" }));
    this.setColour(345);
 this.setTooltip("有害垃圾");
 this.setHelpUrl("https://image.baidu.com/search/index?tn=baiduimage&ps=1&ct=201326592&lm=-1&cl=2&nc=1&ie=utf-8&word=%E6%9C%89%E5%AE%B3%E5%9E%83%E5%9C%BE");
  }
};

Blockly.Blocks['chuyulaji'] = {
  init: function() {
    this.appendStatementInput("chuyu")
        .setCheck(null)
        .appendField("厨余垃圾(最多选择两种垃圾)")
        .appendField(new Blockly.FieldImage("image1/3.jpg", 150, 150, { alt: "*", flipRtl: "FALSE" }));
    this.setColour(135);
 this.setTooltip("厨余垃圾");
 this.setHelpUrl("https://image.baidu.com/search/index?tn=baiduimage&ipn=r&ct=201326592&cl=2&lm=-1&st=-1&fm=result&fr=&sf=1&fmq=1618060931587_R&pv=&ic=&nc=1&z=&hd=&latest=&copyright=&se=1&showtab=0&fb=0&width=&height=&face=0&istype=2&ie=utf-8&sid=&word=%E5%8E%A8%E4%BD%99%E5%9E%83%E5%9C%BE");
  }
};

Blockly.Blocks['yilaguan'] = {
  init: function() {
    this.appendDummyInput()
        .appendField("矿泉水瓶子")
        .appendField(new Blockly.FieldImage("image1/5.jpg", 150, 150, { alt: "*", flipRtl: "FALSE" }));
    this.setPreviousStatement(true, null);
    this.setNextStatement(true, null);
    this.setColour(120);
 this.setTooltip("矿泉水瓶子");
 this.setHelpUrl("https://image.baidu.com/search/index?tn=baiduimage&ipn=r&ct=201326592&cl=2&lm=-1&st=-1&fm=result&fr=&sf=1&fmq=1618061606486_R&pv=&ic=&nc=1&z=&hd=&latest=&copyright=&se=1&showtab=0&fb=0&width=&height=&face=0&istype=2&ie=utf-8&sid=&word=%E7%9F%BF%E6%B3%89%E6%B0%B4%E7%93%B6%E5%AD%90");
  }
};

Blockly.Blocks['suitiexie'] = {
  init: function() {
    this.appendDummyInput()
        .appendField("碎铁屑")
        .appendField(new Blockly.FieldImage("image1/6.jpg", 150, 150, { alt: "*", flipRtl: "FALSE" }));
    this.setPreviousStatement(true, null);
    this.setNextStatement(true, null);
    this.setColour(150);
 this.setTooltip("碎铁屑");
 this.setHelpUrl("https://image.baidu.com/search/index?tn=baiduimage&ipn=r&ct=201326592&cl=2&lm=-1&st=-1&fm=result&fr=&sf=1&fmq=1618061738280_R&pv=&ic=&nc=1&z=&hd=&latest=&copyright=&se=1&showtab=0&fb=0&width=&height=&face=0&istype=2&ie=utf-8&sid=&word=%E7%A2%8E%E9%93%81%E5%B1%91");
  }
};

Blockly.Blocks['guopi'] = {
  init: function() {
    this.appendDummyInput()
        .appendField("果皮")
        .appendField(new Blockly.FieldImage("image1/10.jpg", 150, 150, { alt: "*", flipRtl: "FALSE" }));
    this.setPreviousStatement(true, null);
    this.setNextStatement(true, null);
    this.setColour(180);
 this.setTooltip("果皮");
 this.setHelpUrl("https://image.baidu.com/search/index?tn=baiduimage&ipn=r&ct=201326592&cl=2&lm=-1&st=-1&fm=result&fr=&sf=1&fmq=1618061841086_R&pv=&ic=0&nc=1&z=&hd=&latest=&copyright=&se=1&showtab=0&fb=0&width=&height=&face=0&istype=2&ie=utf-8&sid=&word=%E6%9E%9C%E7%9A%AE");
  }
};

Blockly.Blocks['fanhe'] = {
  init: function() {
    this.appendDummyInput()
        .appendField("一次性餐具")
        .appendField(new Blockly.FieldImage("image1/12.jpg", 150, 150, { alt: "*", flipRtl: "FALSE" }));
    this.setPreviousStatement(true, null);
    this.setNextStatement(true, null);
    this.setColour(135);
 this.setTooltip("一次性餐具");
 this.setHelpUrl("https://image.baidu.com/search/index?tn=baiduimage&ipn=r&ct=201326592&cl=2&lm=-1&st=-1&fm=result&fr=&sf=1&fmq=1618061984590_R&pv=&ic=&nc=1&z=&hd=&latest=&copyright=&se=1&showtab=0&fb=0&width=&height=&face=0&istype=2&ie=utf-8&sid=&word=%E4%B8%80%E6%AC%A1%E6%80%A7%E9%A4%90%E5%85%B7");
  }
};

Blockly.Blocks['feidianchi'] = {
  init: function() {
    this.appendDummyInput()
        .appendField("废电池")
        .appendField(new Blockly.FieldImage("image1/7.jpg", 150, 150, { alt: "*", flipRtl: "FALSE" }));
    this.setPreviousStatement(true, null);
    this.setNextStatement(true, null);
    this.setColour(0);
 this.setTooltip("废电池");
 this.setHelpUrl("https://image.baidu.com/search/index?tn=baiduimage&ipn=r&ct=201326592&cl=2&lm=-1&st=-1&fm=result&fr=&sf=1&fmq=1618062025399_R&pv=&ic=&nc=1&z=&hd=&latest=&copyright=&se=1&showtab=0&fb=0&width=&height=&face=0&istype=2&ie=utf-8&sid=&word=%E5%BA%9F%E7%94%B5%E6%B1%A0");
  }
};

Blockly.Blocks['nongyaopingzi'] = {
  init: function() {
    this.appendDummyInput()
        .appendField("过期的药")
        .appendField(new Blockly.FieldImage("image1/8.jpg", 150, 150, { alt: "*", flipRtl: "FALSE" }));
    this.setPreviousStatement(true, null);
    this.setNextStatement(true, null);
    this.setColour(75);
 this.setTooltip("过期的药");
 this.setHelpUrl("https://image.baidu.com/search/index?tn=baiduimage&ipn=r&ct=201326592&cl=2&lm=-1&st=-1&fm=result&fr=&sf=1&fmq=1618062126817_R&pv=&ic=&nc=1&z=&hd=&latest=&copyright=&se=1&showtab=0&fb=0&width=&height=&face=0&istype=2&ie=utf-8&sid=&word=%E8%BF%87%E6%9C%9F%E7%9A%84%E8%8D%AF");
  }
};

Blockly.Blocks['yugutou'] = {
  init: function() {
    this.appendDummyInput()
        .appendField("鱼骨头")
        .appendField(new Blockly.FieldImage("image1/13.jpg", 150, 150, { alt: "*", flipRtl: "FALSE" }));
    this.setPreviousStatement(true, null);
    this.setNextStatement(true, null);
    this.setColour(240);
 this.setTooltip("鱼骨头");
 this.setHelpUrl("https://image.baidu.com/search/index?tn=baiduimage&ipn=r&ct=201326592&cl=2&lm=-1&st=-1&fm=result&fr=&sf=1&fmq=1618062242415_R&pv=&ic=&nc=1&z=&hd=&latest=&copyright=&se=1&showtab=0&fb=0&width=&height=&face=0&istype=2&ie=utf-8&sid=&word=%E9%B1%BC%E9%AA%A8%E5%A4%B4&f=3&oq=yugutou&rsp=0");
  }
};

Blockly.Blocks['shucaikuye'] = {
  init: function() {
    this.appendDummyInput()
        .appendField("废纸巾")
        .appendField(new Blockly.FieldImage("image1/11.jpg", 150, 150, { alt: "*", flipRtl: "FALSE" }));
    this.setPreviousStatement(true, null);
    this.setNextStatement(true, null);
    this.setColour(45);
 this.setTooltip("废纸巾");
 this.setHelpUrl("https://image.baidu.com/search/index?tn=baiduimage&ipn=r&ct=201326592&cl=2&lm=-1&st=-1&fm=result&fr=&sf=1&fmq=1618061429835_R&pv=&ic=0&nc=1&z=&hd=&latest=&copyright=&se=1&showtab=0&fb=0&width=&height=&face=0&istype=2&ie=utf-8&sid=&word=%E6%B1%A1%E6%9F%93%E7%9A%84%E7%BA%B8%E5%B7%BE");
  }
};

Blockly.Blocks['qitalaji'] = {
  init: function() {
    this.appendStatementInput("qita")
        .setCheck(null)
        .appendField("其他垃圾(最多选择两种垃圾)")
        .appendField(new Blockly.FieldImage("image1/4.jpg", 150, 150, { alt: "*", flipRtl: "FALSE" }));
    this.setColour(210);
 this.setTooltip("其他垃圾");
 this.setHelpUrl("https://image.baidu.com/search/index?tn=baiduimage&ipn=r&ct=201326592&cl=2&lm=-1&st=-1&fm=result&fr=&sf=1&fmq=1618060769291_R&pv=&ic=&nc=1&z=&hd=&latest=&copyright=&se=1&showtab=0&fb=0&width=&height=&face=0&istype=2&ie=utf-8&sid=&word=%E5%85%B6%E4%BB%96%E5%9E%83%E5%9C%BE");
  }
};