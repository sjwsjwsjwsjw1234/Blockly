var sss=0;
Blockly.JavaScript['broadcast'] = function(block) {
sss++;
if(sss%2==0)
{
  var statements_song = Blockly.JavaScript.statementToCode(block, 'song');
  s=String(statements_song).replace("  ","");
 // alert(s);
  var arrays = [];
  for(j=0;j<s.length;j++)
  {
   arrays[j]="song1/"+s[j]+".mp3"
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
  if(s=="3377117")
  {alert("恭喜你，弹奏成功！")}
else
{
  alert("弹奏失败，再试一试！")
}
}
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