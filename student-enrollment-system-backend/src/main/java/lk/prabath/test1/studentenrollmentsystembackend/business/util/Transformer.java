package lk.prabath.test1.studentenrollmentsystembackend.business.util;

import lk.prabath.test1.studentenrollmentsystembackend.dto.CourseDto;
import lk.prabath.test1.studentenrollmentsystembackend.dto.StudentDto;
import lk.prabath.test1.studentenrollmentsystembackend.dto.UserDto;
import lk.prabath.test1.studentenrollmentsystembackend.entity.Course;
import lk.prabath.test1.studentenrollmentsystembackend.entity.Student;
import lk.prabath.test1.studentenrollmentsystembackend.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Transformer {
    private final ModelMapper mapper = new ModelMapper();
    public Course toCourseEntity(CourseDto courseDto){
        return mapper.map(courseDto, Course.class);
    }
    public CourseDto fromCourseEntity(Course course) {
        return mapper.map(course, CourseDto.class);
    }


    public Student toStudentEntity(StudentDto studentDto){
        return mapper.map(studentDto, Student.class);
    }
    public StudentDto fromStudentEntity(Student student) {
        return mapper.map(student, StudentDto.class);
    }

    public User toUserEntity(UserDto userDto){
        return mapper.map(userDto, User.class);
    }
    public UserDto fromUserEntity(User user) {
        return mapper.map(user, UserDto.class);
    }
}
