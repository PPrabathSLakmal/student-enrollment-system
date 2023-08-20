package lk.prabath.test1.studentenrollmentsystembackend.dao.daoImpl;

import lk.prabath.test1.studentenrollmentsystembackend.dao.CourseDao;
import lk.prabath.test1.studentenrollmentsystembackend.dao.CrudDao;
import lk.prabath.test1.studentenrollmentsystembackend.entity.Course;
import lk.prabath.test1.studentenrollmentsystembackend.repsitory.CourseRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Repository
public class CourseDaoImpl implements CourseDao {
    private final CourseRepository repository;

    public CourseDaoImpl(CourseRepository repository) {
        this.repository = repository;
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public Course save(Course entity) {
        return repository.save(entity);
    }

    @Override
    public void update(Course entity) {
        Course existingCourse = repository.findById(entity.getId()).orElse(null);
        if (existingCourse == null)return;
        existingCourse.setId(entity.getId());
        existingCourse.setName(entity.getName());
        existingCourse.setDivision(entity.getDivision());
    }

    @Override
    public void deleteById(String pk) {
        repository.deleteById(pk);
    }

    @Override
    public Optional<Course> findById(String pk) {
        return repository.findById(pk);
    }

    @Override
    public List<Course> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean existById(String pk) {
        return repository.existsById(pk);
    }
}
