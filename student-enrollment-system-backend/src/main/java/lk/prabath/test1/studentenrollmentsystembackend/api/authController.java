package lk.prabath.test1.studentenrollmentsystembackend.api;

import lk.prabath.test1.studentenrollmentsystembackend.business.UserBo;
import lk.prabath.test1.studentenrollmentsystembackend.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.sql.SQLException;
@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RequestMapping("api/v1/auth")
public class authController {
    private final UserBo userBo;

    public authController(UserBo userBo) {
        this.userBo = userBo;
    }

    @PostMapping(value = "/signup", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void signup(@RequestBody @Validated(UserDto.SignUp.class) UserDto userDto) throws SQLException {
        userBo.signUp(userDto);
    }

    @PostMapping( value = "/login",consumes = "application/json")
    public void login(@RequestBody @Valid UserDto userDto, HttpServletRequest request) throws SQLException {
        System.out.println("Awoooo");
        userBo.login(userDto, request);
    }

    @GetMapping("/logout")
    public void logout(HttpServletRequest request){
        userBo.logout(request);
    }

    @GetMapping("/active")
    public String getUserDetails(HttpServletRequest request) throws SQLException{
        return userBo.getUserDetails(request);
    }
}
