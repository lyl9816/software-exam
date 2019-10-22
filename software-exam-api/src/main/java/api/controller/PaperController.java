package api.controller;

import api.utils.LevelNameUtil;
import api.utils.ResponseUtil;
import core.service.PaperService;
import core.service.impl.PaperServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import software.exam.db.domain.Paper;
import software.exam.db.model.dto.RealQuestionDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PaperController {
    @Autowired
    private PaperService paperService;

    //获取套卷
    @GetMapping("/paperInfo")
    public Object paperInfo(){
        List<Paper> allPapers=paperService.seleteAllPeper();
        Map<String,Object> map=new HashMap<>();
        map.put("allPapers",allPapers);
        return ResponseUtil.ok(map);
    }

    //获取真题题目
    @GetMapping("/GetRealQuestions/{id}/{levelName}")
    public Object GetRealQuestions(@PathVariable("id")Integer id,
                                   @PathVariable("levelName")String levelName){
        System.out.println(id);
        System.out.println(levelName);
        int levelId=LevelNameUtil.level(levelName);
        //根据套卷id查题目
        List<RealQuestionDto> allQuestions=paperService.seleteRealQuestions(id,levelId);
        System.out.println("111111111111111111"+allQuestions);
        Map<String,Object> map=new HashMap<>();
        map.put("allQuestions",allQuestions);
        return ResponseUtil.ok(map);
    }

}
