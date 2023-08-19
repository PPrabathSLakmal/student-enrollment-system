package lk.prabath.test1.studentenrollmentsystembackend.repsitory;

import lk.prabath.test1.studentenrollmentsystembackend.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,String> {
}
