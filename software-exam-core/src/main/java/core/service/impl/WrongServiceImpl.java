package core.service.impl;

import core.service.WrongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.exam.db.domain.Choices;
import software.exam.db.domain.WrongQuestions;
import software.exam.db.domain.WrongQuestionsExample;
import software.exam.db.mapper.ChoicesMapper;
import software.exam.db.mapper.QuestionsMapper;
import software.exam.db.mapper.WrongQuestionsMapper;
import software.exam.db.model.dto.OnlineDto;

import java.util.ArrayList;
import java.util.List;
@Service
public class WrongServiceImpl  implements WrongService {
    @Autowired
    WrongQuestionsMapper wrongQuestionsMapper;

    @Autowired
    QuestionsMapper questionsMapper;

    @Autowired
    ChoicesMapper choicesMapper;
    /**
     * 错题添加
     * @param wrongQuestions
     */
    @Override
    public int add(WrongQuestions wrongQuestions,int uid) {
        int i=0;
        boolean flag=true;
        WrongQuestionsExample example=new WrongQuestionsExample();
        WrongQuestionsExample.Criteria criteria=example.createCriteria();
        criteria.andIdIsNotNull();
        List<WrongQuestions> wrongQuestions1 = wrongQuestionsMapper.selectByExample(example);
        for (WrongQuestions wrongQuestions2:wrongQuestions1){
            Integer qid = wrongQuestions2.getQid();
            if (wrongQuestions.getQid()==qid&&wrongQuestions.getUid()==uid){
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

    @Override
    public int deleteQuestions(int qid, int uid) {
        WrongQuestionsExample wrongQuestionsExample=new WrongQuestionsExample();
        WrongQuestionsExample.Criteria criteria = wrongQuestionsExample.createCriteria();
        criteria.andQidEqualTo(qid);
        criteria.andUidEqualTo(uid);
        int i = wrongQuestionsMapper.deleteByExample(wrongQuestionsExample);
        return i;
    }

    @Override
    public List<OnlineDto> findWrong(int uid) {
        //根据用户id获取uid
        WrongQuestionsExample wrongQuestionsExample = new WrongQuestionsExample();
        WrongQuestionsExample.Criteria criteria = wrongQuestionsExample.createCriteria();
        criteria.andUidEqualTo(uid);
        List<WrongQuestions> wrongQuestions = wrongQuestionsMapper.selectByExample(wrongQuestionsExample);

        List<OnlineDto> onlineDtos = new ArrayList<OnlineDto>();
        //遍历qid根据题目id获取信息，封装OnlineDto类
        for (int i = 0; i < wrongQuestions.size() ; i++) {
            Integer qid = wrongQuestions.get(i).getQid();
            OnlineDto onlineDto = questionsMapper.selectAllByQid(qid);
            List<Choices> choices = choicesMapper.randChoiceById(qid);
            onlineDto.setChoices(choices);
            onlineDto.setCollection(true);

            System.out.println(onlineDto.toString());
            System.out.println("------------------------------");
            //将onlineDto类循环添加到List<>中
            onlineDtos.add(onlineDto);
            System.out.println(onlineDtos.toString());


        }

        return onlineDtos;
    }

}
