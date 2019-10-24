// pages/real/real.js
var util = require('../../utils/util.js');
var api = require('../../config/api.js');
var user = require('../../utils/user.js');
Page({

  /**
   * 页面的初始数据
   */
  data: {
    levelName:'初级',
    detailObj: {},
    index: null,
    // 是否收藏
    isCollected: false,
    papers:[]
  },
  getPapers:function(){
    let that=this;
    util.request(api.GetPapers).then(res => {
      if (res.errno === 0) {
        that.setData({
          papers: res.data.allPapers
        })
        console.log(res.data.allPapers)
      } else {
  
      }
  })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    //获取分类
    // var levelName = wx.getStorageSync('levelName');
    // console.log(levelName);
    this.getPapers();
  },
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
  

  goToDetail:function(e){
    var idt = e.currentTarget.dataset.id;
    wx.setStorageSync("id", idt);
    console.log("pid:"+e.currentTarget.dataset.id)
    wx.navigateTo({
      url: "/pages/realpoblems/realproblems" 
    })
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