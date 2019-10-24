package core.service;


import software.exam.db.domain.WrongQuestions;

public interface WrongService {
    /**
     * 错题添加
     * @param wrongQuestions
     */
    int add(WrongQuestions wrongQuestions);
}
