package core.service.impl;

import core.service.PaperService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.exam.db.domain.*;
import software.exam.db.mapper.*;
import software.exam.db.model.dto.RealChoicesDto;
import software.exam.db.model.dto.RealQuestionDto;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class PaperServiceImpl implements PaperService {
    @Autowired
    private PaperMapper paperMapper;
    @Autowired
    private RealQuestionsMapper realQuestionsMapper;
    @Autowired
    private ChoicesMapper choicesMapper;
    @Autowired
    private AnalyzeMapper analyzeMapper;
    @Autowired
    private CollectionMapper collectionMapper;

    @Override
    public List<Paper> selectAllPeper() {
        PaperExample pe=new PaperExample();
        PaperExample.Criteria criteria=pe.createCriteria();
        criteria.andIdIsNotNull();
        return paperMapper.selectByExample(pe);
    }

    @Override
    public List<RealChoicesDto> selectRealQuestions(Integer id,Integer levelId,
                                                    Integer uid) {
        //获取所有题目
        List<RealQuestionDto> realQuestionDtos = realQuestionsMapper.seleteRealQuestions(id, levelId);
        log.info("pid:"+id);
        log.info("levelid:"+levelId);
        List<RealChoicesDto> realChoicesDtos=new ArrayList<>();
        for(int i=0;i<realQuestionDtos.size();i++){
            Integer qid = realQuestionDtos.get(i).getQid();
            log.info("qid:"+qid);
            Integer rqid = realQuestionsMapper.selectRqidByQid(qid);
            log.info("====rqid:"+qid);
            String title=realQuestionDtos.get(i).getTitle();
            //获取选项
            List<Choices> choices = choicesMapper.randChoiceByRqid(rqid);
            //获取解析
            Analyze analyze = analyzeMapper.selectByRqid(rqid);
            log.info("analyze:"+analyze.getDetail());
            RealChoicesDto realChoicesDto=new RealChoicesDto();
            realChoicesDto.setRqid(rqid);
            realChoicesDto.setQid(qid);
            realChoicesDto.setTitle(title);
            realChoicesDto.setDetail(analyze.getDetail());
            realChoicesDto.setChoices(choices);
            //判断是否已收藏
            Collection collection=collectionMapper.selectByQid(qid,uid);
            if(collection !=null){
                realChoicesDto.setCollection(true);
            }else{
                realChoicesDto.setCollection(false);
            }
            realChoicesDtos.add(realChoicesDto);
        }
        return realChoicesDtos;
    }



}
