package core.service;

import org.springframework.stereotype.Service;
import software.exam.db.domain.Choices;
import software.exam.db.domain.Collection;
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
     * 根据等级id获取随机的75条题目,答案并封装
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

    /**
     * 根据题号查找本题是否已收藏
     * @param qid
     * @return
     */
    public Collection findifCollections(int qid,int uid);







}
