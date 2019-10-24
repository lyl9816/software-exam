package api.controller;

import api.utils.ResponseUtil;
import core.service.UserService;
import core.service.WrongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import software.exam.db.domain.User;
import software.exam.db.domain.WrongQuestions;

@RestController
public class WrongController {
    @Autowired
    UserService userService;
    @Autowired
    WrongService wrongService;
    /**
     * 错题
     * @param qid
     * @param nickName
     * @return
     */
    @GetMapping("/wrongQuestions")
    public Object wrongQuestions(int qid,String nickName){
        User user = userService.selectByNickName(nickName);
        System.out.println(user);
        WrongQuestions wrongQuestions=new WrongQuestions();
        wrongQuestions.setQid(qid);
        wrongQuestions.setUid(user.getId());
        int i = wrongService.add(wrongQuestions);
        if (i>0){
            return ResponseUtil.ok();
        }
        return ResponseUtil.fail();
    }
}
