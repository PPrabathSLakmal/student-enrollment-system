package lk.prabath.test1.studentenrollmentsystembackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.groups.Default;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @NotBlank(message = "Username cannot be empty")
    private String username;
    @Length(min = 4, message = "Minimum 4 characters required")
    private String password;
    @NotBlank(message = "Name can not be blank", groups = SignUp.class  )
    @Pattern(regexp = "[A-Za-z ]+", groups = SignUp.class)
    private String fullName;

    public interface SignUp extends Default {}

}
