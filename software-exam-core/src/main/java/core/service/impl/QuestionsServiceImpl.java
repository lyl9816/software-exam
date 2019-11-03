package core.service.impl;


import core.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.exam.db.domain.*;
import software.exam.db.mapper.AnalyzeMapper;
import software.exam.db.mapper.ChoicesMapper;
import software.exam.db.mapper.CollectionMapper;
import software.exam.db.mapper.QuestionsMapper;
import software.exam.db.model.dto.QuestionsDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionsServiceImpl implements QuestionsService {
    @Autowired
    QuestionsMapper questionsMapper;
    @Autowired
    ChoicesMapper choicesMapper;
    @Autowired
    AnalyzeMapper analyzeMapper;
    @Autowired
    CollectionMapper collectionMapper;

    /**
     * 按分类获取题目，选项，科目
     * @param level
     * @return
     */
    @Override
    public List<QuestionsDto> findAll(int level,int uid) {
        List<Choices> choices=null;
        List<QuestionsDto> questionsDtos = questionsMapper.selectAnalyze(level);


        for (QuestionsDto questions1:questionsDtos){
            Integer id = questions1.getId();
            if (id!=null){
                choices = choicesMapper.randChoiceById(id);
                Collection collection = collectionMapper.selectByQid(id,uid);
                if (collection!=null){
                        questions1.setCollection(true);
                }else{
                    questions1.setCollection(false);
                }
            }
            questions1.setChoices(choices);
        }
        return questionsDtos;
    }
    /**
     * 按分类获取题目，正确答案，科目
     * @param level
     * @return
     */
    @Override
    public List<QuestionsDto> findAnswerByLevel(int level,int uid) {
        List<QuestionsDto> questionsDtos = questionsMapper.selectAnswerByLevel(level);
        for (QuestionsDto questionsDto:questionsDtos){
            Integer id = questionsDto.getId();
            if (id!=null){
                Collection collection = collectionMapper.selectByQid(id,uid);
                if (collection!=null){
                    questionsDto.setCollection(true);
                }else{
                    questionsDto.setCollection(false);
                }
            }
        }
        return questionsDtos;
    }
    /**
     * 随机按分类获取题目，答案，科目
     * @param level
     * @return
     */
    @Override
    public List<QuestionsDto> randomSelect(int level,int uid) {
        List<QuestionsDto> questionsDtos = questionsMapper.selectRandom(level);
        for(QuestionsDto questionsDto:questionsDtos){
            Integer id = questionsDto.getId();
            if (id!=null){
                List<Choices> choices = choicesMapper.randChoiceById(id);
                questionsDto.setChoices(choices);

                Collection collection = collectionMapper.selectByQid(id,uid);
                if (collection!=null){
                    questionsDto.setCollection(true);
                }else{
                    questionsDto.setCollection(false);
                }
            }
        }
        return questionsDtos;
    }
}
