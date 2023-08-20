package lk.prabath.test1.studentenrollmentsystembackend.dao.custom;

import lk.prabath.test1.studentenrollmentsystembackend.dao.CrudDao;
import lk.prabath.test1.studentenrollmentsystembackend.dto.UserDto;
import lk.prabath.test1.studentenrollmentsystembackend.entity.User;

import java.net.http.HttpRequest;

public interface UserDao extends CrudDao<User, String> {
  boolean existByUsernameAndPassword(User user);
}
