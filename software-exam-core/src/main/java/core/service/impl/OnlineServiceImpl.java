package core.service.impl;

import core.service.OnlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.exam.db.domain.*;
import software.exam.db.mapper.ChoicesMapper;
import software.exam.db.mapper.CollectionMapper;
import software.exam.db.mapper.QuestionsMapper;
import software.exam.db.model.dto.OnlineDto;

import java.util.List;
@Service
public class OnlineServiceImpl implements OnlineService {

    private QuestionsMapper questionsMapper;

    @Autowired
    private ChoicesMapper choicesMapper;

    @Autowired
    private CollectionMapper collectionMapper;

    /**
     * 根据等级id获取随机的75条题目和答案
     * @param lid
     * @return
     */
    @Override
    public List<Questions> bornExamByLid(int lid) {

        //从数据库中取出随机75条题目存到List数组中
        List<Questions> questionsList = questionsMapper.limitAndRandAll(lid);

        return questionsList;
    }

    @Override
    public List<Choices> bornChoicesByQid(int qid) {

        List<Choices> choices = choicesMapper.randChoiceById(qid);

        return choices;
    }

    @Override
    public Collection findifCollections(int qid,int uid) {
        Collection collection = collectionMapper.selectByQid(qid,uid);
        return collection;
    }



}
