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
    {id: 4,name: '葡萄',}
    ],
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

    total: 75,
    touchS: [0, 0],
    touchE: [0, 0],
    questions:[],
   // id:'',//套卷id
    errormessage: "",
    count: 1,
    levelName: '初级',

  },
  toggleRight1() {
    this.setData({
      showRight1: !this.data.showRight1
    });
  },
  // 选项选择事件
  handleFruitChange({ detail = {} }) {
    this.setData({
      current: detail.value
    });
  },
  handleChange({ detail }) {
    this.setData({
      current: detail.key
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
      this.onLoad();


    } else if (start[0] > end[0] + 30) {
      wx.setStorageSync("counta", that.data.count + 1);
      console.log('左滑')//下一题
      this.onLoad();


    } else {
      console.log('静止')
    }
  },

  add: function (e) {
    var $id = e.currentTarget.dataset.id;
    console.log($id)
    console.log("aaaaa")
    this.data.num++;
  },
  //获取真题题目
  getDetils:function(){
    var id=wx.getStorageSync("id");
    let that=this;
    var levelName = wx.getStorageSync('levelName');
    util.request(api.GetRealQuset+id+"/"+levelName+"/").then(res=>{
      if (res.errno === 0) {
        that.setData({
          questions: res.data.allQuestions
        })
        //console.log(res.data.allQuestions)
      } else {
      }
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
  
    
     var counta = wx.getStorageSync("counta");
     console.log(counta)
    if (counta) {
      this.setData({
        count: counta,
      });
    }
    // var that = this;
    // that.setData({
    //   id: options.id
    // })
    // this.getDetils();
  
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