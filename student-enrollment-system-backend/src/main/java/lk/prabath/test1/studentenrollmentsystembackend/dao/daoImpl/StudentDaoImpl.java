package lk.prabath.test1.studentenrollmentsystembackend.dao.daoImpl;

import lk.prabath.test1.studentenrollmentsystembackend.dao.StudentDao;
import lk.prabath.test1.studentenrollmentsystembackend.entity.Student;
import lk.prabath.test1.studentenrollmentsystembackend.repsitory.StudentRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StudentDaoImpl implements StudentDao {
    private final StudentRepository repository;

    public StudentDaoImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public Student save(Student entity) {
        return repository.save(entity);
    }

    @Override
    public void update(Student entity) {
        Student existingStudent = repository.findById(entity.getId()).orElse(null);
        if (existingStudent == null)return;
        existingStudent.setName(entity.getName());
        existingStudent.setNic(entity.getNic());
        existingStudent.setAddress(entity.getAddress());
        existingStudent.setContact(entity.getContact());
        existingStudent.setCourse(entity.getCourse());

    }

    @Override
    public void deleteById(Integer pk) {
        repository.deleteById(pk);
    }

    @Override
    public Optional<Student> findById(Integer pk) {
        return repository.findById(pk);
    }

    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean existById(Integer pk) {
        return repository.existsById(pk);
    }
}
