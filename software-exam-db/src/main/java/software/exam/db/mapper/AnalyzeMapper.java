package software.exam.db.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import software.exam.db.domain.Analyze;
import software.exam.db.domain.AnalyzeExample;

public interface AnalyzeMapper {
    long countByExample(AnalyzeExample example);

    int deleteByExample(AnalyzeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Analyze record);

    int insertSelective(Analyze record);

    List<Analyze> selectByExample(AnalyzeExample example);

    Analyze selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Analyze record, @Param("example") AnalyzeExample example);

    int updateByExample(@Param("record") Analyze record, @Param("example") AnalyzeExample example);

    int updateByPrimaryKeySelective(Analyze record);

    int updateByPrimaryKey(Analyze record);
}