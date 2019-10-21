// pages/mine/mine.js
var util = require('../../utils/util.js');
var api = require('../../config/api.js');
var user = require('../../utils/user.js');
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userInfo: {
      nickName: '点击登录',
      avatarUrl: '/static/images/my.png'
    },
    hasLogin: false

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },



  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    //获取用户的登录信息
    if (app.globalData.hasLogin) {
      let userInfo = wx.getStorageSync('userInfo');
      this.setData({
        userInfo: userInfo,
        hasLogin: true
      });
    }
    console.log(this.data.userInfo['nickName']);
    console.log(this.data.userInfo['avatarUrl']);

  },






 

  /**
   * 收藏页面
   */
  goCollection(){
    wx.navigateTo({
      url: '/pages/collection/collection',
    })
  },
  goError(){
    wx.navigateTo({
      url: '/pages/error/error',
    })
  },
  // 微信登录
  wxLogin: function (e) {
    wx.vibrateShort();
    if (e.detail.userInfo == undefined) {
      app.globalData.hasLogin = false;
      util.showErrorToast('微信登录失败');
      return;
    }

    user.checkLogin().catch(() => {

      user.loginByWeixin(e.detail.userInfo).then(res => {
        app.globalData.hasLogin = true;

        this.onShow();
      }).catch((err) => {
        app.globalData.hasLogin = false;
        util.showErrorToast('微信登录失败');
      });
    });
  },
})