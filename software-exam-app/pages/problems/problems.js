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
    current2: '',
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
    errormessage:"",
    order: [],
    count:1,
    levelName: '初级',
    flag:false,
    right:0,
    error:0,
    pagenum:[],
    currents:[],//选过的选项，
    sort:"",
    choice:""

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
      if (this.data.order[this.data.count - 1].choices[i].content===this.data.current2){
       
        if (this.data.order[this.data.count - 1].choices[i].status===1){
          this.setData({
              flag: true,
             });
            }else{
           this.setData({
              flag: false,
              });
              }
      }
     
    }
    //错题
    console.log(this.data.flag)
    if (this.data.flag == false) {
      this.wrongQuestions();
    }

  },

  handleChange({ detail }) {
    this.setData({
      current: detail.key
    });
    if (this.data.sort == 2){
    if(this.data.current==='tab1'){
      this.orderquestion();
    }else{
      this.showAnswer();
    }
    }
    if (this.data.sort == 1) {
      if (this.data.current === 'tab1') {
        this.randomQuestion();
      } else {
        this.randomshowAnswer();
      }
    }
  },
  //收藏
  handleCollection() {

    let isCollected = !this.data.order[this.data.count - 1].collection;
    this.data.order[this.data.count - 1].collection=isCollected;
    this.setData({
      // 下面本来是这样子的:isCollected=isCollected,可以简写
      isCollected
    })
    
    wx.showToast({
      title: isCollected ? '收藏成功' : '取消收藏',
      icon: 'success'
    })
    if(isCollected){
      this.collection();
    }else{
      this.cancelCollection();
    }
  }, 
//收藏
collection:function(){
  let that=this;
  var index=this.data.count
   var qid= this.data.order[index-1].qid
  let userInfo = wx.getStorageSync('userInfo');
  util.request(api.CollectionQuestions, { qid: qid, nickName: userInfo.nickName}).then(function(res){
  });
},
//取消收藏
  cancelCollection:function(){
      let that=this;
    var index = this.data.count
    var qid = this.data.order[index - 1].qid
    let userInfo = wx.getStorageSync('userInfo');
    util.request(api.CancelCollection, { qid: qid,nickName: userInfo.nickName}).then(function(res){

    });
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
    let that=this
    console.log(start)
    console.log(end)
    
    if (start[0] < end[0] - 30) {
         wx.setStorageSync("counta", that.data.count-1);
      console.log('右滑')//上一题
      if(that.data.count>0){
        this.onLoad();
      }
      if (that.data.count==1){
        wx.showToast({
        title: '已是第一题',
      })
    
      }
      if (this.data.sort == 1) {
        if (this.data.current === 'tab1') {
          this.randomQuestion();
        } else {
          this.randomshowAnswer();
        }
      }

    
    } else if (start[0] > end[0] + 30) {
       wx.setStorageSync("counta", that.data.count+1);
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
      if(that.data.count<that.data.order.length){
        this.onLoad();
        
      }else{
        wx.showToast({
          title: '已是最后一题',
        })
      }
      if (this.data.sort == 1) {
        if (this.data.current === 'tab1') {
          this.randomQuestion();
        } else {
          this.randomshowAnswer();
        }
      }
      //错题
      // console.log(this.data.flag)
      // if(this.data.flag==false){
      //   this.wrongQuestions();
      // }
    

    } else {
      console.log('静止')
    }
  },
  //做过的题目号解析显示
 problem:function(){
   for (var i = 0; i < this.data.pagenum.length - 1; i++) {
     if (pagenum[i] == this.data.count) {
       this.setData({
         current2:"1"
       })
     } else {
       this.setData({
         current2:""
       })
     }
   }
 },
//  顺序题库答题模式
 orderquestion:function(){
 
   let that=this;
   let userInfo = wx.getStorageSync('userInfo');
  util.request(api.Orderquestion,{levelName:that.data.levelName,nickName:userInfo.nickName}).then(function (res) {
     if (res.errno===-1){
       that.setData({
         errormessage:res.errmsg
       });
     } else {
        that.setData({
          order:res.data,
        });
    console.log(that.data.order)
     //  console.log(that.data.total)
     }

   })
 },
//随机背题模式
  randomshowAnswer:function(){
      for(var i=0;i< this.data.order[this.data.count-1].choices.length;i++)
      {
        if (this.data.order[this.data.count - 1].choices[i].status==1){
          this.setData({
            choice: this.data.order[this.data.count - 1].choices[i].content
          })
        }

      }
  },
  //  随机题库答题模式
  randomQuestion: function () {

    let that = this;
    let userInfo = wx.getStorageSync('userInfo');
    util.request(api.RandomQuestions, { levelName: that.data.levelName,nickName:userInfo.nickName }).then(function (res) {
      if (res.errno === -1) {
        that.setData({
          errormessage: res.errmsg
        });
      } else {
        that.setData({
          order: res.data,
        });
        console.log(that.data.order)
      }

    })
  },
//  顺序题库背题模式
  showAnswer:function(){
  let that = this;
    let userInfo = wx.getStorageSync('userInfo');
  util.request(api.ShowAnswer, { levelName: that.data.levelName,nickName:userInfo.nickName }).then(function (res) {
    if (res.errno === -1) {
      that.setData({
        errormessage: res.errmsg
      });
    } else {
      that.setData({
        order: res.data
      });
    }

  })
},
//错题
  wrongQuestions:function(){
    let that = this;
    var index = this.data.count
    var qid = this.data.order[index - 1].qid
    let userInfo = wx.getStorageSync('userInfo');
    util.request(api.WrongQuestions, { qid: qid, nickName: userInfo.nickName }).then(function (res) {
    });
  },
  goHome() {
    wx.switchTab({
      url: '/pages/index/index',
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (e) {
    if(e!=null){
    this.setData({
      sort:e.sort
    });
    }
    var counta = wx.getStorageSync("counta");
   // console.log(counta)
    if(counta){
    this.setData({
      count:counta,
     });
    }
    if(this.data.order.length!=0){
      this.setData({
        isCollected: this.data.order[this.data.count - 1].collection,
        });
    }
   
    
  // console.log(this.data.count)
    var levelName = wx.getStorageSync('levelName');
    this.setData({
      levelName:levelName
    });
    //顺序题库
    if(e!=null&&e.sort==2){
    if(this.data.order.length==0){
      this.orderquestion();
      }
    }
    //随机题库
    if (e != null &&e.sort == 1) {
      if (this.data.order.length == 0) {
        this.randomQuestion();
      }
    }

    if(this.data.current2){
      this.setData({
        current2:""
      });
    }
 
   },



  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
   
   
   
  },
  onReady: function () {
  
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
      right:0,
      error:0,
      current2:"",
      pagenum:[],
      count:1,
      currents: [],
      choice:"",
      errormessage:""
     
    });
   // console.log(this.data.current)
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