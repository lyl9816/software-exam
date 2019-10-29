package core.service;

import software.exam.db.domain.SortCourse;
import software.exam.db.model.dto.CourseDto;

import java.util.List;

public interface CourseService {
    //获取知识点
    public List<CourseDto> selectCourses();
    //获取知识点列表
    public List<SortCourse> selectTitleCourse();
}
