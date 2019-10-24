package core.service.impl;

import core.service.WrongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.exam.db.domain.WrongQuestions;
import software.exam.db.domain.WrongQuestionsExample;
import software.exam.db.mapper.WrongQuestionsMapper;

import java.util.List;
@Service
public class WrongServiceImpl  implements WrongService {
    @Autowired
    WrongQuestionsMapper wrongQuestionsMapper;
    /**
     * 错题添加
     * @param wrongQuestions
     */
    @Override
    public int add(WrongQuestions wrongQuestions) {
        int i=0;
        boolean flag=true;
        WrongQuestionsExample example=new WrongQuestionsExample();
        WrongQuestionsExample.Criteria criteria=example.createCriteria();
        criteria.andIdIsNotNull();
        List<WrongQuestions> wrongQuestions1 = wrongQuestionsMapper.selectByExample(example);
        for (WrongQuestions wrongQuestions2:wrongQuestions1){
            Integer qid = wrongQuestions2.getQid();
            if (wrongQuestions.getQid()==qid){
                i=1;
                flag=false;
                break;
            }else{
                flag=true;
            }
        }
        if (flag){
            i = wrongQuestionsMapper.insert(wrongQuestions);
        }
        return i;
    }
}
