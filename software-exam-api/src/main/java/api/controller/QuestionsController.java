package api.controller;

import api.utils.LevelNameUtil;
import api.utils.ResponseUtil;
import core.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import software.exam.db.model.dto.QuestionsDto;

import java.util.List;

@RestController
public class QuestionsController {
    @Autowired
    QuestionsService questionsService;

    /**
     * 顺序题库
     * @param levelName
     * @return
     */
    @GetMapping("orderQuestion")
    public Object question(String levelName){
        int level = LevelNameUtil.level(levelName);
        List<QuestionsDto> all = questionsService.findAll(level);
        if (all==null&&all.size()>0){
            return ResponseUtil.fail();
        }
        return ResponseUtil.ok(all);
    }

    /**
     * 顺序题库背题模式
     * @param levelName
     * @return
     */
    @GetMapping("/showAnswer")
    public Object showAnswer(String levelName){
        int level = LevelNameUtil.level(levelName);
        List<QuestionsDto> questionsDtos = questionsService.findAnswerByLevel(level);
        return ResponseUtil.ok(questionsDtos);
    }

    /**
     * 随机题库
     * @param levelName
     * @return
     */
    @GetMapping("/randomQuestions")
    public Object randomQuestions(String levelName){
        int level = LevelNameUtil.level(levelName);
        List<QuestionsDto> questionsDtos = questionsService.randomSelect(level);
        return ResponseUtil.ok(questionsDtos);
    }

}
