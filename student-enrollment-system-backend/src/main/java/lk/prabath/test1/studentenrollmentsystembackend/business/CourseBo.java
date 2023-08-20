package lk.prabath.test1.studentenrollmentsystembackend.business;

import lk.prabath.test1.studentenrollmentsystembackend.dto.CourseDto;

import java.util.List;
import java.util.Optional;

public interface CourseBo {
    CourseDto saveCourse(CourseDto course);

    void updateCourse(CourseDto course);

    void deleteCourse(String courseId);

    Optional<CourseDto> findCourseById(String courseId);

    List<CourseDto> findAllCourse();
}
