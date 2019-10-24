package core.service.impl;

import core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.exam.db.domain.User;
import software.exam.db.domain.UserExample;
import software.exam.db.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User selectByNickName(String nickName) {
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        criteria.andNicknameEqualTo(nickName);
        return userMapper.selectUserByExample(userExample);
    }
}
