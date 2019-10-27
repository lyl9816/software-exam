package core.service;


import software.exam.db.domain.WrongQuestions;
import software.exam.db.model.dto.OnlineDto;

import java.util.List;

public interface WrongService {
    /**
     * 错题添加
     * @param wrongQuestions
     */
    int add(WrongQuestions wrongQuestions,int uid);

    /**
     * 移除错题
     * @param qid
     * @param id
     * @return
     */
    int deleteQuestions(int qid,int id);

    /**
     * 读取错题表
     * @param id
     * @return
     */
    List<OnlineDto> findWrong(int id);
}
