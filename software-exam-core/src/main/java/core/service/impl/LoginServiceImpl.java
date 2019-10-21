package core.service.impl;

import core.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.exam.db.domain.User;
import software.exam.db.domain.UserExample;
import software.exam.db.mapper.UserMapper;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    UserMapper userMapper;

    /**
     * 根据openid查找
     * @param openId
     * @return
     */
    @Override
    public User selectByOpenid(String openId) {
        UserExample userExample=new UserExample();
        userExample.or().andWeixinOpenidEqualTo(openId).andDeletedEqualTo(false);
        return userMapper.selectUserByExample(userExample);
    }

    /**
     * 添加user
     * @param user
     */
    @Override
    public void add(User user) {
        userMapper.insert(user);
    }
}
