// 本机开发时使用
var WxApiRoot = 'http://localhost:8080/';

// 云平台部署时使用
// var WxApiRoot = 'http://3.14.127.134:8080/wx/';
// 云平台上线时使用
//var WxApiRoot = 'http://wechat.kiwi1.cn/wx/';

module.exports = {
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
  
  StorageUpload: WxApiRoot + 'storage/upload', //存储上传,
  FetchStorage: WxApiRoot + 'storage/fetch/', //存储获取,
  
  UserIndex: WxApiRoot + 'user/index', //个人页面用户相关信息
  SubmitIssue: WxApiRoot + 'user/submitIssue', //提交issue
  ShowFriendList: WxApiRoot + 'friend/getAll', //获取朋友列表,

  GetPrivateCategory: WxApiRoot + 'category/getAll/' + 2, //获取私人目录,
  GetPublicCategory: WxApiRoot + 'category/getAll/' + 1, //获取公共目录,
  GetPostsAll: WxApiRoot + 'posts/getAll/', //获取所有posts,
  GetPostsDetail: WxApiRoot + 'posts/getDetail/', //获取posts详细,
  GetOplogs: WxApiRoot + 'logs/getAll', //获取posts详细,
  GetComments: WxApiRoot + 'comment/get/', //获取posts详细,


  GetFriendPublicCategory: WxApiRoot + 'friend/getAll/menu/', //获取朋友共有目录,
  GetFriendPublicPosts: WxApiRoot + 'friend/getPost/', //获取朋友所有posts,
  GetFriendDetail: WxApiRoot + 'friend/getDetail/', //获取朋友posts详细,

  DelPosts: WxApiRoot + 'posts/delete', //删除文章,
  DelFriend: WxApiRoot + 'friend/delete', //删除朋友,
  DelMsg: WxApiRoot + 'sysmsg/delete', //删除消息,
  DelMsgAll: WxApiRoot + 'sysmsg/deleteAll', //删除所有消息,

  AddFriend: WxApiRoot + 'friend/add', //添加朋友,
  
  AddCategory: WxApiRoot + 'category/add', //添加目录,
  UpdateCategory: WxApiRoot + 'category/update', //修改目录,
  DelCategory: WxApiRoot + 'category/delete', //删除目录,
  GetCategoryDetail: WxApiRoot + 'category/detail/', //获取目录详细,

  UpdatePosts: WxApiRoot + 'posts/update', //修改文章,
  AddPost: WxApiRoot + 'posts/add', //添加文章,
  AddComment: WxApiRoot + 'comment/add', //添加文章,
  DelComment: WxApiRoot + 'comment/delete', //删除评论,

};