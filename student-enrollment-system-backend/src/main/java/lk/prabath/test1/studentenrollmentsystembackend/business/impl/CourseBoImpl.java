package lk.prabath.test1.studentenrollmentsystembackend.business.impl;

import lk.prabath.test1.studentenrollmentsystembackend.business.CourseBo;
import lk.prabath.test1.studentenrollmentsystembackend.business.util.Transformer;
import lk.prabath.test1.studentenrollmentsystembackend.dao.CourseDao;
import lk.prabath.test1.studentenrollmentsystembackend.dto.CourseDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CourseBoImpl implements CourseBo {
    private final CourseDao courseDao;
    private final Transformer transformer;

    public CourseBoImpl(CourseDao courseDao, Transformer transformer) {
        this.courseDao = courseDao;
        this.transformer = transformer;
    }

    @Override
    public CourseDto saveCourse(CourseDto course) {
        return transformer.fromCourseEntity(courseDao.save(transformer.toCourseEntity(course)));
    }

    @Override
    public void updateCourse(CourseDto course) {
        courseDao.update(transformer.toCourseEntity(course));
    }

    @Override
    public void deleteCourse(String courseId) {
        courseDao.deleteById(courseId);
    }

    @Override
    public Optional<CourseDto> findCourseById(String courseId) {
        return Optional.ofNullable(transformer.fromCourseEntity(courseDao.findById(courseId).get()));
    }

    @Override
    public List<CourseDto> findAllCourse() {
        return courseDao.findAll().stream().map(transformer::fromCourseEntity).collect(Collectors.toList());
    }
}
