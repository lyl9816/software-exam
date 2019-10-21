package software.exam.db.mapper;

import software.exam.db.domain.SortLevel;
import software.exam.db.domain.SortLevelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SortLevelMapper {
    long countByExample(SortLevelExample example);

    int deleteByExample(SortLevelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SortLevel record);

    int insertSelective(SortLevel record);

    List<SortLevel> selectByExample(SortLevelExample example);

    SortLevel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SortLevel record, @Param("example") SortLevelExample example);

    int updateByExample(@Param("record") SortLevel record, @Param("example") SortLevelExample example);

    int updateByPrimaryKeySelective(SortLevel record);

    int updateByPrimaryKey(SortLevel record);
}