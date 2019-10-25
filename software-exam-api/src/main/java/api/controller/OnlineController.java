package api.controller;

import api.utils.LevelNameUtil;
import api.utils.ResponseUtil;
import core.service.OnlineService;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import software.exam.db.domain.Choices;
import software.exam.db.domain.Questions;
import software.exam.db.model.dto.OnlineDto;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OnlineController {

    @Autowired
    private OnlineService onlineService;

    /**
     * 根据等级（lid)取出随机题目并返回
     * @param levelName
     * @return
     */
    @GetMapping("newPaper")
    public Object showOnlinePaper(@RequestParam String levelName)
    {
        int lid = LevelNameUtil.level(levelName);
        List<Questions> questions = onlineService.bornExamByLid(lid);

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
            onlineDtos.add(onlineDto);
//            System.out.println(onlineDto.toString());

        }
        System.out.println(onlineDtos.toString());


        return ResponseUtil.ok(onlineDtos);
    }
    //todo 左上角返回考试时间重置，pull下来解决冲突，考卷的收藏和错题存入数据库，后两个功能





}
