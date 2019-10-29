package software.exam.db.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import software.exam.db.domain.SortCourse;
import software.exam.db.domain.SortCourseExample;
import software.exam.db.model.dto.CourseDto;

public interface SortCourseMapper {
    long countByExample(SortCourseExample example);

    int deleteByExample(SortCourseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SortCourse record);

    int insertSelective(SortCourse record);

    List<SortCourse> selectByExample(SortCourseExample example);

    SortCourse selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SortCourse record, @Param("example") SortCourseExample example);

    int updateByExample(@Param("record") SortCourse record, @Param("example") SortCourseExample example);

    int updateByPrimaryKeySelective(SortCourse record);

    int updateByPrimaryKey(SortCourse record);

}