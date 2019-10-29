// pages/realpoblems/realproblems.js
var util = require('../../utils/util.js');
var api = require('../../config/api.js');
var user = require('../../utils/user.js');
Page({

  /**
   * 页面的初始数据
   */
  data: {
    fruit: [
    {id: 1,name: '香蕉',}, 
    {id: 2,name: '苹果'}, 
    {id: 3,name: '西瓜'}, 
    {id: 4,name: '葡萄'},
    ],
    current2: '',
    position: 'left',
    // 答案解析data
    name: 'name1',
    //收藏：
    detailObj: {},
    index: null,
    // 是否收藏
    isCollected: false,
    //抽屉、划页
    current: 'tab1',
    current_scroll: 'tab1',
    showRight1: false,
    total: '',
    touchS: [0, 0],
    touchE: [0, 0],

    questions:[],//真题题目
   // id:'',//套卷id
    errormessage: "",
    count: 1,
    levelName: '初级',
    flag:'',//选项对错

    isright:[],//答对的题目
    iswrong:[],//答错的题目
    rchoice:'',//背题答案
    choiceArray: [],//选过的选项
    flagProblems:false//判断此题有没有做过
    

  },
  toggleRight1() {
    this.setData({
      showRight1: !this.data.showRight1
    });
  },
  // 选项选择事件
  handleFruitChange({ detail = {} }) {
    this.setData({
      current2: detail.value
    });
    console.log("选中的选项为："+this.data.current2)
    // console.log("1111111" + this.data.questions[this.data.count - 1].choices)
    for (var i = 0; i < this.data.questions[this.data.count - 1].choices.length;i++){
      if (this.data.questions[this.data.count - 1].choices[i].content===this.data.current2){
        if (this.data.questions[this.data.count - 1].choices[i].status===1){//答对题目
          //答对题目存入数组
          let righttemp = this.data.isright//*******存的是选项id */
          var rr = i + 1;
          righttemp.push(rr)
            this.setData({
              flag:true,
              isright: righttemp,
              flagchoices: true,
            })
           
          }else{//答错题目
          //答错题目存入数组
          let wrongtemp = this.data.iswrong
          var ww = i + 1;
          wrongtemp.push(ww)
          this.setData({
            flag: false,
            iswrong: wrongtemp,
            flagchoices: true,
          })
          }
        }
    }
    console.log("flag:"+this.data.flag)
    console.log('isright[]:'+this.data.isright.length)
    console.log('iswrong[]:' + this.data.iswrong.length)
    if (this.data.flag == false) {//错题
      this.wrongQuestions();
    }
    //做过的题
    this.problems();
  },
  //做过的题目保存到数组
  problems: function () {
    var f = true;
    for (var i = 0; i < this.data.choiceArray.length; i++) {
      if (this.data.choiceArray[i] == this.data.count) {
        f = false;
        break;
      } else {
        f = true;
      }
    }
    if (f) {
      var num = this.data.choiceArray
      var str = { "choice": this.data.current2, "flag": this.data.flag, "pageNum": this.data.count }
      num.push(str)
      this.setData({
        choiceArray: num
      })
      console.log("array" + this.data.choiceArray[0].pageNum)
    }
  },
  //答题/背题
  handleChange({ detail }) {
    this.setData({
      current: detail.key
    });
    console.log("答题/背题："+this.data.current)
    if(this.data.current==="tab1"){
      this.getDetils()
    } else if (this.data.current === "tab2"){
      this.getRead()
    }
  },
  //收藏图案
  handleCollection() {
    let isCollected = !this.data.questions[this.data.count - 1].iscollection;
    this.data.questions[this.data.count - 1].iscollection = isCollected;
    this.setData({
      // 下面本来是这样子的:isCollected=isCollected,可以简写
      isCollected
    })
    //提示用户
    wx.showToast({
      title: isCollected ? '收藏成功' : '取消收藏',
      icon: 'success'
    })
    if (isCollected) {
      this.collection();
    } else {
      this.cancelCollection();
    }
  },
  //收藏
  collection: function () {
    let that = this;
    var index = this.data.count
    var qid = this.data.questions[index - 1].qid
    let userInfo = wx.getStorageSync('userInfo');
    util.request(api.CollectionQuestions, { qid: qid, nickName: userInfo.nickName }).then(function (res) {
    });
  },
  //取消收藏
  cancelCollection: function () {
    let that = this;
    var index = this.data.count 
    var qid = this.data.questions[index - 1].qid
    let userInfo = wx.getStorageSync('userInfo');
    util.request(api.CancelCollection, { qid: qid, nickName: userInfo.nickName }).then(function (res) {

    });
  },
  // 页面滑动
  //   wx.switchTab({
  //   url: 'pages/collection/collection'
  // })
  touchStart: function (e) {
    // console.log(e.touches[0].pageX)
    let sx = e.touches[0].pageX
    let sy = e.touches[0].pageY
    this.data.touchS = [sx, sy]
  },
  touchMove: function (e) {
    let sx = e.touches[0].pageX;
    let sy = e.touches[0].pageY;
    this.data.touchE = [sx, sy]
  },
  touchEnd: function (e) {
    let start = this.data.touchS
    let end = this.data.touchE
    let that = this
    console.log(start)
    console.log(end)

    if (start[0] < end[0] - 30) {
      wx.setStorageSync("counta", that.data.count - 1);
      console.log('右滑')//上一题
      if (that.data.count > 0) {
        this.onLoad();
      }
      //显示做过的题
      if (that.data.choiceArray[that.data.count - 1]) {
        var j = that.data.count;
        console.log(that.data.choiceArray[that.data.count - 1].choice)
        that.setData({
          current2: that.data.choiceArray[that.data.count - 1].choice,
          flagchoices: true,
          flag: that.data.choiceArray[that.data.count - 1].flag
        })
      }
      if (that.data.count == 1) {
        wx.showToast({
          title: '已是第一题',
        })

      }
    
    } else if (start[0] > end[0] + 30) {
      this.setData({
        flagchoices: false
      });
      wx.setStorageSync("counta", that.data.count + 1);
      console.log('左滑')//下一题
      
      if (that.data.count < that.data.questions.length) {
        this.onLoad();

      } else {
        wx.showToast({
          title: '已是最后一题',
        })
      }
      //做过的题显示
      this.reproblem()
    } else {
      console.log('静止')
    }
  },
  //右滑做过的题显示
  reproblem: function () {
    var f = false;
    if (this.data.choiceArray.length > 0 && this.data.choiceArray != null) {
      for (var i = 0; i < this.data.choiceArray.length; i++) {
        if (this.data.choiceArray[i].pageNum == this.data.count) {
          f = true;
          break;
        } else {
          f = false;
        }
      }
    }
    console.log("f" + f)
    if (f) {
      this.setData({
        current2: this.data.choiceArray[this.data.count - 1].choice,
        flagchoices: true,
        flag: this.data.choiceArray[this.data.count - 1].flag
      })
    } else {
      //选项可选
      this.setData({
        current2: "",
        flagchoices: false,
      })
    }
  },
  //获取答题模式真题
  getDetils:function(){
    var id=wx.getStorageSync("id");
    let that=this;
    var levelName = wx.getStorageSync('levelName');
    let userInfo = wx.getStorageSync('userInfo');
    var nickName = userInfo.nickName;
    util.request(api.GetRealQuset + id + "/" + levelName + "/" + nickName+"/").then(res=>{
      if (res.errno === 0) {
        that.setData({
          questions: res.data.allQuestions,
          total: res.data.allQuestions.length
        })
        //console.log("1111111111111111111111111111")
        //console.log(res.data.allQuestions)
        console.log("total:" +this.data.total)
      } else {
      }
    })
  },
//背题模式
  getRead:function(){
    console.log("I am beiti");
    for (var i = 0; i < this.data.questions[this.data.count - 1].choices.length; i++) {

        if (this.data.questions[this.data.count - 1].choices[i].status == 1) {
          this.setData({
            rchoice: this.data.questions[this.data.count - 1].choices[i].content
          })
        }
    }
    console.log("rchoice" + this.data.rchoice)
  },
  //错题
  wrongQuestions: function () {
    let that = this;
    var index = this.data.count
    var qid = this.data.questions[index - 1].qid
    let userInfo = wx.getStorageSync('userInfo');
    util.request(api.WrongQuestions, { qid: qid, nickName: userInfo.nickName }).then(function (res) {
    });
  },
  //首页
  goHome() {
    wx.switchTab({
      url: '/pages/index/index',
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    //页面计数
     var counta = wx.getStorageSync("counta");
     console.log("counta:"+counta)
    if (counta) {
      this.setData({
        count: counta,
      });
    }
    //清空下一页选项
    if(this.data.current2){
      this.setData({
        current2:''
      });
    }
    //只随机查询选项一次
    if(this.data.questions.length==0){
      this.getDetils();   
    }
    // var that = this;
    // that.setData({
    //   id: options.id
    // })
     
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
     wx.removeStorageSync("counta");
     this.setData({
       rchoice:''
     })
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})