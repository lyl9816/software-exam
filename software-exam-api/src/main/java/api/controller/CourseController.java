package api.controller;

import api.utils.ResponseUtil;
import core.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import software.exam.db.domain.SortCourse;
import software.exam.db.model.dto.CourseDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/getCourses")
    public Object getCourses(){
        List<CourseDto> courses=courseService.selectCourses();
        List<SortCourse> titleCourses=courseService.selectTitleCourse();
        Map<String,Object> map=new HashMap<>();
        map.put("courses",courses);
        map.put("titleCourses",titleCourses);
        return ResponseUtil.ok(map);
    }
}
