var iii=3;
Blockly.JavaScript['broadcast'] = function(block) {
  var statements_song = Blockly.JavaScript.statementToCode(block, 'song');
  s=String(statements_song).replace("  ","");
  //alert(s);
  var arrays = [];
  for(j=0,i=0;j<s.length;j+=2)
  {
   arrays[i]="song3/"+s[j]+s[j+1]+".mp3";
   i++;
  }
 // alert(array[0]);
  var audio = document.createElement("audio");
  audio.src =arrays[0];
  audio.playbackRate=4;
  //function setPlaySpeed(){ 
   // audio.playbackRate = 2;//设置速度1/1.5/2
  //}
  audio.play().playbackRate = 4;//播放
  i=1;
  audio.addEventListener("ended",function(){ 
      audio.src = arrays[i];
      audio.playbackRate=4;
      audio.play().playbackRate = 4;//播放

      i++;
    },false)
    //alert(s);
    if((s=="31317171111171")&&(iii==0))
    {//alert("恭喜你，弹奏成功！");
    Android.showToast("恭喜你，弹奏成功！");
    iii=3;
  }
  else
  {
    //alert("弹奏失败，再试一试！");
    Android.showToast("弹奏失败，再试一次");
    iii=3;
  }
  
};


Blockly.JavaScript['instruments'] = function(block) {
  var dropdown__instruments = block.getFieldValue(' instruments');
  var statements_instrument = Blockly.JavaScript.statementToCode(block, 'instrument');
  s=String(statements_instrument).replace("  ","");
  var ss=s[0]+String(dropdown__instruments);
  for(j=1;j<s.length;j++)
  {
    ss+=s[j];
    ss+=String(dropdown__instruments);

  }
  /*
  var arrays = [];
  for(j=0;j<s.length;j++)
  {
   arrays[j]=s[j]+dropdown__instruments+".mp3"
  }
  var audio = document.createElement("audio");
  audio.src =arrays[0];
  audio.playbackRate=4;
  //function setPlaySpeed(){ 
   // audio.playbackRate = 2;//设置速度1/1.5/2
  //}
  audio.play().playbackRate = 4;//播放
  i=1;
  audio.addEventListener("ended",function(){ 
      audio.src = arrays[i];
      audio.playbackRate=4;
      audio.play().playbackRate = 4;//播放

      i++;
    },false)
    */
  

    //alert(ss);

  // TODO: Assemble JavaScript into code variable.
  //var code = '...;\n';
  return String(ss);
};

Blockly.JavaScript['repeat'] = function(block) {
  var dropdown_num = block.getFieldValue('num');
  var statements_repeat = Blockly.JavaScript.statementToCode(block, 'repeat');
  s=String(statements_repeat).replace("  ","");
  var ss=s;
  for(j=1;j<dropdown_num;j++)
  {
   ss+=s;
  }
  //if(dropdown_num==1)
 // {code=s+s;}
 //alert()
  //alert(ss);
  // TODO: Assemble JavaScript into code variable.
  if(dropdown_num==2)
  iii--;
//alert(iii);
  var code = ss;
  return String(code);
};


Blockly.JavaScript['song'] = function(block) {
  var number_name = block.getFieldValue('NAME');
  // TODO: Assemble JavaScript into code variable.
  var code = number_name;
  return String(code);
};

Blockly.JavaScript['song1'] = function(block) {
  var dropdown_song = block.getFieldValue('song');
  // TODO: Assemble JavaScript into code variable.
  if(dropdown_song=='A3')
  { var code = 1}
  if(dropdown_song=='B3')
  { var code = 2}
  if(dropdown_song=='C3')
  { var code = 3}
  if(dropdown_song=='D3')
  { var code = 4}
  if(dropdown_song=='E3')
  { var code = 5}
  if(dropdown_song=='F3')
  { var code = 6}
  if(dropdown_song=='G3')
  { var code = 7}
  //var code = dropdown_song;
  //alert(code);
  return String(code);
};
/*
最早用的延时函数：
  var date1 = new Date();
  var currMS = date1.getMilliseconds(); //当前系统的毫秒值
  let miao = date1.getSeconds(); //当前秒
  var flag = true; //设置一个标记
  while (flag) {
      console.log("循环中...")
      flag = overLoop(1000)
      if (!flag) {
          console.log("循环终止")
      }
  }
  function overLoop(ms) {
      var date = new Date();
      if (date.getSeconds() == miao && date.getMilliseconds() >= currMS + ms) {
          return false;
      }
      if (date.getSeconds() != miao && date.getMilliseconds() > currMS + ms - 1000) {
          return false;
      }
      return true;
  }
*/