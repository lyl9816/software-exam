// pages/problems/problems.js
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

    total: 75,
    touchS: [0, 0],
    touchE: [0, 0],
    errormessage:"",
    order: [],
    count:1,
    levelName: '初级',
    },
  

  // add:function(e){
  //   var $id = e.currentTarget.dataset.id;
  //   console.log($id)
  //   console.log("aaaaa")
  //   this.data.num++;
  // },
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
    let that=this
    console.log(start)
    console.log(end)
    
    if (start[0] < end[0] - 30) {
         wx.setStorageSync("counta", that.data.count-1);
      console.log('右滑')//上一题
      this.onLoad();

    
    } else if (start[0] > end[0] + 30) {
       wx.setStorageSync("counta", that.data.count+1);
      console.log('左滑')//下一题
      this.onLoad();
    
      
    } else {
      console.log('静止')
    }
  },
 
 orderquestion:function(){
   let that=this;

  util.request(api.Orderquestion,{levelName:that.data.levelName}).then(function (res) {
     if (res.errno===-1){
       that.setData({
         errormessage:res.errmsg
       });
     } else {
        // console.log(res.data)
        that.setData({
          order:res.data
        });
        console.log(that.data.order)
     }
   })
 },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function () {
    var counta = wx.getStorageSync("counta");
    console.log(counta)
    if(counta){
    this.setData({
      count:counta
     });
    }
   console.log(this.data.count)
    var levelName = wx.getStorageSync('levelName');
    this.setData({
      levelName:levelName
    });
    this.orderquestion();
    // console.log(this.data.order);
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