package lk.prabath.test1.studentenrollmentsystembackend.business.impl;

import lk.prabath.test1.studentenrollmentsystembackend.business.UserBo;
import lk.prabath.test1.studentenrollmentsystembackend.business.util.Transformer;
import lk.prabath.test1.studentenrollmentsystembackend.dao.custom.UserDao;
import lk.prabath.test1.studentenrollmentsystembackend.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

@Transactional
@Service
public class UserBoImpl implements UserBo {
    private final Transformer transformer;
    private final UserDao userDao;

    public UserBoImpl(Transformer transformer, UserDao userDao) {
        this.transformer = transformer;
        this.userDao = userDao;
    }

    @Override
    public void signUp(UserDto user) {
        if (userDao.existById(user.getFullName()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Username already exists");
        userDao.save(transformer.toUserEntity(user));
    }

    @Override
    public void login(UserDto user, HttpServletRequest request) {
        if (!userDao.existByUsernameAndPassword(transformer.toUserEntity(user))) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Access Denied");
        }else {
            HttpSession session = request.getSession();
            session.setAttribute("username",user.getUsername());
        }
    }

    @Override
    public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session!=null){
            session.invalidate();
        }
    }

    @Override
    public String getUserDetails(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null){
            String username = session.getAttribute("username").toString();
            return "Currently logged user: " + userDao.findById(username).get().getFullName();
        }
        return "Currently no active user";
    }
}
