package software.exam.db.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import software.exam.db.domain.Choices;
import software.exam.db.domain.ChoicesExample;

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

    //根据Qid查询答案，并随机显示
    List<Choices> randChoiceById(int qid);
}