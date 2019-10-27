// 本机开发时使用
var WxApiRoot = 'http://localhost:8080/';

// 云平台部署时使用
// var WxApiRoot = 'http://3.14.127.134:8080/wx/';
// 云平台上线时使用
//var WxApiRoot = 'http://wechat.kiwi1.cn/wx/';

module.exports = {
  WrongQuestions: WxApiRoot + 'wrongQuestions',//错题
  CancelCollection: WxApiRoot +'cancelCollection',//取消收藏
  CollectionQuestions: WxApiRoot+'collectionQuestions',//收藏
  Orderquestion: WxApiRoot + 'orderQuestion',//顺序题库
  RandomQuestions: WxApiRoot + 'randomQuestions',//随机题库
  ShowAnswer: WxApiRoot + 'showAnswer',//顺序题库背题模式
  IndexUrl: WxApiRoot + 'home', //首页数据接口
  GetMsgNumber: WxApiRoot + 'sysmsg/getNum', //获取消息数
  GetMsgList: WxApiRoot + 'sysmsg/getAllMsg', //获取消息列
  GetMsgDetail: WxApiRoot + 'sysmsg/getDetail/', //获取消息详细
  GetLevel: WxApiRoot+'getLevel',//获取分类等级
  GetPapers: WxApiRoot+'paperInfo',//获取往年卷题
  GetRealQuset: WxApiRoot+'getRealQuestions/',//获取真题题目


  AuthLoginByWeixin: WxApiRoot + 'login_by_weixin', //微信登录
  
  //在线考试
  OnlinePaper: WxApiRoot + 'newPaper',//显示试卷
  FindCollection: WxApiRoot +'findCollection',//显示收藏题目
  RemoveWrong: WxApiRoot + 'removeWrong',//移除错题
  FindWrong: WxApiRoot + 'findWrong',//显示错题题目

};