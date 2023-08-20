package lk.prabath.test1.studentenrollmentsystembackend.business.impl;

import lk.prabath.test1.studentenrollmentsystembackend.business.StudentBo;
import lk.prabath.test1.studentenrollmentsystembackend.dto.StudentDto;

import java.util.List;
import java.util.Optional;

public class StudentBoImpl implements StudentBo {
    @Override
    public StudentDto saveStudent(StudentDto studentDto) {
        return null;
    }

    @Override
    public void updateStudent(StudentDto studentDto) {

    }

    @Override
    public void deleteStudent(int studentId) {

    }

    @Override
    public Optional<StudentDto> findStudentById(int Id) {
        return Optional.empty();
    }

    @Override
    public List<StudentDto> findAllStudents() {
        return null;
    }
}
