<template>
  <el-dialog :visible.sync="visible" title="拍照" width="41%" :close-on-click-modal="false" :close-on-press-escape="false">
    <el-form>
      <div class="camera-box">
        <video id="video" :width="videoWidth" :height="videoHeight" v-show="!imgSrc"></video>
        <canvas id="canvas" :width="videoWidth" :height="videoHeight" v-show="imgSrc"></canvas>
        <p class="camera-p">{{!imgSrc?'提示：请将材料居中按"拍照"键确认':''}}</p>
        <el-button type="primary" @click="setImage" v-if="!imgSrc" class="camera-btn">拍照</el-button>
        <el-button type="primary" v-if="imgSrc" @click="setFileUpload" class="camera-btn" id="a">确定</el-button>
      </div>
    </el-form>
  </el-dialog>
</template>

<script>
export default {
  name:'faceRegister',
  data () {
    return {
      videoWidth: '401',
      videoHeight: '340',
      thisCancas: null,
      thisContext: null,
      thisVideo: null,
      imgSrc: '',
      visible: false
    }
  },
  methods: {
    init () {
      this.visible = true;
      this.$nextTick(() => {
        this.getCompetence()
      })
    },
    getCompetence() {
      // 初始化的时候直接让为空
      this.imgSrc = '';
      var _this = this;
      this.thisCancas = document.getElementById('canvas')
      this.thisContext = this.thisCancas.getContext('2d')
      this.thisVideo = document.getElementById('video')
      // 旧版本浏览器可能根本不支持mediaDevices，我们首先设置一个空对象
      if (navigator.mediaDevices === undefined) {
        navigator.mediaDevices = {}
      }
      // 一些浏览器实现了部分mediaDevices，我们不能只分配一个对象
      // 使用getUserMedia，因为它会覆盖现有的属性。
      // 这里，如果缺少getUserMedia属性，就添加它。
      if (navigator.mediaDevices.getUserMedia === undefined) {
        navigator.mediaDevices.getUserMedia = function (constraints) {
          // 首先获取现存的getUserMedia(如果存在)
          var getUserMedia = navigator.webkitGetUserMedia || navigator.mozGetUserMedia || navigator.getUserMedia
          // 有些浏览器不支持，会返回错误信息
          // 保持接口一致
          if (!getUserMedia) {
            return Promise.reject(new Error('getUserMedia is not implemented in this browser'))
          }
          // 否则，使用Promise将调用包装到旧的navigator.getUserMedia
          return new Promise(function (resolve, reject) {
            getUserMedia.call(navigator, constraints, resolve, reject)
          })
        }
      }
      var constraints = {
        audio: false,
        video: {width: this.videoWidth, height: this.videoHeight, transform: 'scaleX(-1)'}
      }
      navigator.mediaDevices.getUserMedia(constraints).then(function (stream) {
        // 旧的浏览器可能没有srcObject
        if ('srcObject' in _this.thisVideo) {
          _this.thisVideo.srcObject = stream
        } else {
          // 避免在新的浏览器中使用它，因为它正在被弃用。
          _this.thisVideo.src = window.URL.createObjectURL(stream)
        }
        _this.thisVideo.onloadedmetadata = function (e) {
          _this.thisVideo.play()
        }
      }).catch(err => {
        console.log(err)
      })
    },
    setImage() {
      var _this = this
      // 点击，canvas画图
      _this.thisContext.drawImage(_this.thisVideo, 0, 0, _this.videoWidth, _this.videoHeight)
      // 获取图片base64链接
      var image = this.thisCancas.toDataURL('image/png')
      _this.imgSrc = image;

    },
    //base64转文件
    dataURLtoFile(dataurl,filename){
      var arr =dataurl.split(",");
      var mime = arr[0].match(/:(.*?);/)[1];
      var bstr = atob(arr[1]);
      var n = bs*96
      tr.length;
      var u8arr = new Uint8Array(n);
      while (n--){
        u8arr[n] = bstr.charCodeAt(n);
      }
      return new File([u8arr],filename,{type:mime});
    },
    setFileUpload(){
      this.visible = false;
      // this.$emit(this.imgSrc);
      this.stopNavigator();
      console.log(this.imgSrc);
      this.download()
    },
    download(){
      let a =document.createElement('a');
      a.href = this.imgSrc;
      var name='stu';
      a.download = name;
      a.click();
    },
    //关闭摄像头
    stopNavigator(){
      this.thisVideo.srcObject.getTracks()[0].stop();
    },
  },
}
</script>

<style scoped>

</style>
