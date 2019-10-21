package api.controller;

import api.config.UserTokenManager;
import api.utils.ResponseUtil;
import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import core.config.IpUtil;
import core.service.LoginService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import software.exam.db.domain.User;
import software.exam.db.domain.UserDto;
import software.exam.db.domain.WxLoginInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;
    @Autowired
    private WxMaService wxService;
    /**
     * 微信登录
     *
     * @param wxLoginInfo
     * @param request     请求对象
     * @return 登录结果
     */
    @ApiOperation(value = "登录")
    @PostMapping("/login_by_weixin")
    public Object login(@RequestBody WxLoginInfo wxLoginInfo, HttpServletRequest request){
        String code = wxLoginInfo.getCode();
        UserDto userDto = wxLoginInfo.getUserInfo();
        if (code==null||userDto==null){
            return ResponseUtil.badArgument();
        }
        String sessionKey = null;
        String openId = null;
        try {
            WxMaJscode2SessionResult result = this.wxService.getUserService().getSessionInfo(code);
            sessionKey = result.getSessionKey();
            openId = result.getOpenid();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (sessionKey==null||openId==null){
            return ResponseUtil.fail();
        }
        User user=loginService.selectByOpenid(openId);
        if (user==null){
            user = new User();
            user.setUsername(openId);
            user.setPassword(openId);
            user.setWeixinOpenid(openId);
            user.setAvatar(userDto.getAvatarUrl());
            user.setNickname(userDto.getNickName());
            user.setGender(userDto.getGender());
            user.setStatus((byte) 0);
            user.setLastLoginTime(new Date());
            user.setLastLoginIp(IpUtil.getIpAddr(request));
            user.setSessionKey(sessionKey);
            loginService.add(user);
        }
        // token
        String token = UserTokenManager.generateToken(user.getId());

        Map<Object, Object> result = new HashMap<Object, Object>();
        result.put("token", token);
        result.put("userInfo", userDto);
        result.put("userId", user.getId());
      return ResponseUtil.ok(result);
    }
}
