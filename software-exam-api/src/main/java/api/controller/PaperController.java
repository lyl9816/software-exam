package api.controller;

import api.utils.LevelNameUtil;
import api.utils.ResponseUtil;
import core.service.PaperService;
import core.service.impl.PaperServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import software.exam.db.domain.Choices;
import software.exam.db.domain.Paper;
import software.exam.db.model.dto.RealChoicesDto;
import software.exam.db.model.dto.RealQuestionDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class PaperController {
    @Autowired
    private PaperService paperService;


    //获取套卷
    @GetMapping("/paperInfo")
    public Object paperInfo(){
        List<Paper> allPapers=paperService.selectAllPeper();
        Map<String,Object> map=new HashMap<>();
        map.put("allPapers",allPapers);
        return ResponseUtil.ok(map);
    }

    //获取真题题目
    @GetMapping("/getRealQuestions/{id}/{levelName}")
    public Object getRealQuestions(@PathVariable("id")Integer id,
                                   @PathVariable("levelName")String levelName){
        System.out.println(id);
        System.out.println(levelName);
        int levelId=LevelNameUtil.level(levelName);
        //根据套卷id查题目
        List<RealChoicesDto> allQuestions=paperService.selectRealQuestions(id,levelId);
        log.info("11111111111111"+allQuestions.get(0).getTitle());
        log.info("22222222222222"+allQuestions.get(0).getChoices().get(0).getContent());
        log.info("3333333333333"+allQuestions.get(0).getChoices().get(0).getStatus());
        Map<String,Object> map=new HashMap<>();
        map.put("allQuestions",allQuestions);
        return ResponseUtil.ok(map);
    }



}
