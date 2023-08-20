package lk.prabath.test1.studentenrollmentsystembackend.dao.custom;

import lk.prabath.test1.studentenrollmentsystembackend.dao.CrudDao;
import lk.prabath.test1.studentenrollmentsystembackend.entity.User;
import lk.prabath.test1.studentenrollmentsystembackend.repsitory.UserRepository;
import org.springframework.stereotype.Repository;

import java.net.http.HttpRequest;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao{
    private final UserRepository repository;

    public UserDaoImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public User save(User entity) {
        return repository.save(entity);
    }


    @Override
    public void update(User entity) {
        User existUser = repository.findById(entity.getUsername()).orElse(null);
        if (existUser == null)return;
        existUser.setPassword(entity.getPassword());
        existUser.setFullName(entity.getFullName());
    }

    @Override
    public void deleteById(String pk) {
        repository.deleteById(pk);
    }

    @Override
    public Optional<User> findById(String pk) {
        return repository.findById(pk);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean existById(String pk) {
        return repository.existsById(pk);
    }

    public boolean existByUsernameAndPassword(User user){
        User existingUser = repository.findById(user.getUsername()).orElse(null);
        if(existingUser == null) {
            return false;
        }else return existingUser.getPassword().equals(user.getPassword());
    }
}
