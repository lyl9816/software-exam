// pages/error/error.js
var util = require('../../utils/util.js');
var api = require('../../config/api.js');
const { $Message } = require('../../dist/base/index');
Page({

  /**
   * 页面的初始数据
   */
  data: {
    order:[],
  },
  /**
   * 显示错题
   */
  showWrongQuestions(){
    let that =this;
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
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    //若order数组为空，才请求后台数据
    if (this.data.order.length == 0) {
      this.showWrongQuestions();
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
  goErrorproblems() {
    wx.navigateTo({
      url: '/pages/errorproblems/errorproblems',
    })

  }
})