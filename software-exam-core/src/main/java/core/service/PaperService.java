package core.service;

import software.exam.db.domain.Choices;
import software.exam.db.domain.Paper;
import software.exam.db.model.dto.RealChoicesDto;
import software.exam.db.model.dto.RealQuestionDto;

import java.util.List;

public interface PaperService {
    //获取真题卷子名
    public List<Paper> selectAllPeper();
    //获取真题及选项及解析
    public List<RealChoicesDto> selectRealQuestions(Integer id,Integer levelId,Integer uid);

}
