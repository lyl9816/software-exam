package core.service;

import software.exam.db.domain.User;

public interface LoginService {
    /**
     * 根据openid查找
     * @param openId
     * @return
     */
    public User selectByOpenid(String openId);
  /**
    * 添加user
   */
    public void add(User user);


}
