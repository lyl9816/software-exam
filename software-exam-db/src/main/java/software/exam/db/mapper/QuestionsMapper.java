package software.exam.db.mapper;

import java.util.Iterator;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import software.exam.db.domain.Questions;
import software.exam.db.domain.QuestionsExample;
import software.exam.db.model.dto.OnlineDto;
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
     //根据分类获取题目和对应的科目
   List<QuestionsDto> selectAnalyze(Integer level);
    //    根据分类获取题目和对应的科目以及正确答案
    List<QuestionsDto> selectAnswerByLevel(int level);
    List<QuestionsDto> selectRandom(int level);

    //根据题目id获取题目、选项、对应科目以及正确答案(错题库和我的收藏)
    OnlineDto selectAllByQid(int qid);

}