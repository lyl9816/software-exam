package db.mapper;

import db.domain.Board;
import db.domain.BoardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BoardMapper {
    long countByExample(BoardExample example);

    int deleteByExample(BoardExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Board record);

    int insertSelective(Board record);

    List<Board> selectByExample(BoardExample example);

    Board selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Board record, @Param("example") BoardExample example);

    int updateByExample(@Param("record") Board record, @Param("example") BoardExample example);

    int updateByPrimaryKeySelective(Board record);

    int updateByPrimaryKey(Board record);
}