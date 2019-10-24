package core.service;

import software.exam.db.domain.User;

public interface UserService {
    User selectByNickName(String nickName);
}
