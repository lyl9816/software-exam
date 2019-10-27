// pages/errorproblems/errorproblems.js
var util = require('../../utils/util.js');
var api = require('../../config/api.js');
const { $Message } = require('../../dist/base/index');
Page({

  /**
   * 页面的初始数据
   */
  data: {
    // 选项：
    fruit: [{
      id: 1,
      name: '香蕉',
    }, {
      id: 2,
      name: '苹果'
    }, {
      id: 3,
      name: '西瓜'
    }, {
      id: 4,
      name: '葡萄',
    }],
    current: '苹果',
    position: 'left',
    // 答案解析data
    name: 'name1',
    //收藏：
    detailObj: {},
    index: null,
    // 是否收藏
    isCollected: false,

    current: 'tab1',
    current_scroll: 'tab1',
    showRight1: false,
    touchS: [0, 0],
    touchE: [0, 0],
    //错题
    order: [],
    count: 1,
    flag: false,
    right: 0,
    error: 0,
    pagenum: [],
    currents: [],//选过的选项，
    sort: "",
    choice: ""

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
    for (var i = 0; i < this.data.order[this.data.count - 1].choices.length; ++i) {
      if (this.data.order[this.data.count - 1].choices[i].content === this.data.current2) {

        if (this.data.order[this.data.count - 1].choices[i].status === 1) {
          this.setData({
            flag: true,
          });
        } else {
          this.setData({
            flag: false,
          });
        }
      }
    }
    //回答正确
    console.log(this.data.flag)
    if (this.data.flag == true) {
      this.removeQuestions();
    }

  },
  handleChange({ detail }) {
    this.setData({
      current: detail.key
    });
    if (this.data.current === 'tab1') {
      this.showWrongQuestions();
    } else {
      this.showWrongAnswer();
    }
  },
  /**
   * 错题库背题模式
   */
  showWrongAnswer:function(){
    for (var i = 0; i < this.data.order[this.data.count - 1].choices.length; i++) {
      if (this.data.order[this.data.count - 1].choices[i].status == 1) {
        this.setData({
          choice: this.data.order[this.data.count - 1].choices[i].content
        })
      }

    }
  },
  //答对移除错题
  removeQuestions:function(){
    let that = this;
    var index = this.data.count
    var qid = this.data.order[index - 1].qid
    let userInfo = wx.getStorageSync('userInfo');
    util.request(api.RemoveWrong, { qid: qid, nickName: userInfo.nickName }).then(function (res) {

    });


  },
  //收藏
  handleCollection() {
    let isCollected = !this.data.isCollected
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
    var qid = this.data.order[index - 1].qid
    let userInfo = wx.getStorageSync('userInfo');
    util.request(api.CollectionQuestions, { qid: qid, nickName: userInfo.nickName }).then(function (res) {
    });
  },
  //取消收藏
  cancelCollection: function () {
    let that = this;
    var index = this.data.count
    var qid = this.data.order[index - 1].qid
    let userInfo = wx.getStorageSync('userInfo');
    util.request(api.CancelCollection, { qid: qid, nickName: userInfo.nickName }).then(function (res) {

    });
  },
  /**
     * 显示错题
     */
  showWrongQuestions() {
    let that = this;
    let userInfo = wx.getStorageSync('userInfo');
    util.request(api.FindWrong, { nickName: userInfo.nickName }).then(function (res) {
      if (res.errno === -1) {
        that.setData({
          errormessage: res.errmsg
        });
      } else {
        that.setData({
          order: res.data
        });
        console.log(that.data.order);
      }
    })


  },
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
      var countr = wx.getStorageSync("counta");
      if (countr <= this.data.order.length) {
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
      // 对错题数
      if (that.data.flag) {
        that.setData({
          right: that.data.right + 1,
        });
      } else {
        that.setData({
          error: that.data.error + 1
        });
      }
      var countw = wx.getStorageSync("counta");

      if (countw <= this.data.order.length) {
        this.onLoad();
      }
      if (countw > this.data.order.length) {
        wx.showToast({
          title: '已经是最后一题！',
        })
      }

    } else {
      console.log('静止')
    }
  },
  /**
  * 返回个人中心
  */
  goMine() {
    wx.switchTab({
      url: '/pages/mine/mine',
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this
    //若order数组为空，才请求后台数据
    if (this.data.order.length == 0) {
      this.showWrongQuestions();
    }
    var counta = wx.getStorageSync("counta");
    // console.log(counta)
    if (counta) {
      this.setData({
        count: counta,
      });
    }
    if (this.data.order.length != 0) {
      this.setData({
        isCollected: this.data.order[this.data.count - 1].collection,
      });
    }
    if (this.data.current2) {
      this.setData({
        current2: ""
      });
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
    wx.removeStorageSync("counta");
    this.setData({
      flag: false,
      right: 0,
      error: 0,
      current2: "",
      pagenum: [],
      count: 1,
      currents: [],
      choice: "",
      errormessage: ""

    });

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