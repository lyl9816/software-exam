package db.mapper;

import db.domain.Choices;
import db.domain.ChoicesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChoicesMapper {
    long countByExample(ChoicesExample example);

    int deleteByExample(ChoicesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Choices record);

    int insertSelective(Choices record);

    List<Choices> selectByExample(ChoicesExample example);

    Choices selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Choices record, @Param("example") ChoicesExample example);

    int updateByExample(@Param("record") Choices record, @Param("example") ChoicesExample example);

    int updateByPrimaryKeySelective(Choices record);

    int updateByPrimaryKey(Choices record);
}