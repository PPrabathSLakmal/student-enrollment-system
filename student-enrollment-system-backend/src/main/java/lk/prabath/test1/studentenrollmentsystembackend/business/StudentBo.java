package lk.prabath.test1.studentenrollmentsystembackend.business;

import lk.prabath.test1.studentenrollmentsystembackend.dto.StudentDto;

import java.util.List;
import java.util.Optional;

public interface StudentBo {
    StudentDto saveStudent(StudentDto studentDto);

    void updateStudent(StudentDto studentDto);

    void deleteStudent(int studentId);

    Optional<StudentDto> findStudentById(int Id);

    List<StudentDto> findAllStudents();
}