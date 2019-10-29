package core.service.impl;

import core.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.exam.db.domain.SortCourse;
import software.exam.db.domain.SortCourseExample;
import software.exam.db.mapper.ContentMapper;
import software.exam.db.mapper.SortCourseMapper;
import software.exam.db.model.dto.CourseDto;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private ContentMapper contentMapper;
    @Autowired
    private SortCourseMapper sortCourseMapper;

    @Override
    public List<CourseDto> selectCourses() {

        return contentMapper.selectCourses();
    }

    @Override
    public List<SortCourse> selectTitleCourse() {
        SortCourseExample sce=new SortCourseExample();
        SortCourseExample.Criteria criteria=sce.createCriteria();
        criteria.andIdIsNotNull();
        return sortCourseMapper.selectByExample(sce);
    }
}
