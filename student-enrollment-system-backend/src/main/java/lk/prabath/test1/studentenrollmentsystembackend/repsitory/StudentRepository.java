package lk.prabath.test1.studentenrollmentsystembackend.repsitory;

import lk.prabath.test1.studentenrollmentsystembackend.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
