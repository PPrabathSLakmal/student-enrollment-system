package lk.prabath.test1.studentenrollmentsystembackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private int studentId;
    @NotBlank(message = "Name can not be empty")
    @Pattern(regexp = "[A-Za-z ]+", message = "Invalid name type")
    private String name;
    @NotBlank(message = "NIC can not be empty")
    @Pattern(regexp = "\\d{9}[Vv]", message = "Invalid NIC")
    private String nic;
    @NotBlank(message = "Address can not be empty")
    @Length(min = 3,message = "Enter a valid address")
    private String address;
    @NotBlank(message = "Contact number can not be empty")
    @Pattern(regexp = "\\d{3}-\\d{7}", message = "Invalid contact number")
    private String contact;

    private String courseId;

}
