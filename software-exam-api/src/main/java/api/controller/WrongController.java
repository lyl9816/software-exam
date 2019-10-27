package api.controller;

import api.utils.ResponseUtil;
import core.service.UserService;
import core.service.WrongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import software.exam.db.domain.User;
import software.exam.db.domain.WrongQuestions;
import software.exam.db.model.dto.OnlineDto;

import java.util.List;

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
        Integer id = user.getId();
        WrongQuestions wrongQuestions=new WrongQuestions();
        wrongQuestions.setQid(qid);
        wrongQuestions.setUid(user.getId());
        int i = wrongService.add(wrongQuestions,id);
        if (i>0){
            return ResponseUtil.ok();
        }
        return ResponseUtil.fail();
    }

    /**
     * 移除错题
     * @param qid
     * @param nickName
     * @return
     */
    @GetMapping("/removeWrong")
    public Object removeWrong(int qid,String nickName)
    {
        User user = userService.selectByNickName(nickName);
        System.out.println(user);
        Integer id = user.getId();
        int i = wrongService.deleteQuestions(qid, id);

        if (i>0){
            return ResponseUtil.ok();
        }
        return ResponseUtil.fail();

    }

    /**
     * 读取错题列表
     * @param nickName
     * @return
     */
    @GetMapping("/findWrong")
    public Object findWrong(String nickName){
        //根据用户姓名获取uid
        User user = userService.selectByNickName(nickName);
        Integer id = user.getId();
        List<OnlineDto> onlineDtos = wrongService.findWrong(id);
        if(onlineDtos.size()<0 && onlineDtos != null)
        {
            return ResponseUtil.fail();
        }
        return ResponseUtil.ok(onlineDtos);

    }


}
