package software.exam.db.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import software.exam.db.domain.SecondTitle;
import software.exam.db.domain.SecondTitleExample;

public interface SecondTitleMapper {
    long countByExample(SecondTitleExample example);

    int deleteByExample(SecondTitleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SecondTitle record);

    int insertSelective(SecondTitle record);

    List<SecondTitle> selectByExample(SecondTitleExample example);

    SecondTitle selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SecondTitle record, @Param("example") SecondTitleExample example);

    int updateByExample(@Param("record") SecondTitle record, @Param("example") SecondTitleExample example);

    int updateByPrimaryKeySelective(SecondTitle record);

    int updateByPrimaryKey(SecondTitle record);
}