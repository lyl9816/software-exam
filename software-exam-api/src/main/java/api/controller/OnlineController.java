package api.controller;

import api.utils.LevelNameUtil;
import api.utils.ResponseUtil;
import core.service.OnlineService;
import core.service.UserService;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import software.exam.db.domain.Choices;
import software.exam.db.domain.Collection;
import software.exam.db.domain.Questions;
import software.exam.db.domain.User;
import software.exam.db.model.dto.OnlineDto;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OnlineController {

    @Autowired
    private OnlineService onlineService;

    @Autowired
    private UserService userService;

    /**
     * 根据等级（lid)取出随机题目及相关信息并返回
     * @param levelName
     * @param nickName
     * @return
     */
    @GetMapping("newPaper")
    public Object showOnlinePaper(String levelName,String nickName)
    {
        int lid = LevelNameUtil.level(levelName);
        List<Questions> questions = onlineService.bornExamByLid(lid);
        //获取用户id
        User user = userService.selectByNickName(nickName);
        Integer uid = user.getId();

        List<OnlineDto> onlineDtos = new ArrayList<OnlineDto>();
        for (int i = 0; i < questions.size(); i++) {
            int qid = questions.get(i).getId();
            String title = questions.get(i).getTitle();
            List<Choices> choices = onlineService.bornChoicesByQid(qid);
            OnlineDto onlineDto = new OnlineDto();
            onlineDto.setId(qid);
            onlineDto.setQid(qid);
            onlineDto.setTitle(title);
            onlineDto.setChoices(choices);
            Collection collection = onlineService.findifCollections(qid,uid);
            if(collection != null)
            {
                onlineDto.setCollection(true);
            }else
            {
                onlineDto.setCollection(false);
            }
            //将onlineDto类添加到List中
            onlineDtos.add(onlineDto);
//            System.out.println(onlineDto.toString());

        }
        System.out.println(onlineDtos.toString());

        if(onlineDtos==null && onlineDtos.size()<0)
        {
            ResponseUtil.fail();
        }

        return ResponseUtil.ok(onlineDtos);
    }






}
