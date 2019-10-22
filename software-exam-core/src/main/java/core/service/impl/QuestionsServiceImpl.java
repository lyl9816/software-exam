package core.service.impl;


import core.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.exam.db.domain.*;
import software.exam.db.mapper.AnalyzeMapper;
import software.exam.db.mapper.ChoicesMapper;
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
    @Override
    public List<QuestionsDto> findAll(int level) {
        List<Choices> choices=null;
        List<Analyze> analyzes=null;
        List<QuestionsDto> questionsDtos = questionsMapper.selectAnalyze();
        for (QuestionsDto questions1:questionsDtos){
            Integer id = questions1.getId();
            if (id!=null){
                choices = choicesMapper.randChoiceById(id);
            }

            questions1.setChoices(choices);
        }
        System.out.println(questionsDtos);
        return questionsDtos;
    }
}
