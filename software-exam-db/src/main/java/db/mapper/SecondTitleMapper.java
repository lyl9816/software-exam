package db.mapper;

import db.domain.SecondTitle;
import db.domain.SecondTitleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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