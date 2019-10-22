package software.exam.db.mapper;

import java.util.Iterator;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import software.exam.db.domain.Questions;
import software.exam.db.domain.QuestionsExample;
import software.exam.db.model.dto.QuestionsDto;

public interface QuestionsMapper {
    long countByExample(QuestionsExample example);

    int deleteByExample(QuestionsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Questions record);

    int insertSelective(Questions record);

    List<Questions> selectByExample(QuestionsExample example);

    Questions selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Questions record, @Param("example") QuestionsExample example);

    int updateByExample(@Param("record") Questions record, @Param("example") QuestionsExample example);

    int updateByPrimaryKeySelective(Questions record);

    int updateByPrimaryKey(Questions record);

    //根据等级id取出随机75条题目
     List<Questions> limitAndRandAll(int Lid);
     //获取题目和解析
   List<QuestionsDto> selectAnalyze();
}