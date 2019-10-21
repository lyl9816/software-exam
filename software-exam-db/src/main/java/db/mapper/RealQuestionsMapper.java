package db.mapper;

import db.domain.RealQuestions;
import db.domain.RealQuestionsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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
}