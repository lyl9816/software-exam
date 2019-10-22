package api.controller;

import api.utils.LevelNameUtil;
import api.utils.ResponseUtil;
import core.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import software.exam.db.domain.Questions;
import software.exam.db.model.dto.QuestionsDto;

import java.util.List;

@RestController
public class QuestionsController {
    @Autowired
    QuestionsService questionsService;
    @GetMapping("orderQuestion")
    public Object question(String levelName){
        int level = LevelNameUtil.level(levelName);
        System.out.println(level);
        List<QuestionsDto> all = questionsService.findAll(level);
        if (all==null&&all.size()>0){
            return ResponseUtil.fail();
        }
        return ResponseUtil.ok(all);
    }
}
