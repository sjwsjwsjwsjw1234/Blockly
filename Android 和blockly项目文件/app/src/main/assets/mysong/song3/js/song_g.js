var iii=3;
var sss=0;
Blockly.JavaScript['choose1'] = function(block) {
sss++;
if(sss%2==0)
{
  var dropdown_check = block.getFieldValue('check');
  var statements_song = Blockly.JavaScript.statementToCode(block, 'song');
  // TODO: Assemble JavaScript into code variable.
  s=String(statements_song).replace("  ","");
  //alert(s);
  var arrays = [];
  var r=[];
  for(j=0,i=0;j<s.length;j+=3)
  {
   arrays[i]="song3/"+s[j]+s[j+1]+".mp3";
   r[i]=s[j+2];
   i++;
  }
 // alert(array[0]);
  var audio = document.createElement("audio");
  audio.src =arrays[0];
  audio.playbackRate=r[0];
  //function setPlaySpeed(){ 
   // audio.playbackRate = 2;//设置速度1/1.5/2
  //}
  audio.play().playbackRate = r[0];//播放
  i=1;
  audio.addEventListener("ended",function(){ 
      audio.src = arrays[i];
      audio.playbackRate=r[i];
      audio.play().playbackRate = r[i];//播放

      i++;
    },false)
    //alert(s);

    if(s=="514514614714714614514414314314414514514414414814")
    {alert("恭喜你，弹奏成功！")}
  else
  {
    alert("弹奏失败，再试一试！")
  }
    iii=3;

}
};
Blockly.JavaScript['choose2'] = function(block) {
sss++;
if(sss%2==0)
{
  var dropdown_check = block.getFieldValue('check');
  var statements_song = Blockly.JavaScript.statementToCode(block, 'song');
  // TODO: Assemble JavaScript into code variable.
  s=String(statements_song).replace("  ","");
  //alert(s);
  var arrays = [];
  var r=[];
  for(j=0,i=0;j<s.length;j+=3)
  {
   arrays[i]="song3/"+s[j]+s[j+1]+".mp3";
   r[i]=s[j+2];
   i++;
  }
 // alert(array[0]);
  var audio = document.createElement("audio");
  audio.src =arrays[0];
  audio.playbackRate=r[0];
  //function setPlaySpeed(){ 
   // audio.playbackRate = 2;//设置速度1/1.5/2
  //}
  audio.play().playbackRate = r[0];//播放
  i=1;
  audio.addEventListener("ended",function(){ 
      audio.src = arrays[i];
      audio.playbackRate=r[i];
      audio.play().playbackRate = r[i];//播放

      i++;
    },false)
    //alert(s);

    if(s=="524724224824124724624824524524524624724124824724824")
    {alert("恭喜你，弹奏成功！")}
  else
  {
    alert("弹奏失败，再试一试！")
  }
    iii=3;
}

};
Blockly.JavaScript['broadcast'] = function(block) {
sss++;
if(sss%2==0)
{
  var dropdown_broadcast = block.getFieldValue('broadcast');
  var statements_song = Blockly.JavaScript.statementToCode(block, 'song');
  // TODO: Assemble JavaScript into code variable.
  s=String(statements_song).replace("  ","");
  //alert(s);
  var arrays = [];
  var r=[];
  for(j=0,i=0;j<s.length;j+=3)
  {
   arrays[i]="song3/"+s[j]+s[j+1]+".mp3";
   r[i]=s[j+2];
   i++;
  }
 // alert(array[0]);
  var audio = document.createElement("audio");
  audio.src =arrays[0];
  audio.playbackRate=r[0];
  //function setPlaySpeed(){ 
   // audio.playbackRate = 2;//设置速度1/1.5/2
  //}
  audio.play().playbackRate = r[0];//播放
  i=1;
  audio.addEventListener("ended",function(){ 
      audio.src = arrays[i];
      audio.playbackRate=r[i];
      audio.play().playbackRate = r[i];//播放

      i++;
    },false)
    //alert(s);

  
    iii=3;

  }
};



Blockly.JavaScript['instruments'] = function(block) {

  var dropdown__instruments = block.getFieldValue(' instruments');
  var statements_instrument = Blockly.JavaScript.statementToCode(block, 'instrument');
  s=String(statements_instrument).replace("  ","");
  var ss=s[0]+String(dropdown__instruments)+s[2];
  for(j=3;j<s.length;j+=3)
  {
    ss+=s[j];
    ss+=String(dropdown__instruments);
    ss+=s[j+2];

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
Blockly.JavaScript['instrument2'] = function(block) {

  var statements_instrument2 = Blockly.JavaScript.statementToCode(block, 'instrument2');
  // TODO: Assemble JavaScript into code variable.
  s=String(statements_instrument2).replace("  ","");
  var ss=s[0]+'6'+'4';
  for(j=1;j<s.length;j++)
  {
    ss+=s[j];
    ss+='6';
    ss+='4';
  }
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

Blockly.JavaScript['change'] = function(block) {

  var dropdown_change = block.getFieldValue('change');
  var statements_song = Blockly.JavaScript.statementToCode(block, 'song');
  // TODO: Assemble JavaScript into code variable.
  s=String(statements_song).replace("  ","");
  s2=dropdown_change*4;
  //alert(s2)
  var ss=s[0]+s[1]+s2;
  for(j=3;j<s.length;j+=3)
  {
    ss+=s[j];
    ss+=s[j+1];
    ss+=s2;
    

  }
  return String(ss);

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
  { var code = 114}
  if(dropdown_song=='B3')
  { var code = 214}
  if(dropdown_song=='C3')
  { var code = 314}
  if(dropdown_song=='D3')
  { var code = 414}
  if(dropdown_song=='E3')
  { var code = 514}
  if(dropdown_song=='F3')
  { var code = 614}
  if(dropdown_song=='G3')
  { var code = 714}
  //var code = dropdown_song;
  //alert(code);
  return String(code);

};
Blockly.JavaScript['xiuzhi'] = function(block) {

  // TODO: Assemble JavaScript into code variable.
  var code = 814;
  //alert(code)
  return String(code);

};

Blockly.JavaScript['xiaoxingxing'] = function(block) {

  // TODO: Assemble JavaScript into code variable.
  var code = '314314714714114114714814614614514514414414314814714714614614514514414814714714614614514514414814314314714714114114714814614614514514414414314814'
  //alert(code)
  return  code;

};
Blockly.JavaScript['huanlesong'] = function(block) {

  // TODO: Assemble JavaScript into code variable.
  var code = '514514614714714614514414314314414514514414414814514514614714714614514414314314414514414314314814414414514314414515615514314414515615514414314414314814514514614714714614514414314314414514414314314'
  //alert(code)
  return  code;

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
