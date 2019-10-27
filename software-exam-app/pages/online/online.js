// pages/online/online.js
var util = require('../../utils/util.js');
var api = require('../../config/api.js');
const { $Message } = require('../../dist/base/index');
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    // 选项：

    current: '',
    position: 'left',
    // 答案解析data
    name: 'name1',
    //收藏：
    detailObj: {},
    index: null,
    // 是否收藏
    isCollected: false,

    showRight1: false,
    //页面方位
    touchS: [0, 0],
    touchE: [0, 0],
    errormessage: "",

    //右侧题目条数
    total: 75,
    //题目List
    questions: [],
    levelName: '初级',
    count: 1,
    flag: false,
    //答对题号
    rightChoice: [],
    //答错题号
    wrongChoice: [],
    ttime: 0,



  },
  // 选项选择事件
  handleChange({ detail = {} }) {
    this.setData({
      current: detail.value
    });
    for (var i = 0; i < this.data.questions[this.data.count - 1].choices.length; i++) {
      if (this.data.questions[this.data.count - 1].choices[i].content === this.data.current) {
        if (this.data.questions[this.data.count - 1].choices[i].status === 1) {//答对题目
          //答对题目存入数组
          var qqid=this.data.questions[this.data.count-1].qid;
         this.data.rightChoice.push(qqid);
        
          this.setData({
            flag: true,
          });


        } else {//答错题目
          //答错题目存入数组
          var wqid = this.data.questions[this.data.count - 1].qid;
          this.data.wrongChoice.push(wqid);
          this.setData({
            flag: false,
          
          });
          // console.log(this.data.wrongChoice);
        }
      }
    }
    //错题
    console.log(this.data.flag)
    if (this.data.flag == false) {
      this.wrongQuestions();
    }




  },

  //抽屉
  toggleRight1() {
    this.setData({
      showRight1: !this.data.showRight1
    });
  },
  //收藏
  handleCollection() {
    let isCollected = !this.data.questions[this.data.count-1].collection;
    this.data.questions[this.data.count-1].collection = isCollected;
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
      //收藏
      this.collection();
    } else {
      //取消收藏
      this.cancelCollection();
    }
  },
  //收藏
  collection: function () {
    let that = this;
    var index = this.data.count
    var qid = this.data.questions[index - 1].qid;
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
  //错题
  wrongQuestions: function () {
    let that = this;
    var index = this.data.count
    var qid = this.data.questions[index - 1].qid
    let userInfo = wx.getStorageSync('userInfo');
    util.request(api.WrongQuestions, { qid: qid, nickName: userInfo.nickName }).then(function (res) {
    });
  },
  //页面滑动切换
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
    // console.log(start)
    // console.log(end)

    if (start[0] < end[0] - 30) {
      wx.setStorageSync("counta", that.data.count - 1);
      console.log('右滑')//上一题
      var countr = wx.getStorageSync("counta");
      if (countr <= this.data.questions.length) {
        this.onLoad();

      }
      if (countr <= 1) {
        wx.showToast({
          title: '已经是第一题啦！',
        })
      }



    } else if (start[0] > end[0] + 30) {
      wx.setStorageSync("counta", that.data.count + 1);
      console.log('左滑')//下一题
      var countw = wx.getStorageSync("counta");

      if (countw <= this.data.questions.length) {
        this.onLoad();
      }
      if (countw > this.data.questions.length) {
        wx.showToast({
          title: '已经是最后一题！',
        })
      }


    } else {
      console.log('静止')
    }
  },

  //显示问题和答案
  showquestions: function () {
    let that = this;
    let userInfo = wx.getStorageSync('userInfo');
    util.request(api.OnlinePaper, { levelName: that.data.levelName, nickName: userInfo.nickName }).then(function (res) {
      if (res.errno === -1) {
        that.setData({
          errormessage: res.errmsg
        });
      } else {
        that.setData({
          questions: res.data
        });
        console.log(that.data.questions);

      }
    })
  },
  /**
   * 提交试卷
   */
  commitPaper: function () {
    wx.setStorageSync("timer", new Date().getTime() + 7200000)
    console.log("================");
    console.log(wx.getStorageSync("timer"));
    var counti = wx.getStorageSync("counta");
    if (counti > this.data.questions.length) {
      var score = this.data.rightChoice.length;
      console.log(score);
      wx.navigateTo({
        url: '/pages/score/score?score=' + score,
      })
    } else {
      wx.showToast({
        title: '还没有答完题！',
      })
    }

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    // this.setData({
    //   targetTime: new Date().getTime() + 7200000,


    // });
    let that = this;
    that.setData({
      ttime: wx.getStorageSync("timer")
    })


    var counta = wx.getStorageSync("counta");

    if (counta) {
      this.setData({
        count: counta,

      });
    }
    if(this.data.questions.length!=0)
    {
      this.setData({
        isCollected:this.data.questions[this.data.count-1].collection,
      });
   
    }


    console.log(this.data.count)
    var levelName = wx.getStorageSync('levelName');
    this.setData({
      levelName: levelName
    });
    // console.log(this.data.levelName);
    //若question数组为空，才请求后台数据库数据存入
    if (this.data.questions.length == 0) {
      this.showquestions();
    }





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
    this.setData({
      clearTimer: true
    });
    wx.removeStorageSync("counta");
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

  },

})