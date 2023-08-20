package lk.prabath.test1.studentenrollmentsystembackend.repsitory;

import lk.prabath.test1.studentenrollmentsystembackend.dto.UserDto;
import lk.prabath.test1.studentenrollmentsystembackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
