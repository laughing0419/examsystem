<template>
  <div>
    <video autoplay style="position: absolute;left: 1%"></video>
    <canvas id="myCanvas" style="position: absolute;left: 30%"></canvas>
    <button id="capture" style="position:absolute;left: 30%;top: 55%;">拍照</button>
    <div id="attr" style="position:absolute; right: 200px">
      性别：<input type="text" id="sex"></input>
      <br><br>
      年龄：<input type="text" id="age"></input>
      <br><br>
      微笑程度：<input type="text" id="smile"></input>
      <br><br>
      开心程度：<input type="text" id="emotion"></input>
      <br><br>
    </div>
  </div>
</template>

<script>
import 'http://code.jquery.com/jquery-latest.js'
import '@/assets/js/face.js'
export default {
  name: "faceDetection"
}
</script>

<style scoped>
video,canvas{
  border: 1px solid gray;
  width: 400px;
  height: 400px;
  border-radius: 50%;
}
</style>
