package lk.prabath.test1.studentenrollmentsystembackend.api;

import lk.prabath.test1.studentenrollmentsystembackend.business.StudentBo;
import lk.prabath.test1.studentenrollmentsystembackend.dto.StudentDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentBo studentBo;

    public StudentController(StudentBo studentBo) {
        this.studentBo = studentBo;
    }

    @PostMapping
    public StudentDto saveStudent(@RequestBody @Valid StudentDto studentDto){
        return studentBo.saveStudent(studentDto);
    }

    @PatchMapping("/{studentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStudent(@PathVariable("studentId") Integer studentId,
                              @RequestBody @Valid StudentDto studentDto) {
        studentDto.setStudentId(studentId);
        studentBo.updateStudent(studentDto);
    }
    @DeleteMapping("/{studentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable("studentId") Integer studentId){
        studentBo.deleteStudent(studentId);
    }

    @GetMapping("/{studentId}")
    public Optional<StudentDto> findStudentById(@PathVariable("studentId") Integer studentId) {
        return studentBo.findStudentById(studentId);
    }
    @GetMapping
    public List<StudentDto> getStudents(){
        return studentBo.findAllStudents();
    }
}
