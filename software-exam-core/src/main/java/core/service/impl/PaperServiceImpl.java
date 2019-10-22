package core.service.impl;

import core.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.exam.db.domain.Paper;
import software.exam.db.domain.PaperExample;
import software.exam.db.mapper.PaperMapper;
import software.exam.db.mapper.RealQuestionsMapper;
import software.exam.db.model.dto.RealQuestionDto;

import java.util.List;

@Service
public class PaperServiceImpl implements PaperService {
    @Autowired
    private PaperMapper paperMapper;
    @Autowired
    private RealQuestionsMapper realQuestionsMapper;

    @Override
    public List<Paper> seleteAllPeper() {
        PaperExample pe=new PaperExample();
        PaperExample.Criteria criteria=pe.createCriteria();
        criteria.andIdIsNotNull();
        return paperMapper.selectByExample(pe);
    }

    @Override
    public List<RealQuestionDto> seleteRealQuestions(Integer id,Integer levelId) {
        return realQuestionsMapper.seleteRealQuestions(id,levelId);
    }


}
