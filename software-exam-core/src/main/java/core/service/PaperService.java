package core.service;

import software.exam.db.domain.Paper;
import software.exam.db.model.dto.RealQuestionDto;

import java.util.List;

public interface PaperService {
    //获取真题卷子名
    public List<Paper> seleteAllPeper();
    //获取真题
    public List<RealQuestionDto> seleteRealQuestions(Integer id,Integer levelId);
}
