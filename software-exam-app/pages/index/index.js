//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    motto: 'Hello World',
    userInfo: {},
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    current: 'homepage',
    //分类等级
    fruit: [
      {id: 1, name: '初级',}, 
      {id: 2,name: '中级'}, 
      {id: 3,name: '高级'}
    ],
    current2: '初级',
    position: 'left',
    showRight1: false,
  },
  // 选项事件
  handleFruitChange({ detail = {} }) {
    this.setData({
      current2: detail.value
    });
    // console.log(this.data.current2)
    var levelName = this.data.current2;
    wx.setStorageSync('levelName', levelName);
  },
  //抽屉事件
  toggleRight1() {
    this.setData({
      showRight1: !this.data.showRight1
    });
  },
  //事件处理函数
  bindViewTap: function() {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  // level:function(id,name){
  //   let that=this;
  //   that.data.fruit.id
  //   url.request(api.GetLevel,{
  //     id:this.fruit.id,
  //     name:name
  //   })
   
  // },
  onLoad: function () {
   //加载选择分类等级

    if (app.globalData.userInfo) {
      this.setData({
        userInfo: app.globalData.userInfo,
        hasUserInfo: true
      })
    } else if (this.data.canIUse){
      // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
      // 所以此处加入 callback 以防止这种情况
      app.userInfoReadyCallback = res => {
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
      }
    } else {
      // 在没有 open-type=getUserInfo 版本的兼容处理
      wx.getUserInfo({
        success: res => {
          app.globalData.userInfo = res.userInfo
          this.setData({
            userInfo: res.userInfo,
            hasUserInfo: true
          })
        }
      })
    }
  },
  getUserInfo: function(e) {
    console.log(e)
    app.globalData.userInfo = e.detail.userInfo
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    })
  },
  handleChange({ detail }) {
    this.setData({
      current: detail.key
    });
  },
  goKnowledge() {
    wx.navigateTo({
      url: "/pages/knowledge/knowledge"
    })
  },
  goReal(){
    wx.navigateTo({
      url: '/pages/real/real',
    })
  },
  goProblems(){
    wx.navigateTo({
      url: '/pages/problems/problems',
    })
  },
  goOnline()
  {
    wx.navigateTo({
      url: '/pages/online/online',
    })
  }

})
