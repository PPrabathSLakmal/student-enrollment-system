package lk.prabath.test1.studentenrollmentsystembackend.business.impl;

import lk.prabath.test1.studentenrollmentsystembackend.business.CourseBo;
import lk.prabath.test1.studentenrollmentsystembackend.dto.CourseDto;

import java.util.List;
import java.util.Optional;

public class CourseBoImpl implements CourseBo {
    @Override
    public CourseDto saveCourse(CourseDto course) {
        return null;
    }

    @Override
    public void updateCourse(CourseDto course) {

    }

    @Override
    public void deleteCourse(String courseId) {

    }

    @Override
    public Optional<CourseDto> findCourseById(String courseId) {
        return Optional.empty();
    }

    @Override
    public List<CourseDto> findAllCourse() {
        return null;
    }
}
