package core.service;

import software.exam.db.domain.Questions;
import software.exam.db.model.dto.QuestionsDto;

import java.util.List;

public interface QuestionsService {
    /**
     * 按分类获取题目，选项，科目
     * @param level
     * @return
     */
    List<QuestionsDto> findAll(int level,int  uid);

    /**
     * 按分类获取题目，正确答案，科目
     * @param level
     * @return
     */
    List<QuestionsDto> findAnswerByLevel(int level,int uid);

    /**
     * 随机按分类获取题目，答案，科目
     * @param level
     * @return
     */
    List<QuestionsDto> randomSelect(int level,int uid);
}
