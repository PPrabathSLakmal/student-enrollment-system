package lk.prabath.test1.studentenrollmentsystembackend.api;

import lk.prabath.test1.studentenrollmentsystembackend.business.CourseBo;
import lk.prabath.test1.studentenrollmentsystembackend.dto.CourseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/courses")
@CrossOrigin
public class CourseController {
    private final CourseBo courseBo;

    public CourseController(CourseBo courseBo) {
        this.courseBo = courseBo;
    }

    @PostMapping
    public CourseDto saveCourse(@RequestBody @Valid CourseDto courseDto) {
        return courseBo.saveCourse(courseDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{courseId}")
    public void updateCourse(@PathVariable("courseId") String courseId,
                             @RequestBody @Valid CourseDto courseDto) {
        courseDto.setCourseId(courseId);
        System.out.println(courseDto.getName());
        courseBo.updateCourse(courseDto);
    }

    @DeleteMapping("/{courseId}")
    public void deleteCourse(@PathVariable("courseId") String courseId) {
        courseBo.deleteCourse(courseId);
    }

    @GetMapping("/{courseId}")
    public Optional<CourseDto> findCourseById(@PathVariable("courseId") String courseId) {
        return courseBo.findCourseById(courseId);
    }
    @GetMapping
    public List<CourseDto> getAllCourses(){
        return courseBo.findAllCourse();
    }
}
