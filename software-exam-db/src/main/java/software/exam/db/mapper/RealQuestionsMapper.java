package software.exam.db.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import software.exam.db.domain.RealQuestions;
import software.exam.db.domain.RealQuestionsExample;
import software.exam.db.model.dto.RealQuestionDto;

public interface RealQuestionsMapper {
    long countByExample(RealQuestionsExample example);

    int deleteByExample(RealQuestionsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RealQuestions record);

    int insertSelective(RealQuestions record);

    List<RealQuestions> selectByExample(RealQuestionsExample example);

    RealQuestions selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RealQuestions record, @Param("example") RealQuestionsExample example);

    int updateByExample(@Param("record") RealQuestions record, @Param("example") RealQuestionsExample example);

    int updateByPrimaryKeySelective(RealQuestions record);

    int updateByPrimaryKey(RealQuestions record);
    //获取套卷题目
    List<RealQuestionDto> seleteRealQuestions(Integer id,Integer levelId);
    //根据qid找rqid
    int selectRqidByQid(Integer qid) ;
}