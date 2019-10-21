package software.exam.db.mapper;

import software.exam.db.domain.WrongQuestions;
import software.exam.db.domain.WrongQuestionsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WrongQuestionsMapper {
    long countByExample(WrongQuestionsExample example);

    int deleteByExample(WrongQuestionsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WrongQuestions record);

    int insertSelective(WrongQuestions record);

    List<WrongQuestions> selectByExample(WrongQuestionsExample example);

    WrongQuestions selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WrongQuestions record, @Param("example") WrongQuestionsExample example);

    int updateByExample(@Param("record") WrongQuestions record, @Param("example") WrongQuestionsExample example);

    int updateByPrimaryKeySelective(WrongQuestions record);

    int updateByPrimaryKey(WrongQuestions record);
}