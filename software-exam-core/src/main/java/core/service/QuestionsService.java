package core.service;

import software.exam.db.domain.Questions;
import software.exam.db.model.dto.QuestionsDto;

import java.util.List;

public interface QuestionsService {
    /**
     * 查询题目，选项，解析
     * @param level
     * @return
     */
    List<QuestionsDto> findAll(int level);
}
