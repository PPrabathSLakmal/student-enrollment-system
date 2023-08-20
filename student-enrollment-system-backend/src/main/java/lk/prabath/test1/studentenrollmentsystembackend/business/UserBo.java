package lk.prabath.test1.studentenrollmentsystembackend.business;

import lk.prabath.test1.studentenrollmentsystembackend.dto.UserDto;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
public interface UserBo {
    void signUp(UserDto user);

    void login(UserDto user, HttpServletRequest request);

    void logout(HttpServletRequest request);

    String getUserDetails(HttpServletRequest request);
}
