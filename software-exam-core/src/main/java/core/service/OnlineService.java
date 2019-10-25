package core.service;

import org.springframework.stereotype.Service;
import software.exam.db.domain.Choices;
import software.exam.db.domain.Questions;
import software.exam.db.mapper.QuestionsMapper;
import software.exam.db.model.dto.OnlineDto;

import java.util.List;

/**
 * 在线考试逻辑模块
 */
@Service
public interface OnlineService {

    /**
     * 根据等级id获取随机的75条题目及答案
     * @param lid
     * @return
     */
    public List<Questions> bornExamByLid(int lid);

    /**
     * 根据问题id获取答案List
     * @param qid
     * @return
     */
    public List<Choices> bornChoicesByQid(int qid);







}
