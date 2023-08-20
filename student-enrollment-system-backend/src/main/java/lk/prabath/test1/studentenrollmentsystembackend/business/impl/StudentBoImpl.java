package lk.prabath.test1.studentenrollmentsystembackend.business.impl;

import lk.prabath.test1.studentenrollmentsystembackend.business.StudentBo;
import lk.prabath.test1.studentenrollmentsystembackend.business.util.Transformer;
import lk.prabath.test1.studentenrollmentsystembackend.dao.StudentDao;
import lk.prabath.test1.studentenrollmentsystembackend.dto.StudentDto;
import lombok.val;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class StudentBoImpl implements StudentBo {
    private final StudentDao studentDao;
    private final Transformer transformer;

    public StudentBoImpl(StudentDao studentDao, Transformer transformer) {
        this.studentDao = studentDao;
        this.transformer = transformer;
    }

    @Override
    public StudentDto saveStudent(StudentDto studentDto) {

        return transformer.fromStudentEntity(studentDao.save(transformer.toStudentEntity(studentDto)));
    }

    @Override
    public void updateStudent(StudentDto studentDto) {
        studentDao.update(transformer.toStudentEntity(studentDto));
    }

    @Override
    public void deleteStudent(int studentId) {
        studentDao.deleteById(studentId);
    }

    @Override
    public Optional<StudentDto> findStudentById(int id) {
        return Optional.ofNullable(transformer.fromStudentEntity(studentDao.findById(id).get()));
    }

    @Override
    public List<StudentDto> findAllStudents() {
        return (studentDao.findAll().stream().map(transformer::fromStudentEntity).collect(Collectors.toList()));
    }
}
