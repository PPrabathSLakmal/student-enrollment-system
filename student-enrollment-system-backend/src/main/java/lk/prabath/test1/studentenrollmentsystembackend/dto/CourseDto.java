package lk.prabath.test1.studentenrollmentsystembackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {
    @NotBlank(message = "Course ID cannot be empty")
    @Pattern(regexp = "C\\d{3}")
    private String courseId;
    @NotBlank(message = "Name can not be empty")
    @Pattern(regexp = "[A-Za-z ]+")
    private String name;
    @NotBlank(message = "Division can not be empty")
    private String division;
}
